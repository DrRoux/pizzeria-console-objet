/**
 * 
 */
package fr.pizzeria.utils;

import java.lang.reflect.Field;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class StringUtils<T>
{
	private T attribut;

	public StringUtils()
	{
	}

	public StringUtils(T type)
	{
		this.attribut = type;
	}

	@Override
	public String toString()
	{
		Class<? extends Object> classe = attribut.getClass();
		Field[] fields = classe.getDeclaredFields();
		String retour = "";

		for (Field f : fields)
		{
			f.setAccessible(true);
			if (f.isAnnotationPresent(ToString.class))
			{
				try
				{
					ToString annotation = f.getAnnotation(ToString.class);
					boolean uppercase = annotation.upperCase();
					boolean display = annotation.display();
					String separateurAv = annotation.separateurAv();
					String separateurAp = annotation.separateurAp();

					retour += separateurAv;
					if (display)
					{
						if (uppercase)
						{
							retour += f.get(attribut).toString().toUpperCase();
						}
						else
						{
							retour += f.get(attribut);
						}
					}
					retour += separateurAp;

				}
				catch (IllegalArgumentException | IllegalAccessException e)
				{
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
