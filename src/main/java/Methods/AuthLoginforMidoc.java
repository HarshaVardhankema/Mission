package Methods;

import com.microsoft.playwright.*;

public class AuthLoginforMidoc {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();

            Page page = context.newPage();

            // Set auth token in localStorage before navigating
            page.addInitScript("window.localStorage.setItem('token', 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InZlZ2FzQGdtYWlsLmNvbSIsInJvbGUiOiJwYXRpZW50In0.yHWQzbAyVcuF6pm9WY-6ilHammfjeU8TX6NzcHIX_Nk');");

            // Navigate to the protected page directly
            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/appointments");

            // Print the current URL (for verification)
            System.out.println("Page URL after login: " + page.url());

            // Keep the browser open to check authentication
            page.waitForTimeout(5000);
        }
    }
}

//package NewThings;
//
//import com.microsoft.playwright.*;
//
//public class MidocAuthLogin {
//    public static void main(String[] args) {
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//            BrowserContext context = browser.newContext();
//            Page page = context.newPage();
//
//            // Navigate to the login page first
//            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/login");
//
//            // Set the auth token in localStorage (AFTER navigation)
//            page.evaluate("() => { localStorage.setItem('token', 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InZlZ2FzQGdtYWlsLmNvbSIsInJvbGUiOiJwYXRpZW50In0.yHWQzbAyVcuF6pm9WY-6ilHammfjeU8TX6NzcHIX_Nk'); }");
//
//            // Reload the page to apply the token
//            page.reload();
//
//            // Navigate to a protected page
//            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/myhealth");
//
//            // Print the current URL (for verification)
//            System.out.println("Page URL after login: " + page.url());
//
//            // Wait to check authentication status
//            page.waitForTimeout(5000);
//        }
//    }
//}
//
////


