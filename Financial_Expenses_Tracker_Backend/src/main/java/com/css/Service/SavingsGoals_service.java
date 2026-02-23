package com.css.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.Entity.Savings_goal;
import com.css.Repository.IMYSQL_Database_Savings_Goals;

@Service
public class SavingsGoals_service implements ISavingsGoals_Servicel {

    @Autowired
    private IMYSQL_Database_Savings_Goals mysqlGoals;

  
    @Override
    public Savings_goal create_Savings_Goal(Savings_goal saving_goal) {

     
        if (saving_goal.getTarget_amount() <= 0) {
            throw new IllegalArgumentException("Target amount must be greater than zero");
        }

        
        if (saving_goal.getSaved_amount() == null) {
            saving_goal.setSaved_amount(0.0);
        }

        
        if (saving_goal.getCreated_at() == null) {
            saving_goal.setCreated_at(LocalDateTime.now());
        }

        return mysqlGoals.save(saving_goal);
    }

    
    @Override
    public Optional<Savings_goal> get_Savings_Goal() {

        Iterable<Savings_goal> iterable = mysqlGoals.findAll();

        for (Savings_goal goal : iterable) {
            return Optional.of(goal); 
        }

        return Optional.empty(); 
    }


    @Override
    public Double get_Savings_Progress() {

        Optional<Savings_goal> optionalGoal = get_Savings_Goal();

        if (optionalGoal.isEmpty()) {
            return 0.0;
        }

        Savings_goal goal = optionalGoal.get();

        if (goal.getTarget_amount() == 0) {
            return 0.0;
        }

        return (goal.getSaved_amount() / goal.getTarget_amount()) * 100;
    }

    
    @Override
    public Savings_goal update_Saved_Amount(Double amountToAdd) {

        if (amountToAdd <= 0) {
            throw new IllegalArgumentException("Amount to add must be greater than zero");
        }

        Optional<Savings_goal> optionalGoal = get_Savings_Goal();

        if (optionalGoal.isEmpty()) {
            throw new IllegalStateException("Savings goal not found");
        }

        Savings_goal goal = optionalGoal.get();

        double updatedAmount = goal.getSaved_amount() + amountToAdd;

        // Ensure saved amount does not exceed target
        if (updatedAmount > goal.getTarget_amount()) {
            updatedAmount = goal.getTarget_amount();
        }

        goal.setSaved_amount(updatedAmount);

        return mysqlGoals.save(goal);
    }
}
