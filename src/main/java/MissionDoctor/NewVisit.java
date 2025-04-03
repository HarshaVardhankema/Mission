package MissionDoctor;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.nio.file.Paths;

public class NewVisit {

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
            page.locator("input.chakra-input.css-1iu283f").nth(0).fill("0478987654");
            page.waitForTimeout(2000);

            //Email id
            page.locator("input.chakra-input.css-oj3rkf").first().fill("jenson@gmail.com");
            page.waitForTimeout(2000);

            //First Name
            page.locator("input.chakra-input.css-huwrqk").nth(0).fill("Olura");
            page.waitForTimeout(2000);

            // last Name
            page.locator("input.chakra-input.css-ju3peg").fill("Jenson");
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
            page.locator("//button[contains(@class, 'css-1hyoz7m')]//div[contains(text(), 'Add Vaccine')]").click();
            page.waitForTimeout(2000);

            //check box
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(0).click();
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
            page.locator("//button[contains(@class, 'css-1hyoz7m')]//div[text()='Add Medication']").click();

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


            //chief complaint
            page.locator("textarea.chakra-input.css-1gerjx2")
                    .fill("**Chief Complaint:**  " +
                            "The patient presents with a **severe headache** that has persisted for the past three days, described as" +
                            " a throbbing pain localized to the frontal region. The headache is accompanied by **nausea, sensitivity " +
                            "to light, and occasional dizziness**. The patient reports that over-the-counter pain relievers" +
                            " have provided minimal relief. There is no history of recent head trauma, but the patient mentions " +
                            "increased stress and lack of sleep over the past week. No fever, vision changes, " +
                            "or loss of consciousness have been reported.");
            page.waitForTimeout(6000);

            // Submit button
            page.locator("button.chakra-button.css-c4nswg").click();
            page.waitForTimeout(2000);

            //HPI
            Locator hpiButton = page.locator("//div[contains(text(),'HPI')]");
            hpiButton.waitFor(); // Wait until element appears
            hpiButton.click();
            System.out.println(" Filling HPI Details ");

            page.waitForTimeout(2000);

            //Add or + button
            page.locator("span.chakra-badge.css-pj758u").first().click();
            page.waitForTimeout(2000);

            //Site
            page.locator("button.chakra-button.css-qse13x").nth(6).click();
            page.waitForTimeout(2000);

            //On site
            page.locator("span.chakra-radio__control.css-vtg3j9").nth(1).click();
            page.waitForTimeout(2000);

            //Chronity
            page.locator("span.chakra-radio__control.css-vtg3j9").nth(4).click();
            page.waitForTimeout(2000);

            //On site Quality
            page.locator("span.chakra-radio__control.css-vtg3j9").nth(7).click();
            page.waitForTimeout(2000);

            //Asscioated Symtons
            page.locator("span.chakra-checkbox__control.css-x93bhs").nth(1).click();
            page.waitForTimeout(2000);

            //Time
            page.locator("input.chakra-input.css-10dip6r").fill("6");
            page.waitForTimeout(2000);

            //Save HPI
            page.locator("button.chakra-button.css-m8d89p").click();
            page.waitForTimeout(2000);
            System.out.println("Successfully Entered the HPI Details");

            //ROS
            Locator ROSButton = page.locator("//div[contains(text(),'ROS')]");
            ROSButton.waitFor(); // Wait until element appears
            ROSButton.click();
            page.waitForTimeout(2000);
            System.out.println("Entering the ROS Details  ");

            //Checkbox of palpitations
            page.locator("button.chakra-button.css-eltcmb").nth(1).click();
            page.waitForTimeout(2000);

            // fever
            page.locator("button.chakra-button.css-eltcmb").nth(4).click();
            page.waitForTimeout(2000);

            //symptoms
            page.locator("button.chakra-button.css-eltcmb").nth(8).click();
            page.waitForTimeout(2000);

            //vomiting
            page.locator("button.chakra-button.css-eltcmb").nth(11).click();
            page.waitForTimeout(2000);

            //urgency
            page.locator("button.chakra-button.css-eltcmb").nth(16).click();
            page.waitForTimeout(2000);

            //PID
            page.locator("button.chakra-button.css-eltcmb").nth(21).click();
            page.waitForTimeout(2000);

            // Vitals
            Locator VitalsButton = page.locator("//div[contains(text(),'Vitals')]").nth(1);
            VitalsButton.waitFor(); // Wait until element appears
            VitalsButton.click();
            page.waitForTimeout(2000);
            System.out.println("enter the Vitals Details ");


            //Body Tempeature
            page.locator("input.chakra-input.css-9gr7sy").fill("65");
            page.waitForTimeout(2000);

            //Heart rate
            page.locator("input.chakra-input.css-ibn2gw").fill("78");
            page.waitForTimeout(2000);

