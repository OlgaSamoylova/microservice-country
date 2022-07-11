package ru.skillbox.diplom.alpha.microservice.country.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.skillbox.diplom.alpha.library.core.dto.AccountByIdDto;
import ru.skillbox.diplom.alpha.library.core.dto.AccountSearchDto;
import ru.skillbox.diplom.alpha.microservice.country.dto.CityDto;
import ru.skillbox.diplom.alpha.microservice.country.dto.CountryDto;
import ru.skillbox.diplom.alpha.microservice.country.response.GeoLocation;
import ru.skillbox.diplom.alpha.microservice.country.response.GeoLocationList;

import java.util.List;


/**
 * FeignCountryResource
 *
 * @author OlgaSamoylova
 */
@FeignClient(name = "microservice-country", path = "api/v1/geo/")
public interface FeignCountryResource {

    @GetMapping(value = "countries")
    List<CountryDto> getCountries();

    @GetMapping(value = "cities/{countryId}")
    List<CityDto> getCities(@PathVariable(value = "countryId", required = false) Integer countryId);

    @GetMapping(value = "location")
    GeoLocation getLocation(@RequestParam(value = "countryId", required = false) Integer countryId,
                            @RequestParam(value = "cityId", required = false) Integer cityId);

    @GetMapping(value = "locationList")
    GeoLocationList getLocationList(@RequestParam(value = "countryIds", required = false) List<Integer> countryIds,
                                    @RequestParam(value = "cityIds", required = false) List<Integer> cityIds);
}
