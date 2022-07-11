package ru.skillbox.diplom.alpha.microservice.country.resource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.skillbox.diplom.alpha.microservice.country.response.CommonResponseCity;
import ru.skillbox.diplom.alpha.microservice.country.response.CommonResponseCountry;
import ru.skillbox.diplom.alpha.microservice.country.response.GeoLocation;
import ru.skillbox.diplom.alpha.microservice.country.response.GeoLocationList;
import ru.skillbox.diplom.alpha.microservice.country.service.GeoService;

import java.util.List;

/**
 * GeoResourceImpl
 *
 * @author Olga Samoylova
 */

@Setter
@Getter
@RestController
@RequiredArgsConstructor
@EnableCaching
public class GeoResourceImpl implements LocationsController {

    private final GeoService geoService;

    @Override
    public ResponseEntity<CommonResponseCountry> getCountries() {
        return ResponseEntity.ok(geoService.getCountries());
    }

    @Override
    public ResponseEntity<CommonResponseCity> getCitiesById(Integer countryId) {
        return ResponseEntity.ok(geoService.getCities(countryId));
    }

    @Override
    public ResponseEntity<GeoLocation> getLocation(Integer countryId, Integer cityId) {
        return ResponseEntity.ok(geoService.getLocation(countryId, cityId));
    }

    @Override
    public ResponseEntity<GeoLocationList> getLocationList(List<Integer> countryIds, List<Integer> cityIds) {
        return ResponseEntity.ok(geoService.getLocationList(countryIds, cityIds));
    }


}
