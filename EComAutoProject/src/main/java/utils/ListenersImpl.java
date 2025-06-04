package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersImpl implements ITestListener {

    // This will hold the current test's reporting object so we can log info, pass, fail, etc.
    ExtentTest test;

    // Called automatically when each test method starts running
    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test entry in the report using the test method's name
        test = ExtentReport.createTest(result.getMethod().getMethodName());
        // Log an info message that the test case execution has started
        test.info("********************* TEST CASE EXECUTION STARTED *******************");
    }

    // Called automatically when a test method passes successfully
    @Override
    public void onTestSuccess(ITestResult result) {
        // Log a green PASS message with the test method's name
        test.log(Status.PASS, "Test Case: " + result.getMethod().getMethodName() + " is Passed.");
    }

    // Called automatically when a test method fails
    @Override
    public void onTestFailure(ITestResult result) {
        // Log a red FAIL message with the test method's name
        test.log(Status.FAIL, "Test Case: " + result.getMethod().getMethodName() + " is Failed.");
        // Log the error message or exception details that caused the failure
        test.log(Status.FAIL, result.getThrowable().getMessage());

        // Take a screenshot at the point of failure using the helper class
        String screenShotPath = "";
		try {
			screenShotPath = TakeScreenShot.getTakeScreenShotObj().screenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Attach the screenshot to the report for easier debugging
        test.addScreenCaptureFromPath(screenShotPath, "Test Case Failure ScreenShot.");
    }

    // Called automatically when a test method is skipped (not run)
    @Override
    public void onTestSkipped(ITestResult result) {
        // Log a yellow SKIP message with the test method's name
        test.log(Status.SKIP, "Test Case: " + result.getMethod().getMethodName() + " is Skipped.");
    }

    // Called if a test fails but still meets the success percentage (rarely used)
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Default implementation, no extra action taken here
    }

    // Called if a test fails due to timeout (rarely used)
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // Default implementation, no extra action taken here
    }

    // Called once before any test methods run in the test context
    @Override
    public void onStart(ITestContext context) {
        // Set up the ExtentReport and prepare it to start logging
        ExtentReport.setupExtentReport();
    }

    // Called once after all test methods have run in the test context
    @Override
    public void onFinish(ITestContext context) {
        // Finalize the report by writing all logged info to the HTML file
        ExtentReport.closeExtentReport();
    }
}
