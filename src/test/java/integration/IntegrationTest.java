package integration;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ronald Bao on 06/04/2019.
 */

//@RunWith(Karate.class)
//@CucumberOptions(features = "classpath:karate")
public class IntegrationTest {

    private RestTemplate restTemplate = null;
    private static WireMockServer wireMockServer = null;

    @BeforeClass
    public static void setUp() throws Exception {

    }

    @Test
    public void shouldReturnHttpStatusCodeOk() {

    }


    @AfterClass
    public static void tearDown() throws Exception {
        
    }


    private static String buildApiMethodUrl(){
        return String.format("http://localhost:%/api/message", wireMockServer.port());
    }

}
