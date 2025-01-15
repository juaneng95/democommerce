package com.beonit.minsait.democommerce.web;

import com.beonit.minsait.democommerce.api.EcomApi;
import com.beonit.minsait.democommerce.exception.NotFoundPriceException;
import com.beonit.minsait.democommerce.model.PriceDto;
import com.beonit.minsait.democommerce.model.PriceQueryDto;
import com.beonit.minsait.democommerce.service.PriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * The type Ecom controller.
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class EcomController implements EcomApi {

    /**
     * The price service.
     */
    private final PriceService priceService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<PriceDto>> getAllPrices() {

        log.info("--> Running /ecom/list");

        List<PriceDto> priceDtoList = priceService.getAllPrices();
        return ResponseEntity.ok(priceDtoList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<PriceQueryDto> getPriceByCriteriaQuery(
            String requiredDate, Integer productId, Long brandId) throws NotFoundPriceException {

        log.info("--> Running /ecom/list/price?");

        PriceQueryDto priceQueryDto = priceService.getPriceByCriteriaQuery(
                Timestamp.valueOf(requiredDate), productId, brandId);
        return ResponseEntity.ok(priceQueryDto);
    }
}
