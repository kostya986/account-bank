package ru.iteco.accountbank.service;

import org.springframework.stereotype.Service;
import ru.iteco.accountbank.model.AccountInfo;

@Service
public class AccountServiceMockImpl implements AccountService {

    @Override
    public AccountInfo getAccountInfoById(Integer accountId) {
        return new AccountInfo();
    }

}
