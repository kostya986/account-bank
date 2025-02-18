package ru.iteco.accountbank.config;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.iteco.accountbank.annotation.InjectRandom;

import java.lang.reflect.Field;

@Slf4j
@Component
public class InjectRandomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, @NonNull String beanName) throws BeansException {
        log.info("beanName: {} + beanClass: {}", beanName, bean.getClass().getSimpleName());
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectRandom.class)) {
                field.setAccessible(true);
                InjectRandom annotation = field.getAnnotation(InjectRandom.class);
                int random = getRandom(annotation.min(), annotation.max());
                log.debug("Set random value in: {} value: {}", field.getName(), random);
                ReflectionUtils.setField(field, bean, random);
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        return bean;
    }

    private static int getRandom(int min, int max) {
        return min + (int) (Math.random() * (max - min) + 1);
    }

}