            //Respiratory rate
            page.locator("input.chakra-input.css-1hluu5k").first().fill("45");
            page.waitForTimeout(2000);

            //Blood Pressure
            page.locator("input.chakra-input.css-1t53g0r").first().fill("90");
            page.waitForTimeout(2000);

            page.locator("input.chakra-input.css-1t53g0r").nth(1).fill("160");
            page.waitForTimeout(2000);

            //Sp02
            page.locator("input.chakra-input.css-1hluu5k").nth(1).fill("87");
            page.waitForTimeout(2000);

            // Fasting Glcouse
            page.locator("input.chakra-input.css-1hluu5k").nth(2).fill("99");
            page.waitForTimeout(2000);

            //Post glucouse
            page.locator("input.chakra-input.css-1hluu5k").nth(3).fill("50");
            page.waitForTimeout(2000);

            // Weight
            page.locator("input.chakra-input.css-1hluu5k").nth(4).fill("80");
            page.waitForTimeout(2000);

            //Height
            page.locator("input.chakra-input.css-13byjhi").nth(0).fill("5");
            page.waitForTimeout(2000);

            page.locator("input.chakra-input.css-13byjhi").nth(1).fill("5");
            page.waitForTimeout(2000);


            // Save Vitals
            page.locator("button.chakra-button.css-26eig2").click();
            page.waitForTimeout(2000);
            System.out.println("Visit is Completed ");



            //Physical Exam
            Locator PhysicalExam = page.locator("//div[contains(text(),'Physical Exam')]");
            PhysicalExam.waitFor(); // Wait until element appears
            PhysicalExam.click();
            page.waitForTimeout(2000);
            System.out.println("Entering the Physical Exam Details");

            //Eyes
            page.locator("div.css-1eziwv").nth(2).click();
            page.waitForTimeout(5000);

            // EOM Button
            Locator EOM = page.locator("//button[contains(text(), 'EOM intact')]").first();
            EOM.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            EOM.click();
            page.waitForTimeout(4000);

            // + Symbol Button
            Locator plusButton = page.locator("button.css-0 > svg").nth(22);
            plusButton.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            plusButton.click();
            page.waitForTimeout(4000);

            //- button
            Locator plusButton1 = page.locator("button.css-0 > svg").nth(25);
            plusButton1.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
            plusButton1.click();
            page.waitForTimeout(4000);

            // Save button
            page.locator("button.chakra-button.css-12mxl0v").click();
            page.waitForTimeout(4000);
            System.out.println("Completed the Physical Exam Details");


            //Assessment
            Locator Assessment = page.locator("//div[contains(text(),'Assessment')]");
            Assessment.waitFor(); // Wait until element appears
            Assessment.click();
            page.waitForTimeout(2000);
            System.out.println("Entering the Assessment");


