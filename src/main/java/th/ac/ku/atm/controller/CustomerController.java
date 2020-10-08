package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.service.CustomerService;
import th.ac.ku.atm.model.Customer;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getCustomerPage(Model model) {
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "customer";
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        customerService.createCustomer(customer);
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "redirect:customer";
    }
}

//@Controller
//public class CustomerController {
//
//    private CustomerService customerService;
//
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @GetMapping("/customer")
//    public String getCustomerPage(Model model) {
//        model.addAttribute("allCustomers", customerService.getCustomers());
//        return "customer";
//    }
//
//    @PostMapping("/customer")
//    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
//        customerService.createCustomer(customer);
//        model.addAttribute("allCustomers", customerService.getCustomers());
//        return "redirect:customer";
//    }
//}

//package th.ac.ku.atm.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import th.ac.ku.atm.model.Customer;
//
//import java.util.ArrayList;
//
//
//@Controller
//public class CustomerController {
//    ArrayList<Customer> customers = new ArrayList<>();
//
//    @GetMapping("/customer")
//    public String getCustomerPage(Model model) {
//        ArrayList<Customer> customers= new ArrayList<>();
//        customers.add(new Customer(1,"Peter",1234));
//        customers.add(new Customer(2,"Nancy",2345));
//        customers.add(new Customer(3,"Rick",3456));
//        model.addAttribute("allCustomers", customers);
//        return "customer";  // customer.html
//    }
//    @PostMapping("/customer")
//    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
//        customers.add(customer);
//        model.addAttribute("allCustomers", customers);
//        return "redirect:customer";
//    }
//}
