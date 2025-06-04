package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	// Holds the current date and time
	Date date;

	// Formats the date into a string (e.g., "2025-05-27 15:30:00")
	SimpleDateFormat simpleDateFormat;

	// A single shared instance of DateUtil (singleton)
	private static DateUtil dateUtil;

	// Private constructor: prevents others from creating new objects directly
	private DateUtil() {
	}

	// Returns the one and only instance of DateUtil (singleton pattern)
	public static DateUtil getDateUtilObj() {
		if (dateUtil == null)
			dateUtil = new DateUtil(); // Create it if it doesn't exist
		return dateUtil; // Return the shared instance
	}

	// Sets the format pattern and updates the current date
	// Example: "dd-MM-yyyy HH:mm:ss" → "27-05-2025 15:45:00"
	public DateUtil setDatePattern(String pattern) {
		this.date = new Date(); // Get current date and time
		this.simpleDateFormat = new SimpleDateFormat(pattern); // Set the format style
		return this; // Return this object to allow method chaining
	}

	// Converts the current date into a string using the format pattern
	public String getDateInString() {
		return simpleDateFormat.format(date); // Returns something like "27-05-2025 15:45:00"
	}

}
