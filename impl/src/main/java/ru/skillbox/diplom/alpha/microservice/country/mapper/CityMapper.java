package ru.skillbox.diplom.alpha.microservice.country.mapper;

import org.mapstruct.Mapper;
import ru.skillbox.diplom.alpha.microservice.country.City;
import ru.skillbox.diplom.alpha.microservice.country.dto.CityDto;

import java.util.List;

/**
 * CityMapper
 *
 * @author Olga Samoylova
 */

@Mapper
public interface CityMapper {
    City CityDtoToCity(CityDto entity);
    CityDto CityToCityDTO(City entity);
    List<City> convertCityDtoListToCityList(List<CityDto> list);
    List<CityDto> convertCityListToCityDtoList(List<City> list);

}
