package MissionPatient;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class patient {


    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newContext().newPage();

            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/login");
            String pageurl = page.url();
            System.out.println("Page url: " + pageurl);


            //email id
            page.locator("//input[@class='chakra-input css-dhzvz6']").fill("Penta@gmail.com");
            page.waitForTimeout(2000);

            // continue button
            page.locator("//button[@class='chakra-button css-12kaf87']").click();
            page.waitForTimeout(2000);

            // enter first name
            Locator firstNameField = page.locator("//input[@class='chakra-input css-2e40ac']").nth(0);
            firstNameField.fill("Penta");
            page.waitForTimeout(2000);
            // Get the entered value
            String text = firstNameField.inputValue(); // Use inputValue() instead of textContent()
            System.out.println("Entered First Name: " + text);


            // last name
            Locator Secondfeildname = page.locator("//input[@class='chakra-input css-8fw5pz']").nth(0);
            Secondfeildname.fill("gaon");
            page.waitForTimeout(2000);
            // Get the entered value
            String text2 = Secondfeildname.inputValue();
            System.out.println("Entered Second Name: " + text2);

            // gender
            page.locator("//button[@class='chakra-button chakra-menu__menu-button css-1237bhg']").nth(0).click();
            page.waitForTimeout(1000);

            //selecting the gender
            page.locator("//button[@class='chakra-menu__menuitem css-18esm8n']").nth(0).click();
            page.waitForTimeout(2000);

            //selecting the weight dropdown
            page.locator("//button[@class='chakra-button chakra-menu__menu-button css-1237bhg']").nth(1).click();
            page.waitForTimeout(2000);

            //select the weight
            page.locator("//button[@class='chakra-menu__menuitem css-18esm8n']").nth(81).click();
            page.waitForTimeout(2000);

            //select the height in feets
            page.locator("//button[@class='chakra-button chakra-menu__menu-button css-1237bhg']").nth(2).click();
            page.waitForTimeout(2000);

            // selecting the feets
            page.locator("//button[@class='chakra-menu__menuitem css-18esm8n']").nth(7).click();
            page.waitForTimeout(2000);

            // select the inches
            page.locator("//button[@class='chakra-button chakra-menu__menu-button css-1237bhg']").nth(3).click();
            page.waitForTimeout(2000);

            //selecting the inches
            page.locator("//button[@class='chakra-menu__menuitem css-18esm8n']").nth(3).click();
            page.waitForTimeout(2000);
//
            // DOB
            page.locator("//img[@class='chakra-image css-11u7wab']").nth(0).click();
            page.waitForTimeout(2000);

            //select the year
            page.locator("//select[@class='rdp-dropdown']").nth(1).click();
            page.waitForTimeout(2000);

            //choose the year
            // Ensure the "Year" dropdown is visible and stable before interacting
            Locator yearDropdown = page.locator("//select[@name='years']");
            yearDropdown.waitFor(); // Wait until the dropdown is ready
            yearDropdown.selectOption("1996"); // Select the year
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

            //sout for DOB
            System.out.println("Date of Birth selected successfully!");

            // Mobile No
            page.locator("//input[@class='chakra-input css-1iu283f']").nth(0)
                    .fill("9908076543");
            page.waitForTimeout(2000);


            // Continue button
            page.locator("//button[@class='chakra-button css-zk5ooc']").nth(0).click();
            page.waitForTimeout(2000);
            System.out.println("Sucessfully First page completed!");

            // OTP Page
            page.locator("//input[@class='chakra-pin-input css-1u9rwo1']").nth(0).fill("1");
            page.waitForTimeout(2000);
            page.locator("//input[@class='chakra-pin-input css-1u9rwo1']").nth(1).fill("2");
            page.waitForTimeout(2000);
            page.locator("//input[@class='chakra-pin-input css-1u9rwo1']").nth(2).fill("3");
            page.waitForTimeout(2000);
            page.locator("//input[@class='chakra-pin-input css-1u9rwo1']").nth(3).fill("4");
            page.waitForTimeout(2000);

            // OTP Continue button
            page.locator("//button[@class='chakra-button css-12kaf87']").click();
            page.waitForTimeout(2000);
            System.out.println("completed the otp page ");

            //Blood type dropdown
            page.locator("//button[@class='chakra-button chakra-menu__menu-button css-1237bhg']")
                    .nth(0).click();
            page.waitForTimeout(2000);

            // Selecting the dropdown
            page.locator("//button[@class='chakra-menu__menuitem css-18esm8n']").nth(4).click();
            page.waitForTimeout(2000);

            //Covid Vaccination  dropdown
            page.locator("//button[@class='chakra-button chakra-menu__menu-button css-1237bhg']")
                    .nth(1).click();
            page.waitForTimeout(2000);

            //dropdown details
            page.locator("//button[@class='chakra-menu__menuitem css-18esm8n']").nth(8).click();
            page.waitForTimeout(2000);

            //skip
            page.locator("//button[@class='chakra-button css-1cv8wnd']").nth(0).click();
            page.waitForTimeout(2000);

            //new password
            page.locator("//input[@id='password']").first().fill("midoc123");
            page.waitForTimeout(2000);

            //confirm password
            page.locator("//input[@id='confirmpassword']").first().fill("midoc123");
            page.waitForTimeout(2000);

            //continue
            page.locator("//button[@class='chakra-button css-zk5ooc']").first().click();
            page.waitForTimeout(4000);
            System.out.println("completed the flow of signup");

            page.locator("//button[@class='chakra-button css-zk5ooc']").click();
            page.waitForTimeout(3000);

            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/home");
            page.waitForTimeout(3000);
            String pageurl1 = page.url();
            System.out.println("Page url: " + pageurl1);

            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/myhealth");
            page.waitForTimeout(3000);
            String pageurl2 = page.url();
            System.out.println("Page url: " + pageurl2);

            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/vitals");
            page.waitForTimeout(3000);
            String pageurl3 = page.url();
            System.out.println("Page url: " + pageurl3);

            // add data button
            page.locator("//button[@class='chakra-button css-15i9xzt']").first().click();

            // add body tempeature
            page.locator("p.chakra-text.css-11rqhwb").first().click();

            // click on the feild box
            page.locator("//input[@id='vitalvalue']").fill("100");
            page.waitForTimeout(2000);

            //add body temperature
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);

            // skip
            page.locator("button.chakra-button.css-1cv8wnd").click();
            page.waitForTimeout(4000);
            System.out.println("Body Tempeature Value entered");

            // weight
            page.locator("div.css-1xkj9qd").first().click();
            page.waitForTimeout(2000);

            // add weight
            page.locator("input.chakra-input.css-17k2bm9").fill("81");

            // submit weight
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);

            //skip
            page.locator("button.chakra-button.css-1cv8wnd").click();
            page.waitForTimeout(4000);
            System.out.println("Weight Value entered");

            //height
            page.locator("div.css-1xkj9qd").nth(1).click();
            page.waitForTimeout(2000);

            // height details
            page.locator("//input[@id='heightvalue']").first().fill("6");

            //submit height button
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);

