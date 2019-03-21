package fr.pizzeria.utils;

import java.lang.annotation.*;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)
public @interface ToString
{
	String separateur() default "";
	boolean upperCase() default false;
}
