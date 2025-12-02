package com.example.demo.mapperTests;

import com.example.demo.dto.CountryDto;
import com.example.demo.entity.Country;
import com.example.demo.mapper.CountryMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CountryMapperTest {

    @Autowired
    private CountryMapper mapper;

    @Test
    void convertEntityTest() {
        Country country = new Country();
        country.setCode("KZ");
        country.setName("Kazakhstan");

        CountryDto dto = mapper.toDto(country);

        Assertions.assertNotNull(dto);

        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getCountryName());
        Assertions.assertNotNull(dto.getCountryCode());

        Assertions.assertEquals(country.getId(), dto.getId());
        Assertions.assertEquals(country.getName(), dto.getCountryName());
        Assertions.assertEquals(country.getCode(), dto.getCountryCode());
    }

    @Test
    void convertDtoTest() {
        CountryDto dto = new CountryDto();
        dto.setCountryName("Kazakhstan");
        dto.setCountryCode("KZ");

        Country country = mapper.toEntity(dto);

        Assertions.assertNotNull(country);

        Assertions.assertNotNull(country.getId());
        Assertions.assertEquals(country.getName(), dto.getCountryName());
        Assertions.assertEquals(country.getCode(), dto.getCountryCode());

        Assertions.assertEquals(country.getId(), dto.getId());
        Assertions.assertEquals(country.getName(), dto.getCountryName());
        Assertions.assertEquals(country.getCode(), dto.getCountryCode());
    }

    @Test
    void convertEntityListTest() {
        List<Country> countries = new ArrayList<>();

        Country c1 = new Country();
        c1.setCode("KZ");
        c1.setName("Kazakhstan");

        Country c2 = new Country();
        c2.setCode("RU");
        c2.setName("Russia");

        Country c3 = new Country();
        c3.setCode("GR");
        c3.setName("Germany");

        countries.add(c1);
        countries.add(c2);
        countries.add(c3);

        List<CountryDto> dtos = mapper.toDtoList(countries);

        Assertions.assertNotNull(dtos);

        Assertions.assertNotEquals(0, dtos.size());

        Assertions.assertEquals(countries.size(), dtos.size());

        for(int i=0;i<countries.size();i++) {
            Country country = countries.get(i);
            CountryDto dto = dtos.get(i);

            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getCountryName());
            Assertions.assertNotNull(dto.getCountryCode());

            Assertions.assertEquals(country.getId(), dto.getId());
            Assertions.assertEquals(country.getName(), dto.getCountryName());
            Assertions.assertEquals(country.getCode(), dto.getCountryCode());

        }
    }

}
