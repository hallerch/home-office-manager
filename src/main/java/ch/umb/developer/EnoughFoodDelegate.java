package ch.umb.developer;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class EnoughFoodDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("The fridge is checking if you have enough food");
        boolean alwaysFalseForDemoReason = false;
        execution.setVariable("enoughFood", alwaysFalseForDemoReason);
    }
}
