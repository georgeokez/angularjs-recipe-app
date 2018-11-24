package com.george.dev.angularjsrecipeapp.service;

import com.george.dev.angularjsrecipeapp.model.apimodel.RuleApiModel;
import com.george.dev.angularjsrecipeapp.model.entitymodel.Rule;
import com.george.dev.angularjsrecipeapp.repository.RulesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by George on 24/11/2018
 */

@Service
public class RulesService {

    private static final Logger logger = LoggerFactory.getLogger(RulesService.class.getName());

    private RulesRepository rulesRepository;

    public RulesService(RulesRepository rulesRepository) {
        this.rulesRepository = rulesRepository;
    }

    public List<RuleApiModel> findAllRules(){
        List<Rule> ruleList = rulesRepository.findAll();
        List<RuleApiModel> responseList = new ArrayList<>();

        ruleList.forEach( rule -> {
            RuleApiModel ruleApiModel = new RuleApiModel();
            ruleApiModel.setId(rule.getId());
            ruleApiModel.setRule(rule.getRules());
            responseList.add(ruleApiModel);
        });

        return responseList;
    }

    public RuleApiModel getRule(long id){
        try {
            Rule rule = rulesRepository.findRulesById(id);
            RuleApiModel responseModel = new RuleApiModel(rule.getId(),rule.getRules());
            return responseModel;
        } catch (NoSuchElementException ex){
            logger.error("This rule does not exist");
            return null;
        }
    }

    public void createRule(String responseRule) {
        try {
            Rule rule = new Rule();
            rule.setRules(responseRule);
            rulesRepository.save(rule);
        }catch (Exception ex){
            logger.error("An error occured while creating rule");
        }
    }

    public RuleApiModel updateRule(long id, String ruleStr){
        try {
            Rule rule = rulesRepository.findRulesById(id);
            rule.setRules(ruleStr);
            return getRule(id);
        } catch (NoSuchElementException ex){
            logger.error("An error occured while updating rule");
            return null;
        }
    }

    public void deleteRule(long id){
        try {
            rulesRepository.deleteById(id);
        } catch (NoSuchElementException ex){
            logger.error("An error occured while deleting rule.");
        }
    }


}
