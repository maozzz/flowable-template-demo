package ru.webinnovations.flowabletemplatedemo.repositories;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.webinnovations.flowabletemplatedemo.entities.Order;

/**
 * @author : maoz (mao_z@mail.ru)
 **/
public interface OrderRepository extends JpaRepository<Order, Long> {
}
