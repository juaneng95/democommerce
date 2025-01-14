package com.beonit.minsait.democommerce.mapper;

import com.beonit.minsait.democommerce.entity.PriceEntity;
import com.beonit.minsait.democommerce.model.PriceDto;
import com.beonit.minsait.democommerce.model.PriceQueryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    // Fixing timestamp mapping error
    @Mapping(target = "startDate", dateFormat = "yyyy-MM-dd' 'HH:mm:ss")
    @Mapping(target = "endDate", dateFormat = "yyyy-MM-dd' 'HH:mm:ss")
    PriceDto priceEntityToDto(PriceEntity src);

    // Fixing timestamp mapping error
    @Mapping(target = "startDate", dateFormat = "yyyy-MM-dd' 'HH:mm:ss")
    @Mapping(target = "endDate", dateFormat = "yyyy-MM-dd' 'HH:mm:ss")
    PriceQueryDto priceEntityToQueryDto(PriceEntity src);
}
