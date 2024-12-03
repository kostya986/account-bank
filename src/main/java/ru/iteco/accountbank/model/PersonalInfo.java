package ru.iteco.accountbank.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonalInfo {

    private Integer userId;
    private String name;

}