            //primary
            Locator primary = page.locator("//button[contains(text(), 'Primary Health Issues')]");
            primary.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(60000));
            primary.click();

            page.waitForTimeout(2000);

            // Diagnons
            page.locator("input.chakra-input.css-rlygj7").fill("Doctors play a vital role in society as healthcare professionals" +
                    " who diagnose, treat, and prevent illnesses, injuries, and other health conditions." +
                    " They often specialize in various fields such as surgery, pediatrics, cardiology, neurology, and more.");
            page.waitForTimeout(2000);

            //Plan
            page.locator("textarea.chakra-textarea.css-40v6i3").fill("Doctors are highly trained professionals, " +
                    "requiring years of education and practical experience." +
                    " This typically includes earning a medical degree, completing internships or residencies, " +
                    "and often pursuing additional specialized training." +
                    " Their work is critical in maintaining public health, managing chronic conditions, and performing life-saving procedures.");


            page.waitForTimeout(2000);

            // Save Assessment
            page.locator("button.chakra-button.css-1nqo9p").click();
            page.waitForTimeout(2000);
            System.out.println("Assessment is completed ");


            //Orders
            Locator Orders = page.locator("//div[contains(text(),'Orders')]");
            Orders.waitFor(); // Wait until element appears
            Orders.click();page.waitForTimeout(2000);
            System.out.println("Order page is opened");

            //Prescription Add button
            page.locator("span.chakra-badge.css-pj758u").first().click();
            page.waitForTimeout(4000);
            System.out.println("Prescription details should added");

            //Add medication
            page.locator("button.chakra-button.css-u1gftr").click();
            page.waitForTimeout(3000);
            System.out.println("Prescription details should added");

            // Medicine
            page.locator("input.chakra-input.css-oj3rkf").nth(0).fill("Doloper");
            page.waitForTimeout(2000);

            //Fetch
            page.locator("button.chakra-button.css-1wg96yj").click();
            page.waitForTimeout(6000);

            //dosage
            page.locator("input.chakra-input.css-1qyvit7").fill("150");
            page.waitForTimeout(2000);

            //duration
            page.locator("input.chakra-input.css-daur78").nth(1).click();
            page.waitForTimeout(2000);

            //dropdown
            page.locator("button.chakra-menu__menuitem.css-jax8ii").nth(16).click();
            page.waitForTimeout(2000);

            //custom message
            page.locator("textarea.chakra-textarea.css-x7edcr").fill("I understand that you’ve been experiencing headaches, and I want to assure you that we are here to help. " +
                    " Make sure to stay hydrated, get enough rest, and avoid stress as much as possible. " +
                    "If the pain persists or worsens," +
                    " please follow the prescribed medication and let us know if you need any further assistance.");


            page.waitForTimeout(3000);

            //Add Medication
            page.locator("button.chakra-button.css-l8g89s").click();
            page.waitForTimeout(2000);

            //save prescription
            page.locator("button.chakra-button.css-dn6flb").click();
            page.waitForTimeout(2000);

            //procedure
            page.locator("span.chakra-badge.css-pj758u").nth(1).click();
            page.waitForTimeout(4000);
            System.out.println("procedure details should added");

            //Search procedure
            page.locator("button.chakra-button.css-1ovj24w").click();
            page.waitForTimeout(4000);

            //check box
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(5).click();
            page.waitForTimeout(4000);

            // Save to Orders
            page.locator("button.chakra-button.css-dn6flb").click();
            page.waitForTimeout(4000);

            //Labs
            page.locator("span.chakra-badge.css-pj758u").nth(2).click();
            page.waitForTimeout(4000);
            System.out.println("Labs details should added");

            //Add Labs
            page.locator("button.chakra-button.css-ro89zj").click();
            page.waitForTimeout(2000);

            //Lab Details
            page.locator("input.chakra-input.css-oj3rkf").nth(0).fill("Blood Test");
            page.waitForTimeout(2000);

            //Lab Details 2
            page.locator("input.chakra-input.css-oj3rkf").nth(1).fill("Blood Template  Test");
            page.waitForTimeout(2000);

            //Save labs
            page.locator("button.chakra-button.css-dn6flb").click();
            page.waitForTimeout(2000);
            System.out.println("Labs details entered successfully");

            //Imaging
            page.locator("span.chakra-badge.css-pj758u").nth(3).click();
            page.waitForTimeout(3000);
            System.out.println("Imaging details should added");

            //Search Imaging
            page.locator("button.chakra-button.css-1ovj24w").click();
            page.waitForTimeout(3000);

            // check box
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(2).click();
            page.waitForTimeout(3000);

            //Save Imaging
            page.locator("button.chakra-button.css-dn6flb").click();
            page.waitForTimeout(2000);
            System.out.println("Imaging details entered successfully");

            //Dietician Notes
            page.locator("span.chakra-badge.css-pj758u").nth(4).click();
            page.waitForTimeout(3000);
            System.out.println("Imaging details should added");

            //Add Dietician Notes
            page.locator("textarea.chakra-textarea.css-c4zcpx").nth(0).fill("I understand that you’ve been experiencing headaches, " +
                    "and we are here to help. Please ensure you stay hydrated, " +
                    "get enough rest, and manage stress effectively. " +
                    "Along with your prescribed medication, following a proper diet can also help alleviate headaches.");
            page.waitForTimeout(2000);

            //Add  Dietician
            page.locator("button.chakra-button.css-1397mel").nth(0).click();
            page.waitForTimeout(2000);

            // general notes
            page.locator("span.chakra-badge.css-pj758u").nth(5).click();
            page.waitForTimeout(3000);
            System.out.println("General Notes  details should added");

            //Add general Notes
            page.locator("textarea.chakra-textarea.css-c4zcpx").nth(1).fill("I understand that you’ve been experiencing headaches, " +
                    "and we are here to help. Please ensure you stay hydrated, " +
                    "get enough rest, and manage stress effectively. " +
                    "Along with your prescribed medication, following a proper diet can also help alleviate headaches.");
            page.waitForTimeout(2000);

            //            //Add  general
            page.locator("button.chakra-button.css-1397mel").nth(1).click();
            page.waitForTimeout(2000);

            // End Visit
            page.locator("button.chakra-button.css-8b8bhe").click();
            page.waitForTimeout(2000);

            //check box
            page.locator("span.chakra-checkbox__control.css-x93bhs").nth(0).click();
            page.waitForTimeout(2000);

            //checkbox 2
            page.locator("span.chakra-checkbox__control.css-x93bhs").nth(1).click();
            page.waitForTimeout(2000);

            //Sign Here
            page.locator("span.chakra-checkbox__control.css-x93bhs").nth(14).click();
            page.waitForTimeout(2000);

            //End Visit
            page.locator("button.chakra-button.css-dn6flb").click();
            page.waitForTimeout(2000);























        }

    }
}

