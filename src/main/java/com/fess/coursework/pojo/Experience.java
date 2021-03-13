package com.fess.coursework.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Eugene Mereha
 */

@Data
public class Experience {

    @NotEmpty(message = "Выберите дату начала работы")
    private String dateStart;

    @NotEmpty(message = "Выберите дату окончания работы")
    private String dateEnd;

    @NotEmpty (message = "Поле 'Организация' не должно быть пустым")
    private String organization;

    @NotEmpty(message = "Поле 'Должность' не должно быть пустым")
    private String position;

    @NotEmpty(message = "Поле 'Обязанности' не должно быть пустым")
    private String responsibility;

    private boolean hasExperience = true;

    public boolean checkExperience() {
        return dateStart == null && dateEnd == null && organization == null && position == null && responsibility == null;
    }
}
