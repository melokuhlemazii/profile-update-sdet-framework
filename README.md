# Profile Update Automation Project

This project automates the profile-update journey on the Ndosi Simplified Automation website. It includes browser-based UI tests written with Cucumber, Selenium WebDriver, and TestNG, plus API tests written with Rest Assured and TestNG.

## What the tests cover

### UI scenario

The `@editProfile` scenario in `src/test/resources/features/myProfile.feature`:

1.  Opens the login page and signs in.
2.  Opens the menu and navigates to My Profile.
3.  Opens Edit Profile and uploads `profilePhoto.jpg`.
4.  Saves the change and checks the success alert.

The upload uses the HTML file input directly via Selenium `sendKeys`, so it does not need to interact with the operating-system file chooser.

### API scenario

`Tests.ProfileUpdateApiTest` exercises the following sequence:

Operation

HTTP request

Expected status

Log in

`POST /APIDEV/login`

200

Read profile

`GET /APIDEV/profile`

200

Update profile names

`PUT /APIDEV/profile`

200

Upload profile image

`POST /APIDEV/profile/image`

200

Read profile after upload

`GET /APIDEV/profile`

200

The API builder extracts the login token and uses it for authenticated profile requests. The tests also check successful login and confirm that profile data, including an image field, is returned.

## Technology

-   Java 21
-   Maven
-   Selenium WebDriver 4.28.0
-   Cucumber 7.0.0 with its TestNG integration
-   TestNG
-   Rest Assured 5.5.0
-   Allure TestNG adapter
-   ExtentReports Cucumber adapter