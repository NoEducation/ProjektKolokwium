package projekt.kolokwium;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import org.apache.commons.lang3.math.NumberUtils;

import projekt.kolokwium.domain.StudentExam;
import projekt.kolokwium.infrastructure.CsvFileFilter;
import projekt.kolokwium.infrastructure.CsvFileReader;
import projekt.kolokwium.infrastructure.CsvFileWriter;
import projekt.kolokwium.infrastructure.StudentExamConverter;

import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Button;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

/** 
* Klasa która przedstawia głowne okno programu okienkowego
*/
public class MainWindow {

	/** 
	* Głowne okno programu : frame
	*/
	private JFrame frmKolokwium;
	/** 
	* Text field number albumu
	*/
	private JTextField numberOfAlbumTextField;
	/** 
	* Text field number albumu
	*/
	private JTextField personTextField;
	/** 
	* Text field grupa
	*/
	private JTextField groupTextField;
	/** 
	* Text field praca domowa
	*/
	private JTextField homeworkTextField;
	/** 
	* Text field aktywnosc
	*/
	private JTextField activityTextField;
	/** 
	* Text field project
	*/
	private JTextField projectTextField;
	/** 
	* Text field kolokwium 1
	*/
	private JTextField testOneTextField;
	/** 
	* Text field kolokwium 2
	*/
	private JTextField testTwoTextField;
	/** 
	* Text field egzamin
	*/
	private JTextField examTextField;
	
	
	/** 
	* Model dla tabeli
	*/
	private DefaultTableModel model = new DefaultTableModel();
	/** 
	* Lista wynkow studentow
	*/
	private List<StudentExam> data = new ArrayList<StudentExam>();
	/** 
	* Tablela z przedstawiajaca dane
	*/
	final private JTable mainTable = new JTable();
	/** 
	* Nazwa pliku do zapisu
	*/
	private JTextField fileNameTextFiled;
	/** 
	* Text field Ściezka do zapisu pliku
	*/
	private String directoryPath = "";
	/** 
	* Nazwa pliku
	*/
	private String fileSavePath = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmKolokwium.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKolokwium = new JFrame();
		frmKolokwium.setTitle("Kolokwium");
		frmKolokwium.setAlwaysOnTop(true);
		frmKolokwium.setBackground(Color.GRAY);
		frmKolokwium.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmKolokwium.setType(Type.POPUP);
		frmKolokwium.setBounds(100, 100, 900, 600);
		frmKolokwium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKolokwium.getContentPane().setLayout(null);
		frmKolokwium.setResizable(false);

		JLabel numberOfAlbumLabel = new JLabel("Nr albumu");
		numberOfAlbumLabel.setBounds(26, 252, 63, 14);
		frmKolokwium.getContentPane().add(numberOfAlbumLabel);
		
		numberOfAlbumTextField = new JTextField();
		numberOfAlbumTextField.setBounds(101, 250, 185, 17);
		frmKolokwium.getContentPane().add(numberOfAlbumTextField);
		numberOfAlbumTextField.setColumns(10);
		
		JLabel personLabel = new JLabel("Osoba");
		personLabel.setBounds(26, 280, 46, 14);
		frmKolokwium.getContentPane().add(personLabel);
		
		personTextField = new JTextField();
		personTextField.setBounds(101, 278, 185, 17);
		frmKolokwium.getContentPane().add(personTextField);
		personTextField.setColumns(10);
		
		groupTextField = new JTextField();
		groupTextField.setColumns(10);
		groupTextField.setBounds(101, 306, 185, 17);
		frmKolokwium.getContentPane().add(groupTextField);
		
		homeworkTextField = new JTextField();
		homeworkTextField.setColumns(10);
		homeworkTextField.setBounds(101, 334, 185, 17);
		frmKolokwium.getContentPane().add(homeworkTextField);
		
		JLabel groupLabel = new JLabel("Grupa");
		groupLabel.setBounds(26, 307, 63, 14);
		frmKolokwium.getContentPane().add(groupLabel);
		