//            Skip
            page.locator("button.chakra-button.css-1cv8wnd").click();
            page.waitForTimeout(4000);
            System.out.println("Height Value entered");

//          Respiratory
            page.locator("div.css-1xkj9qd").nth(2).click();
            page.waitForTimeout(2000);

//            respiratory value
            page.locator("input.chakra-input.css-17k2bm9").fill("26");
            page.waitForTimeout(2000);

//          Add respiratory value button
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);

//          skip button
            page.locator("button.chakra-button.css-1cv8wnd").click();
            page.waitForTimeout(4000);
            System.out.println("Respiratory Value entered");

            //oxygen saturation
            page.locator("div.css-1xkj9qd").nth(4).click();
            page.waitForTimeout(2000);

            // add oxygen saturation
            page.locator("input.chakra-input.css-17k2bm9").fill("46");
            page.waitForTimeout(2000);

            // submit button
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);

            //Skip button
            page.locator("button.chakra-button.css-1cv8wnd").click();
            page.waitForTimeout(4000);
            System.out.println("oxygen saturation Value entered");

            //blood Pressure
            page.locator("div.css-1xkj9qd").nth(5).click();
            page.waitForTimeout(2000);

            // add blood Pressure syscolic
            page.locator("input.chakra-input.css-17k2bm9").first().fill("26");
            page.waitForTimeout(2000);

            //add blood Pressure Diastolic
            page.locator("input.chakra-input.css-17k2bm9").nth(1).fill("46");
            page.waitForTimeout(2000);

            //add blood pressure
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(4000);

            // skip
            page.locator("button.chakra-button.css-1cv8wnd").click();
            page.waitForTimeout(4000);
            System.out.println("Oxygen saturation Value entered");

            //Hear rate
            page.locator("div.css-1xkj9qd").nth(6).click();
            page.waitForTimeout(2000);

            // heart rate value
            page.locator("input.chakra-input.css-17k2bm9").fill("78");
            page.waitForTimeout(2000);

            // submit
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);

            //skip
            page.locator("button.chakra-button.css-1cv8wnd").click();
            page.waitForTimeout(4000);
            System.out.println("Heart Rate Value entered");

            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/conditions");
            String pageurl4 = page.url();
            System.out.println("Page url: " + pageurl4);
            page.waitForTimeout(2000);

            //add condition
            page.locator("button.chakra-button.css-15i9xzt").click();
            page.waitForTimeout(2000);

            //check box
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(3).click();
            page.waitForTimeout(2000);

            // continue button
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);


            //calendar
            page.locator("input.chakra-input.css-m3kfhz").click();
            page.waitForTimeout(2000);

            // date
            page.locator("button.rdp-button_reset.rdp-button.rdp-day").nth(2).click();
            page.waitForTimeout(2000);

            // add conditon
            page.locator("button.chakra-button.css-zk5ooc").nth(1).click();
            page.waitForTimeout(2000);

            System.out.println("Successfully Added condition");

            // Surgeries
            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/surgeries");
            String pageurl5 = page.url();
            System.out.println("Page url: " + pageurl5);
            page.waitForTimeout(3000);

            //add surgeries
            page.locator("button.chakra-button.css-15i9xzt").click();
            page.waitForTimeout(2000);

            // checkbox
            page.locator("span.chakra-checkbox__control.css-1fnocdi").first().click();
            page.waitForTimeout(2000);

            //continue
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);

            //surgeron name
            page.locator("input.chakra-input.css-s5ecup").nth(1).fill("Lee");
            page.waitForTimeout(2000);

            //Hospital name
            page.locator("input.chakra-input.css-121oy8e").fill("Lee Hospital");
            page.waitForTimeout(2000);

            // Click 'Add Document' button
            page.locator("button:has(img[src='/assets/imgs/add-blue.png'])").click();
            page.waitForTimeout(2000);

            // Locate and upload file using input[type='file']
            Locator fileInput = page.locator("input[type='file']");
            fileInput.setInputFiles(Paths.get("C:\\Users\\hneth\\IdeaProjects\\untitled1\\youtube.png"));

            page.waitForTimeout(6000);

            //Add surgical button
            page.locator("button.chakra-button.css-zk5ooc").nth(1).click();

            // medication
            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/medications");
            String pageurl6 = page.url();
            System.out.println("Page url: " + pageurl6);
            page.waitForTimeout(2000);
