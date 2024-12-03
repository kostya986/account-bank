package ru.iteco.accountbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.iteco.accountbank.model.AccountInfo;
import ru.iteco.accountbank.model.BankBook;
import ru.iteco.accountbank.model.PersonalInfo;

import java.util.List;
import java.util.Map;

@Service
@Primary
public class AccountServiceImpl implements AccountService {

    private final PersonalInformationService personalInformationService;
    private final Map<String, BankBookService> bankBookServices;

    @Autowired
    public AccountServiceImpl(@Qualifier("personalInformationMockServiceImpl")
                              PersonalInformationService personalInformationService,
                              Map<String, BankBookService> bankBookServices) {
        this.personalInformationService = personalInformationService;
        this.bankBookServices = bankBookServices;
    }

    @Override
    public AccountInfo getAccountInfoById(Integer accountId) {
        AccountInfo accountInfo = new AccountInfo();
        PersonalInfo personalInfo = personalInformationService.getPersonalInfoByAccountId(accountId);
        System.out.println(personalInformationService);
        accountInfo.setPersonalInfo(personalInfo);
        System.out.println(bankBookServices);
        for (BankBookService bankBookService : bankBookServices.values()) {
            List<BankBook> bankBooks = bankBookService.getBankBooksByAccountId(accountId);
            System.out.println(bankBooks);
            if (bankBooks != null && !bankBooks.isEmpty()) {
                accountInfo.setBankBooks(bankBooks);
            }
        }
        return accountInfo;
    }

}
