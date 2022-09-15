package COCmodules;

import reporters.CsvReporter;

public class Demo {
	
	public static void main(String[] args) {
		
		CsvReporter.getReporter("test");
		CsvReporter.createTableWithHeader(new String [] {"testcases","expectedresult"});
	}

}
