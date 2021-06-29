package projekt.kolokwium.infrastructure;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import projekt.kolokwium.domain.StudentExam;

/** 
* Testy dla klasy StudentExamConverter
*/
public class StudentExamConverterTests {
	
	/** 
	* Test dla metody convertListStudentExamToTableData
	*/
	 @Test                                               
	 public void ConvertListStudentExamToTableData_CorrectDataReturned() {
		 
		 String[][] resultExpected = { 
			 {"18501","TEST_PERSON1","TEST_GROUP1","1","2","3","4","5","6", "21"},
			 {"18502","TEST_PERSON2","TEST_GROUP2","1","2","3","4","5","6", "21"},
			 {"18503","TEST_PERSON3","TEST_GROUP3","1","2","3","4","5","6", "21"}
		 };
		 
		 StudentExam student1 = new StudentExam(18501, "TEST_PERSON1", "TEST_GROUP1", 1,2,3,4,5,6);
		 StudentExam student2 = new StudentExam(18502, "TEST_PERSON2", "TEST_GROUP2", 1,2,3,4,5,6);
		 StudentExam student3 = new StudentExam(18503, "TEST_PERSON3", "TEST_GROUP3", 1,2,3,4,5,6);
		 
	     List<StudentExam>  target = new ArrayList<StudentExam>();
	     target.add(student1);
	     target.add(student2);
	     target.add(student3);
	     
	     String[][] result = StudentExamConverter.ConvertListStudentExamToTableData(target);
	     
	     assertArrayEquals(resultExpected, result);      
	 }
	 
	 /** 
	 * Test dla metody ConvertStudentExamToTableData
	 */
	 @Test                                               
	 public void ConvertStudentExamToTableData_CorrectDataReturned() {
		 
		 String[] resultExpected = new String[] {"1850","TEST_PERSON","TEST_GROUP","1","2","3","4","5","6", "21"};
		 StudentExam target = new StudentExam(1850, "TEST_PERSON", "TEST_GROUP", 1,2,3,4,5,6);
		 String[] result = StudentExamConverter.ConvertStudentExamToTableData(target);

		 assertArrayEquals(resultExpected,result);          
	 }
}
