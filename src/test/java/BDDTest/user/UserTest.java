package BDDTest.user;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/BDDTest/user/user.feature"
)
public class UserTest {

}
