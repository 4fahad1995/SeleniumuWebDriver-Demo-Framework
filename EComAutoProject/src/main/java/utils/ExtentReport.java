package utils;

// Importing classes from the ExtentReports library
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

    // Shared instance of the report manager used to log and manage all test results
    static ExtentReports extent;

    // This method sets up the test report and returns the ExtentReports object
    public static ExtentReports setupExtentReport() {

        // Define how the date and time should be formatted in the report filename
        String pattern = "dd-MM-yyyy HH-mm-ss";

        // Get the current date and time as a string using our custom DateUtil helper
        DateUtil dateUtil = DateUtil.getDateUtilObj();

        // Build the path for the report file, placing it in a "Reports" folder with a timestamp
        String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport_"
                + dateUtil.setDatePattern(pattern).getDateInString() + ".html";

        // Just print the path to the console for visibility/debugging
        System.out.println(reportPath);

        // Create the main report object
        extent = new ExtentReports();

        // Create a "Spark" reporter that generates an HTML report at the given path
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

        // Attach the HTML reporter to the main report object
        extent.attachReporter(spark);

        // Set the title that appears in the browser tab of the HTML report
        spark.config().setDocumentTitle("Execution Report");

        // Set the visual theme of the report (e.g., DARK or STANDARD)
        spark.config().setTheme(Theme.DARK);

        // Set the main heading shown in the report
        spark.config().setReportName("Test case execution report");

        // Return the fully configured ExtentReports object
        return extent;
    }

    // This method finalizes and saves the report to the file
    public static void closeExtentReport() {
        // Flush means "write everything to the file and close it"
        extent.flush();
    }

    // This method creates a new test section inside the report for logging test steps/results
    public static ExtentTest createTest(String methodName) {
        // Create a new test case in the report with the given method name
        ExtentTest test = extent.createTest(methodName);

        // Return the test object so you can log steps like pass/fail
        return test;
    }
}
