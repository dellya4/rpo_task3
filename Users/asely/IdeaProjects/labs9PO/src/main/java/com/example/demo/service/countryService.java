package com.example.demo.service;

import com.example.demo.dto.CountryDto;

import java.util.List;

public interface countryService {
    List<CountryDto> getCountries();
    CountryDto addCountry(CountryDto dto);
    CountryDto getCountry(Long id);
    CountryDto updateCountry(Long id, CountryDto dto);
    boolean deleteCountry(Long id);
}
