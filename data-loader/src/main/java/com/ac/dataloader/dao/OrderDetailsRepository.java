package com.ac.dataloader.dao;

import com.ac.dataloader.entity.orm.OrderDetails;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer> {
}
