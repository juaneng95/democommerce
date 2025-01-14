package com.beonit.minsait.democommerce.service;

import com.beonit.minsait.democommerce.exception.NotFoundPriceException;
import com.beonit.minsait.democommerce.model.PriceDto;
import com.beonit.minsait.democommerce.model.PriceQueryDto;

import java.sql.Timestamp;
import java.util.List;

/**
 * The interface Price service.
 */
public interface PriceService {

    /**
     * Gets all prices.
     *
     * @return the all prices
     */
    List<PriceDto> getAllPrices();

    /**
     * Gets price by criteria query.
     *
     * @param requiredDate the required date
     * @param productId    the product id
     * @param brandId      the brand id
     * @return the price by criteria query
     * @throws NotFoundPriceException the not found price exception
     */
    PriceQueryDto getPriceByCriteriaQuery(
            Timestamp requiredDate, Integer productId, Long brandId) throws NotFoundPriceException;
}
