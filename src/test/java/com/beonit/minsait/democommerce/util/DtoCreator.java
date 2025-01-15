package com.beonit.minsait.democommerce.util;

import com.beonit.minsait.democommerce.model.PriceDto;
import com.beonit.minsait.democommerce.model.PriceQueryDto;
import lombok.experimental.UtilityClass;

/**
 * The type Dto creator.
 */
@UtilityClass
public class DtoCreator {

    /**
     * Build price dto.
     *
     * @return the price dto.
     */
    public static PriceDto buildPriceDto() {
        return PriceDto.builder()
                .id(1L)
                .brandId(1L)
                .startDate("2020-06-14 00:00:00")
                .endDate("2020-06-14 00:00:00")
                .priceList(1)
                .productId(1)
                .priority(1)
                .price(200F)
                .curr("EUR").build();
    }

    /**
     * Build price query dto.
     *
     * @return the price query dto.
     */
    public static PriceQueryDto buildPriceQueryDto() {
        return PriceQueryDto.builder()
                .brandId(1L)
                .startDate("2020-06-14 00:00:00")
                .endDate("2020-06-14 00:00:00")
                .priceList(1)
                .productId(1)
                .price(200F).build();
    }

}
