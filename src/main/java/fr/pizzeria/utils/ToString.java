package fr.pizzeria.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ToString
{
	String separateurAv() default "";

	String separateurAp() default "";

	boolean upperCase() default false;

	boolean display() default true;
}
