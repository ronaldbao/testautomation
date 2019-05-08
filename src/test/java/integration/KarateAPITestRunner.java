package integration;

import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by Ronald Bao on 07/04/2019.
 */
@RunWith(Karate.class)
@CucumberOptions(
        tags = {"@FR"},
        features = "classpath:integration/OrderMilestone.feature",
        format = {"pretty","json:target/output.json", "html:target/html/"}
)
public class KarateAPITestRunner {

    @BeforeClass
    public static void before() {
        System.setProperty("karate.env", "is05");
    }

}

