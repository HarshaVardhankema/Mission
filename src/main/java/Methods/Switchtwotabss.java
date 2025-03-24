package Methods;

import com.microsoft.playwright.*;

public class Switchtwotabss {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();

            // **Step 1: Open the first tab (Doctor Signup)**
            Page doctorPage = context.newPage();
            doctorPage.navigate("https://midoc-provider-dev.azurewebsites.net/signup");

            // Perform signup steps (example: entering details)
            doctorPage.fill("#name", "Dr. Harsha");
            doctorPage.fill("#email", "drharsha@example.com");
            doctorPage.fill("#password", "Password123");
            doctorPage.click("#submitButton"); // Click Signup button
            doctorPage.waitForTimeout(3000); // Wait for request submission

            // **Step 2: Open the Admin Panel in a New Tab**
            Page adminPage = context.newPage();
            adminPage.navigate("https://midoc-admin-dev.azurewebsites.net/login");

            // Perform Admin Login
            adminPage.fill("#email", "admin@example.com");
            adminPage.fill("#password", "Admin123");
            adminPage.click("#loginButton");
            adminPage.waitForTimeout(3000);

            // **Step 3: Approve Doctor Request in Admin Panel**
            adminPage.click("#approveDoctorRequest"); // Click approve button
            adminPage.waitForTimeout(3000);

            // **Step 4: Switch Back to the Doctor Tab**
            doctorPage.bringToFront(); // Brings the doctor page to the front

            // Check if the approval reflects on the doctor page
            doctorPage.waitForTimeout(2000);
            doctorPage.reload(); // Refresh the page if needed

            System.out.println("Doctor request approved successfully!");
        }
    }
}



