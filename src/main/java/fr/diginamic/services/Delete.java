/**
 * 
 */
package fr.diginamic.services;

import java.util.Scanner;

import org.springframework.transaction.annotation.Transactional;

import com.google.protobuf.Value;

import fr.diginamic.dao.JdbcConfigurationDao;

/**
 * @author manon
 *
 */
public class Delete {

	@Transactional
	public void deletePokemon(Scanner scanner, JdbcConfigurationDao jdbc) {
		System.out.println("DELETE POKEMON :\n");

		// AFFICHAGE DE LA LISTE DES POKEMON EN BASE BDD
		Select selectAll = new Select();
		selectAll.selectAll(scanner, jdbc);

		System.out.println("\nVeillez saisir l'id du pokemon a supprimé");
		String saisiId = scanner.nextLine();
		int choixId = Integer.parseInt(saisiId);

		String nomPoekemon = jdbc.selectName(choixId);

		System.out.println("Etes vous sur de vouloir supprimer " + nomPoekemon + " ? (O/N)");
		String value = scanner.nextLine();

		if (value.equals("O")) {
			String resultDelete = jdbc.delete(choixId);
			System.out.println(resultDelete);
		} else {
			System.out.println("retour menu");
		}

	}

}
