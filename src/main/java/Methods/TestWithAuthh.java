package Methods;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class TestWithAuthh {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            // Load saved authentication state
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setStorageStatePath(Paths.get("auth.json"))
            );

            Page page = context.newPage();
            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/login");

            System.out.println("✅ Logged in using saved session!");

            // Test Flow Example: Click on 'Add Allergy'
            page.locator("//button[contains(text(),'Add Allergy')]").click();
            System.out.println("✅ Clicked on 'Add Allergy' button");

            // Validate if the modal opens
            boolean isModalVisible = page.locator(".chakra-modal__content-container").isVisible();
            if (isModalVisible) {
                System.out.println("✅ Modal opened successfully!");
            } else {
                System.out.println("❌ Modal did not open!");
            }

            browser.close();
        }
    }
}


