package com.cis365.week5;


import com.cis365.week5.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @RequestMapping("/customers")
    public List<Customer> customers() {
        return DataStore.listCustomers();
    }
}
