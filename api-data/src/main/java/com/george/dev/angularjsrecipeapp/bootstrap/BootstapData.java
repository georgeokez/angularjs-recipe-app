package com.george.dev.angularjsrecipeapp.bootstrap;

import com.george.dev.angularjsrecipeapp.model.apimodel.RuleApiModel;
import com.george.dev.angularjsrecipeapp.service.RulesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by George on 24/11/2018
 */

@Component
public class BootstapData implements CommandLineRunner {

    private RulesService rulesService;

    public BootstapData(RulesService rulesService) {
        this.rulesService = rulesService;
    }

    @Override
    public void run(String... args) throws Exception {
        RuleApiModel ruleApiModel1 = new RuleApiModel();
        ruleApiModel1.setRule("Must be 5 characters");

        rulesService.createRule(ruleApiModel1.getRule());

        RuleApiModel ruleApiModel2 = new RuleApiModel();
        ruleApiModel2.setRule("Must not be used elsewhere");

        rulesService.createRule(ruleApiModel2.getRule());

        RuleApiModel ruleApiModel3 = new RuleApiModel();
        ruleApiModel3.setRule("Must be cool");

        rulesService.createRule(ruleApiModel3.getRule());
    }
}
