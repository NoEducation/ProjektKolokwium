package projekt.kolokwium.infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import projekt.kolokwium.domain.StudentExam;

/** 
* Klasa która zapisuje dane z pliku csv
*/
public class CsvFileWriter {
		/**
		* Wczytwanie danych z pliku
		*
		* @param path Scieżka do pliku
		* @param target Dane do zapisu
		*/
		  public static void writeToFile(String path, List<StudentExam> target) {

			if(path.isEmpty())
				return;
		
			if(target == null || target.size() <= 0)
				return;
			  
		    try (PrintWriter writer = new PrintWriter(new File(path))) {

		      StringBuilder sb = new StringBuilder();
		      
		      sb.append("Nr albumu,");
		      sb.append(',');
		      sb.append("Osoba");
		      sb.append(',');
		      sb.append("Grupa");
		      sb.append(',');
		      sb.append("Praca domowa");
		      sb.append(',');
		      sb.append("Aktywność");
		      sb.append(',');
		      sb.append("Projekt");
		      sb.append(',');
		      sb.append("Kolokwium1");
		      sb.append(',');
		      sb.append("Kolokwium2");
		      sb.append(',');
		      sb.append("Egzamin");
	    	  sb.append(System.getProperty("line.separator"));
		      
		      for(StudentExam studentExam: target) {
		    	  
			      sb.append(studentExam.getAlbumNumber());
			      sb.append(',');
			      sb.append(studentExam.getPerson());
			      sb.append(',');
			      sb.append(studentExam.getGroup());
			      sb.append(',');
			      sb.append(studentExam.getHomework());
			      sb.append(',');
			      sb.append(studentExam.getActivity());
			      sb.append(',');
			      sb.append(studentExam.getProject());
			      sb.append(',');
			      sb.append(studentExam.getTestOne());
			      sb.append(',');
			      sb.append(studentExam.getTestTwo());
			      sb.append(',');
			      sb.append(studentExam.getExam());
			      sb.append(',');
		    	  
		    	  sb.append(System.getProperty("line.separator"));
		      }
		      
		      writer.write(sb.toString());

		    } catch (FileNotFoundException e) {
		      System.out.println(e.getMessage());
		    }
		  }
}
