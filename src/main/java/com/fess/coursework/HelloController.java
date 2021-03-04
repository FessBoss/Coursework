package com.fess.coursework;

import com.fess.coursework.model.MainInformation;
import org.springframework.stereotype.Controller;
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
                         @RequestParam("languages[]") String languages,
                         @RequestParam("university") String university,
                         @RequestParam("startStudy[]") String startStudy,
                         @RequestParam("endStudy[]") String endStudy) {
        System.out.println(startStudy);
        System.out.println(endStudy);
        System.out.println(university);
        System.out.println(languages);
        System.out.println(mainInformation);
        return "index";
    }
}
