/**
 * 
 */
package fr.pizzeria.dao;

import java.io.*;
import java.util.*;
import fr.pizzeria.exception.TechnicalException;

/**
 * Cette classe permet d'ouvrir, de lire et décrire dans un fichier
 * Elle est utilisée pour sauvegarder de manière persistante les données
 * de notre application
 * @author BIRABEN-BIANCHI Hugo
 */
public class gestionFichier
{
	public File file;
	public PrintWriter fileWriter;
	public BufferedReader fileReader;
	
	
	/**
	 * Constructor by default
	 * Use a "save.txt" file
	 */
	public gestionFichier ()
	{
		try
		{
			// file = new File ("C:\\Users\\hugo-\\Documents\\save.txt");
			file = new File ("save.txt");
			
			if (file.exists () == false)
				file.createNewFile ();
		} 
		catch (IOException e)
		{
			throw new TechnicalException(e);
		}
	}
	
	/**
	 * ecriture : Prend une List <String> 
	 * pour écrire dans un fichier ligne par ligne
	 * @param listString
	 */
	public void ecriture (List <String> listString)
	{
		try
		{
			fileWriter = new PrintWriter (new FileWriter (file));
			
			for (String s : listString)
				fileWriter.println (s);
			
			fileWriter.flush ();
			fileWriter.close ();
		} 
		catch (IOException e)
		{
			throw new TechnicalException(e);
		}
	}
	
	/**
	 * lecture : Retourne une List <String> 
	 * contenant un fichier entier ligne par ligne
	 * @return
	 */
	public List <String> lecture () 
	{
		try
		{
			String line = null;
			List <String> records = new ArrayList <String> ();
			fileReader = new BufferedReader (new FileReader (file));	
			
			while ((line = fileReader.readLine ()) != null)
			{
				records.add(line);
			}
			
			fileReader.close ();
			return records;
		} 
		catch (IOException e)
		{
			throw new TechnicalException(e);
		} 
	}
}
