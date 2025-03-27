package Modules;

import com.microsoft.playwright.*;


    public class DoctorFinal {
        public static void main(String[] args) {

            try (Playwright playwright = Playwright.create()) {
                // Launch browser in non-headless mode
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                BrowserContext context = browser.newContext();
                Page page = context.newPage();

                page.navigate("https://www.google.co.in/");
                page.waitForTimeout(2000);

                page.navigate("https://midoc-provider-dev.azurewebsites.net/finalsteps");
                page.waitForTimeout(10000);

                // clinic visit
                page.locator("p.chakra-text.css-is26s5").nth(0).click();
                page.waitForTimeout(2000);

                // video visit
                page.locator("p.chakra-text.css-is26s5").nth(1).click();
                page.waitForTimeout(2000);
//
                //continue button for service type
                page.locator("button.chakra-button.css-dn6flb").first().click();
                page.waitForTimeout(2000);

                // working hours
                page.locator("button.chakra-button.css-180ieaa").first().click();
                page.waitForTimeout(2000);

                // Before Call buffer
                page.locator("input.chakra-input.css-1gb6m6j").nth(1).fill("20");
                page.waitForTimeout(2000);

                //After Call buffer
                page.locator("input.chakra-input.css-huwrqk").nth(1).fill("20");
                page.waitForTimeout(2000);

                //Limit
                page.locator("span.chakra-switch__thumb.css-7roig").nth(0).click();
                page.waitForTimeout(2000);

                //upto
                page.locator("input.chakra-input.css-1mfmui2").fill("31");
                page.waitForTimeout(2000);

                //Range
                page.locator("button.chakra-button.chakra-menu__menu-button.css-1237bhg").nth(4).click();
                page.waitForTimeout(2000);

                // Selecting the range
                page.locator("button.chakra-menu__menuitem.css-jax8ii").nth(8).click();
                page.waitForTimeout(2000);

                //slot setup
                page.locator("button.chakra-button.css-dn6flb").first().click();
                page.waitForTimeout(2000);


                //Review Continue button
                page.locator("button.chakra-button.css-180ieaa").first().click();
                page.waitForTimeout(2000);

                // page.waitForTimeout(9000);


            }
        }
    }


