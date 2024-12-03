package ru.iteco.accountbank.service;

import org.springframework.stereotype.Service;
import ru.iteco.accountbank.model.PersonalInfo;

@Service
public class PersonalInformationMockServiceImpl implements PersonalInformationService{

    @Override
    public PersonalInfo getPersonalInfoByAccountId(Integer accountId) {
        return new PersonalInfo();
    }

}
