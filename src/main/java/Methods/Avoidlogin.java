package Methods;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Avoidlogin {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/login");

            // Fill login details
            page.locator("//input[@class='chakra-input css-dhzvz6']").fill("vegas@gmail.com");
            page.waitForTimeout(2000);

            // continue button
            page.locator("//button[@class='chakra-button css-12kaf87']").click();
            page.waitForTimeout(2000);

            //password
            page.locator("//input[@class='chakra-input css-1rsaweq']").fill("midoc123");
            page.waitForTimeout(2000);

            //continue
            page.locator("//button[@class='chakra-button css-12kaf87']").click();
            page.waitForTimeout(2000);

            // Wait for the login to complete
            page.waitForURL("https://midoc-patientapp-dev.azurewebsites.net/home");

            // Save authentication state
            context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("vegas.json")));

            System.out.println("✅ Auth state saved! You won't need to log in again.");
        }
    }
}

