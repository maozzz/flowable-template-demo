package ru.webinnovations.flowabletemplatedemo.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author : maoz (mao_z@mail.ru)
 **/
@Entity @Table(name = "orders") @Data
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;

    String name;
    Integer status = 0;
    @CreationTimestamp Date createdAt;
    @UpdateTimestamp Date updatedAt;
}
