package MissionDoctor;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class Doctor {
        public static void main(String[] args) {

            try (Playwright playwright = Playwright.create()) {
                // Launch browser in non-headless mode
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                BrowserContext context = browser.newContext();
                Page page = context.newPage();

                // Navigate to DoctorLogin
                page.navigate("https://midoc-provider-dev.azurewebsites.net/login");

             //   String pageurl = page.url();
                System.out.println("Page url: " + pageurl);
                page.waitForTimeout(8000);

                //signup link
                page.locator("button.css-eq1gvl").first().click();
                page.waitForTimeout(2000);


                // upload profile image
                page.locator("input[type='file']").nth(1).setInputFiles(Paths.get("C:\\Users\\hneth\\OneDrive\\Pictures\\Camera Roll\\download.jpeg"));
                page.waitForTimeout(5000);
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upload")).click();
                page.waitForTimeout(2000);

                //first name
                page.locator("input.chakra-input.css-rlygj7").first().fill("Odin");
                page.waitForTimeout(2000);

                //Last Name
                page.locator("input.chakra-input.css-oj3rkf").first().fill("Mars");
                page.waitForTimeout(2000);

                //Gender
                page.locator("input.chakra-input.css-daur78").first().click();
                page.waitForTimeout(2000);

                //dropdown
                page.locator("button.chakra-menu__menuitem.css-jax8ii").nth(1).click();
                page.waitForTimeout(2000);

                //DOB
                page.locator("input.chakra-input.css-9uk493").first().click();
                page.waitForTimeout(2000);

                //choose the year
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

                // Mobile No
                page.locator("input.chakra-input.css-15q3kii").nth(0).fill("8011508100");
                page.waitForTimeout(2000);

                //Email
                page.locator("input.chakra-input.css-oj3rkf").nth(1).fill("MarsOdin@gmail.com");
                page.waitForTimeout(2000);

                //Password
                page.locator("input.chakra-input.css-efg1n9").first().fill("midoc123");
                page.waitForTimeout(2000);

                //continue button
                page.locator("button.chakra-button.css-dn6flb").first().click();
                page.waitForTimeout(2000);
                System.out.println("First page Completed");

                // Hospital Name
                page.getByLabel("Hospital/Clinic name*").nth(0).fill("Mars Hospital");
                page.waitForTimeout(4000);


                //Degree
                page.locator("button.css-vk0o94").first().click();
                page.waitForTimeout(4000);

                // dropdown and checkbox
                page.locator("p.chakra-text.css-3pk8di").first().click();
                page.waitForTimeout(2000);

                //Update Degree
                page.locator("div.css-1hw3fmi").click();
                page.waitForTimeout(2000);

                //Years of Experencies
                page.locator("button.chakra-button.chakra-menu__menu-button.css-1237bhg").first().click();
                page.waitForTimeout(2000);

                //selecting the years from dropdown
                page.locator("button.chakra-menu__menuitem.css-jax8ii").nth(12).click();
                page.waitForTimeout(2000);

                //Continue
                page.locator("button.chakra-button.css-dn6flb").first().click();
                page.waitForTimeout(4000);
                System.out.println("Second page Completed");

                //Select the Speaclity
                page.locator(".css-ytxh3i").first().click();
                page.waitForTimeout(2000);

                // continue
                page.locator("button.chakra-button.css-dn6flb").first().click();
                page.waitForTimeout(2000);
                System.out.println("Third page Completed");

                // skip
                page.locator("button.chakra-button.css-xx89lr").first().click();
                page.waitForTimeout(2000);
                System.out.println("Fourth page Completed");

                // payment
                page.locator("span.chakra-radio__control.css-efvpi5").nth(0).click();
                page.waitForTimeout(4000);

                // continue button
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
                page.waitForTimeout(8000);
                System.out.println("Five page Completed");

                page.navigate("https://midoc-provider-dev.azurewebsites.net/finalsteps");
                String pageurl1 = page.url();
                System.out.println("Page url: " + pageurl1);
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
                System.out.println("Service Page Completed");

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
                System.out.println("Working Hours page completed");


                //Review Continue button
                page.locator("button.chakra-button.css-180ieaa").first().click();
                page.waitForTimeout(2000);
                System.out.println("Review page Completed");
                System.out.println("Successfully Doctor Created Thanks midoc ");
                System.out.println("Page is navigating to admin panel ");


                // **Step 2: Open the Admin Panel in a New Tab**
                Page adminPage = context.newPage();
                adminPage.navigate("https://midoc-admin-dev.azurewebsites.net/login");
                String pageurl11 = page.url();
                System.out.println("Page url: " + pageurl1);
                page.waitForTimeout(8000);


//            // Email
//            // Navigate to
//            adminPage.navigate("https://midoc-admin-dev.azurewebsites.net/login");
//            adminPage.waitForTimeout(2000);

                // email
                adminPage.locator("input.chakra-input.css-1jqxemg").fill("midocadmin@gmail.com");
                adminPage.waitForTimeout(2000);

                // password
                adminPage.locator("input.chakra-input.css-efg1n9").fill("midocadmin@321");
                adminPage.waitForTimeout(2000);

                // continue
                adminPage.locator("button.chakra-button.css-10jer1w").click();
                adminPage.waitForTimeout(4000);

                //page navigate to doctors
                adminPage.navigate("https://midoc-admin-dev.azurewebsites.net/doctors");
                String pageurl2 = page.url();
                System.out.println("Page url: " + pageurl2);
                adminPage.waitForTimeout(2000);

                //Three Dots
                adminPage.locator("button.chakra-menu__menu-button").nth(3).click();
                adminPage.waitForTimeout(4000);

                //View
                adminPage.locator("button.chakra-menu__menuitem.css-jax8ii").nth(23).click();
                adminPage.waitForTimeout(5000);

                //Approve
                adminPage.locator("button.chakra-button.css-dn6flb").click();
                adminPage.waitForTimeout(2000);

                //confirm Approve
                adminPage.locator("button.chakra-button.css-1xnl2vp").click();
                adminPage.waitForTimeout(2000);
                System.out.println("Doctor Approved Successfully ");





























































            }

        }

    }


