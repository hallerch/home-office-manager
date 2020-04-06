package ch.umb.developer;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Random;

public class EnoughFoodDelegate implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Random random = new Random();
        String enoughFood = "enoughFood";

        execution.setVariable(enoughFood, random.nextBoolean());
    }
}
