package com.banquemisr.repository;

import org.springframework.data.repository.CrudRepository;
import com.banquemisr.persistence.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepo extends CrudRepository<Customer,Integer> {

//    @Override
//    <S extends Customer> S save(S Customer);
//
//    @Override
//    Optional<Customer> findById(Integer integer);
//
//    @Override
//    Iterable<Customer> findAll();
//
//    @Override
//    long count();
//
//    @Override
//    void delete(Customer entity);
//
//    @Override
//    boolean existsById(Integer integer);

}
