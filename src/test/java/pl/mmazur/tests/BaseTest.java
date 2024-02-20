package pl.mmazur.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static pl.mmazur.utils.StringUtils.removeRoundBrackets;

public class BaseTest {
    private static Playwright pw;
    protected static Browser browser;

    protected BrowserContext browserContext;

    protected Page page;

    @BeforeAll
    static void launchBrowser() {
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000));
    }

    @BeforeEach
    void createContextAndPage() {
        browserContext = browser.newContext();
//        browserContext.tracing().start(new Tracing.StartOptions()
//                .setScreenshots(true)
//                .setSnapshots(true)
//                .setSources(true));

        page = browserContext.newPage();
        page.setViewportSize(1920, 1080);
    }

    @AfterEach
    void closeContext(TestInfo testInfo) {
//        String traceName = "traces/trace_"
//                + removeRoundBrackets(testInfo.getDisplayName())
//                + "_" + LocalDateTime.now().format(DateTimeFormatter
//                .ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".zip";
//        browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));


        browserContext.close();
    }

    @AfterAll
    static void closeBrowser() {
        pw.close();
    }

}
