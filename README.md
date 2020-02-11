# BDDWebAutomationWoolies


## Design:

###1. The Test is built using Maven Build Management.

###2. BDD Automation framework implemented.

###3. Data Driven using exetrnal files.

###4. Supports running on Firefox, Chrome, IE, Selenium Hub / Grid.

###5. Run on Windows , Linux or Mac.

###6. All required dependencies are included in pom.xml

###7. Junit Testing framework is used for Setup, Tests and Teardown.



## How to Run:

###1. Set the JAVA_HOME Path on Your system.

###2. Download/Clone the project to your desktop

###3. Eclipse -> Import Existing Maven Project -> Select the Folder -> This would select the pom.xml -> Finish

###4. Go to src\test\java\cucumber\testRunner.java -> Run as Junit 


## Test Results:

>Setup

>C:\Users\username\WebAutomationWoolies\

>Starting ChromeDriver 76.0.3809.68 (420c9498db8ce8fcd190a954d51297672c1515d5-refs/branch-heads/3809@{#864}) on port 5691

>Only local connections are allowed.

>Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.

>[1570466561.436][WARNING]: This version of ChromeDriver has not been tested with Chrome version 77.

>[1570466563.450][WARNING]: Timed out connecting to Chrome, retrying...

>Oct 08, 2019 3:42:45 AM org.openqa.selenium.remote.ProtocolHandshake createSession

>INFO: Detected dialect: W3C

>[1570466567.540][WARNING]: Timed out connecting to Chrome, retrying...

>user_is_on_home_page

>adds_two_items_to_the_cart_and_proceeds_to_checkout

>verify_shopping_cart_summary_contains_two_items_and_proceeds_to_checkout

>authenticates_using_existing_login_credentials_username_and_password

>use_default_address_and_proceed_to_checkout

>agrees_to_Shipping_terms_of_service

>selects_Pay_by_bank_wire_as_the_payment_method

>confirms_the_order

>gets_the_Order_Confirmation

>Closing the browser

>1 Scenarios ([32m1 passed[0m)

>9 Steps ([32m9 passed[0m)

>0m43.217s
