package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.service.UserService;

// Mô Hình MVC
@Controller
public class UserController {
        private final UserService userService;
        
    public UserController(UserService userService) {
        this.userService = userService;
       
    }
    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> users = this.userService.getAllUsersByEmail("tinh@gmail.com");
        System.out.println("List of users: " + users);
        model.addAttribute("eric","test" );
        model.addAttribute("hoiCongLucTran", "Tôi yêu IT");
        return "hello";
    }
    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User user) {
       this.userService.handleSaveUser(user);
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
