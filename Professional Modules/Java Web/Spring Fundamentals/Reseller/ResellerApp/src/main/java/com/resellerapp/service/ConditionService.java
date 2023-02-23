package com.resellerapp.service;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.enums.ConditionEnums;
import com.resellerapp.repository.ConditionRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionService {

    private final ConditionRepository conditionRepository;

    public ConditionService(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    public void initConditions() {

        if (conditionRepository.count() == 0) {
            Arrays.stream(ConditionEnums.values()).forEach(c -> {
                Condition condition = new Condition();
                condition.setName(c);
                String value = "";
                switch (c.name()) {
                    case "EXCELLENT":
                        value = "In perfect condition";
                        break;
                    case "GOOD":
                        value = "Some signs of wear and tear or minor defects";
                        break;
                    case "ACCEPTABLE":
                        value = "The item is fairly worn but continues to function properly";
                        break;

                }
                condition.setDescription(value);
                this.conditionRepository.save(condition);
            });
        }

    }

    public Condition findConditionByName(ConditionEnums conditionEnums) {
        return this.conditionRepository.findByName(conditionEnums).orElse(null);
    }
}
