package ru.iteco.accountbank.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BankBook {

    private Integer userId;
    private Long number;

}
