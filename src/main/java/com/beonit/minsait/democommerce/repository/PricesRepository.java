package com.beonit.minsait.democommerce.repository;

import com.beonit.minsait.democommerce.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

/**
 * The interface Prices repository.
 */
@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Long> {

    /**
    * Selecting the price by criteria parameters with limit 1
    *
    * @param requiredDate the required date
    * @param productId    the product id
    * @param brandId      the brand id
    * @return the price entity
    */
    @Query(
            value =
                    "SELECT * FROM DEMOCOMMERCE_SCHEMA.PRICES "
                            + "WHERE PRODUCT_ID = :productId AND BRAND_ID = :brandId "
                            + "AND (START_DATE <= :requiredDate AND END_DATE >= :requiredDate) "
                            + "ORDER BY PRIORITY DESC LIMIT 1",
            nativeQuery = true)
    PriceEntity findPriceByDateAndProductIdAndBrandId(
            @Param("requiredDate") Timestamp requiredDate,
            @Param("productId") Integer productId,
            @Param("brandId") Long brandId);
}
