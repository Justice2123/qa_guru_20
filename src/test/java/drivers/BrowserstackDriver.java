package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.io.SessionOutputBuffer;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {


    private static final BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class);
    private static final AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);


    public WebDriver getDriver() {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", authConfig.browserstackUser());
        caps.setCapability("browserstack.key", authConfig.browserstackKey());
        caps.setCapability("app", config.app());
        caps.setCapability("device", config.device());
        caps.setCapability("os_version", config.version());
        caps.setCapability("project", config.project());
        caps.setCapability("build", config.build());
        caps.setCapability("name", config.name());

        try {
            return new RemoteWebDriver(
                    new URL(config.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        return getDriver();
    }
}