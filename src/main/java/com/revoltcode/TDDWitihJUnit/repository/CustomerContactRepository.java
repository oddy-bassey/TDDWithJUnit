package com.revoltcode.TDDWitihJUnit.repository;

import com.revoltcode.TDDWitihJUnit.domain.CustomerContact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {

}
