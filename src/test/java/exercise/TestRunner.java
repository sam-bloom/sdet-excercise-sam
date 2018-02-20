package exercise;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import exercise.baseclass.Baseclass;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature/")
public class TestRunner extends Baseclass{

}
