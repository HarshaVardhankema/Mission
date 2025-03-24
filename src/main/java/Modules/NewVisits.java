package Modules;

import com.microsoft.playwright.*;

public class NewVisits {

    public static void main(String[] args) throws Exception {  // Declare that this method can throw an exception
        // Use try-with-resources to ensure resources are closed automatically
        try (Playwright playwright = Playwright.create()) {
            // Launch browser in non-headless mode
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Navigate to the login page
            page.navigate("https://midoc-provider-dev.azurewebsites.net/login");
            String pageurl = page.url();
            System.out.println("Page url: " + pageurl);
            page.waitForTimeout(8000);

            // Email
            page.locator("input.chakra-input.css-rlygj7").first().fill("zampa@gmail.com");
            page.waitForTimeout(2000);

            //Password
            page.locator("input.chakra-input.css-efg1n9").first().fill("midoc123");
            page.waitForTimeout(2000);

            // continue
            page.locator("button.chakra-button.css-1gt1si2").first().click();
            page.waitForTimeout(5000);

            // Visits
            page.navigate("https://midoc-provider-dev.azurewebsites.net/visits");
            String pageurl1 = page.url();
            System.out.println("Page url: " + pageurl1);

            page.waitForTimeout(5000);

            // New visits
            page.locator("button.chakra-button.css-1u98ohr").click();
            page.waitForTimeout(2000);

            // Add Patient
            page.locator("button.chakra-button.css-1l383uj").click();
            page.waitForTimeout(6000);

            //Mobile No
            page.locator("input.chakra-input.css-1iu283f").nth(0).fill("9878987654");
            page.waitForTimeout(2000);

            //Email id
            page.locator("input.chakra-input.css-oj3rkf").first().fill("Adam@gmail.com");
            page.waitForTimeout(2000);

            //First Name
            page.locator("input.chakra-input.css-huwrqk").nth(0).fill("Adam");
            page.waitForTimeout(2000);

            // last Name
            page.locator("input.chakra-input.css-ju3peg").fill("John");
            page.waitForTimeout(2000);

            //DOB
            page.locator("input.chakra-input.css-5srits").click();
            page.waitForTimeout(2000);

            //  Ensure the "Year" dropdown is visible and stable before interacting
            Locator yearDropdown = page.locator("//select[@name='years']");
            yearDropdown.waitFor(); // Wait until the dropdown is ready
            yearDropdown.selectOption("1984"); // Select the year
            page.waitForTimeout(2000);

            // Select the Month
            Locator monthDropdown = page.locator("//select[@name='months']"); // Specific locator
            monthDropdown.waitFor();
            monthDropdown.selectOption("7"); // Choose August
            page.waitForTimeout(2000);

            // Select Date (Ensure correct structure in UI)
            Locator dateButton = page.locator("//button[contains(@class, 'rdp-day') and text()='22']");
            dateButton.scrollIntoViewIfNeeded();
            dateButton.click();
            page.waitForTimeout(2000);

            System.out.println("Successfully Entered the DOB ");

//            // Age in Years
//             page.locator("input.chakra-input.css-oj3rkf").nth(1).fill("24");
//             page.waitForTimeout(2000);
//
//             // Age in MOnths
//             page.locator("input.chakra-input.css-oj3rkf").nth(2).fill("24");
//             page.waitForTimeout(2000);

            // Address
            page.locator("textarea.chakra-textarea.css-x7edcr").fill("Aravinda handloom,Pedda Amberpet");
            page.waitForTimeout(2000);

            //Emergency contact name
            page.locator("input.chakra-input.css-huwrqk").nth(1).fill("Mike");
            page.waitForTimeout(2000);

            // Emergency Mobile No
            page.locator("input.chakra-input.css-1iu283f").nth(1).fill("9998887776");
            page.waitForTimeout(2000);

            //create Visits
            page.locator("button.chakra-button.css-1n76g75").click();
            page.waitForTimeout(8000);









            //


        }
    }
}
