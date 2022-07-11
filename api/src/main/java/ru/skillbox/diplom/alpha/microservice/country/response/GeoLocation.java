package ru.skillbox.diplom.alpha.microservice.country.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ru.skillbox.diplom.alpha.microservice.country.dto.CityDto;
import ru.skillbox.diplom.alpha.microservice.country.dto.CountryDto;

/**
 * GeoLocation
 *
 * @author Olga Samoylova
 */

@Data
public class GeoLocation {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    CountryDto countryDto = null;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    CityDto cityDto = null;
}
