package projekt.kolokwium.domain;

/** 
* Model reprezentujacy encje wyniku studenta
*/
public class StudentExam {
	
	/** 
	* Konstruktor parametryczny
	*/
	public StudentExam(int albumNumber, String person, String group, int homework, int activity, int project,
			int testOne, int testTwo, int exam) {
		super();
		this.albumNumber = albumNumber;
		this.person = person;
		this.group = group;
		this.homework = homework;
		this.activity = activity;
		this.project = project;
		this.testOne = testOne;
		this.testTwo = testTwo;
		this.exam = exam;
	}

	/** 
	* Konstruktor domyślny
	*/
	public StudentExam() {
		this.albumNumber = 0;
		this.person = null;
		this.group = null;
		this.homework = 0;
		this.activity = 0;
		this.project = 0;
		this.testOne = 0;
		this.testTwo = 0;
		this.exam = 0;
	}
	/** 
	* Nr albumu
	*/
	private int albumNumber;
	/** 
	* Osoba
	*/
	private String person;
	/** 
	* Grupa
	*/
	private String group;
	/** 
	* Praca domowa
	*/
	private int homework;
	/** 
	* Aktywność
	*/
	private int activity;
	/** 
	* Projekt
	*/
	private int project;
	/** 
	* Kolokwium1
	*/
	private int testOne;
	/** 
	* Kolokwium2
	*/
	private int testTwo;
	/** 
	* Egzamin
	*/
	private int exam;
	
	/** 
	* getter i setter
	*/

	public int getSum() {
		return this.homework + this.activity + this.project + 
				this.testOne + this.testTwo + this.exam;
	}
	
	public int getAlbumNumber() {
		return albumNumber;
	}
	
	public void setAlbumNumber(int albumNumber) {
		this.albumNumber = albumNumber;
	}
	
	public String getPerson() {
		return person;
	}
	
	public void setPerson(String person) {
		this.person = person;
	}
	
	public String getGroup() {
		return group;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	public int getHomework() {
		return homework;
	}
	
	public void setHomework(int homework) {
		this.homework = homework;
	}
	
	public int getActivity() {
		return activity;
	}
	
	public void setActivity(int activity) {
		this.activity = activity;
	}
	
	public int getProject() {
		return project;
	}
	
	public void setProject(int project) {
		this.project = project;
	}
	
	public int getTestOne() {
		return testOne;
	}
	
	public void setTestOne(int testOne) {
		this.testOne = testOne;
	}
	
	public int getTestTwo() {
		return testTwo;
	}
	
	public void setTestTwo(int testTwo) {
		this.testTwo = testTwo;
	}
	
	public int getExam() {
		return exam;
	}
	
	public void setExam(int exam) {
		this.exam = exam;
	}
	
}
