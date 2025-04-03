# UI Automation Testing Exercise  

## Objective  

This exercise is designed to evaluate your proficiency in UI automation testing, encompassing various aspects of software development and testing best practices.  

## Evaluation Criteria  

Your submission will be assessed based on the following criteria:  

-   **GitHub Proficiency:** Version control using Git, including branching, commits, and pull requests.  
-   **Pipeline Creation:** Design and implementation of CI/CD pipelines.  
-   **Best Practices:** Adherence to industry standards for:  
    -   Test Automation  
    -   Continuous Testing  
    -   Clean Code  
-   **Technical Skills:** Demonstrated expertise in Selenium and Java.  

## Workflow  

-   The exercise is divided into 5 phases, each requiring at least one Pull Request (PR).  
-   Submit your work to your personal GitHub repository.  
-   Consider submitting multiple PRs per phase to facilitate code review.  
-   Each phase outlines high-level requirements. Clarifications can be sought from your evaluator.  

## Phases  

### Phase 1: Initial Setup  

1.  **Repository Creation:** Create a new repository on GitHub.  
2.  **Environment Configuration:** Configure your development environment for Selenium and Java. Choose between Maven and Gradle, and include necessary libraries.  
3.  **Test Automation (SauceDemo):** Using [https://www.saucedemo.com/](https://www.saucedemo.com/) as the base:  
    -   Automate test cases for successful and unsuccessful login attempts using the `standard_user` account.  
    -   Automate test cases for login attempts using the `locked_out_user` account.  

### Phase 2: Pipeline Configuration  

1.  **Cross-Browser Testing:** Configure existing tests to run on multiple browsers.  
2.  **GitHub Actions Integration:** Configure existing tests to run on GitHub Actions.  
    -   **Triggers:**  
        -   Scheduled execution once per day at a fixed time.  
        -   Triggered upon creation of a new PR.  
        -   Triggered upon merging into the main branch.  
    -   **Static Analysis:** Enable linters or static code analysis tools.  

### Phase 3: End-to-End (E2E) Flow  

1.  **Target Website:** [https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/)  
    -   **Credentials:**  
        -   **Username:** `customer@practicesoftwaretesting.com`  
        -   **Password:** `welcome01`  
2.  **Automation Requirements:** Automate a purchase flow that includes:  
    -   Selecting one tool from each category (hand tools, power tools, and other).  
    -   Using a different search method for each tool selection:  
        -   Search bar  
        -   Category filters  
        -   Combination of the above with sorting or price range filters.  
    -   After adding the three products to the shopping cart, complete the checkout process using the provided credentials.  
    -   Use any payment method to confirm the purchase.  
    -   Verify that the process completes successfully.  
    -   Verify that the invoice is successfully associated with the user account.  

### Phase 4: Reporting  

1.  **Reporting Tool Integration:** Integrate a test execution reporting tool such as Allure, ExtentReports, or custom reports using TestNG or JUnit.  
2.  **Pipeline Integration:** Configure the pipeline to generate reports for all executed tests.  

### Phase 5: Alerts, iFrames, and Tabs  

1.  **Target Website:** [https://demoqa.com/](https://demoqa.com/)  
2.  **Section:** Navigate to the "Alerts, Frame & Windows" section.  
3.  **Test Cases:** Implement test cases for each of the following examples:  
    -   **Browser Windows:** Open a new browser tab and verify its content.  
    -   **Alerts:** Verify that a confirmation box opens and that the page reflects the selected button.  
    -   **Nested Frames:** Verify the content of the nested iFrame.  

    # UI Automation Testing Exercise  

## Objective  

This exercise is designed to evaluate your proficiency in UI automation testing, encompassing various aspects of software development and testing best practices.  

## Evaluation Criteria  

Your submission will be assessed based on the following criteria:  

- **GitHub Proficiency:** Version control using Git, including branching, commits, and pull requests.  
- **Pipeline Creation:** Design and implementation of CI/CD pipelines.  
- **Best Practices:** Adherence to industry standards for:  
  - Test Automation  
  - Continuous Testing  
  - Clean Code  
- **Technical Skills:** Demonstrated expertise in Selenium and Java.  

## Workflow  

- The exercise is divided into 5 phases, each requiring at least one Pull Request (PR).  
- Submit your work to your personal GitHub repository.  
- Consider submitting multiple PRs per phase to facilitate code review.  
- Each phase outlines high-level requirements. Clarifications can be sought from your evaluator.  

## Phases  

### Phase 1: Initial Setup  

1. **Repository Creation:** Create a new repository on GitHub.  
2. **Environment Configuration:** Configure your development environment for Selenium and Java. Choose between Maven and Gradle, and include necessary libraries.  
3. **Test Automation (SauceDemo):** Using [https://www.saucedemo.com/](https://www.saucedemo.com/) as the base:  
   - Automate test cases for successful and unsuccessful login attempts using the `standard_user` account.  
   - Automate test cases for login attempts using the `locked_out_user` account.  

cehck 

### Phase 3: End-to-End (E2E) Flow  

1. **Target Website:** [https://practicesoftwaretesting.com/](https://practicesoftwaretesting.com/)  
   - **Credentials:**  
     - **Username:** `customer@practicesoftwaretesting.com`  
     - **Password:** `welcome01`  
2. **Automation Requirements:** Automate a purchase flow that includes:  
   - Selecting one tool from each category (hand tools, power tools, and other).  
   - Using a different search method for each tool selection:  
     - Search bar  
     - Category filters  
     - Combination of the above with sorting or price range filters.  
   - After adding the three products to the shopping cart, complete the checkout process using the provided credentials.  
   - Use any payment method to confirm the purchase.  
   - Verify that the process completes successfully.  
   - Verify that the invoice is successfully associated with the user account.  

### Phase 4: Reporting  

1. **Reporting Tool Integration:** Integrate a test execution reporting tool such as Allure, ExtentReports, or custom reports using TestNG or JUnit.  
2. **Pipeline Integration:** Configure the pipeline to generate reports for all executed tests.  

### Phase 5: Alerts, iFrames, and Tabs  

1. **Target Website:** [https://demoqa.com/](https://demoqa.com/)  
2. **Section:** Navigate to the "Alerts, Frame & Windows" section.  
3. **Test Cases:** Implement test cases for each of the following examples:  
   - **Browser Windows:** Open a new browser tab and verify its content.  
   - **Alerts:** Verify that a confirmation box opens and that the page reflects the selected button.  
   - **Nested Frames:** Verify the content of the nested iFrame.  

feat(automation): Implement E2E purchase flow with API response handling

This commit introduces comprehensive enhancements to the UI automation framework, focusing on the implementation of Phase 3: End-to-End Purchase Flow. The changes include:

1. API Response Handling:
   - Introduced ApiWaitUtils utility class to manage asynchronous API responses
   - Implemented waitForApiResponse method to ensure UI elements are updated after API calls
   - Added proper error handling for API response waiting

2. Code Optimization:
   - Removed unused methods from CartPage and HomePage classes
   - Eliminated redundant code in PracticeSoftwareTestingSteps
   - Standardized WebElement locators using data-test attributes for improved maintainability

3. E2E Purchase Flow Implementation:
   - Enhanced product selection methods with multiple search strategies:
     * Direct search bar queries
     * Category-based filtering
     * Combined filtering with price range and sorting
   - Implemented robust checkout process with proper validation
   - Added invoice verification to confirm successful order association

4. Technical Improvements:
   - Replaced magic numbers with named constants
   - Improved exception handling throughout the codebase
   - Enhanced WebDriverWaitUtils with standardized timeout values
   - Implemented proper cleanup in tearDown methods

These changes ensure reliable execution of the E2E purchase flow, with proper handling of asynchronous operations and validation of the complete user journey from product selection to invoice verification.