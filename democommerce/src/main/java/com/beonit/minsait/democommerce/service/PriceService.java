package com.beonit.minsait.democommerce.service;

import com.beonit.minsait.democommerce.exception.NotFoundPriceException;
import com.beonit.minsait.democommerce.model.PriceDto;
import com.beonit.minsait.democommerce.model.PriceQueryDto;

import java.sql.Timestamp;
import java.util.List;

public interface PriceService {

    List<PriceDto> getAllPrices();

    PriceQueryDto getPriceByCriteriaQuery(
            Timestamp requiredDate, Integer productId, Long brandId) throws NotFoundPriceException;
}
