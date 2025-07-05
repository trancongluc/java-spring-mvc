package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.service.UserService;

// Mô Hình MVC
@Controller
public class UserController {
        private UserService userService;
    
    public UserController(UserService userService) {
       
        this.userService = userService;
    }
    @RequestMapping("/")
    public String getHomePage(Model model) {
         String test = userService.handleHello();
        model.addAttribute("eric",test );
        model.addAttribute("hoiCongLucTran", "Tôi yêu IT");
        return "hello";
    }
}


//RestFull API
// @RestController
// public class UserController {
//     private UserService userService;
    
//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     @GetMapping("/")
//     public String getHomePage() {
//         return userService.handleHello();
//     }
// }
