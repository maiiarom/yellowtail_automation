import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ProviderForDriver;
import utils.Constants;


@ExtendWith(TestResultLoggerExtension.class)
public class JunitRunner {

    @BeforeEach
    public void before() {
        ProviderForDriver.INSTANCE.getDriver().get(Constants.WELCOME_PAGE_URL);
    }

    @AfterEach
    public void after() {
        ProviderForDriver.INSTANCE.removeDriver();
    }
}
