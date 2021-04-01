/**
 * 
 */
package fr.diginamic;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.dao.JdbcConfigurationDao;
import fr.diginamic.entities.Pokemon;
import fr.diginamic.exceptions.ExceptionMessage;
import fr.diginamic.services.Delete;
import fr.diginamic.services.Insert;
import fr.diginamic.services.Select;
import fr.diginamic.utils.UtilsConsol;


/**
 * @author manon
 *
 */
public class Luncher {

	/**
	 * @param args
	 * @throws ExceptionMessage
	 */
	@Transactional
	public static void main(String[] args) throws ExceptionMessage {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		JdbcConfigurationDao jdbc = context.getBean(JdbcConfigurationDao.class);

		Scanner scanner = new Scanner(System.in);

		int choix = 0;
		do {
			// Affichage du menu
			afficherMenu();

			// Poser une question à l'utilisateur
			String choixMenu = scanner.nextLine();

			// Conversion du choix utilisateur en int
			choix = Integer.parseInt(choixMenu);
			try {
				switch (choix) {
				case 1: // SELECT ALL
					Select selectAll = new Select();
					selectAll.selectAll(scanner, jdbc);
					break;
				case 2: // SELECT BY TYPE
					Select selectByType = new Select();
					selectByType.selectByType(scanner, jdbc);
					break;
				case 3: // INSERT POKEMON
					Insert insertOnePokemon = new Insert();
					insertOnePokemon.insertPokemon(scanner, jdbc);					
					break;
				case 4: // INSERT THREE POKEMON SAME TYPE
					Insert insertThreePokemon = new Insert();
					insertThreePokemon.insertThreePokemonSameType(scanner, jdbc);					
					break;	
				case 5: // UPDATE PV
					System.out.println("UPDATE PV");
					
					System.out.println("Veillez saisir le nom du pokemon a modifier");
					String saisiNomUp = scanner.nextLine();
					
					System.out.println("Veillez saisir le nombre de pv");
					String saisiPvUp = scanner.nextLine();
					int saisiPvUp2 = Integer.parseInt(saisiPvUp);
					
					String resultUp = jdbc.updatePv(saisiPvUp2, saisiNomUp);
					System.out.println(resultUp);
				case 6: // DELETE POKEMON
					Delete deletePokemon = new Delete();
					deletePokemon.deletePokemon(scanner, jdbc);
					break;
					
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} while (choix != 99);

		scanner.close();
	}

	/**
	 * Affichage du menu
	 */
	private static void afficherMenu() {
		System.out.println(UtilsConsol.ANSI_YELLOW);
		System.out.println("\n***** MENU POKEMON *****");
		System.out.println("1. SELECT ALL");
		System.out.println("2. SELECT BY TYPE");
		System.out.println("3. INSERT POKEMON");
		System.out.println("4. INSERT THREE POKEMON SAME TYPE");
		System.out.println("5. UPDATE PV");
		System.out.println("6. DELETE POKEMON");
		System.out.println("99. Sortir");
		System.out.println(UtilsConsol.ANSI_RESET);
	}

}
