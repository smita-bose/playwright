import com.microsoft.playwright.*;

public class PlaywrightTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setChannel("chrome")   // 👈 Opens real Chrome
                            .setHeadless(false)
                            .setSlowMo(100)
            );

            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Open H&M
            page.navigate("https://www2.hm.com/en_in/index.html");

            page.waitForTimeout(5000);

            // Accept cookies
            page.locator("button")
                    .filter(new Locator.FilterOptions().setHasText("Accept"))
                    .first()
                    .click();

        }
    }
}