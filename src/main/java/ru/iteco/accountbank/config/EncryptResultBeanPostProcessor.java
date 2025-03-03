package ru.iteco.accountbank.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;
import ru.iteco.accountbank.annotation.EncryptResult;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.lang.reflect.Method;
import java.util.Base64;
import java.util.Objects;

@Slf4j
@Component
public class EncryptResultBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("EncryptResul for bean: {}", beanName);
        for (Method method : bean.getClass().getMethods()) {
            if (method.isAnnotationPresent(EncryptResult.class)) {
                log.info("Been is need proxy");
                ProxyFactory proxyFactory = new ProxyFactory(bean);
                proxyFactory.addAdvice(new MethodInterceptor() {
                    @Override
                    public Object invoke(MethodInvocation invocation) throws Throwable {
                        log.info("Before call method in bean: {}", beanName);
                        log.info(invocation.getMethod().getName());
                        Object proceed = invocation.proceed();
                        for (Method declaredMethod : Objects.requireNonNull(invocation.getThis()).getClass().getDeclaredMethods()) {
                            log.info(declaredMethod.getName());
                            if (invocation.getMethod().getName().equals(declaredMethod.getName()) && AnnotationUtils.findAnnotation(declaredMethod, EncryptResult.class) != null) {
                                log.info("Call : {} result of witch need to be encrypted", invocation.getMethod().getName());
                                return EncryptResultBeanPostProcessor.this.encrypt(proceed);
                            }
                        }
                        return proceed;
                    }
                });
                return proxyFactory.getProxy();
            }
        }
        return bean;
    }

    @SneakyThrows
    private Object encrypt(Object proceed) {
        Cipher cipher = Cipher.getInstance("AES");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        cipher.init(Cipher.ENCRYPT_MODE, keyGenerator.generateKey());
        byte[] bytes = cipher.doFinal(Objects.requireNonNull(SerializationUtils.serialize(proceed)));
        return Base64.getEncoder().encodeToString(bytes);
    }

}
