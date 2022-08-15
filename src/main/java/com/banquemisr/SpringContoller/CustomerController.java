package com.banquemisr.SpringContoller;

import com.banquemisr.DTOs.CustomerDTO;
import com.banquemisr.DAOs.DAO;
import com.banquemisr.persistence.Customer;
import com.banquemisr.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cust/v1")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

//    @RequestBody CustomerDTO customerDTO
    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        Customer customer = new Customer();
        customer.fill(customerDTO);
        customerRepo.save(customer);
//        DAO dao = new DAO();
//        dao.addCustomer(Customer);
        return "Success";
    }

    @PostMapping("saveMappedCustomers")
    public String saveCustomerUsingMapper(@RequestBody CustomerDTO customerDTO)
    {

        Customer customer = new Customer();
        modelMapper.map(customerDTO, customer);
        customerRepo.save(customer);
        return "Success";
    }

    @GetMapping("")
    public String unitTest()
    {
        return "Hello rtert";
    }

    @GetMapping("/get/{id}")
    public String index(@PathVariable int id)
    {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isPresent())
            return customer.get().toString();
        return "Customer not found.";
    }


    @GetMapping("/getMappedCustomers")
    public String getAllCustomers()
    {
        List<Customer> list = (List<Customer>) customerRepo.findAll();
        List<CustomerDTO> retList = new ArrayList<>();

        for (Customer customer: list) {
            CustomerDTO customerDTO = new CustomerDTO();
            modelMapper.map(customer, customerDTO);
            retList.add(customerDTO);
        }

        StringBuilder result = new StringBuilder();
        if(retList.isEmpty())
        {
            result.append("There are no mapped customers");
        }
        for (CustomerDTO cust: retList) {
            result.append(cust.toString());
        }

        return result.toString();
    }


}
