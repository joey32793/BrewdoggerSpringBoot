package com.brewdogger.beer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BREWERIES")
public class Brewery {

    @Id
    @SequenceGenerator(name = "BREWERY_ID_GENERATOR", sequenceName = "BREWERY_SEQUENCE", allocationSize = 1, initialValue = 100)
    @GeneratedValue(generator = "BREWERY_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "brewery_name")
    private String breweryName;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "brewery", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("brewery")
    private List<Beer> beers;

    public Brewery () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }
}
