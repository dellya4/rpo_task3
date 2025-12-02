package com.example.demo.service;

import com.example.demo.dto.CountryDto;
import com.example.demo.entity.Country;
import com.example.demo.mapper.CountryMapper;
import com.example.demo.repository.countryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class countryServiceImpl implements countryService {

    private final countryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public List<CountryDto> getCountries() {
        List<Country> countries = countryRepository.findAll();
        return countryMapper.toDtoList(countries);
    }

    @Override
    public CountryDto addCountry(CountryDto dto) {
        Country c = countryMapper.toEntity(dto);
        Country saved = countryRepository.save(c);
        return countryMapper.toDto(saved);
    }

    @Override
    public CountryDto getCountry(Long id) {
        Country country = countryRepository.findById(id).orElse(null);
        if (country == null) {
            return null;
        }
        return countryMapper.toDto(country);
    }

    @Override
    public CountryDto updateCountry(Long id, CountryDto dto) {
        Country existing = countryRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }

        existing.setName(dto.getCountryName());
        existing.setCode(dto.getCountryCode());

        Country updated = countryRepository.save(existing);
        return countryMapper.toDto(updated);
    }

    @Override
    public boolean deleteCountry(Long id) {
        CountryDto dto = getCountry(id);

        if (dto == null) {
            return false;
        }

        countryRepository.deleteById(id);
        return true;
    }
}
