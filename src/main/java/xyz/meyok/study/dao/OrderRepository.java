package xyz.meyok.study.dao;

import xyz.meyok.study.pojo.dto.Order;

/**
 * @author meyokyang@163.com
 * @date 17/02/2024 23:24
 */
public interface OrderRepository {
    Order save(Order order);
}
