package com.banquemisr.SpringContoller;

import com.banquemisr.DTOs.CustomerDTO;
import com.banquemisr.Service.customerServices.sImpl.RichCustomers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cust/v2")
public class CustCntrRich {

    @Autowired
    RichCustomers RichCustomers;

    @GetMapping("/getRich")
    public String index()
    {
        List<CustomerDTO> list= RichCustomers.getCustomers();

        if(!list.isEmpty())
        {
            StringBuilder result = new StringBuilder() ;
            for (CustomerDTO cust: list) {
                result.append(cust.toString());
            }
            return result.toString();
        }
        return "Customer not found.";
    }

    @GetMapping("")
    public String test()
    {
        return "In service impl";
    }

}
