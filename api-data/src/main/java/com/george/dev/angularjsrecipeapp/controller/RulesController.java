package com.george.dev.angularjsrecipeapp.controller;

import com.george.dev.angularjsrecipeapp.model.apimodel.RuleApiModel;
import com.george.dev.angularjsrecipeapp.service.RulesService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by George on 24/11/2018
 */

@RestController
@RequestMapping("/api/v1/")
public class RulesController {

    private RulesService rulesService;

    public RulesController(RulesService rulesService) {
        this.rulesService = rulesService;
    }

    @GetMapping("/rule/")
    public List<RuleApiModel> fetchAllRules(){
        return rulesService.findAllRules();
    }

    @GetMapping("/rule/{id}")
    public RuleApiModel getRule(@PathVariable("id") long id){
        return rulesService.getRule(id);
    }

    @PostMapping("/rule/")
    public void createRule(@RequestBody String rule){
        rulesService.createRule(rule);
    }

    @PutMapping("/rule/{id}")
    public RuleApiModel updateRule(@PathVariable("id") long id, @RequestBody String rule){
        return rulesService.updateRule(id, rule);
    }

    @DeleteMapping("/rule/{id}")
    public void deleteRule(@PathVariable("id") long id){
        rulesService.deleteRule(id);
    }


}
