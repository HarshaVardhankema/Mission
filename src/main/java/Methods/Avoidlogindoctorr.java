package Methods;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Avoidlogindoctorr {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate("https://midoc-provider-dev.azurewebsites.net/login");

            // Fill login details
            page.locator("input.chakra-input.css-rlygj7").nth(0).fill("zampa@gmail.com");
            page.waitForTimeout(2000);


            //password
            page.locator("input.chakra-input.css-efg1n9").nth(0).fill("midoc123");
            page.waitForTimeout(2000);

            //continue
            page.locator("button.chakra-button.css-1gt1si2").nth(0).click();
            page.waitForTimeout(8000);

            // Wait for the login to complete
            page.waitForURL("https://midoc-provider-dev.azurewebsites.net/home");

            // Save authentication state
            context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("zampa.json")));

            System.out.println("✅ Auth state saved! You won't need to log in again.");
        }
    }
}



