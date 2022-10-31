package ru.netology.springboot2.model;

import lombok.Getter;
import lombok.Setter;
import ru.netology.springboot2.authorities.Authorities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class User {

    @Getter
    @Setter
    @Size(min = 2, max = 30)
    @NotBlank
    private String name;

    @Getter
    @Setter
    @Size(min = 2, max = 30)
    @NotBlank
    private String password;

    @Getter
    @Setter
    private List<Authorities> authorities;

    public User (String name, String password, List<Authorities> authorities) {
        this.name = name;
        this.password = password;
        this.authorities = authorities;
    }


}
