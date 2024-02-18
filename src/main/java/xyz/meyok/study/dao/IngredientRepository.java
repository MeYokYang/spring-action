package xyz.meyok.study.dao;

import xyz.meyok.study.pojo.po.Ingredient;

/**
 * @author meyokyang@163.com
 * @date 17/02/2024 23:24
 */
public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);
}
