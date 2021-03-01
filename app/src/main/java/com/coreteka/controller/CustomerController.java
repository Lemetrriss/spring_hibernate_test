package com.coreteka.controller;

import com.coreteka.entity.Customer;
import com.coreteka.service.CustomerService;
import com.coreteka.util.SortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(@RequestParam(required = false, name = "sort") String sort, Model model) {
        List<Customer> customers;
        if (sort != null){
            customers = customerService.getCustomers(sort);
        } else {
            customers = customerService.getCustomers(SortUtil.LAST_NAME);
        }
        model.addAttribute("customery", customers);
        return "list-customers";
    }

    @GetMapping("/addCustomerForm")
    public String addCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-add-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/updateCustomerForm")
    public String updateCustomer(@RequestParam ("customerId") int id, Model model){
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "customer-add-form";
    }

    @GetMapping("/deleteCustomerForm")
    public String deleteCustomer(@RequestParam ("customerId") int id, Model model){
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam ("theSearchName") String search, Model model){
        List<Customer> list = customerService.searchCustomers(search);
        model.addAttribute("customery", list);
        return "list-customers";
    }

    @GetMapping("/customerDetailForm")
    public String customerDetail(@RequestParam ("customer") int id, Model model){
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "customer-detail";
    }
}
