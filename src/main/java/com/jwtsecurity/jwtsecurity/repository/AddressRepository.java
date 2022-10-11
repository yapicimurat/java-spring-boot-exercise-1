package com.jwtsecurity.jwtsecurity.repository;

import com.jwtsecurity.jwtsecurity.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address getAddressById(Long addressId);

}
