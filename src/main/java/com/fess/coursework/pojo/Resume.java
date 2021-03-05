package com.fess.coursework.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Eugene Mereha
 */

@Data
public class Resume {
    private MainInformation mainInformation;
    private List<String> skills;
    private List<Experience> experiences;
    private List<Education> educations;
    private List<String> languages;
    private String additionalInformation;

    public static class Builder {
        private MainInformation mainInformation;
        private List<String> skills;
        private List<Experience> experiences = new ArrayList<>();
        private List<Education> educations = new ArrayList<>();
        private List<String> languages = new ArrayList<>();
        private String additionalInformation;

        public Builder() {

        }

        public Builder mainInformation(MainInformation mainInformation) {
            this.mainInformation = mainInformation;
            return this;
        }

        public Builder skills(String str) {
            String[] words = str.split(",");
            skills = Arrays.asList(words);
            return this;
        }

        public Builder experiences(Experience experiences) {
            int count = experiences.getOrganization().split(",").length;

            if (count == 1) {
                this.experiences.add(experiences);
            } else {
                String[] datesStart = experiences.getDateStart().split(",");
                String[] datesEnd = experiences.getDateEnd().split(",");
                String[] positions = experiences.getPosition().split(",");
                String[] organizations = experiences.getOrganization().split(",");
                String[] getResponsibilities = experiences.getResponsibility().split(",");

                for (int i = 0; i < count; i++) {
                    Experience experience = new Experience();
                    experience.setDateStart(datesStart[i]);
                    experience.setDateEnd(datesEnd[i]);
                    experience.setPosition(positions[i]);
                    experience.setOrganization(organizations[i]);
                    experience.setResponsibility(getResponsibilities[i]);

                    this.experiences.add(experience);
                }
            }

            return this;
        }

        public Builder educations(Education educations) {
            int count = educations.getUniversity().split(",").length;

            if (count == 1) {
                this.educations.add(educations);
            } else {
                String[] universities = educations.getUniversity().split(",");
                String[] faculties = educations.getFaculty().split(",");
                String[] specialties = educations.getSpecialty().split(",");
                String[] startsStudy = educations.getStartStudy().split(",");
                String[] endsStudy = educations.getEndStudy().split(",");

                for (int i = 0; i < count; i++) {
                    Education education = new Education();
                    education.setUniversity(universities[i]);
                    education.setFaculty(faculties[i]);
                    education.setSpecialty(specialties[i]);
                    education.setStartStudy(startsStudy[i]);
                    education.setEndStudy(endsStudy[i]);

                    this.educations.add(education);
                }
            }

            return this;
        }

        public Builder languages(String languages) {
            String[] words = languages.split(",");
            this.languages = Arrays.asList(words);

            return this;
        }

        public Builder additionalInformation(String additionalInformation) {
            this.additionalInformation = additionalInformation;
            return this;
        }

        public Resume build() {
            return new Resume(this);
        }
    }

    private Resume(Builder builder) {
        this.mainInformation = builder.mainInformation;
        this.skills = builder.skills;
        this.experiences = builder.experiences;
        this.educations = builder.educations;
        this.languages = builder.languages;
        this.additionalInformation = builder.additionalInformation;
    }
}
