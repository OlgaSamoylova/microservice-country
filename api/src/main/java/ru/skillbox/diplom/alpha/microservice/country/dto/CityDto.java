package ru.skillbox.diplom.alpha.microservice.country.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CityDto
 *
 * @author OlgaSamoylova
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;

    @JsonProperty(value = "country_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer countryId;
}
