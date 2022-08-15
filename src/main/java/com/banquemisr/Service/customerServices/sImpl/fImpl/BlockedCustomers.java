package com.banquemisr.Service.customerServices.sImpl.fImpl;

import com.banquemisr.DTOs.CustomerDTO;
import com.banquemisr.Service.customerServices.sImpl.custServiceInterface;
import com.banquemisr.persistence.Customer;
import com.banquemisr.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class BlockedCustomers implements custServiceInterface {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public List<CustomerDTO> getCustomers() {
        List<Customer> customers = (List<Customer>) customerRepo.findAll();


        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.OCTOBER, 16);
        date.setTime(calendar.getTime().getTime());
//        Date date = new Date(calendar.getTime());

        List<CustomerDTO> list = new ArrayList<CustomerDTO>();

        for (Customer customer: customers) {
            if(customer.getDueDate() == null)
                continue;
            if(customer.getDueDate().before(calendar.getTime()))
                list.add(new CustomerDTO(customer));
        }

        return list;
    }

    public List<CustomerDTO> getCustomersWDate(Date threshold) {
        List<Customer> customers = (List<Customer>) customerRepo.findAll();


        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(threshold);
        date.setTime(calendar.getTime().getTime());

//        Date date = new Date(calendar.getTime());

        List<CustomerDTO> list = new ArrayList<CustomerDTO>();

        for (Customer customer: customers) {
            if(customer.getDueDate() == null)
                continue;
            if(customer.getDueDate().before(calendar.getTime()))
                list.add(new CustomerDTO(customer));
        }

        return list;
    }


}
