package xyz.meyok.study.pojo.po;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author meyokyang@163.com
 * @date 17/02/2024 21:24
 */
@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
