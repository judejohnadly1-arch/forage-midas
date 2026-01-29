package com.jpmc.midascore.repository;
import com.jpmc.midascore.TransactionRecord;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionRecord, Long>
{


}
