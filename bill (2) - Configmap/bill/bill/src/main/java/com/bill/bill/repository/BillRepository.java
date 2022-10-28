package com.bill.bill.repository;

import com.bill.bill.entity.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill,Long> {
}
