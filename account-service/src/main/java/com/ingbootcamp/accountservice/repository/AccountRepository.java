package com.ingbootcamp.accountservice.repository;

import com.ingbootcamp.accountservice.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface AccountRepository extends CassandraRepository<Account,String> {
}
