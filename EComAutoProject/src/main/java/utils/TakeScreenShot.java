package utils;

// Required imports for file operations and Selenium WebDriver screenshot functionality
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testBase.BaseTest;

public class TakeScreenShot {
	
	// This variable will store the final path of the screenshot file
	String destinationPath;

	// Static instance to implement Singleton pattern (only one instance of this class)
	private static TakeScreenShot takeScreenShot;

	// Private constructor prevents direct creation of objects from outside this class
	private TakeScreenShot() {}

	// This method returns the single instance of TakeScreenShot class
	public static TakeScreenShot getTakeScreenShotObj() {
		// Create the object only if it hasn't been created already
		if (takeScreenShot == null)
			takeScreenShot = new TakeScreenShot();
		return takeScreenShot;
	}

	// This method captures a screenshot and returns the saved file path
	public String screenShot() throws IOException {

		// Define the date-time pattern to make each screenshot file name unique
		String pattern = "dd-MM-yyyy HH-mm-ss";

		// Build the destination file path where screenshot will be saved
		destinationPath = System.getProperty("user.dir") + "/Reports/Screenshots/ExecutionReport_screenshot"
				+ DateUtil.getDateUtilObj().setDatePattern(pattern).getDateInString() + ".png";

		// Take a screenshot using Selenium WebDriver and store it as a temporary file
		File screenShotFile = ((TakesScreenshot) BaseTest.getDriverObj()).getScreenshotAs(OutputType.FILE);

		// Create a File object pointing to the final destination path
		File destinationFile = new File(destinationPath);

		FileUtils.copyFile(screenShotFile, destinationFile);

		// Return the file path where the screenshot has been saved
		return destinationPath;
	}
}
