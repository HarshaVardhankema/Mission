package Methods;

import com.microsoft.playwright.*;

public class doctorAPIlogin {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();

            Page page = context.newPage();

            // Set auth token in localStorage before navigating
            page.addInitScript("window.localStorage.setItem('token', 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InZpZ2d1QGdtYWlsLmNvbSIsInJvbGUiOiJwYXRpZW50In0.MfeYhj9_WefaY5NbN_mucFfPdcSlGDqxxx24BBWO2IY');");

            // Navigate to the protected page directly
            page.navigate("https://midoc-provider-dev.azurewebsites.net/home");

            // Print the current URL (for verification)
            System.out.println("Page URL after login: " + page.url());

            // Keep the browser open to check authentication
            page.waitForTimeout(5000);
        }
    }
}

