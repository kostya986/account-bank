package ru.iteco.accountbank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.iteco.accountbank.model.AccountInfo;
import ru.iteco.accountbank.service.AccountService;
import ru.iteco.accountbank.service.IObject;
import ru.iteco.accountbank.service.protinjectsing.Prot1;
import ru.iteco.accountbank.service.singInjectprot.Sing;
import ru.iteco.accountbank.service.singInjectprot.Sing1;

@ComponentScan
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class AccountBankApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AccountBankApplication.class);
        AccountService accountService = context.getBean(AccountService.class);
        System.out.println("kek");
        System.out.println(accountService.getPersonalInfo());
        AccountInfo accountInfo = accountService.getAccountInfoById(2);
        System.out.println(accountService.getPersonalInfo());
        System.out.println(accountInfo);

        for (int i = 0; i < 5; i++) {
            IObject iObject = context.getBean(IObject.class);
            System.out.println("objectValue type: " + iObject.getClass());
            System.out.println("result info: " + iObject.getInfo());
        }

        Sing sing = context.getBean(Sing.class);
        Sing1 sing1 = context.getBean(Sing1.class);

        System.out.println(sing);
        System.out.println(sing1);

        System.out.println();
        System.out.println();

        Prot1 prot1 = context.getBean(Prot1.class);
        Prot1 prot11 = context.getBean(Prot1.class);
        System.out.println(prot1);
        System.out.println(prot11);

    }

}
