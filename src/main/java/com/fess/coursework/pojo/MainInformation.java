package com.fess.coursework.pojo;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author Eugene Mereha
 */

@Data
public class MainInformation {
    @NotEmpty(message = "Поле 'Фамилия' не должно быть пустым")
    @Size(min = 2, max = 30, message = "Фамилия должна содержать от 2 до 30 символов")
    private String lastname;

    @NotEmpty(message = "Поле 'Имя' не должно быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно содержать от 2 до 30 символов")
    private String firstname;

    @NotEmpty(message = "Поле 'Желаемая позиция' не должно быть пустым")
    private String desiredPosition;

    @NotEmpty(message = "Поле 'Место проживания' не должно быть пустым")
    private String location;

    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "Неверный формат телефона")
    private String phone;

    @Email
    @NotEmpty(message = "Поле Email не должно быть пустым")
    private String email;

    @Pattern(regexp = "^(?:github\\.com/\\w+|)$", message = "Неверный формат GitHub")
    private String github;
}
