# UI Automation Framework

### Phase 1: Initial Setup and Basic Navigation
- Created basic project structure with Maven for dependency management
- Implemented WebDriver initialization with Chrome options for headless execution
- Added basic page objects following Page Object Model pattern:
  * HomePage with navigation and search functionality
  * LoginPage with authentication methods
  * BasePage with common utilities and wait methods
- Implemented first test scenarios:
  * Basic navigation flows
  * Login functionality with valid/invalid credentials
  * Error handling and validation

### Phase 2: Enhanced Test Coverage and Reporting
- Added Allure reporting integration with detailed test steps
- Implemented retry mechanism for flaky tests using TestNG annotations
- Added detailed test steps and attachments for better debugging:
  * Screenshots on failure
  * API response logs
  * Element state information
- Enhanced error handling and logging:
  * Custom exception handling
  * Detailed error messages
  * Stack trace capture
- Added screenshots for failed tests with timestamp
- Implemented API wait utilities for better stability:
  * Wait for API responses
  * Wait for UI updates
  * Wait for element state changes

### Phase 3: E2E Purchase Flow Implementation
- Implemented complete purchase flow scenarios:
  * Product search and selection
  * Cart management
  * Checkout process
  * Payment processing
  * Order confirmation
- Added product search and filtering functionality:
  * Search by name
  * Filter by category
  * Sort by price
  * Price range filtering
- Implemented cart management:
  * Add/remove products
  * Update quantities
  * Price calculations
- Added checkout process:
  * Shipping information
  * Payment details
  * Order review
- Implemented invoice verification:
  * Order number validation
  * Invoice generation
  * Invoice details check
- Added shipping and payment information handling:
  * Form validation
  * Data persistence
  * Error handling
- Enhanced test data management:
  * Constants for test data
  * Reusable data structures
  * Data validation
- Added validation for order confirmation:
  * Success messages
  * Order details
  * Payment confirmation
- Implemented invoice association verification:
  * User account linking
  * Invoice accessibility
  * Data consistency

### Phase 4: Reporting and Documentation
- Implemented comprehensive test reporting:
  * Allure reports with detailed test steps
  * Test execution statistics
  * Failure analysis
  * Performance metrics
- Added test documentation:
  * Test case descriptions
  * Step-by-step guides
  * Expected results
  * Actual results
- Enhanced logging and debugging:
  * Detailed logs for each step
  * Error tracking
  * Performance monitoring
- Added test metrics:
  * Execution time
  * Success rate
  * Failure analysis
  * Coverage reports

## Project Structure
```
src/                                    # Source root directory containing all test code
├── test/                               # Test directory containing all test-related files
│   ├── java/                          # Java source files for tests
│   │   ├── pages/                     # Page Object Model classes for different pages
│   │   │   ├── BasePage.java          # Base class with common page functionality
│   │   │   ├── HomePage.java          # Common home page functionality
│   │   │   ├── LoginPage.java         # Common login page functionality
│   │   │   ├── practicesoftwaretestingpages/    # Pages for Practice Software Testing website
│   │   │   │   ├── AccountPage.java             # User account management page
│   │   │   │   ├── CartPage.java                # Shopping cart functionality
│   │   │   │   ├── CheckoutPage.java            # Checkout process page
│   │   │   │   ├── HomePage.java                # Practice Software Testing home page
│   │   │   │   ├── InvoiceDetailPage.java       # Invoice details view
│   │   │   │   ├── InvoicesPage.java            # List of user invoices
│   │   │   │   ├── LoginPagePST.java            # Practice Software Testing login page
│   │   │   │   ├── ProductListPage.java         # Product listing and filtering
│   │   │   │   └── ProductPage.java             # Individual product details
│   │   │   └── shadowdemonpages/                # Pages for Sauce Demo website
│   │   │       ├── HomePage.java                # Sauce Demo home page
│   │   │       ├── LoginPage.java               # Sauce Demo login page
│   │   │       └── ProductsPage.java            # Sauce Demo products page
│   │   ├── steps/                     # Step definition classes for Cucumber scenarios
│   │   │   ├── PracticeSoftwareTestingSteps.java    # Steps for Practice Software Testing
│   │   │   └── SauceDemoSteps.java                  # Steps for Sauce Demo
│   │   └── utilities/                 # Utility classes for common functionality
│   │       ├── ApiWaitUtils.java                 # API response waiting utilities
│   │       └── WebDriverWaitUtils.java           # WebDriver wait utilities
│   └── resources/                     # Test resources and configuration files
│       ├── PracticeSoftwareTesting.feature       # Cucumber feature file for Practice Software Testing
│       ├── SauceDemon.feature                    # Cucumber feature file for Sauce Demo
│       └── allure.properties                     # Allure reporting configuration
```

## Latest Changes (Phase 3 Improvements)
Based on Line Manager feedback, the following improvements have been implemented:

### 1. Code Cleanup and Optimization
- Removed unused methods from various page classes
- Eliminated redundant code in step definitions
- Standardized WebElement locators using data-test attributes
   - Replaced magic numbers with named constants

### 2. Test Scenario Enhancements
- Updated product names in feature files to be more specific
- Improved step descriptions for better clarity
- Enhanced error handling in API wait utilities
- Added proper cleanup in tearDown methods

### 3. Documentation Updates
- Enhanced README with detailed phase descriptions
- Added comprehensive project structure
- Improved code comments and documentation
- Updated test case descriptions

These changes aim to improve code maintainability, test reliability, and overall project documentation.