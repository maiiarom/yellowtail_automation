import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.ProviderForDriver;
import utils.Constants;

import java.time.Duration;

public class JunitRunner {

    @BeforeEach
    public void before() {
        ProviderForDriver.getDriver();
        ProviderForDriver.getDriver().get(Constants.WELCOME_PAGE_URL);
        ProviderForDriver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterEach
    public void after() {
        ProviderForDriver.removeDriver();
    }

}
