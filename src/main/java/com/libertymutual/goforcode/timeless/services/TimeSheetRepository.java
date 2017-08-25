package com.libertymutual.goforcode.timeless.services;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.libertymutual.goforcode.timeless.models.TimeSheet;

@Service 
public class TimeSheetRepository {
	
	private int nextId = 1;
	
	public List<TimeSheet> getAll() {
		List<TimeSheet> timesEntered = new ArrayList<TimeSheet>();
		try (Reader in = new FileReader("timeless.csv")) {
			Iterable<CSVRecord> records = null;
			records = CSVFormat.DEFAULT.parse(in);
			
			for (CSVRecord record : records) {
				TimeSheet item = new TimeSheet();
				item.setId(Integer.parseInt(record.get(0)));
				item.setDateEntered(record.get(1));
				item.setMonday(Double.parseDouble(record.get(2)));
				item.setTuesday(Double.parseDouble(record.get(3)));
				item.setWednesday(Double.parseDouble(record.get(4)));
				item.setThursday(Double.parseDouble(record.get(5)));
				item.setFriday(Double.parseDouble(record.get(6)));
				
			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("file not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("file not found");
		}
		
		return timesEntered;
	}
	
	public int getNextId() {
		return nextId;
	}
	public void create(TimeSheet item) {
		String[] stringArray = new String[7];
		nextId += 1;
		
		Writer out = null;
		
		try {
			out = new FileWriter ("timeless.csv", true);
//		} catch (IOException e) {
//			System.out.println("hit IOException");
//		} try {
			stringArray[0] = (Integer.toString(item.getId()));
			stringArray[1] = (item.getDateEntered());
			stringArray[2] = (Double.toString(item.getMonday()));
			stringArray[3] = (Double.toString(item.getTuesday()));
			stringArray[4] = (Double.toString(item.getWednesday()));
			stringArray[5] = (Double.toString(item.getThursday()));
			stringArray[6] = (Double.toString(item.getFriday()));
			CSVPrinter printer = CSVFormat.DEFAULT.print(out);
			
			printer.printRecords(stringArray);
			out.close();
			} catch (IOException e){
				System.out.println("hit exception");
			}
	}

	
	}

