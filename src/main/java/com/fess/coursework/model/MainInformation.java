package com.fess.coursework.model;

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
public class MainInformation {
    private long id;
    private String lastname;
    private String firstname;
    private String position;
    private String phone;
    private String email;
    private String github;
}
