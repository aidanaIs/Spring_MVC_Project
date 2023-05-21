package course.api;

import course.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/houses")
@RequiredArgsConstructor
public class HouseApi {

    private final CustomerService customerService;

//    @GetMapping
//    private String getAllCustomers(Model model){
//        model.addAttribute("customers", customerService.getAllCustomers());
//        return "customer/allCustomers";
//    }



}
