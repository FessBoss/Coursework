package com.fess.coursework;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Eugene Mereha
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Test Thymeleaf");
        return "index";
    }
}
