package com.fess.coursework.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Eugene Mereha
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Education {
    private String university;
    private String faculty;
    private String specialty;
    private String startStudy;
    private String endStudy;
}
