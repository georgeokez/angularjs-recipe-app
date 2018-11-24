package com.george.dev.angularjsrecipeapp.model.entitymodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * Created by George on 24/11/2018
 */

@Entity
@Table(name="rule")
public class Rule extends BaseEntity {

    @Column(name = "rules")
    @NotEmpty
    private String rules;

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "rules='" + rules + '\'' +
                '}';
    }
}
