package ru.skillbox.diplom.alpha.microservice.country.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ru.skillbox.diplom.alpha.microservice.country.dto.CityDto;
import ru.skillbox.diplom.alpha.microservice.country.dto.CountryDto;

import java.util.ArrayList;
import java.util.List;

/**
 * GeoLocationList
 *
 * @author Olga Samoylova
 */

@Data
public class GeoLocationList {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<CountryDto> countryDtoList = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<CityDto> cityDtoList = new ArrayList<>();
}


