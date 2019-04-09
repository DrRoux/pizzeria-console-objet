/**
 * 
 */
package fr.pizzeria.dao.old;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.exception.TechnicalException;

/**
 * Cette classe permet d'ouvrir, de lire et décrire dans un fichier Elle est
 * utilisée pour sauvegarder de manière persistante les données de notre
 * application
 * 
 * @author BIRABEN-BIANCHI Hugo
 */
public class GestionFichier
{
	static Logger logger = LoggerFactory.getLogger(GestionFichier.class);
	private File file;
	private PrintWriter fileWriter;
	private BufferedReader fileReader;

	/**
	 * Constructor by default Use a "save.txt" file
	 */
	public GestionFichier(String nomFichier)
	{
		try
		{
			file = new File(nomFichier);

			if (!file.exists())
			{
				boolean result = file.createNewFile();

				if (!result)
				{
					logger.info("Ouverture du fichier échoué");
				}
			}
		}
		catch (IOException e)
		{
			throw new TechnicalException(e);
		}
	}

	public boolean isEmpty()
	{
		return file.length() < 1;
	}

	/**
	 * ecriture : Prend une List <String> pour écrire dans un fichier ligne par
	 * ligne
	 * 
	 * @param listString
	 */
	public void ecriture(List<String> listString)
	{
		try
		{
			fileWriter = new PrintWriter(new FileWriter(file));

			for (String s : listString)
			{
				fileWriter.println(s);
			}

			fileWriter.flush();
			fileWriter.close();
		}
		catch (IOException e)
		{
			throw new TechnicalException(e);
		}
	}

	/**
	 * lecture : Retourne une List <String> contenant un fichier entier ligne par
	 * ligne
	 * 
	 * @return
	 */
	public List<String> lecture()
	{
		try
		{
			String line = null;
			List<String> records = new ArrayList<>();
			fileReader = new BufferedReader(new FileReader(file));

			while ((line = fileReader.readLine()) != null)
			{
				records.add(line);
			}

			fileReader.close();
			return records;
		}
		catch (IOException e)
		{
			throw new TechnicalException(e);
		}
	}

	/**
	 * Getter
	 * 
	 * @return the file
	 */
	public File getFile()
	{
		return file;
	}

	/**
	 * Setter
	 * 
	 * @param file the file to set
	 */
	public void setFile(File file)
	{
		this.file = file;
	}

	/**
	 * Getter
	 * 
	 * @return the fileWriter
	 */
	public PrintWriter getFileWriter()
	{
		return fileWriter;
	}

	/**
	 * Setter
	 * 
	 * @param fileWriter the fileWriter to set
	 */
	public void setFileWriter(PrintWriter fileWriter)
	{
		this.fileWriter = fileWriter;
	}

	/**
	 * Getter
	 * 
	 * @return the fileReader
	 */
	public BufferedReader getFileReader()
	{
		return fileReader;
	}

	/**
	 * Setter
	 * 
	 * @param fileReader the fileReader to set
	 */
	public void setFileReader(BufferedReader fileReader)
	{
		this.fileReader = fileReader;
	}
}
