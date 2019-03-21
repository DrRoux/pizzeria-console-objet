/**
 * 
 */
package fr.pizzeria.utils;

import java.lang.reflect.Field;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class StringUtils <T>
{
	private T attribut;
	
	public StringUtils ()
	{	}
	
	public StringUtils (T type)
	{	
		this.attribut = type;
	}
	
	public String toString ()
	{
		Class classe = attribut.getClass ();
		Field [] fields = classe.getDeclaredFields();
		String retour = "";
		
		for (Field f : fields)
		{
				f.setAccessible(true);
				if (f.isAnnotationPresent(ToString.class))
				{
					try
					{
						ToString annotation = f.getAnnotation(ToString.class);
						boolean uppercase = annotation.upperCase ();
						boolean display = annotation.display ();
						String separateur = annotation.separateur();
						
						retour += separateur;
						if (display == true)
						{
							if (uppercase == true)
								retour += f.get(attribut).toString ().toUpperCase();
							else
								retour += f.get(attribut);
						}
						
					} 
					catch (IllegalArgumentException e)
					{
						e.printStackTrace();
					}
					catch (IllegalAccessException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
		
		return retour;
	}

	public T getAttribut()
	{
		return attribut;
	}

	public void setAttribut(T attribut)
	{
		this.attribut = attribut;
	}
}
