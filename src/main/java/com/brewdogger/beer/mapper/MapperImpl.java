package com.brewdogger.beer.mapper;

import com.brewdogger.beer.entity.Beer;
import com.brewdogger.beer.entity.Brewery;
import com.brewdogger.beer.helper.EntityPropertyHelper;
import com.brewdogger.beer.model.BeerRequest;
import com.brewdogger.beer.model.BreweryRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements Mapper {

    private static final Logger logger = LoggerFactory.getLogger(MapperImpl.class);

    @Autowired
    private EntityPropertyHelper entityPropertyHelper;

    @Override
    public Beer mapBeerRequestToBeer(BeerRequest beerRequest) {

        var beer = new Beer();
        var beerRequestProperties = entityPropertyHelper.getFields(beerRequest);

        try {
            entityPropertyHelper.setFields(beer, beerRequestProperties);
        } catch (IllegalAccessException e) {
            logger.error("MapperImpl::map - Could not map fields for breweryRequest to brewery");
        }

        return beer;
    }

    @Override
    public Brewery mapBreweryRequestToBrewery(BreweryRequest breweryRequest) {

        var brewery = new Brewery();
        var breweryRequestProperties = entityPropertyHelper.getFields(breweryRequest);

        try {
            entityPropertyHelper.setFields(brewery, breweryRequestProperties);
        } catch (IllegalAccessException e) {
            logger.error("MapperImpl::map - Could not map fields for breweryRequest to brewery");
        }

        return brewery;
    }
}