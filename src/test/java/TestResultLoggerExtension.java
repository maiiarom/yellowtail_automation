import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.ProviderForDriver;


public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback {

    public void afterAll(ExtensionContext extensionContext) {
        ProviderForDriver.INSTANCE.removeDriver();
    }

    public void testFailed(ExtensionContext context, Throwable cause) {
        makeScreenshot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
        private byte[] makeScreenshot() {
        return ((TakesScreenshot) ProviderForDriver.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
