package org.example;

import com.microsoft.playwright.*;

public class FindingName {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            // Launch browser in non-headless mode
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Navigate to the login page
            page.navigate("https://midoc-provider-dev.azurewebsites.net/login");
            System.out.println("Page url: " + page.url());
            page.waitForTimeout(8000);

            // Email
            page.locator("input.chakra-input.css-rlygj7").first().fill("zampa@gmail.com");
            page.waitForTimeout(2000);

            // Password
            page.locator("input.chakra-input.css-efg1n9").first().fill("midoc123");
            page.waitForTimeout(2000);

            // Continue button
            page.locator("button.chakra-button.css-1gt1si2").first().click();
            page.waitForTimeout(5000);

            // Print new page URL after login
            System.out.println("Page url after login: " + page.url());
            page.waitForTimeout(5000);

            // Wait for the text element to be visible
            page.waitForSelector("p.chakra-text.css-1wbno34");

            // Extract visible text
            String text = page.locator("p.chakra-text.css-1wbno34").innerText();
            System.out.println("Extracted text: " + text);
        }
    }
}
