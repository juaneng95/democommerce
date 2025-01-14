package com.beonit.minsait.democommerce.service.impl;

import com.beonit.minsait.democommerce.entity.PriceEntity;
import com.beonit.minsait.democommerce.exception.NotFoundPriceException;
import com.beonit.minsait.democommerce.mapper.PriceMapper;
import com.beonit.minsait.democommerce.model.PriceDto;
import com.beonit.minsait.democommerce.model.PriceQueryDto;
import com.beonit.minsait.democommerce.repository.PricesRepository;
import com.beonit.minsait.democommerce.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {
    private final PricesRepository pricesRepository;
    private final PriceMapper priceMapper;

    public PriceServiceImpl(PricesRepository pricesRepository, PriceMapper priceMapper){
      this.pricesRepository = pricesRepository;
      this.priceMapper = priceMapper;
    }

    @Override
    public List<PriceDto> getAllPrices() {

        log.info("Running query: findAll()");
        return pricesRepository.findAll().stream().map(priceMapper::priceEntityToDto).toList();
    }

    @Override
    public PriceQueryDto getPriceByCriteriaQuery(
            Timestamp requiredDate, Integer productId, Long brandId) throws NotFoundPriceException {

        log.info("Running query: findPriceByDateAndProductIdAndBrandId()");
        PriceEntity priceEntity =
                pricesRepository.findPriceByDateAndProductIdAndBrandId(requiredDate, productId, brandId);

        // If priceEntity is null
        if (Objects.isNull(priceEntity)) {
            throw new NotFoundPriceException(
                    "PRICE NOT FOUND - Without results. The price doesn't exist in H2 Database.");
        }

        return priceMapper.priceEntityToQueryDto(priceEntity);
    }
}
