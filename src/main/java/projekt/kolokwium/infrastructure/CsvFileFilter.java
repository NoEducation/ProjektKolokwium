package projekt.kolokwium.infrastructure;

import java.io.File;

/** 
* Klasa która definuje filter na wyswietlane pliki w chooser
*/
public class CsvFileFilter extends javax.swing.filechooser.FileFilter 
{
	
	/**
	* Sprawdza czy plik jest z roszerzeniem csv
	*
	* @param file  Plik ktorego roszerzenie jest sprawdzane
	* @return czy plik ma byc wyswietlony
	*/
	@Override
	public boolean accept(File file) {
	   return file.isFile() && file.getName().toLowerCase().endsWith(".csv");
	}

	/**
	* Podpowiedz wyswietlana w chooserze
	*
	* @return wyswietlany tekst w chooos
	*/
	public String getDescription() {
	        return "*.csv";
	}
}
