package xyz.meyok.study.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import xyz.meyok.study.pojo.dto.Order;

/**
 * @author meyokyang@163.com
 * @date 17/02/2024 23:24
 */
//public interface OrderRepository extends CrudRepository<Order, Long> {
public interface OrderRepository {

    Order save(Order order);

    // List<Order> findByDeliveryZip(String deliveryZip);

    // List<Order> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);

    // List<Order> findByDeliveryToAndDeliveryCityAllIgnoresCase(String deliveryTo, String deliveryCity);

    // List<Order> findByDeliveryCityOrderByDeliveryTo(String city);

    // @Query("Order o where o.deliveryCity = 'Seattle'")
    // List<Order> readOrdersDeliveredInSeattle();

}
