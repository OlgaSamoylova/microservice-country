package ru.skillbox.diplom.alpha.microservice.country.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ru.skillbox.diplom.alpha.microservice.country.dto.CountryDto;

import java.util.ArrayList;
import java.util.List;

/**
 * CommonResponseCountry
 *
 * @author Olga Samoylova
 */

@Data
public class CommonResponseCountry {

    private long timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CountryDto> data = new ArrayList<>();

}
