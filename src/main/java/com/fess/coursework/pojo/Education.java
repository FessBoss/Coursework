package com.fess.coursework.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Eugene Mereha
 */

@Data
public class Education {

    @NotEmpty(message = "Поле 'Учебное заведение' не должно быть пустым")
    private String university;

    @NotEmpty(message = "Поле 'Факультет' не должно быть пустым")
    private String faculty;

    @NotEmpty(message = "Поле 'Специальность' не должно быть пустым")
    private String specialty;

    @NotEmpty(message = "Выберите дату начала обучения")
    private String startStudy;

    @NotEmpty(message = "Выберите конец обучения")
    private String endStudy;

    private boolean hasEducation = true;

    public boolean checkEducation() {
        return university == null && faculty == null && specialty == null && startStudy == null && endStudy == null;
    }
}
