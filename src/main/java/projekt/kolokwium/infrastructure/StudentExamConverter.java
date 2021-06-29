package projekt.kolokwium.infrastructure;

import java.util.ArrayList;
import java.util.List;

import projekt.kolokwium.domain.StudentExam;

/** 
* Klasa która definuje metody konwersji modelu do modelu tabeli
*/
public class StudentExamConverter {
	/**
	* Konwersja listy z modelem do postacji tekstowej
	*
	* @param target Lista z modelem danych do konwersji
	* @return zwracany model dla tabeli kazda wartosc jest konwerterowana do postaciu ciagu znakow
	*/
	public static String[][] ConvertListStudentExamToTableData(List<StudentExam> target){
		List<String[]> result = new ArrayList<String[]>();
		
		for(StudentExam studentExam: target) {
			result.add(ConvertStudentExamToTableData(studentExam));
		}
		
		String[][] data = new String[result.size()][];
		result.toArray(data);

		return data;
	}
	
	/**
	* Konwersja modelu do postaci teksowej
	*
	* @param target Model do konwersji
	* @return zwracany tablica serilizownych wartosci do postacji ciagu znakow
	*/
	public static String[] ConvertStudentExamToTableData(StudentExam target) {
		List<String> result = new ArrayList<String>();
		
		result.add(Integer.toString(target.getAlbumNumber()));
		result.add(target.getPerson());
		result.add(target.getGroup());
		result.add(Integer.toString(target.getHomework()));
		result.add(Integer.toString(target.getActivity()));
		result.add(Integer.toString(target.getProject()));
		result.add(Integer.toString(target.getTestOne()));
		result.add(Integer.toString(target.getTestTwo()));
		result.add(Integer.toString(target.getExam()));
		result.add(Integer.toString(target.getSum()));
		
		String[] data = new String[result.size()];
		result.toArray(data );

		return data;
	}
}
