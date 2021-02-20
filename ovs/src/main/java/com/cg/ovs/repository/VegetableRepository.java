package com.cg.ovs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ovs.domain.OrderDetail;
import com.cg.ovs.domain.Vegetable;

@Repository
public interface VegetableRepository extends CrudRepository<Vegetable,Long> {
List<Vegetable> findByVegId(Long vegId);
}
