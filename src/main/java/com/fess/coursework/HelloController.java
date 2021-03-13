package com.fess.coursework;

import com.fess.coursework.pojo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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
    public String create(@ModelAttribute("MainInformation") @Valid MainInformation mainInformation,
                         BindingResult bindingResultMainInformation,
                         @ModelAttribute("Experience") @Valid Experience experience,
                         BindingResult bindingResultExperience,
                         @ModelAttribute("Education") Education education,
                         @RequestParam("skills") String skills,
                         @RequestParam(value = "languages", required = false) String languages,
                         @RequestParam("additionalInformation") String additionalInformation,
                         Model model) {

        if (bindingResultMainInformation.hasErrors() ||
                (bindingResultExperience.hasErrors() && !experience.checkExperience()) ||
                skills.isEmpty()) {

            if (skills.isEmpty()) {
                model.addAttribute("skillsError", "Поле 'Навыки' не должно быть пустым");
            }


            return "index";
        }

        Resume resume = new Resume.Builder()
                .mainInformation(mainInformation)
                .skills(skills)
                .experiences(experience)
                .educations(education)
                .languages(languages)
                .additionalInformation(additionalInformation)
                .build();

        ResumeWordCreator resumeWordCreator = new ResumeWordCreator(resume);
        resumeWordCreator.create();

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
