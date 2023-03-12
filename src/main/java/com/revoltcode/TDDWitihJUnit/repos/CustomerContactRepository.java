package com.revoltcode.TDDWitihJUnit.repos;

import com.revoltcode.TDDWitihJUnit.domain.CustomerContact;
import org.springframework.data.repository.CrudRepository;

public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {

}
