import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.ProviderForDriver;


public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback {
//    private List<TestResultStatus> testResultStatus = new ArrayList<>();

    public void afterAll(ExtensionContext extensionContext) {
//        System.out.println("Test in after all section");
        ProviderForDriver.INSTANCE.removeDriver();
    }

//    private enum TestResultStatus {
//        FAILED
//    }

    public void testFailed(ExtensionContext context, Throwable cause) {
//        System.out.println("Test is failed");
        makeScreenshot();
//        testResultStatus.add(TestResultStatus.FAILED);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
        private byte[] makeScreenshot() {
        return ((TakesScreenshot) ProviderForDriver.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
