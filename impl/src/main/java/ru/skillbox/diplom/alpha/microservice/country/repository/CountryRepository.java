package ru.skillbox.diplom.alpha.microservice.country.repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.skillbox.diplom.alpha.microservice.country.Country;

/**
 * CountryRepository
 *
 * * @author Olga Samoylova
 */

@Repository
public interface CountryRepository extends JpaSpecificationExecutor<Country>,
        PagingAndSortingRepository<Country, Integer> {
}
