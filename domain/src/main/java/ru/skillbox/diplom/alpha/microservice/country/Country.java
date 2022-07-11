package ru.skillbox.diplom.alpha.microservice.country;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

/**
 * Country
 *
 * @author Olga Samoylova
 */

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "country", schema = "country")
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<City> cities;
}