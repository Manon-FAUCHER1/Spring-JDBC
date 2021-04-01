/**
 * 
 */
package fr.diginamic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.diginamic.utils.UtilsConsol;

/**
 * @author manon
 *
 */
@Configuration
@ComponentScan
public class App {

	/**
	 * Constructor
	 */
	public App() {
		System.out.println(UtilsConsol.ANSI_RED + "*** start ***" + UtilsConsol.ANSI_RESET);
	}
}
