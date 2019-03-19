/**
 * 
 */
package fr.pizzeria.dao;

import java.io.*;
import java.util.*;

import fr.pizzeria.exception.TechnicalException;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class gestionFichier
{
	public File file;
	public PrintWriter fileWriter;
	public BufferedReader fileReader;
	
	public gestionFichier ()
	{
		try
		{
			file = new File ("C:\\Users\\hugo-\\Documents\\save.txt");
			
			if (file.exists () == false)
				file.createNewFile ();
		} catch (IOException e)
		{
			throw new TechnicalException(e);
		}
	}
	
	public void ecriture (List <String> listString)
	{
		try
		{
			fileWriter = new PrintWriter (new FileWriter (file));
			
			for (String s : listString)
				fileWriter.println (s);
			
			fileWriter.flush ();
			fileWriter.close ();
		} catch (IOException e)
		{
			throw new TechnicalException(e);
		}
	}
	
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
		} catch (IOException e)
		{
			throw new TechnicalException(e);
		} 
	}
}
