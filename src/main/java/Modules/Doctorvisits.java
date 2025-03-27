package Modules;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.nio.file.Paths;

public class Doctorvisits {

    public static void main(String[] args) {

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

            String pageurl1 = page.url();
            System.out.println("Page url: " + pageurl1);
            page.waitForTimeout(5000);

            //Visits
            page.navigate("https://midoc-provider-dev.azurewebsites.net/visits");
            String pageurl2 = page.url();
            System.out.println("Page url: " + pageurl2);
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
            System.out.println("Successfully Entered the Address");

            //Emergency contact name
            page.locator("input.chakra-input.css-huwrqk").nth(1).fill("Mike");
            page.waitForTimeout(2000);
            System.out.println("Successfully Entered the Emergency contact name ");

            // Emergency Mobile No
            page.locator("input.chakra-input.css-1iu283f").nth(1).fill("9998887776");
            page.waitForTimeout(2000);
            System.out.println("Successfully Entered the Emergency Mobile No ");

            //create Visits
            page.locator("button.chakra-button.css-1n76g75").click();
            page.waitForTimeout(8000);
            System.out.println("Visit is started ");

            //In Patient Overview
            page.locator("button.css-1hyoz7m").first().click();
            page.waitForTimeout(2000);
            System.out.println("Visit is going on...  ");

            String pageurl3 = page.url();
            System.out.println("Page url: " + pageurl3);
            page.waitForTimeout(5000);


            // Checkbox
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(3).click();
            page.waitForTimeout(2000);

            // continue button
            page.locator("button.chakra-button.css-dn6flb").nth(0).click();
            page.waitForTimeout(2000);


            // add conditon
            page.locator("button.chakra-button.css-dn6flb").nth(1).click();
            page.waitForTimeout(5000);

            System.out.println("Successfully Added condition");

            // Going back to Overview
            page.locator("div[class^=\"startvisit_tabButton__\"][class*=\"css-\"] ").first().click();
            page.waitForTimeout(2000);
            System.out.println("Going back to Overview");

            // Surgeries
            page.locator("div.css-16e7rfy").nth(1).click();
            page.waitForTimeout(2000);

            // checkbox
            page.locator("span.chakra-checkbox__control.css-1fnocdi").first().click();
            page.waitForTimeout(2000);

            //continue
            page.locator("button.chakra-button.css-dn6flb").click();
            page.waitForTimeout(2000);

            //Surgeon Name
            page.locator("input.chakra-input.css-oj3rkf").nth(1).fill("Zampa");
            page.waitForTimeout(2000);

            //  Hospital Name
            page.locator("input.chakra-input.css-1kjj4hm").click();
            page.waitForTimeout(2000);

             //Click 'Add Document' button
            page.locator("button:has(img[src='/assets/imgs/add-blue.png'])").click();
            page.waitForTimeout(2000);

            // Locate and upload file using input[type='file']
            Locator fileInput = page.locator("input[type='file']");
            fileInput.setInputFiles(Paths.get("C:\\Users\\hneth\\IdeaProjects\\untitled1\\youtube.png"));

            page.waitForTimeout(6000);
            System.out.println("Uploaded File");

            //Add Surgery or contine button
            page.locator("button.chakra-button.css-dn6flb").nth(1).click();
            page.waitForTimeout(4000);
            System.out.println("Successfully Added Surgery");

              // Going back to Overview
            page.locator("div[class^=\"startvisit_tabButton__\"][class*=\"css-\"] ").first().click();
            page.waitForTimeout(2000);
            System.out.println("Going back to Overview for Allergies");

            //Allergies
            page.locator("div.css-16e7rfy").nth(2).click();
            page.waitForTimeout(2000);

            //check box
            page.locator("p.chakra-text.css-b2463j").nth(3).click();
            page.waitForTimeout(2000);

            //continue
            page.locator("button.chakra-button.css-dn6flb").click();
            page.waitForTimeout(2000);

            //Reaction
            page.locator("p.chakra-text.css-5y93pu").click();
            page.waitForTimeout(2000);

            //checkbox
         page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(3)
                 .click(new Locator.ClickOptions().setForce(true));

         page.waitForTimeout(2000);
//
//
////            //Upload file
////            page.locator("button:has(img[src='/assets/imgs/add-blue.png'])").click();
////            page.waitForTimeout(2000);
////
////            // Locate and upload file using input[type='file']
////            Locator fileInput1 = page.locator("input[type='file']");
////            fileInput.setInputFiles(Paths.get("C:\\Users\\hneth\\IdeaProjects\\untitled1\\youtube.png"));
////
////            page.waitForTimeout(6000);
////            System.out.println("Uploaded File for Allergies");

            //Add reactions
            page.locator("button.chakra-button.css-dn6flb").nth(2).click();
            page.waitForTimeout(2000);

            //add allergies
            page.locator("button.chakra-button.css-dn6flb").nth(1).click();
            page.waitForTimeout(2000);
            System.out.println("Successfully Added Allergies");

            // Going back to Overview
            page.locator("div[class^=\"startvisit_tabButton__\"][class*=\"css-\"] ").first().click();
            page.waitForTimeout(2000);
            System.out.println("Going back to Overview for Social History");

            // Add social history
            page.locator("div.css-16e7rfy").nth(3).click();
            page.waitForTimeout(2000);

            //Click Type
            page.locator("input.chakra-input.css-sf1kzh").click();
            page.waitForTimeout(2000);

            //Illict drugs
            page.locator("button.chakra-menu__menuitem.css-jax8ii").nth(8).click();
            page.waitForTimeout(2000);

            //click on radio button
            page.locator("span.chakra-radio__control.css-134kubt").first().click();
            page.waitForTimeout(2000);

            //click on radio button for "Smoke"
            page.locator("span.chakra-radio__control.css-134kubt").nth(3).click();
            page.waitForTimeout(2000);

            //drugs
            page.locator("div.css-lyv24l").click();
            page.waitForTimeout(2000);

            // Check box
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(2).click();
            page.waitForTimeout(2000);

            //Add Drugs
            page.locator("button.chakra-button.css-dn6flb").nth(1).click();
            page.waitForTimeout(2000);

            //Start
            page.locator("input.chakra-input.css-sf1kzh").nth(1).click();
            page.waitForTimeout(2000);

            //selecting the year
            page.locator("button.chakra-menu__menuitem.css-jax8ii").nth(19).click();
            page.waitForTimeout(2000);

            //Time per week
            page.locator("input.chakra-input.css-huwrqk").fill("12");
            page.waitForTimeout(2000);

            // continue or Add Social History
            page.locator("button.chakra-button.css-dn6flb").click();
            page.waitForTimeout(2000);

            System.out.println("Successfully Added Social History");

            // Going back to Overview
            page.locator("div[class^=\"startvisit_tabButton__\"][class*=\"css-\"] ").first().click();
            page.waitForTimeout(2000);
            System.out.println("Going back to Overview for Vaccination History ");

             // Index value isn't mandatory while u testing this code with different email id please chance the index value
            //Add Vaccination History
            page.locator("div.css-16e7rfy").nth(3).click();
            page.waitForTimeout(2000);

            //check box
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(1).click();
            page.waitForTimeout(2000);

            //continue
            page.locator("button.chakra-button.css-dn6flb").first().click();
            page.waitForTimeout(2000);

            //Add vaccine
            page.locator("button.chakra-button.css-dn6flb").nth(1).click();
            page.waitForTimeout(2000);
            System.out.println("Successfully Added Vaccination History");

            // Going back to Overview
            page.locator("div[class^=\"startvisit_tabButton__\"][class*=\"css-\"] ").first().click();
            page.waitForTimeout(2000);
            System.out.println("Going back to Overview for Medication ");

           // Index value isn't mandatory while u testing this code with different email id please chance the index value
            //Current Medication
            page.locator("div.css-16e7rfy").nth(4).click();

            //add medication
            page.locator("button.chakra-button.css-oeo0th").nth(0).click();
            page.waitForTimeout(2000);

            // Medicine Name
            page.locator("input.chakra-input.css-g8471e").fill("Doloper");
            page.waitForTimeout(2000);

            //Fetch
            page.locator("button.chakra-button.css-186gsh8").click();
            page.waitForTimeout(2000);

            //Dosage
            page.locator("input.chakra-input.css-wk9h3d").fill("250");
            page.waitForTimeout(2000);

            //frequency
            page.locator("input.chakra-input.css-f528jk").first().click();
            page.waitForTimeout(3000);

            //selecting the frequency
            page.locator("button.chakra-menu__menuitem.css-jax8ii").nth(11).click();
            page.waitForTimeout(3000);

            //Interval
            page.locator("input.chakra-input.css-daur78").nth(0).click();
            page.waitForTimeout(3000);

            //Interval frequency
            Locator button = page.locator("//button[contains(@class, 'chakra-menu__menuitem') and contains(@class, 'css-jax8ii')]").nth(18);
            button.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            button.scrollIntoViewIfNeeded();
            button.click();


            page.waitForTimeout(3000);

            //Duration
            page.locator("input.chakra-input.css-daur78").nth(1).click();
            page.waitForTimeout(6000);

            //frequncy duration
            page.locator("button.chakra-menu__menuitem.css-jax8ii").nth(24).click();
            page.waitForTimeout(6000);

            //Interval value
            page.locator("button.chakra-button.chakra-menu__menu-button.css-1237bhg").nth(3).click();
            page.waitForTimeout(6000);

            //Interval value frequency
            page.locator("button.chakra-menu__menuitem.css-jax8ii").nth(30).click();
            page.waitForTimeout(6000);

            // Medicine Expiry
            page.locator("img.chakra-image.css-11u7wab").click();
            page.waitForTimeout(6000);

            //Medicine Expiry calendar
            Locator dropdown = page.locator("select[name='months']");
            dropdown.waitFor(); // Ensure the dropdown is visible
            dropdown.selectOption("7"); // Select August by value

            page.waitForTimeout(2000);

            //Afternoon Checkbox
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(1).click();
            page.waitForTimeout(2000);

            //Before Food
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(3).click();
            page.waitForTimeout(2000);

            //Prescribed
            page.locator("input.chakra-input.css-rlygj7").fill("Zampa.Dr");
            page.waitForTimeout(2000);

            //Hospital
            page.locator("input.chakra-input.css-1kjj4hm").fill("Melboure Hospital");
            page.waitForTimeout(2000);

            //Current
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(5).click();
            page.waitForTimeout(2000);

            //Add Medication
            page.locator("button.chakra-button.css-dn6flb").click();
            page.waitForTimeout(2000);







            















        }

    }
}
