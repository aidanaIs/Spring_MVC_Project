package course.api;

import course.entity.Customer;
import course.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerApi {
     private final CustomerService customerService;


    @GetMapping
    private String getAllCustomers(Model model){
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer/allCustomers";
    }


    @GetMapping("/new")
    public String createCustomer(Model model){
        model.addAttribute("newCustomer", new Customer());
        return "customer/newCustomer";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("newCustomer") Customer customer){
       customerService.saveCustomer(customer);
        return "redirect:/customers";
    }


    @GetMapping("/{id}/edit")
    public String updateCustomer(@PathVariable("id") Long id,  Model model) {
        model.addAttribute("editCustomer", customerService.getCustomerById(id));
        return "customer/updateCustomer";
    }


    @PostMapping("/updateCustomer/{id}")
    public String saveUpdate(@ModelAttribute("editCustomer") Customer customer, @PathVariable("id") Long id){
        customerService.updateCustomerById(id, customer);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }


}
