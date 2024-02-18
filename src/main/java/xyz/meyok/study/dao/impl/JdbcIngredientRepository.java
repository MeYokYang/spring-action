package xyz.meyok.study.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import xyz.meyok.study.dao.IngredientRepository;
import xyz.meyok.study.pojo.po.Ingredient;

/**
 * @author meyokyang@163.com
 * @date 17/02/2024 23:24
 */
@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbc;

    // @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("SELECT id, name, type FROM Ingredient", this::mapRowToIngredient);
    }

    @Override
    public Ingredient findOne(String id) {
        return jdbc.queryForObject("SELECT id, name, type FROM Ingredient WHERE id=?", this::mapRowToIngredient, id);
    }

    /*
    @Override
    public Ingredient findOne(String id) {
        return jdbc.queryForObject(
            "SELECT id, name, type FROM Ingredient WHERE id=?",
            new RowMapper<Ingredient>() {
                public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new Ingredient(
                        rs.getString("id"),
                        rs.getString("name"),
                        Ingredient.Type.valueOf(rs.getString("type")));
                };
            },
            id);
    }
    */

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbc.update(
        "INSERT INTO Ingredient (id, name, type) VALUES (?, ?, ?)",
            ingredient.getId(),
            ingredient.getName(),
            ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
            rs.getString("id"),
            rs.getString("name"),
            Ingredient.Type.valueOf(rs.getString("type")));
    }

}
