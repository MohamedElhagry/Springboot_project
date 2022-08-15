package com.banquemisr.Service.customerServices.sImpl;

import com.banquemisr.DTOs.CustomerDTO;
import com.banquemisr.persistence.Customer;
import com.banquemisr.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RichCustomers implements custServiceInterface {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public List<CustomerDTO> getCustomers() {
        List<Customer> customers = (List<Customer>) customerRepo.findAll();

        Long threshold = 100000L;

        List<CustomerDTO> list = new ArrayList<CustomerDTO>();

        for (Customer customer: customers) {
            if(customer.getBalance() >= threshold)
                list.add(new CustomerDTO(customer));
        }
        return list;
    }


}
