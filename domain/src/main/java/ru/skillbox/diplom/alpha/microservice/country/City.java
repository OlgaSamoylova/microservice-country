package ru.skillbox.diplom.alpha.microservice.country;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * City
 *
 * @author Olga Samoylova
 */

@Getter
@Setter
@Table(name = "city", schema = "country")
@Accessors(chain = true)
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    //@Column(nullable = false)
    private Country country;
}
