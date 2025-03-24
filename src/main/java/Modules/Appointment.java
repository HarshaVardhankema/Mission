package Modules;

import com.microsoft.playwright.*;

public class Appointment {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Launch browser in non-headless mode
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Set auth token in localStorage before navigating
            page.addInitScript("window.localStorage.setItem('token', 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InZlZ2FzQGdtYWlsLmNvbSIsInJvbGUiOiJwYXRpZW50In0.yHWQzbAyVcuF6pm9WY-6ilHammfjeU8TX6NzcHIX_Nk');");

            // Navigate to the protected page directly
            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/appointments");
            page.waitForTimeout(2000);

            //Cardiology
            page.locator("p.css-vha4au").first().click();
            page.waitForTimeout(2000);

            //Search bar
            page.locator("img.chakra-image.css-19gc7lg").nth(1).click();
            page.waitForTimeout(2000);

            // search input
            page.locator("input.chakra-input.css-xvhf0p").fill("MarsOdin");
            page.waitForTimeout(2000);
            page.keyboard().press("Enter");
            page.waitForTimeout(2000);

            // Book Appoinmnet
            page.locator("div.css-1xkj9qd").click();
            page.waitForTimeout(5000);

            //contine for booking the date
            page.locator("button.chakra-button.css-k6gnbm").click();
            page.waitForTimeout(3000);

            //book a time
            page.locator("button.chakra-button.css-1thz7gh").nth(15).click();
            page.waitForTimeout(3000);

            //chief compliant
            page.locator("textarea.chakra-textarea.css-dkylh8").fill("Hlo Doctor Suffering from Headache ");
            page.waitForTimeout(3000);

            // booking the appoinment
            page.locator("button.chakra-button.css-k6gnbm").click();
            page.waitForTimeout(3000);

            // cash
            page.locator("chakra-button css-zk5ooc").nth(1).click(new Locator.ClickOptions().setForce(true));  // ✅ Correct
            page.waitForTimeout(3000);

            //Booking successfully
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(3000);



            page.pause();



            //







        }
    }

}


