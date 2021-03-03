package com.fess.coursework;

import com.fess.coursework.model.MainInformation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Eugene Mereha
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String index(@ModelAttribute("MainInformation") MainInformation mainInformation) {
        return "index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("MainInformation") MainInformation mainInformation,
                         @RequestParam("title[]") String title) {
        System.out.println(title);
        System.out.println(mainInformation);
        return "index";
    }
}