//            page.waitForTimeout(2000);

            //add medication
            page.locator("button.chakra-button.css-15i9xzt").click();
            page.waitForTimeout(2000);

            //medicine name
            page.locator("input.chakra-input.css-g8471e").fill("Doloper");
            page.waitForTimeout(2000);

            //fetch
            page.locator("button.chakra-button.css-1og3d7u").click();
            page.waitForTimeout(5000);

            //dosage
            page.locator("input.chakra-input.css-wk9h3d").fill("150");
            page.waitForTimeout(2000);
//
            //consumption frequncy
            page.locator("input.chakra-input.css-wr6uy9").click();
            page.waitForTimeout(2000);

            // dropdown select
            page.getByText("2").nth(1).click();
            page.waitForTimeout(2000);

            //medicine expiry
            page.locator("input.chakra-input.css-1t2m1dl").click();
            page.waitForTimeout(2000);

            // Ensure the "Year" dropdown is visible and stable before interacting
            yearDropdown = page.locator("//select[@name='years']");
            yearDropdown.waitFor(); // Wait until the dropdown is ready
            yearDropdown.selectOption("2027"); // Select the year
            page.waitForTimeout(2000);

            // moring check box
            page.locator("span.chakra-checkbox__control.css-1fnocdi").first().click();
            page.waitForTimeout(2000);

            // before food
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(3).click();
            page.waitForTimeout(2000);

            //prescribed by
            page.locator("input.chakra-input.css-dhzvz6").fill("Lee");
            page.waitForTimeout(2000);

            //Hospital
            page.locator("input.chakra-input.css-121oy8e").fill("Lee Hospital");
            page.waitForTimeout(2000);

            // Current
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(5).click();
            page.waitForTimeout(2000);


            // Click 'Add Document' button
            page.locator("button:has(img[src='/assets/imgs/add-blue.png'])").click();
            page.waitForTimeout(2000);
            page.locator("input[type='file']").nth(1).setInputFiles(Paths.get("C:\\Users\\hneth\\OneDrive\\Pictures\\Camera Roll\\download.jpeg"));
            page.waitForTimeout(4000);

            // mediction submit button
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);

            // Allergies
            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/allergies");
            String pageurl7 = page.url();
            System.out.println("Page url: " + pageurl7);
            page.waitForTimeout(2000);

            // add allergies
            page.locator("button.chakra-button.css-15i9xzt").first().click();
            page.waitForTimeout(2000);

            // selecting the allergies
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(1).click();
            page.waitForTimeout(2000);

            // continue
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);

