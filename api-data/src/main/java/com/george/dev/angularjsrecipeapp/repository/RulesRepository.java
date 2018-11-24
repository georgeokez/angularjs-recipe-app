package com.george.dev.angularjsrecipeapp.repository;

import com.george.dev.angularjsrecipeapp.model.entitymodel.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by George on 24/11/2018
 */

@Repository
public interface RulesRepository extends JpaRepository<Rule, Long> {
    Rule findRulesById(long id);
}
