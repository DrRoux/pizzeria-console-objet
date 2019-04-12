/**
 * 
 */
package fr.pizzeria.utils;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class StringUtils<T>
{
	private static Logger logger = LoggerFactory.getLogger(StringUtils.class);
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
		StringBuilder retour = new StringBuilder();

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

					retour.append(separateurAv);
					if (display)
					{
						if (uppercase)
						{
							retour.append(f.get(attribut).toString().toUpperCase());
						}
						else
						{
							retour.append(f.get(attribut));
						}
					}
					retour.append(separateurAp);

				}
				catch (IllegalArgumentException | IllegalAccessException e)
				{
					logger.info(e.getMessage());
				}
			}
		}

		return retour.toString();
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
