package ru.skillbox.diplom.alpha.microservice.country.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ru.skillbox.diplom.alpha.microservice.country.dto.CityDto;
import ru.skillbox.diplom.alpha.microservice.country.dto.CountryDto;

import java.util.ArrayList;
import java.util.List;

/**
 * CommonResponseCity
 *
 * @author Olga Samoylova
 */

@Data
public class CommonResponseCity {
    private long timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CityDto> data = new ArrayList<>();
}
