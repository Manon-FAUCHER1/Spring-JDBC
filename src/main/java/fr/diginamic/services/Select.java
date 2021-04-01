/**
 * 
 */
package fr.diginamic.services;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.dao.JdbcConfigurationDao;
import fr.diginamic.entities.Pokemon;

/**
 * @author manon
 *
 */
public class Select {
	
	@Transactional
	public void selectAll(Scanner scanner, JdbcConfigurationDao jdbc) {
		System.out.println("\nSELECT ALL :");
		List<Pokemon> resultSelectAll = jdbc.selectAll();
		for (Pokemon pokemon : resultSelectAll) {
			System.out.println(pokemon);
		}
	}
	
	@Transactional
	public void selectByType(Scanner scanner, JdbcConfigurationDao jdbc) {
		System.out.println("SELECT BY TYPE:");
		
		System.out.println("Saisir un type");
		
		String saisiType = scanner.nextLine();
		
		List<Pokemon> resultSelectByType = jdbc.selectByType(saisiType);
		for (Pokemon pokemon : resultSelectByType) {
			System.out.println(pokemon);
		}
	}

}