//         //   calendar
            page.locator("input.chakra-input.css-m3kfhz").click();
            page.waitForTimeout(2000);

            // date
            page.locator("button.rdp-button_reset.rdp-button.rdp-day").nth(2).click();
            page.waitForTimeout(2000);

            // Reactions
            page.locator("div.css-lyv24l").click();
            page.waitForTimeout(2000);

            // check box
            page.locator("span.chakra-checkbox__control.css-1fnocdi").nth(1).click(new Locator.ClickOptions().setForce(true));
            page.waitForTimeout(3000);

            //Add reaction button
            Locator addReactionsButton = page.locator("//button[contains(text(),'Add reactions')]");
            addReactionsButton.click();

            page.waitForTimeout(2000);

            // Click 'Add Document' button
            page.locator("button:has(img[src='/assets/imgs/add-blue.png'])").click();
            page.waitForTimeout(2000);
            page.locator("input[type='file']").setInputFiles(Paths.get("C:\\Users\\hneth\\OneDrive\\Pictures\\Camera Roll\\download.jpeg"));
            page.waitForTimeout(4000);

            //submit allergies details
            page.locator("button.chakra-button.css-zk5ooc").nth(1).click();
            page.waitForTimeout(5000);

            //Family History
            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/familyhistory");
            String pageurl8 = page.url();
            System.out.println("Page url: " + pageurl8);
            page.waitForTimeout(2000);

            // Add Family button
            page.locator("button.chakra-button.css-15i9xzt").click();
            page.waitForTimeout(2000);
