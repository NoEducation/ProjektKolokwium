package projekt.kolokwium.infrastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

import projekt.kolokwium.domain.StudentExam;


/** 
* Klasa która wczytuje dane z pliku csv
*/
public class CsvFileReader {
	
	/**
	* Wczytwanie danych z pliku
	*
	* @param file  Plik z ktorego czytamy dane
	* @return zwracany model danych
	* @exception typowy input output wyjatek IOException
	*/
	public static List<StudentExam> ReadDataFromCsv(File file) throws IOException{
		List<StudentExam> result = new ArrayList<StudentExam>();
		
		String row;
		StudentExam entity;
		
		BufferedReader csvReader = null;
		
		try {
			csvReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		csvReader.readLine();
		
		while ((row = csvReader.readLine()) != null) {
			entity = new StudentExam();
		    String[] data = row.split(",");
		    
		    entity.setAlbumNumber(NumberUtils.toInt(data[0], 0));
		    entity.setPerson(data[1]);
		    entity.setGroup(data[2]);
		    entity.setHomework(NumberUtils.toInt(data[3], 0));
		    entity.setActivity(NumberUtils.toInt(data[4], 0));
		    entity.setProject(NumberUtils.toInt(data[6], 0));
		    entity.setTestOne(NumberUtils.toInt(data[6], 0));
		    entity.setTestTwo(NumberUtils.toInt(data[7], 0));
		    entity.setExam(NumberUtils.toInt(data[8], 0));
		    
		    result.add(entity);
		}
		
		csvReader.close();
		
		return result;
	}
}
