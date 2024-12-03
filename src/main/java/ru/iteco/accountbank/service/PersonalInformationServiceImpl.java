package ru.iteco.accountbank.service;

import org.springframework.stereotype.Service;
import ru.iteco.accountbank.model.PersonalInfo;

@Service
public class PersonalInformationServiceImpl implements PersonalInformationService {

    @Override
    public PersonalInfo getPersonalInfoByAccountId(Integer accountId) {
        return new PersonalInfo().setUserId(accountId).setName("user");
    }

}