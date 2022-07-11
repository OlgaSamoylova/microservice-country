package ru.skillbox.diplom.alpha.microservice.country.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * CountryDto
 *
 * @author OlgaSamoylova
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;

    private List<CityDto> cities;

}
