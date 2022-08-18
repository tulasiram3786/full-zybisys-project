package reporters;

import org.testng.Reporter;

public class ReportUtil {
/*
 * <table border=\"1\">
 * <thead>
 * <tr>
 * <th>
 * Expected result
 * </th>
 * <th>
 * Acutual result
 * </th>
 * </tr>
 * </thead>
 */
	public static void createTableWithHeader(String[] headers) {
		Reporter.log("<table border=\"1\">");
		Reporter.log("<thead>");
		Reporter.log("<tr>");
		for (int i = 0; i < headers.length; i++) {
			Reporter.log("<th>" + headers[i] + "</th>");
		}
		Reporter.log("</tr>");
		Reporter.log("</thead>");
		Reporter.log("<tbody>");
		CsvReporter.createTableWithHeader(headers);
	}
	
	/*
	 * <td style="color:red">Pass</td>
	 */

	public static void addCell(String tbData, String style) {
		Reporter.log("<td style=\""+style+"\">" + tbData + "</td>");
		CsvReporter.addCell(tbData);
	}
	
	
	/*
	 * <td>Pass</td>
	 */
	public static void addCell(String tbData) {
		Reporter.log("<td>" + tbData + "</td>");
		CsvReporter.addCell(tbData);
	}
	public static void addData(String tbData) {
		
		CsvReporter.addData(tbData);
	}
	
	
	public static void addRow() {
		Reporter.log("<tr>");
		CsvReporter.addRow();
	}
	public static void endRow() {
		Reporter.log("</tr>");
		CsvReporter.endRow();
	}

	public static void addRow(String[] rowData, String []style) {
		Reporter.log("<tr>");
		for (int i = 0; i < rowData.length; i++) {
			Reporter.log("<td style=\""+style[i]+"\">" + rowData[i] + "</td>");
		}
		Reporter.log("</tr>");
		CsvReporter.addRow(rowData);
	}

	public static void endTable() {
		Reporter.log("</tbody>");
		Reporter.log("</table>");
		//CsvReporter.endFile();
	}

}
