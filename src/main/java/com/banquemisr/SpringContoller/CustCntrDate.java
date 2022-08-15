package com.banquemisr.SpringContoller;

import com.banquemisr.DTOs.CustomerDTO;
import com.banquemisr.Service.customerServices.sImpl.fImpl.BlockedCustomers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cust/v3")
public class CustCntrDate{

    @Autowired
    BlockedCustomers blockedCustomers;

    @GetMapping("/getDate")
    public String getCustsWDateFilter()
    {
        List<CustomerDTO> list= blockedCustomers.getCustomers();

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

    @GetMapping("/getDate2")
    public String getCustsWGivenDateFilter(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1)
    {
        List<CustomerDTO> list= blockedCustomers.getCustomersWDate(d1);

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
        return "In blocked impl";
    }

}
