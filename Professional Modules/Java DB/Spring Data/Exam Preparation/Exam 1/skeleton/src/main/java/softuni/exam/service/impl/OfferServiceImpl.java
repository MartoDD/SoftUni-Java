package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferWrapperDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.enums.ApartmentType;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationTool;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.util.Messages.INVALID_OFFER;
import static softuni.exam.util.Messages.OFFER_IMPORTED;
import static softuni.exam.util.Paths.PATH_OF_OFFER;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final XmlParser xmlParser;
    private final ValidationTool validationTool;
    private final AgentRepository agentRepository;
    private final ModelMapper modelMapper;
    private final ApartmentRepository apartmentRepository;

    public OfferServiceImpl(OfferRepository offerRepository, XmlParser xmlParser, ValidationTool validationTool, AgentRepository agentRepository, ModelMapper modelMapper, ApartmentRepository apartmentRepository) {
        this.offerRepository = offerRepository;
        this.xmlParser = xmlParser;
        this.validationTool = validationTool;
        this.agentRepository = agentRepository;
        this.modelMapper = modelMapper;
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(PATH_OF_OFFER);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile("src/main/resources/files/xml/offers.xml", OfferWrapperDto.class)
                .getOffers()
                .stream()
                .filter(offerDto -> {

                    boolean isValid = validationTool.isValid(offerDto);
                    boolean agentDoesntExist = agentRepository.findAgentByFirstName(offerDto.getAgentName().getName()).isEmpty();

                    if (agentDoesntExist) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format(OFFER_IMPORTED, offerDto.getPrice()) : INVALID_OFFER).append(System.lineSeparator());

                    return isValid;

                }).map(offerDto -> {
                    Offer offer = modelMapper.map(offerDto, Offer.class);
                    Apartment apartment = apartmentRepository.findApartmentById(offerDto.getApartmentId().getId());
                    Agent agent = agentRepository.findAgentByFirstName(offerDto.getAgentName().getName()).orElse(null);
                    offer.setApartment(apartment);
                    offer.setAgent(agent);

                    return offer;
                }).forEach(offerRepository::save);


        return sb.toString();
    }

    @Override
    public String exportOffers() {

        return offerRepository.findAllByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc(ApartmentType.three_rooms)
                .stream().map(Object::toString).collect(Collectors.joining(System.lineSeparator()));

    }
}
