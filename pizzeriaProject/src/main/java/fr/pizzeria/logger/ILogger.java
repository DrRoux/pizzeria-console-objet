/**
 * 
 */
package fr.pizzeria.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface ILogger
{
	static final Logger LOG = LoggerFactory.getLogger(ILogger.class);
}
