∑# Allure Integration with Cucumber

This project includes a minimal but functional integration of Allure with Cucumber to generate detailed test reports.

## Requirements

- Java 22 or higher
- Gradle 8.8 or higher
- Allure Command Line Tool

## Installing Allure Command Line Tool

### macOS (using Homebrew)
```
brew install allure
```

### Windows (using Scoop)
```
scoop install allure
```

### Linux
```
sudo apt-add-repository ppa:qameta/allure
sudo apt-get update
sudo apt-get install allure
```

## Running Tests with Allure

1. Run the tests with the unified Cucumber runner:
```
./gradlew test --tests "runner.CucumberRunner"
```

2. Generate the Allure report:
```
allure serve build/allure-results
```

## Troubleshooting Common Issues

If you encounter errors when running tests with Allure, try the following:

1. Clean the project and rebuild it:
```
./gradlew clean build
```

2. Make sure Allure dependencies are correctly configured in the `build.gradle` file.

3. Verify that the Allure plugin is correctly configured in the `build.gradle` file.

4. If you're still having issues, try running the tests without the Allure runner and then generate the report manually:
```
./gradlew test
allure serve build/allure-results
```

## Integration Structure

- `build.gradle`: Allure configuration and dependencies
- `src/test/resources/allure.properties`: Allure configuration
- `src/test/java/runner/CucumberRunner.java`: Unified Cucumber runner with Allure support

## Integration Features

- Detailed reports for each test step
- Test duration tracking
- Log and error visualization

## Viewing the Report

After running `allure serve build/allure-results`, a browser will automatically open with the Allure report. You can navigate through the different scenarios, view details of each step, and analyze the test results. 