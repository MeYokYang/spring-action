package xyz.meyok.study.dao;

import org.springframework.data.repository.CrudRepository;

import xyz.meyok.study.pojo.po.Taco;

/**
 * @author meyokyang@163.com
 * @date 17/02/2024 23:24
 */
//public interface TacoRepository extends CrudRepository<Taco, Long> {
public interface TacoRepository {
    Taco save(Taco design);
}
