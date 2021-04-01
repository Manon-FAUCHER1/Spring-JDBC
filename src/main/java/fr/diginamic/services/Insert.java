/**
 * 
 */
package fr.diginamic.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.dao.JdbcConfigurationDao;
import fr.diginamic.entities.Pokemon;
import fr.diginamic.exceptions.ExceptionMessage;

/**
 * @author manon
 *
 */
public class Insert {
	

	@Transactional
	public void insertPokemon(Scanner scanner, JdbcConfigurationDao jdbc) throws ExceptionMessage {
		System.out.println("INSERT POKEMON");

		System.out.println("Entrer le nom :");
		String saisiNomIn = scanner.nextLine();

		System.out.println("Entrer le type :");
		String saisiTypeIn = scanner.nextLine();

		System.out.println("Entrer le nombre de de pv");
		String saisiPv = scanner.nextLine();
		int saisiPvIn = Integer.parseInt(saisiPv);

		System.out.println("Entrer le nombre de de point d'attaque ");
		String saisiAttaque = scanner.nextLine();
		int saisiAttaqueIn = Integer.parseInt(saisiAttaque);

		System.out.println("Entrer le nombre de de point defence");
		String saisiDefence = scanner.nextLine();
		int saisiDefenceIn = Integer.parseInt(saisiDefence);

		System.out.println("Entrer le nombre de de point vitesse");
		String saisiVitesse = scanner.nextLine();
		int saisiVitesseIn = Integer.parseInt(saisiVitesse);

		Pokemon pokemon = new Pokemon(saisiNomIn, saisiTypeIn, saisiPvIn, saisiAttaqueIn, saisiDefenceIn,
				saisiVitesseIn);
		String resultInsert = jdbc.insert(pokemon);
		System.out.println(resultInsert);
	}

	@Transactional
	public void insertThreePokemonSameType(Scanner scanner, JdbcConfigurationDao jdbc) throws ExceptionMessage {
		System.out.println("INSERT THREE POKEMON SAME TYPE");

		// TYPE
		System.out.println("Entrer le type :");
		String saisiType = scanner.nextLine();

		
		// POKEMON 1
		System.out.println("Entrer le nom du pokemon 1:");
		String saisiNom1 = scanner.nextLine();
		
		System.out.println( saisiNom1 + ", pv :");
		String saisiPv1 = scanner.nextLine();
		int saisiPvIn1 = Integer.parseInt(saisiPv1);
		
		System.out.println( saisiNom1 + ", point d'attaque :");
		String saisiAttaque1 = scanner.nextLine();
		int saisiAttaqueIn1 = Integer.parseInt(saisiAttaque1);
		
		System.out.println(saisiNom1 + ", point defence");
		String saisiDefence1 = scanner.nextLine();
		int saisiDefenceIn1 = Integer.parseInt(saisiDefence1);
		
		System.out.println( saisiNom1 + ", point vitesse");
		String saisiVitesse1 = scanner.nextLine();
		int saisiVitesseIn1 = Integer.parseInt(saisiVitesse1);
		
		
		// POKEMON 2
		System.out.println("Entrer le nom du pokemon 2:");
		String saisiNom2 = scanner.nextLine();
		
		System.out.println( saisiNom2 + ", pv :");
		String saisiPv2 = scanner.nextLine();
		int saisiPvIn2 = Integer.parseInt(saisiPv2);
		
		System.out.println( saisiNom2 + ", point d'attaque :");
		String saisiAttaque2 = scanner.nextLine();
		int saisiAttaqueIn2 = Integer.parseInt(saisiAttaque2);
		
		System.out.println(saisiNom2 + ", point defence");
		String saisiDefence2 = scanner.nextLine();
		int saisiDefenceIn2 = Integer.parseInt(saisiDefence2);
		
		System.out.println( saisiNom2 + ", point vitesse");
		String saisiVitesse2 = scanner.nextLine();
		int saisiVitesseIn2 = Integer.parseInt(saisiVitesse2);
		
		
		// POKEMON 3
		System.out.println("Entrer le nom du pokemon 3:");
		String saisiNom3 = scanner.nextLine();
		
		System.out.println( saisiNom3 + ", pv :");
		String saisiPv3 = scanner.nextLine();
		int saisiPvIn3 = Integer.parseInt(saisiPv3);
		
		System.out.println( saisiNom3 + ", point d'attaque :");
		String saisiAttaque3 = scanner.nextLine();
		int saisiAttaqueIn3 = Integer.parseInt(saisiAttaque3);
	
		System.out.println(saisiNom3 + ", point defence");
		String saisiDefence3 = scanner.nextLine();
		int saisiDefenceIn3 = Integer.parseInt(saisiDefence3);
		
		System.out.println( saisiNom3 + ", point vitesse");
		String saisiVitesse3 = scanner.nextLine();
		int saisiVitesseIn3 = Integer.parseInt(saisiVitesse3);
				
		// CREATION DES POKEMONS
		Pokemon pokemon1 = new Pokemon(saisiNom1, saisiType, saisiPvIn1, saisiAttaqueIn1, saisiDefenceIn1, saisiVitesseIn1);
		Pokemon pokemon2 = new Pokemon(saisiNom2, saisiType, saisiPvIn2, saisiAttaqueIn2, saisiDefenceIn2, saisiVitesseIn2);
		Pokemon pokemon3 = new Pokemon(saisiNom3, saisiType, saisiPvIn3, saisiAttaqueIn3, saisiDefenceIn3, saisiVitesseIn3);
		
		// INSERT POKEMONS
		String resultInsert1 = jdbc.insert(pokemon1);
		String resultInsert2 = jdbc.insert(pokemon2);
		String resultInsert3 = jdbc.insert(pokemon3);
		
		
		List<Pokemon> pokemonsInsert = new ArrayList<>();
		pokemonsInsert.add(pokemon1);
		pokemonsInsert.add(pokemon2);
		pokemonsInsert.add(pokemon3);

		// AFFICHAGE DE LA PHRASE INDIQUAND LA REUSSITE
		for (Pokemon pokemon : pokemonsInsert) {
			jdbc.insert(pokemon);
		}
		
		// AFFICHAGE DE LA LISTE DES POKEMON EN BASE BDD
		Select selectAll = new Select();
		selectAll.selectAll(scanner, jdbc);

	}

}
