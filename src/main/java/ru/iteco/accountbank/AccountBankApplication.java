package ru.iteco.accountbank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.iteco.accountbank.model.AccountInfo;
import ru.iteco.accountbank.service.AccountService;

@ComponentScan
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class AccountBankApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AccountBankApplication.class);
        AccountService accountService = context.getBean(AccountService.class);
        AccountInfo accountInfo = accountService.getAccountInfoById(2);
        System.out.println(accountInfo);
    }

}
