package fr.diginamic.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.entities.Pokemon;
import fr.diginamic.exceptions.ExceptionMessage;

/**
 * @author manon
 */
@Repository
public class JdbcConfigurationDao {

	private JdbcTemplate jdbcTemplate;

	/**
	 * Selectionne le nom du pokemon en fonction de son id 
	 * @param id
	 * @return Nom : String
	 */
	public String selectName(int id) {
		String pokemonName;
		return pokemonName = this.jdbcTemplate.queryForObject("SELECT nom FROM pokemon WHERE id = ?", String.class, id);
	}

	/**
	 * Selectionne la totaliter des pokemons 
	 * @return {@link List<Pokemon>}
	 */
	public List<Pokemon> selectAll() {
		String requet = "SELECT * FROM pokemon";

		return this.jdbcTemplate.query(requet, (rs, i) -> new Pokemon(rs.getInt(1), rs.getString(2), rs.getString(3),
				rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
	}

	/**
	 * Selectionne les pokemons pour un type donné
	 * @param type : String
	 * @return {@link List<Pokemon>}
	 */
	public List<Pokemon> selectByType(String type) {
		String requet = "SELECT * FROM pokemon WHERE type = ?";

		return this.jdbcTemplate.query(requet, (rs, i) -> new Pokemon(rs.getInt(1), rs.getString(2), rs.getString(3),
				rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)), type);

	}
	
	/**
	 * @param name
	 * @return
	 */
	public Integer countByName(String name) {
        String sqlQuery = "select count(1) from pokemon where name_ = ?";
        return jdbcTemplate.queryForObject(
                sqlQuery,
                Integer.class,
                name);
    }

	/**
	 * Insert un pokemon , les paramettres sont saisie par l'utilisateur dans la console 
	 * @param pokemon
	 * @return une petite phrase indiquant la réussite de l'insert
	 * @throws ExceptionMessage
	 */
	public String insert(Pokemon pokemon) throws ExceptionMessage {
		if (countByName(pokemon.getNom()) > 0) {
			  throw new RuntimeException("Le pokemon '" + pokemon.getNom() + "' existe déja .");
		}
		
		this.jdbcTemplate.update(
				"INSERT INTO pokemon (nom, type, pv, attaque, defense, vitesse) VALUES (?, ?, ?, ?, ?, ?)",
				pokemon.getNom(), pokemon.getType(), pokemon.getPv(), pokemon.getAttaque(), pokemon.getDefense(),
				pokemon.getVitesse());

		return "Insertion réussi !";
	}

	/**
	 * @param pv : int
	 * @param nom : String
	 * @return une petite phrase indiquant la réussite de l'update
	 */
	public String updatePv(int pv, String nom) {
		this.jdbcTemplate.update("UPDATE pokemon set pv = ? WHERE nom = ?", pv, nom);
		return "Update effectué";
	}
	
	/**
	 * @param nom : String
	 * @return une petite phrase indiquant la réussite de la suppression du pokemon
	 */
	public String delete(int id) {
		String namepokemon = selectName(id);
		this.jdbcTemplate.update("DELETE FROM pokemon where id = ?", id);
		return namepokemon + " a bien été supprimé";
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
