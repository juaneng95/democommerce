package com.beonit.minsait.democommerce.mapper;

import com.beonit.minsait.democommerce.entity.PriceEntity;
import com.beonit.minsait.democommerce.model.PriceDto;
import com.beonit.minsait.democommerce.model.PriceQueryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface Price mapper.
 */
@Mapper(componentModel = "spring")
public interface PriceMapper {

    /**
     * Price entity to dto price dto.
     *
     * @param src - The source.
     * @return the price dto
     */
    @Mapping(target = "startDate", dateFormat = "yyyy-MM-dd' 'HH:mm:ss")
    @Mapping(target = "endDate", dateFormat = "yyyy-MM-dd' 'HH:mm:ss")
    PriceDto priceEntityToDto(PriceEntity src);

    /**
     * Price entity to query dto price query dto.
     *
     * @param src - The source.
     * @return the price query dto
     */
    @Mapping(target = "startDate", dateFormat = "yyyy-MM-dd' 'HH:mm:ss")
    @Mapping(target = "endDate", dateFormat = "yyyy-MM-dd' 'HH:mm:ss")
    PriceQueryDto priceEntityToQueryDto(PriceEntity src);
}
