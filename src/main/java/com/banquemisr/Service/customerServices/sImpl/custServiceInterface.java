package com.banquemisr.Service.customerServices.sImpl;

import com.banquemisr.DTOs.CustomerDTO;
import com.banquemisr.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface custServiceInterface {


    public List<CustomerDTO> getCustomers();

//    boolean addCustomer( CustomerDTO customerDTO);


}
