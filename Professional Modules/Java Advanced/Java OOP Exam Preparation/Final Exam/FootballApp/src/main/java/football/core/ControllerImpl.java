package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private SupplementRepository supplementRepository;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;

        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }
        this.fields.add(field);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {

        Supplement supplement;

        switch (type) {
            case "Powdered":
                supplement = new Powdered();
                break;
            case "Liquid":
                supplement = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }

        this.supplementRepository.add(supplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {

        Supplement supplement = this.supplementRepository.findByType(supplementType);

        if (supplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }
        this.supplementRepository.remove(supplement);
        this.fields.stream().filter(field -> field.getName().equals(fieldName)).findFirst().get().addSupplement(supplement);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {

        Field field = fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
        Player player;

        switch (playerType) {
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
        assert field != null;
        String fieldType = field.getClass().getSimpleName();

        if ((playerType.equals("Men") && fieldType.equals("ArtificialTurf")) || (playerType.equals("Women") && fieldType.equals("NaturalGrass"))) {
            return ConstantMessages.FIELD_NOT_SUITABLE;
        } else {
            fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().get().addPlayer(player);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
        }


    }

    @Override
    public String dragPlayer(String fieldName) {
        fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().get().drag();
        int playerCount = fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().get().getPlayers().size();
        return String.format(ConstantMessages.PLAYER_DRAG, playerCount);
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = this.fields.stream().filter(f->f.getName().equals(fieldName)).findFirst().orElse(null);
        assert field != null;
        int strength =field.getPlayers().stream().mapToInt(Player::getStrength).sum();
        return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, strength);
    }

    @Override
    public String getStatistics() {
        return this.fields.stream().map(Field::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }
}
