package com.george.dev.angularjsrecipeapp.model.apimodel;

/**
 * Created by George on 24/11/2018
 */

public class RuleApiModel {

    private long id;
    private String rule;

    public RuleApiModel() {
    }

    public RuleApiModel(long id, String rule) {
        this.id = id;
        this.rule = rule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
