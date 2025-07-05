package vn.hoidanit.laptopshop;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    @GetMapping("/")
    public String Index() {
        return "Hello, Spring Boot CongLucTran Update 1!";
    }
    @GetMapping("/user")
    public String userPage() {
        return "Only user can access this page!";
    }
    @GetMapping("/admin")
    public String adminPage() {
        return "Only admin can access this page!";
    }
    
}
