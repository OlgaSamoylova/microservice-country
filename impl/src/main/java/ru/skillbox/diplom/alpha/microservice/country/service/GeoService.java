package ru.skillbox.diplom.alpha.microservice.country.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.skillbox.diplom.alpha.microservice.country.City;
import ru.skillbox.diplom.alpha.microservice.country.City_;
import ru.skillbox.diplom.alpha.microservice.country.Country;
import ru.skillbox.diplom.alpha.microservice.country.Country_;
import ru.skillbox.diplom.alpha.microservice.country.dto.CityDto;
import ru.skillbox.diplom.alpha.microservice.country.dto.CountryDto;
import ru.skillbox.diplom.alpha.microservice.country.mapper.CityMapper;
import ru.skillbox.diplom.alpha.microservice.country.mapper.CountryMapper;
import ru.skillbox.diplom.alpha.microservice.country.repository.CityRepository;
import ru.skillbox.diplom.alpha.microservice.country.repository.CountryRepository;
import ru.skillbox.diplom.alpha.microservice.country.response.CommonResponseCity;
import ru.skillbox.diplom.alpha.microservice.country.response.CommonResponseCountry;
import ru.skillbox.diplom.alpha.microservice.country.response.GeoLocation;
import ru.skillbox.diplom.alpha.microservice.country.response.GeoLocationList;

import java.time.Instant;
import java.util.List;

import static ru.skillbox.diplom.alpha.library.core.repository.NewSpecification.is;

/**
 * GeoService
 *
 * @author Olga Samoylova
 */

@Setter
@Getter
@Service
@Slf4j
@RequiredArgsConstructor
public class GeoService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);
    private final CityMapper cityMapper = Mappers.getMapper(CityMapper.class);

    @Cacheable("countries")
    public CommonResponseCountry getCountries() {
        log.info("Start get countries");
        CommonResponseCountry response = new CommonResponseCountry();
        List<Country> countries = countryRepository.findAll(getSpecification(new CountryDto()));
        response.setTimestamp(Instant.now().getEpochSecond());
        response.setData(countryMapper.convertCountryListToCountryDtoList(countries));
        log.info("finish get countries");
        return response;
    }

    @Cacheable("cities")
    public CommonResponseCity getCities(Integer countryId) {
        log.info("start get cities");
        CommonResponseCity response = new CommonResponseCity();
        CountryDto dto = new CountryDto();
        dto.setId(countryId);
        if (countryRepository.findAll(getSpecification(dto)).isEmpty()){
            throw new NullPointerException();
        }
        List<City> cities = countryRepository.findAll(getSpecification(dto)).get(0).getCities();
        response.setTimestamp(Instant.now().getEpochSecond());
        response.setData(cityMapper.convertCityListToCityDtoList(cities));
        log.info("finish get cities");
        return response;
    }

    @Cacheable("location")
    public GeoLocation getLocation(Integer countryId, Integer cityId){
        log.info("start get location");
        GeoLocation geoLocation = new GeoLocation();
        if (countryId == null){
            return geoLocation;
        }
        CountryDto dto = new CountryDto();
        dto.setId(countryId);
        geoLocation.setCountryDto(countryMapper.сountryToCountryDTO(countryRepository.findAll(getSpecification(dto)).get(0)));
        if (cityId != null){
            List<City> cities = countryRepository.findAll(getSpecification(dto)).get(0).getCities();
            for (City city: cities){
                if (city.getId() == cityId){
                    geoLocation.setCityDto(cityMapper.CityToCityDTO(city));
                    break;
                }
            }
        }
        log.info("finish get location");
        return geoLocation;
    }

    @Cacheable("locations")
    public GeoLocationList getLocationList(List<Integer> countryIds, List<Integer> cityIds){
        log.info("start get location list");

        GeoLocationList geoLocationList = new GeoLocationList();
        for (int i : countryIds){
            CountryDto countryDto = new CountryDto();
            countryDto.setId(i);
            geoLocationList.getCountryDtoList()
                    .add(countryMapper.сountryToCountryDTO(countryRepository.findAll(getSpecification(countryDto)).get(0)));
        }

        if (!cityIds.isEmpty()){
            for (int i : cityIds){
                CityDto cityDto = new CityDto();
                cityDto.setId(i);
                geoLocationList.getCityDtoList()
                        .add(cityMapper.CityToCityDTO(cityRepository.findAll(getSpecificationCity(cityDto)).get(0)));
            }
        }
        log.info("finish get location list");
        return geoLocationList;
    }

    private Specification<Country> getSpecification(CountryDto dto) {
        return is(Country_.id, dto.getId(), true);
    }

    private Specification<City> getSpecificationCity(CityDto dto) {
        return is(City_.id, dto.getId(), true);
    }



}
