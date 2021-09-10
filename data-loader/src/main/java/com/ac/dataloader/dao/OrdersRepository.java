package com.ac.dataloader.dao;


import com.ac.dataloader.entity.orm.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Order, Integer> {

}
