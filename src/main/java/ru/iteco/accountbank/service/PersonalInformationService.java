package ru.iteco.accountbank.service;

import ru.iteco.accountbank.model.PersonalInfo;

public interface PersonalInformationService {

    PersonalInfo getPersonalInfoByAccountId(Integer accountId);

}
