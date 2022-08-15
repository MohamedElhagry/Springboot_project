package com.banquemisr.repository;


import com.banquemisr.persistence.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends CrudRepository<Account, Integer> {


}
