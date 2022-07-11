package ru.skillbox.diplom.alpha.microservice.country.mapper;

import org.mapstruct.Mapper;
import ru.skillbox.diplom.alpha.microservice.country.Country;
import ru.skillbox.diplom.alpha.microservice.country.dto.CountryDto;

import java.util.List;

/**
 * CountryMapper
 *
 * @author Olga Samoylova
 */

@Mapper
public interface CountryMapper {
    Country сountryDtoToCountry(CountryDto entity);
    CountryDto сountryToCountryDTO(Country entity);
    List<Country> convertCountryDtoListToCountryList(List<CountryDto> list);
    List<CountryDto> convertCountryListToCountryDtoList(List<Country> list);
}
