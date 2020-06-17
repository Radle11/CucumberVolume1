package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void setup(Scenario scenario){

        System.out.println("it will run before each scenario");
        System.out.println(scenario.getName());
    }
    @After
    public void tearDown(Scenario scenario){

        System.out.println("it will run after each scenario");
        if(scenario.isFailed()){
            scenario.log(scenario.getName()+" is failed");
            BrowserUtils.takeScreenShot();
        }
    }
    @Before("@conditional")
    public void conditionalAnnotation(){
        System.out.println("conditional annotation");
    }
}
