package reporters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.Reporter;

public class CsvReporter {
	/*
	 * Declaration of FileWriter
	 */
	static ThreadLocal<FileWriter> writer;
	/*
	 * Store the file path
	 */
	 
	/*
	 * Constructor
	 */
	private CsvReporter(String fileName){
		try {
			/* Create the object for new file
			 * 
			 */
			fileName = "C:\\Users\\Tulasiram\\Desktop\\104\\"+fileName+".csv";
			File file= new File(fileName);
			/*
			 * if file already exist delete the file
			 * 
			 */
			if(file.exists()) {
				file.delete();
			}
			/*
			 * Creating the object for new file
			 * 
			 */
			file= new File(fileName);
			/*
			 * it will create the file in actual location like cdrive or d drive
			 */
			file.createNewFile();
			writer = new ThreadLocal<>();
			writer.set(new FileWriter(fileName));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void getReporter(String fileName) {
		/*
		 * if any values in writer it wont do anything
		 */
		if(writer != null && writer.get() != null) {
			return;
		}
		/* 
		 * Create new CSVReporter
		 * 
		 */
		new CsvReporter(fileName);
	}

	public static void createTableWithHeader(String[] headers)  {
		for (int i = 0; i < headers.length; i++) {
			writeData(headers[i]+",");
		}
		/*
		 * add new line
		 */
		
		writeData("\n");
	}
	/*
	 * Add cell
	 */
	public static void addCell(String tbData) {
		writeData(tbData+",");
	}
	
	/*
	 * Add row
	 */
	public static void addRow() {
		writeData("\n");
	}
/*
 * End row
 */
	public static void endRow() {
		writeData("\n");
	}
	public static void addData(String data) {
		writeData(data+"\n");
	}
/*
 * Adding the data in row
 */
	public static void addRow(String[] rowData) {
		for (int i = 0; i < rowData.length; i++) {
			writeData(rowData[i]+",");
		}
		writeData("\n");
	}

/*
 * appends the data into the file
 * 
 */
	
	public static void writeData(String tbData) {
		try {
			writer.get().append(tbData);
			writer.get().flush();
		}catch(Exception e) {
		//	e.printStackTrace();
		}
		
	}
	/*
	 * End file
	 */
	public static void endFile() {
		try {
			writer.get().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
	}
}
