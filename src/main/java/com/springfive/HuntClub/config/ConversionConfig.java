package com.springfive.HuntClub.config;

import com.springfive.HuntClub.convertor.RoomEntityToReservationResponseConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import javax.persistence.Converter;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfig {
    private Set<Converter> getConverters(){
        Set<Converter> converters = new HashSet<Converter>();
        converters.add((Converter) new RoomEntityToReservationResponseConvertor());
        return converters;
    }

    @Bean
    public ConversionService conversionService(){
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();
        return bean.getObject();
    }
}
