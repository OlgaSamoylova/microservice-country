package ru.skillbox.diplom.alpha.microservice.country.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.skillbox.diplom.alpha.microservice.country.response.*;

import java.util.List;

/**
 * LocationsController
 *
 * @author Olga Samoylova
 */

@Tag(name = "countries", description = "Работа со странами и городами")
@RequestMapping("/api/v1/geo/")
public interface LocationsController {

    @Operation(summary = "Получение списка стран")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommonResponseCountry.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorRs.class)),
                    }),
            @ApiResponse(responseCode = "401", description = "unauthorized",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorRs.class)),
                    })
    })
    @GetMapping("countries")
    ResponseEntity<CommonResponseCountry> getCountries();


    @Operation(summary = "Получение списка городов по id страны")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommonResponseCity.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorRs.class)),
                    }),
            @ApiResponse(responseCode = "401", description = "unauthorized",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorRs.class)),
                    })
    })
    @GetMapping("cities/{countryId}")
    ResponseEntity<CommonResponseCity> getCitiesById(@PathVariable(value = "countryId") Integer countryId);

    @Operation(summary = "Получение страны и города")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommonResponseCity.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorRs.class)),
                    }),
            @ApiResponse(responseCode = "401", description = "unauthorized",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorRs.class)),
                    })
    })
    @GetMapping(value = "location")
    ResponseEntity<GeoLocation> getLocation(@RequestParam(value = "countryId", required = false) Integer countryId,
                            @RequestParam(value = "cityId", required = false) Integer cityId);

    @Operation(summary = "Получение списков стран и городов по спискам их id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CommonResponseCity.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorRs.class)),
                    }),
            @ApiResponse(responseCode = "401", description = "unauthorized",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorRs.class)),
                    })
    })
    @GetMapping(value = "locationList")
    ResponseEntity<GeoLocationList> getLocationList(@RequestParam(value = "countryIds", required = false) List<Integer> countryIds,
                                                    @RequestParam(value = "cityIds", required = false) List<Integer> cityIds);
}