		JLabel homeworkLabel = new JLabel("Praca domowa");
		homeworkLabel.setBounds(26, 335, 77, 14);
		frmKolokwium.getContentPane().add(homeworkLabel);
		
		activityTextField = new JTextField();
		activityTextField.setColumns(10);
		activityTextField.setBounds(101, 362, 185, 17);
		frmKolokwium.getContentPane().add(activityTextField);
		
		JLabel activityLabel = new JLabel("Aktywnosc");
		activityLabel.setBounds(26, 364, 77, 14);
		frmKolokwium.getContentPane().add(activityLabel);
		
		JLabel projectLabel = new JLabel("Projekt");
		projectLabel.setBounds(26, 390, 77, 14);
		frmKolokwium.getContentPane().add(projectLabel);
		
		projectTextField = new JTextField();
		projectTextField.setColumns(10);
		projectTextField.setBounds(101, 387, 185, 17);
		frmKolokwium.getContentPane().add(projectTextField);
		
		JLabel testOneLabel = new JLabel("Kolokwium 1");
		testOneLabel.setBounds(313, 251, 77, 14);
		frmKolokwium.getContentPane().add(testOneLabel);
		
		testOneTextField = new JTextField();
		testOneTextField.setColumns(10);
		testOneTextField.setBounds(388, 249, 185, 17);
		frmKolokwium.getContentPane().add(testOneTextField);
		
		JLabel testTwoLabel = new JLabel("Kolokwium 2");
		testTwoLabel.setBounds(313, 279, 77, 14);
		frmKolokwium.getContentPane().add(testTwoLabel);
		
		testTwoTextField = new JTextField();
		testTwoTextField.setColumns(10);
		testTwoTextField.setBounds(388, 277, 185, 17);
		frmKolokwium.getContentPane().add(testTwoTextField);
		
		JLabel examLabel = new JLabel("Egzamin");
		examLabel.setBounds(313, 308, 77, 14);
		frmKolokwium.getContentPane().add(examLabel);
		
		examTextField = new JTextField();
		examTextField.setColumns(10);
		examTextField.setBounds(388, 306, 185, 17);
		frmKolokwium.getContentPane().add(examTextField);
		
		JButton saveBtn = new JButton("Zapisz");
		saveBtn.setBounds(484, 386, 89, 23);
		frmKolokwium.getContentPane().add(saveBtn);
		
		JButton readFileBtn = new JButton("Wczytaj dane");
		
		readFileBtn.setBounds(26, 458, 138, 26);
		frmKolokwium.getContentPane().add(readFileBtn);
		
		JButton saveChooseFolderBtn = new JButton("Wybierz folder");
		
		saveChooseFolderBtn.setBounds(185, 458, 137, 26);
		frmKolokwium.getContentPane().add(saveChooseFolderBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(615, 252, 259, 152);
		frmKolokwium.getContentPane().add(scrollPane);
		
		final JTextPane validationPanel = new JTextPane();
		scrollPane.setViewportView(validationPanel);
		validationPanel.setForeground(Color.RED);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 12, 846, 212);
		
		
		frmKolokwium.getContentPane().add(scrollPane_1);
				scrollPane_1.setViewportView(mainTable);
		
