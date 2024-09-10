
package helpers;

import config.AuthConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;


public class Browserstack {
    private static final AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(authConfig.browserstackUser(), authConfig.browserstackKey())
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
