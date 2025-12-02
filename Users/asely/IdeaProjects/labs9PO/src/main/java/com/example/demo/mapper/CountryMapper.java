package com.example.demo.mapper;

import com.example.demo.dto.CountryDto;
import com.example.demo.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mapping(source = "name", target = "countryName")
    @Mapping(source = "code", target = "countryCode")
    CountryDto toDto(Country country);

    @Mapping(source = "countryName", target = "name")
    @Mapping(source = "countryCode", target = "code")
    Country toEntity(CountryDto dto);

    List<CountryDto> toDtoList(List<Country> countries);

    List<Country> toEntityList(List<CountryDto> dtos);
}