//
            // first name
            page.locator("input.chakra-input.css-dhzvz6").fill("Pitts");
            page.waitForTimeout(2000);

            // last name
            page.locator("input.chakra-input.css-s5ecup").first().fill("burg");
            page.waitForTimeout(2000);

            // gender
            page.locator("//button[@class='chakra-button chakra-menu__menu-button css-1237bhg']").nth(0).click();
            page.waitForTimeout(1000);

            //selecting the gender
            page.locator("//button[@class='chakra-menu__menuitem css-18esm8n']").nth(0).click();
            page.waitForTimeout(2000);

            //selecting the weight dropdown
            page.locator("//button[@class='chakra-button chakra-menu__menu-button css-1237bhg']").nth(1).click();
            page.waitForTimeout(2000);

            //select the weight
            page.locator("//button[@class='chakra-menu__menuitem css-18esm8n']").nth(81).click();
            page.waitForTimeout(2000);

            //select the height in feets
            page.locator("//button[@class='chakra-button chakra-menu__menu-button css-1237bhg']").nth(2).click();
            page.waitForTimeout(2000);

            // selecting the feets
            page.locator("//button[@class='chakra-menu__menuitem css-18esm8n']").nth(7).click();
            page.waitForTimeout(2000);

            // select the inches
            page.locator("//button[@class='chakra-button chakra-menu__menu-button css-1237bhg']").nth(3).click();
            page.waitForTimeout(2000);

            //selecting the inches
            page.locator("//button[@class='chakra-menu__menuitem css-18esm8n']").nth(3).click();
            page.waitForTimeout(2000);

            // DOB
            page.locator("//img[@class='chakra-image css-11u7wab']").nth(0).click();
            page.waitForTimeout(2000);

            //select the year
            page.locator("//select[@class='rdp-dropdown']").nth(1).click();
            page.waitForTimeout(2000);

            //choose the year
            // Ensure the "Year" dropdown is visible and stable before interacting
            yearDropdown = page.locator("//select[@name='years']");
            yearDropdown.waitFor(); // Wait until the dropdown is ready
            yearDropdown.selectOption("1996"); // Select the year
            page.waitForTimeout(2000);

            // Select the Month
            monthDropdown = page.locator("//select[@name='months']");
            monthDropdown.waitFor();
            monthDropdown.selectOption("7"); // Choose August
            page.waitForTimeout(2000);

            // Select Date (Ensure correct structure in UI)
            dateButton = page.locator("//button[contains(@class, 'rdp-day') and text()='22']");
            dateButton.scrollIntoViewIfNeeded();
            dateButton.click();
            page.waitForTimeout(2000);

            //sout for DOB
            System.out.println("Date of Birth selected successfully!");

            //Relationship
            page.locator("button.chakra-button.chakra-menu__menu-button.css-1237bhg").nth(4).click();
            page.waitForTimeout(2000);

            // selecting the Relationship
            page.locator("button.chakra-menu__menuitem.css-18esm8n").nth(3).click();
            page.waitForTimeout(2000);

            // Mobile No
            page.locator("//input[@class='chakra-input css-1iu283f']").nth(0)
                    .fill("2108976543");
            page.waitForTimeout(2000);

            //Email
            page.locator("input.chakra-input.css-s5ecup").nth(1).fill("Pittsburg@gmail.com");
            page.waitForTimeout(2000);

            // Blood type dropdown
            page.locator("//button[@class='chakra-button chakra-menu__menu-button css-1237bhg']")
                    .nth(5).click();
            page.waitForTimeout(2000);

            // Selecting the dropdown
            page.locator("button.chakra-menu__menuitem.css-18esm8n").nth(13).click();
            page.waitForTimeout(2000);

            // Martial Status
            page.locator("//button[@class='chakra-button chakra-menu__menu-button css-1237bhg']")
                    .nth(6).click();
            page.waitForTimeout(2000);

            //Selecting the dropdown
            page.locator("button.chakra-menu__menuitem.css-18esm8n").nth(21).click();
            page.waitForTimeout(2000);

            //add member
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);

            // vaccination
            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/vaccination");
            String pageurl9 = page.url();
            System.out.println("Page url: " + pageurl9);
            page.waitForTimeout(2000);

            //Add vaccination
            page.locator("button.chakra-button.css-15i9xzt").nth(0).click();
            page.waitForTimeout(2000);

            //selecting the vaccine from checkbox
            page.locator("p.chakra-text.css-3pk8di").nth(0).click();
            page.waitForTimeout(2000);

            // continue button
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);

            //Admin Calendar

            page.locator("input.chakra-input.css-m3kfhz").first().click();
            page.waitForTimeout(2000);

            // date
            page.locator("button.rdp-button_reset.rdp-button.rdp-day").nth(2).click();
            page.waitForTimeout(2000);

            // continue button
            page.locator("button.chakra-button.css-zk5ooc").nth(1).click();
            page.waitForTimeout(2000);

            // Soical History
            page.navigate("https://midoc-patientapp-dev.azurewebsites.net/socialhistory");
            String pageurl10 = page.url();
            System.out.println("Page url: " + pageurl10);
            page.waitForTimeout(2000);

            // Add Social History
            page.locator("button.chakra-button.css-15i9xzt").first().click();
            page.waitForTimeout(2000);

            //Type
            page.locator("button.chakra-button.chakra-menu__menu-button.css-1237bhg").click();
            page.waitForTimeout(2000);

            //tYPE DROPDOWN
            page.locator("button.chakra-menu__menuitem.css-18esm8n").nth(0).click();
            page.waitForTimeout(2000);

            //Current
            page.locator("span.chakra-radio__label.css-14iyyou").nth(0).click();
            page.waitForTimeout(2000);

            //start year
            page.locator("button.chakra-button.chakra-menu__menu-button.css-1237bhg").nth(1).click();
            page.waitForTimeout(2000);

            // dropdown
            page.locator("button.chakra-menu__menuitem.css-18esm8n").nth(8).click();
            page.waitForTimeout(2000);

            //Drink per week
            page.locator("input.chakra-input.css-12iacnc").fill("6");
            page.waitForTimeout(2000);

            //Add social History button
            page.locator("button.chakra-button.css-zk5ooc").click();
            page.waitForTimeout(2000);



        }

    }
}


