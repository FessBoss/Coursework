package com.fess.coursework;

import com.fess.coursework.pojo.Education;
import com.fess.coursework.pojo.Experience;
import com.fess.coursework.pojo.MainInformation;
import com.fess.coursework.pojo.Resume;
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
                         @RequestParam("languages") String languages,
                         @RequestParam("additionalInformation") String additionalInformation) {
        System.out.println(education);
        Resume resume = new Resume.Builder()
                .mainInformation(mainInformation)
                .skills(skills)
                .experiences(experience)
                .educations(education)
                .languages(languages)
                .additionalInformation(additionalInformation)
                .build();

        System.out.println(resume.getMainInformation());
        System.out.println("!==============================================================================!");

        System.out.println(resume.getSkills());
        System.out.println("!==============================================================================!");

        System.out.println(resume.getExperiences());
        System.out.println("!==============================================================================!");

        System.out.println(resume.getEducations());
        System.out.println("!==============================================================================!");

        System.out.println(resume.getLanguages());
        System.out.println("!==============================================================================!");

        System.out.println(resume.getAdditionalInformation());

        return "redirect:/";
    }
}
