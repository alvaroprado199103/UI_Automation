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

### Phase 2: Pipeline Configuration (Current Phase)  

1. **Cross-Browser Testing:** Configure existing tests to run on multiple browsers.  
2. **GitHub Actions Integration:** Configure existing tests to run on GitHub Actions.  
   - **Triggers:**  
     - Scheduled execution once per day at a fixed time.  
     - Triggered upon creation of a new PR.  
     - Triggered upon merging into the main branch.  
   - **Static Analysis:** Enable linters or static code analysis tools.  

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

## Current Status and Recent Changes  

**Current Phase:** The project is currently in **Phase 2**. All recent changes were made in collaboration with my line manager and include the following updates:  

1. **Initial Commit:**  
   - Created a basic initial commit that includes the README and .gitignore files, following best practices.  

2. **Gitignore Configuration:**  
   - Improved the .gitignore file to exclude unnecessary files such as `.DS_Store`, and the `bin` and `target` folders. This configuration was informed by best practices using resources like gitignore.io.  

3. **Branch and Commit Naming:**  
   - Adopted English for branch names and improved commit messages for better clarity and context.  

4. **Commit Management:**  
genera solo la parte que arranca desde aqui: ## Current Status and Recent Changes  y generalo completo
Sider Fusion
Claro, aquí está la sección completa que comienza desde "## Current Status and Recent Changes":

markdown
## Current Status and Recent Changes  

**Current Phase:** The project is currently in **Phase 2**. All recent changes were made in collaboration with my line manager and include the following updates:  

1. **Initial Commit:**  
   - Created a basic initial commit that includes the README and .gitignore files, following best practices, including setting up the repository properly from the start.  

2. **Gitignore Configuration:**  
   - Improved the .gitignore file to exclude unnecessary files such as `.DS_Store`, as well as the `bin` and `target` folders. This configuration was informed by best practices using resources like gitignore.io.  

3. **Branch and Commit Naming:**  
   - Adopted English for branch names, ensuring consistency and clarity. Commit messages have also been improved to provide better descriptions.  

4. **Commit Management:**  
   - Cleaned up multiple commit instances by testing locally before pushing changes to the repository, avoiding unnecessary commits that could clutter the project history.  

5. **GitHub Actions Workflow Updates:**  
   - Refined the GitHub Actions workflow configuration to include a structured approach for push and pull request triggers, enhancing CI/CD efficiency.  
   - Eliminated unnecessary steps related to permissions and cache configurations, focusing on those that add value.  
   - Adjusted the sequence of actions to ensure static analysis tools, such as Checkstyle, run before executing tests to maintain code quality.  

6. **Dependencies in `build.gradle`:**  
   - Updated the `build.gradle` file to improve dependency management. Removed redundant comments in Spanish, ensuring clarity in the dependency declarations. Dependencies now include:  
     - JUnit, Selenium, Cucumber, and REST-assured frameworks, aligning with project requirements.  

7. **Checkstyle Configuration:**  
   - Updated `config/checkstyle/checkstyle.xml` to follow the Google Style Guide, which is an industry standard. This includes implementations for rules such as limiting method length and ensuring newline at the end of files.  

8. **Cucumber Feature Files:**  
   - Revised the feature file located in `src/test/resources/TCS.feature` to improve clarity and organization. Suggested structure now includes a clearer description of scenarios, utilizing the `Background` section for common steps across scenarios.  
   - Scenarios were divided to clearly differentiate between valid and invalid login attempts (correct vs. incorrect credentials).  
   - Improved steps in scenarios to be more descriptive, ensuring each action (e.g., logging in) is singular and clear.  

9. **Code Review Comments:**   
   - Integrated feedback received about avoiding inline comments in Spanish, using better naming conventions for classes (e.g., renaming `Scenario1` to `CucumberRunner`), and removing unnecessary commented code.  
   - Suggested moving WebDriver initialization to a separate class implementing the Factory Method design pattern.  

10. **Merge Request Settings:**  
    - Updated repository settings to ensure that pull requests require changes to be addressed before merging, which promotes better code quality.  

This README serves as a living document that will continue to be updated as the project progresses through its various phases. Future updates will reflect ongoing enhancements and changes made in collaboration with the line manager. 