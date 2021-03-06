package com.fess.coursework.controller;

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
                         @ModelAttribute("Education") @Valid Education education,
                         BindingResult bindingResultEducation,
                         @RequestParam("skills") String skills,
                         @RequestParam(value = "languages", required = false) String languages,
                         @RequestParam("additionalInformation") String additionalInformation,
                         Model model) {

        if (bindingResultMainInformation.hasErrors() ||
                (bindingResultExperience.hasErrors() && !experience.checkExperience()) ||
                (bindingResultEducation.hasErrors() && !education.checkEducation()) ||
                skills.isEmpty() ||
                languages == null) {

            if (skills.isEmpty()) {
                model.addAttribute("skillsError", "Поле 'Навыки' не должно быть пустым");
            }

            if (languages == null) {
                model.addAttribute("languagesError", "Выберите хотя бы один язык");
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

        return "redirect:/download/file/resume.docx";
    }
}
