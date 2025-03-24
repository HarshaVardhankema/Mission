package Modules;

import com.microsoft.playwright.*;

public class midocAdmin {


        public static void main(String[] args) {

            try (Playwright playwright = Playwright.create()) {
                // Launch browser in non-headless mode
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                BrowserContext context = browser.newContext();
                Page page = context.newPage();

                // Navigate to
                page.navigate("https://midoc-admin-dev.azurewebsites.net/login");
                page.waitForTimeout(2000);

                // email
                page.locator("input.chakra-input.css-1jqxemg").fill("midocadmin@gmail.com");
                page.waitForTimeout(2000);

                // password
                page.locator("input.chakra-input.css-efg1n9").fill("midocadmin@321");
                page.waitForTimeout(2000);

                // continue
                page.locator("button.chakra-button.css-10jer1w").click();
                page.waitForTimeout(4000);

                // view details
                page.locator("button.css-1hyoz7m").first().click();
                page.waitForTimeout(4000);

                //approve button
                page.locator("button.chakra-button.css-dn6flb").click();
                page.waitForTimeout(4000);

                //confirm approve button
                page.locator("button.chakra-button.css-1xnl2vp").click();
                page.waitForTimeout(4000);








            }

        }

    }


