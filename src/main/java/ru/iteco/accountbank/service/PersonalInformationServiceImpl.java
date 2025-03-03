package ru.iteco.accountbank.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.iteco.accountbank.model.PersonalInfo;

@Service
@Lazy
public class PersonalInformationServiceImpl implements PersonalInformationService {

    @Value("${name}")
    private String name;

    public PersonalInformationServiceImpl() {

    }

    @PostConstruct
    public void init() {
        if (!name.isEmpty()) {
            System.out.println(name);
        }
    }

    @PostConstruct
    public void init2() {
        System.out.println("init2");
    }

    @Override
    public PersonalInfo getPersonalInfoByAccountId(Integer accountId) {
        return new PersonalInfo()
                .setUserId(accountId)
                .setName(name);
    }

}