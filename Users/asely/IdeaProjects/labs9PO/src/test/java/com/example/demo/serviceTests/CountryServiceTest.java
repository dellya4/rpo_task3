package com.example.demo.serviceTests;

import com.example.demo.dto.CountryDto;
import com.example.demo.service.countryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class CountryServiceTest {

    @Autowired
    private countryService countryService;

    @Test
    void getCountriesTest() {
        List<CountryDto> dtos = countryService.getCountries();

        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());

        for (CountryDto dto : dtos) {
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getCountryName());
            Assertions.assertNotNull(dto.getCountryCode());
        }
    }

    @Test
    void getCountryByIdTest() {
        Random random = new Random();
        int randomIndex  = random.nextInt(countryService.getCountries().size());

        Long randomCountry = countryService.getCountries().get(randomIndex).getId();

        CountryDto dto = countryService.getCountry(randomCountry);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getCountryName());
        Assertions.assertNotNull(dto.getCountryCode());

        CountryDto errorCountry = countryService.getCountry(-1L);
        Assertions.assertNull(errorCountry);
    }

    @Test
    void addCountryTest() {
        CountryDto dto = new CountryDto();
        dto.setCountryName("Test Country");
        dto.setCountryCode("TC");

        CountryDto created = countryService.addCountry(dto);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertNotEquals(0L, created.getId());

        Assertions.assertEquals(created.getCountryName(), dto.getCountryName());
        Assertions.assertEquals(created.getCountryCode(), dto.getCountryCode());

        CountryDto check = countryService.getCountry(created.getId());

        Assertions.assertNotNull(check);
        Assertions.assertEquals(created.getId(), check.getId());
        Assertions.assertEquals(created.getCountryName(), check.getCountryName());
        Assertions.assertEquals(created.getCountryCode(), check.getCountryCode());
    }

    @Test
    void updateCountryTest() {
        Random random = new Random();
        int randomIndex = random.nextInt(countryService.getCountries().size());

        Long randomCountryId = countryService.getCountries().get(randomIndex).getId();

        CountryDto dto = new CountryDto();
        dto.setCountryName("Updated Name");
        dto.setCountryCode("UC");

        CountryDto updated = countryService.updateCountry(randomCountryId, dto);

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getId());
        Assertions.assertEquals(dto.getCountryName(), updated.getCountryName());
        Assertions.assertEquals(dto.getCountryCode(), updated.getCountryCode());

        CountryDto check = countryService.getCountry(randomCountryId);

        Assertions.assertNotNull(check);
        Assertions.assertEquals(updated.getId(), check.getId());
        Assertions.assertEquals(updated.getCountryName(), check.getCountryName());
        Assertions.assertEquals(updated.getCountryCode(), check.getCountryCode());

        CountryDto errorUpdate = countryService.updateCountry(-1L, dto);
        Assertions.assertNull(errorUpdate);
    }

    @Test
    void deleteCountryTest() {
        Random random = new Random();
        int randomIndex = random.nextInt(countryService.getCountries().size());

        Long id = countryService.getCountries().get(randomIndex).getId();

        boolean deleted = countryService.deleteCountry(id);
        Assertions.assertTrue(deleted);

        CountryDto check = countryService.getCountry(id);
        Assertions.assertNull(check);

        boolean errorDelete = countryService.deleteCountry(-1L);
        Assertions.assertFalse(errorDelete);
    }
}
