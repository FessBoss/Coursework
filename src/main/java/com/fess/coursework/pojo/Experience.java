package com.fess.coursework.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

/**
 * @author Eugene Mereha
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Experience {
    private String dateStart;
    private String dateEnd;
    private String position;
    private String organization;
    private String responsibility;
}
