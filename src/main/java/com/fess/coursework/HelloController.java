package com.fess.coursework;

import com.fess.coursework.pojo.Education;
import com.fess.coursework.pojo.Experience;
import com.fess.coursework.pojo.MainInformation;
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
    public String index(@ModelAttribute("MainInformation") MainInformation mainInformation,
                        @ModelAttribute("Experience") Experience experience,
                        @ModelAttribute("Education") Education education) {
        return "index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("MainInformation") MainInformation mainInformation,
                         @ModelAttribute("Experience") Experience experience,
                         @ModelAttribute("Education") Education education,
                         @RequestParam("skills") String skills,
                         @RequestParam("additionalInformation") String additionalInformation) {
        System.out.println(mainInformation);
        System.out.println(experience);
        System.out.println(education);
        System.out.println(skills);
        System.out.println(additionalInformation);
        return "index";
    }
}
