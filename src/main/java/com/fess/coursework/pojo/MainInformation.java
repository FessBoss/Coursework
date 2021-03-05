package com.fess.coursework.pojo;

import com.fess.coursework.pojo.Education;
import com.fess.coursework.pojo.Experience;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eugene Mereha
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MainInformation {
    private long id;
    private String lastname;
    private String firstname;
    private String position;
    private String phone;
    private String email;
    private String github;

    private List<String> skills;

    private ArrayList<Experience> experiences;

    private ArrayList<Education> educations;

    private ArrayList<String> languages;

    private String additionalInformation;
}
