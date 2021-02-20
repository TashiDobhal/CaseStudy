package com.cg.ovs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ovs.domain.OrderDetail;
@Repository
public interface OrderRepository extends CrudRepository<OrderDetail,Long> {

OrderDetail findByOrderNo(String orderNo);
}