				mainTable.setModel(new DefaultTableModel(
					new Object[][] {},
					new String[] {
						"Nr albumu", "Osoba", "Grupa", "Praca domowa", "Aktywno\u015B\u0107", "Projekt", "Kolokwium1", "Kolokwium2", "Egzamin", "Suma"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Object.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false, false, false, true, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				mainTable.getColumnModel().getColumn(0).setResizable(false);
				mainTable.getColumnModel().getColumn(1).setResizable(false);
				mainTable.getColumnModel().getColumn(2).setResizable(false);
				mainTable.getColumnModel().getColumn(3).setResizable(false);
				mainTable.getColumnModel().getColumn(4).setResizable(false);
				mainTable.getColumnModel().getColumn(5).setResizable(false);
				mainTable.getColumnModel().getColumn(6).setResizable(false);
				mainTable.getColumnModel().getColumn(7).setResizable(false);
				mainTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				mainTable.setToolTipText("");
				mainTable.setCellSelectionEnabled(true);
				mainTable.setColumnSelectionAllowed(true);
				mainTable.setFillsViewportHeight(true);
				
				JSeparator separator = new JSeparator();
				separator.setBounds(24, 422, 850, 14);
				frmKolokwium.getContentPane().add(separator);
				
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(26, 236, 850, 14);
				frmKolokwium.getContentPane().add(separator_1);
				
				JSeparator separator_2 = new JSeparator();
				separator_2.setBounds(176, 422, 7, 127);
				frmKolokwium.getContentPane().add(separator_2);
				
				JSeparator separator_3 = new JSeparator();
				separator_3.setOrientation(SwingConstants.VERTICAL);
				separator_3.setBounds(176, 422, 7, 122);
				frmKolokwium.getContentPane().add(separator_3);
				
				JLabel lblNewLabel = new JLabel("Wczytywanie danych");
				lblNewLabel.setForeground(Color.DARK_GRAY);
				lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
				lblNewLabel.setBounds(26, 429, 157, 19);
				frmKolokwium.getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Zapis danych");
				lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
				lblNewLabel_1.setForeground(Color.DARK_GRAY);
				lblNewLabel_1.setBounds(185, 430, 99, 16);
				frmKolokwium.getContentPane().add(lblNewLabel_1);
				
				fileNameTextFiled = new JTextField();
				fileNameTextFiled.setBounds(352, 461, 185, 23);
				frmKolokwium.getContentPane().add(fileNameTextFiled);
				fileNameTextFiled.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("Nazwa pliku");
				lblNewLabel_2.setBounds(349, 431, 99, 16);
				frmKolokwium.getContentPane().add(lblNewLabel_2);
				
				JButton saveDataBtn = new JButton("Zapisz dane");
				
				saveDataBtn.setBounds(185, 496, 137, 26);
				frmKolokwium.getContentPane().add(saveDataBtn);
				
				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(615, 433, 257, 89);
				frmKolokwium.getContentPane().add(scrollPane_2);
				
				final JTextPane validationFilePanel = new JTextPane();
				validationFilePanel.setForeground(Color.RED);
				scrollPane_2.setViewportView(validationFilePanel);
		
				readFileBtn.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {

						final JFileChooser chooser = new JFileChooser();
						chooser.setCurrentDirectory(new java.io.File("."));
						chooser.setAcceptAllFileFilterUsed(false);
						
						chooser.setDialogTitle("Select file");
						chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
						chooser.addChoosableFileFilter(new CsvFileFilter());
						
						if (chooser.showDialog(frmKolokwium, "Open") == JFileChooser.APPROVE_OPTION) { 
		     
							File file = chooser.getSelectedFile();
							System.out.println("file: " + file);
							try {
								data = CsvFileReader.ReadDataFromCsv(file);
								Object[][] tableData = StudentExamConverter.ConvertListStudentExamToTableData(data);
								mainTable.setModel(GetModel(tableData));
								JOptionPane.showMessageDialog(frmKolokwium, "Wczytano dane", "Wczytano dane", JOptionPane.INFORMATION_MESSAGE);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
		                }
		                   
					}

				});
				
				saveChooseFolderBtn.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						final JFileChooser chooser = new JFileChooser();
						chooser.setCurrentDirectory(new java.io.File("."));
						chooser.setAcceptAllFileFilterUsed(false);
						
						chooser.setDialogTitle("Select folder");
						chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

						if (chooser.showDialog(frmKolokwium, "Choose") == JFileChooser.APPROVE_OPTION) { 
						     
							File directory = chooser.getSelectedFile();
							System.out.println("Directory: " + directory);
							directoryPath = directory.getAbsolutePath();
							JOptionPane.showMessageDialog(frmKolokwium, "Zapisano sciezke", "Zapisno sciezke", JOptionPane.INFORMATION_MESSAGE);
		                }
					}
				});
				
				saveDataBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						StringBuilder validationMessage = new StringBuilder();
						String fileName = fileNameTextFiled.getText();

						if(fileName.isEmpty()) {
							validationMessage.append("Nazwa pliku musi byc wypełniona")
								.append(System.getProperty("line.separator"));
						}
						
						if(directoryPath.isEmpty()) {
							validationMessage.append("Proszę wybrac sciezke zapisu (Wybierz folder)")
								.append(System.getProperty("line.separator"));
						}
						
						if(data == null || data.size() ==0) {
							validationMessage.append("Nie ma żadnych danych do zapisu")
								.append(System.getProperty("line.separator"));
						}
						
						String validation = validationMessage.toString();
						
						if(validation.isEmpty()) {
							
							 try {
							      Document doc =  validationFilePanel.getDocument();
							      doc.remove(0, doc.getLength());
							   } catch(BadLocationException exc) {
							      exc.printStackTrace();
							}
							 
							 CsvFileWriter.writeToFile(directoryPath + "\\" + fileName + ".csv", data);
							 JOptionPane.showMessageDialog(frmKolokwium, "Zapisano dane", "Zapisano dane", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							 try {
							      Document doc =  validationFilePanel.getDocument();
							      doc.remove(0, doc.getLength());
							      doc.insertString(0, validation, null);
							   } catch(BadLocationException exc) {
							      exc.printStackTrace();
							}
							
						}
					}
				});		
				
				saveBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						StringBuilder validationMessage = new StringBuilder();
						String numberOfAlbum = numberOfAlbumTextField.getText();
						String person = personTextField.getText();
						String group = groupTextField.getText();
						String homework = homeworkTextField.getText();
						String activity = activityTextField.getText();
						String project = projectTextField.getText();
						String testOne = testOneTextField.getText();
						String testTwo = testTwoTextField.getText();
						String exam = examTextField.getText();
					
						if(numberOfAlbum.isEmpty()) {
							validationMessage.append("Number albumu musi byc wypełniony")
								.append(System.getProperty("line.separator"));
						}
						else if(!NumberUtils.isDigits(numberOfAlbum)) {
							validationMessage.append("Number albumu musi skladac jednie z cyfr")
								.append(System.getProperty("line.separator"));
						}
						
						if(person.isEmpty()) {
							validationMessage.append("Osoba musi byc wypełniona")
								.append(System.getProperty("line.separator"));
						}
						else if(person.trim().split("\\s+").length != 2) {
							validationMessage.append("Osoba muis składac sie z dwoch czlonow")
								.append(System.getProperty("line.separator"));
						}
			
						if(group.isEmpty()) {
							validationMessage.append("Grupa musi byc wypełniona")
								.append(System.getProperty("line.separator"));
						}
						
						if(homework.isEmpty()) {
							validationMessage.append("Praca domowa musi byc wypelniona")
								.append(System.getProperty("line.separator"));
						}
						else if(!NumberUtils.isDigits(homework)) {
							validationMessage.append("Praca domowa musi byc cyfra")
								.append(System.getProperty("line.separator"));
						}
						else if(NumberUtils.createInteger(homework) < 0 || NumberUtils.createInteger(homework) > 5) {
							validationMessage.append("Praca domowa musi byc w zakresie od 0 do 5")
								.append(System.getProperty("line.separator"));
						}
						
						if(activity.isEmpty()) {
							validationMessage.append("Aktywnosc musi byc wypelniona")
								.append(System.getProperty("line.separator"));
						}
						else if(!NumberUtils.isDigits(activity)) {
							validationMessage.append("Aktywnosc musi byc cyfra")
								.append(System.getProperty("line.separator"));
						}
						else if(NumberUtils.createInteger(activity) < 0 || NumberUtils.createInteger(activity) > 5) {
							validationMessage.append("Aktywnosc musi byc w zakresie od 0 do 5")
								.append(System.getProperty("line.separator"));
						}
						
						if(project.isEmpty()) {
							validationMessage.append("Project musi byc wypelniona")
								.append(System.getProperty("line.separator"));
						}
						else if(!NumberUtils.isDigits(project)) {
							validationMessage.append("Project musi byc cyfra")
								.append(System.getProperty("line.separator"));
						}
						else if(NumberUtils.toInt(project) < 0 || NumberUtils.toInt(project) > 10) {
							validationMessage.append("Project musi byc w zakresie od 0 do 10")
								.append(System.getProperty("line.separator"));
						}
						
						
						if(testOne.isEmpty()) {
							validationMessage.append("Kolokwium 1 musi byc wypelniona")
								.append(System.getProperty("line.separator"));
						}
						else if(!NumberUtils.isDigits(testOne)) {
							validationMessage.append("Kolokwium 1 musi byc cyfra")
								.append(System.getProperty("line.separator"));
						}
						else if(NumberUtils.createInteger(testOne) <  0 || NumberUtils.createInteger(testOne) > 20) {
							validationMessage.append("Kolokwium 1 musi byc w zakresie od 0 do 20")
								.append(System.getProperty("line.separator"));
						}
						
						if(testTwo.isEmpty()) {
							validationMessage.append("Kolokwium 2 musi byc wypelniona")
								.append(System.getProperty("line.separator"));
						}
						else if(!NumberUtils.isDigits(testTwo)) {
							validationMessage.append("Kolokwium 2 musi byc cyfra")
								.append(System.getProperty("line.separator"));
						}
						else if(NumberUtils.createInteger(testTwo) < 0 || NumberUtils.createInteger(testTwo) > 20) {
							validationMessage.append("Kolokwium 2 musi byc w zakresie od 0 do 20")
								.append(System.getProperty("line.separator"));
						}
						
						if(exam.isEmpty()) {
							validationMessage.append("Egzamin musi byc wypelniona")
								.append(System.getProperty("line.separator"));
						}
						else if(!NumberUtils.isDigits(exam)) {
							validationMessage.append("Egzamin musi byc cyfra")
								.append(System.getProperty("line.separator"));
						}
						else if(NumberUtils.createInteger(exam) < 0 || NumberUtils.createInteger(exam) > 40) {
							validationMessage.append("Egzamin musi byc w zakresie od 0 do 40")
								.append(System.getProperty("line.separator"));
						}
						
						
						String validation = validationMessage.toString();
				
						if(validation.isEmpty()) {
							
							 try {
							      Document doc =  validationPanel.getDocument();
							      doc.remove(0, doc.getLength());
							   } catch(BadLocationException exc) {
							      exc.printStackTrace();
							}
							
							StudentExam entity = new StudentExam(NumberUtils.toInt(numberOfAlbum),person, group,
									NumberUtils.toInt(homework),NumberUtils.toInt(activity),NumberUtils.toInt(project),
									NumberUtils.toInt(testOne),NumberUtils.toInt(testTwo),NumberUtils.toInt(exam));
							
							data.add(entity);
							Object[][] tableData = StudentExamConverter.ConvertListStudentExamToTableData(data);
							mainTable.setModel(GetModel(tableData));
						}
						else {
							 try {
							      Document doc =  validationPanel.getDocument();
							      doc.remove(0, doc.getLength());
							      doc.insertString(0, validation, null);
							   } catch(BadLocationException exc) {
							      exc.printStackTrace();
							}
							
						}
					}
				});
	
	}
	
	/**
	* Pobierz ustawniania tabeli
	*
	* @param data Dane dla tabli
	* @return model dla tabeli
	*/
	private DefaultTableModel GetModel(Object[][] data) {
		return new DefaultTableModel(
				data,
				new String[] {
					"Nr albumu", "Osoba", "Grupa", "Praca domowa", "Aktywno\u015B\u0107", "Projekt", "Kolokwium1", "Kolokwium2", "Egzamin", "Suma"
				}
			) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Object.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, true, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
	}
}
