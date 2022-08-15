package com.banquemisr.SpringContoller;


import com.banquemisr.DTOs.AccountDTO;
import com.banquemisr.persistence.Account;
import com.banquemisr.persistence.Customer;
import com.banquemisr.repository.AccountRepo;
import com.banquemisr.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/acc/v1")
public class AccountController {

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/add")
    public String addAccount(@RequestBody AccountDTO accountDTO)
    {
        System.out.println(accountDTO.toString());

        Account account = new Account();

        modelMapper.map(accountDTO, account);
        accountRepo.save(account);
        return "Success";
    }

    @PostMapping("/addUsingMapping")
    public String addAccount2(@RequestBody AccountDTO accountDTO)
    {
        Account account = new Account();
        account = convertAccountTOAccountDTO(accountDTO);
        if(account.getCustomer() == null)
            return "Customer doesn't exist";
        accountRepo.save(account);
        return "Success";
    }

    public Account convertAccountTOAccountDTO(AccountDTO accountDTO)
    {
        Account account = new Account();
        modelMapper.map(accountDTO, account);
        Optional<Customer> customer = customerRepo.findById(accountDTO.getCustomer().getId());
        if(!customer.isPresent())
        {
            account.setCustomer(null);
            return account;
        }
        account.setCustomer(customer.get());
        return account;
    }


}
