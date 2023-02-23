package com.resellerapp.service;

import com.resellerapp.model.dtos.OfferAddDto;
import com.resellerapp.model.dtos.ReturnedOffersDto;
import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;
    private final CurrentUser currentUser;
    private final ConditionService conditionService;
    private final UserRepository userRepository;

    private final UserService userService;

    public OfferService(ModelMapper modelMapper, OfferRepository offerRepository, CurrentUser currentUser, ConditionService conditionService, UserRepository userRepository, UserService userService) {
        this.modelMapper = modelMapper;
        this.offerRepository = offerRepository;
        this.currentUser = currentUser;
        this.conditionService = conditionService;
        this.userRepository = userRepository;
        this.userService = userService;

    }

    public void addOffer(OfferAddDto offerAddDto) {

        Offer offer = new Offer();
        User user = userService.findUserByUsername(currentUser.getUsername()).orElse(null);
        Condition condition = conditionService.findConditionByName(offerAddDto.getCondition());

        offer.setUser(user);
        offer.setCondition(condition);
        offer.setDescription(offerAddDto.getDescription());
        offer.setPrice(offerAddDto.getPrice());
        offerRepository.save(offer);

    }

    public Set<ReturnedOffersDto> mapOffers(Set<Offer> offers) {

        return offers.stream().map(offer -> {

            ReturnedOffersDto returnedOffersDto = new ReturnedOffersDto();

            returnedOffersDto.setId(offer.getId());
            returnedOffersDto.setCondition(offer.getCondition());
            returnedOffersDto.setDescription(offer.getDescription());
            returnedOffersDto.setPrice(offer.getPrice());
            returnedOffersDto.setUser(offer.getUser());
            return returnedOffersDto;
        }).collect(Collectors.toSet());
    }

    public Set<ReturnedOffersDto> findAllOffersByUser(Long id) {
        return mapOffers(this.offerRepository.findAllByUserId(id));
    }

    public Set<ReturnedOffersDto> findAllOffersByOtherUsers(Long id) {
        return mapOffers(this.offerRepository.findAllByUserIdNot(id));
    }

    @Transactional
    public void removeOffer(Long id) {

        this.offerRepository.removeOfferById(id);
    }

    public void buyOffer(Long id) {
        Offer offer = this.offerRepository.findOffersById(id);
        User user = userService.findUserByUsername(currentUser.getUsername()).orElse(null);
        user.getBoughtOffers().add(offer);
        userRepository.save(user);
    }
}
