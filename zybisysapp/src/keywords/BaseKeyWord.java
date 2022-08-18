package keywords;

import org.testng.Reporter;

public class BaseKeyWord {

	private Boolean skipKeywordLogs = true;
	private static Boolean skipAppLogs = false;

	void log(String str) {
		if (!skipKeywordLogs)
			Reporter.log(str);
	}

	static void logApp(String str) {
		if (!skipAppLogs)
			Reporter.log(str);
	}

}
