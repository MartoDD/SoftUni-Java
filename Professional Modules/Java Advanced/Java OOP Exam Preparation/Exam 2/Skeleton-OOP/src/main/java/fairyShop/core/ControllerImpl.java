package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.helpers.BaseHelper;
import fairyShop.models.helpers.Happy;
import fairyShop.models.helpers.Helper;
import fairyShop.models.helpers.Sleepy;
import fairyShop.models.instrumets.Instrument;
import fairyShop.models.instrumets.InstrumentImpl;
import fairyShop.models.presents.Present;
import fairyShop.models.presents.PresentImpl;
import fairyShop.models.shop.Shop;
import fairyShop.models.shop.ShopImpl;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.Objects;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private HelperRepository helperRepository;
    private PresentRepository presentRepository;

    public ControllerImpl() {
        helperRepository = new HelperRepository();
        presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        BaseHelper helper = null;
        if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);
        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Instrument instrument = new InstrumentImpl(power);

        Helper helper = helperRepository.findByName(helperName);

        if (helper == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        helper.addInstrument(instrument);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);

        presentRepository.add(present);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {

        Helper helper = helperRepository.getModels().stream().filter(h -> h.getEnergy() > 50).findFirst().orElse(null);

        if (helper == null) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        Present present = presentRepository.findByName(presentName);

        Shop shop = new ShopImpl();

        shop.craft(present, helper);

        String done = present.isDone()? "done": "not done";

        return String.format(ConstantMessages.PRESENT_DONE + ConstantMessages.COUNT_BROKEN_INSTRUMENTS,presentName,done,helper.getInstruments().stream().filter(Instrument::isBroken).count());
    }

    @Override
    public String report() {
        return presentRepository.getModels().stream().filter(Present::isDone).count() + " presents are done!" +System.lineSeparator() +
                "Helpers info:" + System.lineSeparator() +
                helperRepository.getModels().stream().map(h-> "Name: " + h.getName() + System.lineSeparator() + "Energy: " + h.getEnergy()+ System.lineSeparator()+
                        "Instruments: " + h.getInstruments().stream().filter(i->!i.isBroken()).count() + " not broken left").collect(Collectors.joining(System.lineSeparator()));
    }
}
