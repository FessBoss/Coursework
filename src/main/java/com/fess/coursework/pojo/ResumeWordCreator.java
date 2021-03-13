package com.fess.coursework.pojo;

import lombok.Data;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author Eugene Mereha
 */

@Data
public class ResumeWordCreator {
    private String wordName;
    private Resume resume;

    public ResumeWordCreator(Resume resume) {
        this.resume = resume;
    }

    public void create() {
        XWPFDocument document = new XWPFDocument();

        //Основная часть
        XWPFParagraph mainInformationBlock = document.createParagraph();
        XWPFRun fullName = mainInformationBlock.createRun();
        fullName.setText(wordSetFullName());
        fullName.setFontSize(14);
        fullName.setFontFamily("Times New Roman");
        fullName.setBold(true);
        fullName.addBreak();

        XWPFRun position = mainInformationBlock.createRun();
        position.setText(wordSetPosition());
        position.setFontSize(14);
        position.setFontFamily("Times New Roman");
        position.addBreak();

        XWPFRun city = mainInformationBlock.createRun();
        city.setText(wordSetLocation());
        city.setFontSize(14);
        city.setFontFamily("Times New Roman");
        city.addBreak();

        XWPFRun phone = mainInformationBlock.createRun();
        phone.setText("Телефон:");
        phone.setFontSize(14);
        phone.setFontFamily("Times New Roman");
        phone.setBold(true);
        phone = mainInformationBlock.createRun();
        phone.setText(" " + wordSetPhone());
        phone.setFontSize(14);
        phone.setFontFamily("Times New Roman");
        phone.addBreak();

        XWPFRun email = mainInformationBlock.createRun();
        email.setText("Email:");
        email.setFontSize(14);
        email.setFontFamily("Times New Roman");
        email.setBold(true);
        email = mainInformationBlock.createRun();
        email.setText(" " + wordSetEmail());
        email.setFontSize(14);
        email.setFontFamily("Times New Roman");
        email.addBreak();

        if (!resume.getMainInformation().getGithub().equals("")) {
            XWPFRun github = mainInformationBlock.createRun();
            github.setText("GitHub:");
            github.setFontSize(14);
            github.setFontFamily("Times New Roman");
            github.setBold(true);
            github = mainInformationBlock.createRun();
            github.setText(" " + wordSetGitHub());
            github.setFontSize(14);
            github.setFontFamily("Times New Roman");
            github.addBreak();
        }

        //Навыки
        XWPFParagraph skillsBlock = document.createParagraph();
        XWPFRun skillsHeader = skillsBlock.createRun();
        createHeader(skillsHeader, "НАВЫКИ");

        XWPFRun skillsRun = skillsBlock.createRun();
        skillsRun.setFontSize(14);
        skillsRun.setFontFamily("Times New Roman");
        skillsRun.setText(wordSetSkills());

        //Опыт работы
        XWPFParagraph experienceBlock = document.createParagraph();
        XWPFRun experiencesHeader = experienceBlock.createRun();
        createHeader(experiencesHeader, "ОПЫТ РАБОТЫ");

        if (wordSetExperience().size() == 0) {
            XWPFRun experienceRun = experienceBlock.createRun();
            experienceRun.setText("Без опыта работы");
            experienceRun.setFontSize(14);
            experienceRun.setFontFamily("Times New Roman");
        } else {
            for (int i = 0; i < wordSetExperience().size(); i++) {
                if (i == 0) {
                    createExperienceRunBlock(experienceBlock, i);
                } else {
                    XWPFParagraph experiencesParagraph = document.createParagraph();
                    createExperienceRunBlock(experiencesParagraph, i);
                }
            }
        }

        //Образование
        XWPFParagraph educationBlock = document.createParagraph();
        XWPFRun educationHeader = educationBlock.createRun();
        createHeader(educationHeader, "ОБРАЗОВАНИЕ");

        for (int i = 0; i < wordSetEducation().size(); i++) {
            if (i == 0) {
                createEducationRunBlock(educationBlock, i);
            } else {
                XWPFParagraph educationParagraph = document.createParagraph();
                createEducationRunBlock(educationParagraph, i);
            }
        }

        //ЗНАНИЕ ЯЗЫКОВ
        XWPFParagraph languagesBlock = document.createParagraph();
        XWPFRun languageHeader = languagesBlock.createRun();
        createHeader(languageHeader, "ЗНАНИЕ ЯЗЫКОВ");

        for (int i = 0; i < wordSetLanguages().size(); i++) {
            XWPFRun languageRun = languagesBlock.createRun();
            languageRun.setText("-" + wordSetLanguages().get(i));
            languageRun.setFontSize(14);
            languageRun.setFontFamily("Times New Roman");

            if (i != wordSetLanguages().size() - 1) {
                languageRun.addBreak();
            }
        }

        //ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ
        XWPFParagraph additionalInformationBlock = document.createParagraph();
        XWPFRun additionalInformationHeader = additionalInformationBlock.createRun();
        createHeader(additionalInformationHeader, "ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ");

        XWPFRun additionalInformationRun = additionalInformationBlock.createRun();
        additionalInformationRun.setText(wordSetAdditionalInformation());
        additionalInformationRun.setFontSize(14);
        additionalInformationRun.setFontFamily("Times New Roman");

        try {
            wordName = "resume.docx";
            FileOutputStream outputStream = new FileOutputStream("F://Coursework//out//" + wordName);
            document.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createHeader(XWPFRun xwpfRun, String text) {
        xwpfRun.setText(text);
        xwpfRun.setFontSize(16);
        xwpfRun.setFontFamily("Calibri");
        xwpfRun.setBold(true);
        xwpfRun.setColor("B85B21");
        xwpfRun.addBreak();
    }

    private void createEducationRunBlock(XWPFParagraph paragraph, int i) {
        XWPFRun educationDatesRun = paragraph.createRun();
        educationDatesRun.setText(wordSetEducation().get(i).getStartStudy() + " - " + wordSetEducation().get(i).getEndStudy());
        educationDatesRun.setFontSize(14);
        educationDatesRun.setFontFamily("Times New Roman");
        educationDatesRun.setBold(true);
        educationDatesRun.addBreak();

        XWPFRun educationUniversitiesRun = paragraph.createRun();
        educationUniversitiesRun.setText("  " + wordSetEducation().get(i).getUniversity());
        educationUniversitiesRun.setFontSize(14);
        educationUniversitiesRun.setFontFamily("Times New Roman");
        educationUniversitiesRun.addBreak();

        XWPFRun educationFacultyRun = paragraph.createRun();
        educationFacultyRun.setText("    " + wordSetEducation().get(i).getFaculty());
        educationFacultyRun.setFontSize(14);
        educationFacultyRun.setFontFamily("Times New Roman");
        educationFacultyRun.addBreak();

        XWPFRun educationSpecialtyRun = paragraph.createRun();
        educationSpecialtyRun.setText("      " + wordSetEducation().get(i).getSpecialty());
        educationSpecialtyRun.setFontSize(12);
        educationSpecialtyRun.setFontFamily("Times New Roman");
    }

    private void createExperienceRunBlock(XWPFParagraph paragraph, int i) {
        XWPFRun experienceDatesRun = paragraph.createRun();
        experienceDatesRun.setText(wordSetExperience().get(i).getDateStart() + " - "
                + wordSetExperience().get(i).getDateEnd());
        experienceDatesRun.setFontSize(14);
        experienceDatesRun.setFontFamily("Times New Roman");
        experienceDatesRun.setBold(true);
        experienceDatesRun.addBreak();

        XWPFRun experienceOrganisationAndPositionRun = paragraph.createRun();
        experienceOrganisationAndPositionRun.setText("  " +
                wordSetExperience().get(i).getOrganization() + " - " +
                wordSetExperience().get(i).getPosition());
        experienceOrganisationAndPositionRun.setFontSize(14);
        experienceOrganisationAndPositionRun.setFontFamily("Times New Roman");
        experienceOrganisationAndPositionRun.addBreak();

        XWPFRun experienceResponsibilitiesRun = paragraph.createRun();
        experienceResponsibilitiesRun.setText("    " + wordSetExperience().get(i).getResponsibility());
        experienceResponsibilitiesRun.setFontSize(12);
        experienceResponsibilitiesRun.setFontFamily("Times New Roman");
    }

    private String wordSetFullName() {
        return resume.getMainInformation().getFirstname() + " " + resume.getMainInformation().getLastname();
    }

    private String wordSetPosition() {
        return resume.getMainInformation().getDesiredPosition();
    }

    private String wordSetLocation() {
        return resume.getMainInformation().getLocation() + ", Россия";
    }

    private String wordSetPhone() {
        return resume.getMainInformation().getPhone();
    }

    private String wordSetEmail() {
        return resume.getMainInformation().getEmail();
    }

    private String wordSetGitHub() {
        return resume.getMainInformation().getGithub();
    }

    private String wordSetSkills() {
        return resume.getSkills();
    }

    private List<Experience> wordSetExperience() {
        List<Experience> experiences = resume.getExperiences();
        for (Experience experience: experiences) {
            experience.setDateStart(experience.getDateStart().replace('-', '.'));
            experience.setDateEnd(experience.getDateEnd().replace('-', '.'));
        }
        return experiences;
    }

    private List<Education> wordSetEducation() {
        return resume.getEducations();
    }

    private List<String> wordSetLanguages() {
        return resume.getLanguages();
    }

    private String wordSetAdditionalInformation() {
        return resume.getAdditionalInformation();
    }
}
