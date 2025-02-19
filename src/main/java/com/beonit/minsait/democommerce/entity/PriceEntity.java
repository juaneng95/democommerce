package com.beonit.minsait.democommerce.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Price entity class.
 */
@Entity
@Table(name = "prices", schema = "democommerce_schema")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceEntity implements Serializable {

    /**
     * The serial version id.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Foreign key of the group string (1 = ZARA).
     */
    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    /**
     * Initial date on which the indicated rate is applied.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    /**
     * Final date on which the indicated rate is applied.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;

    /**
     * Applicable price rate identifier.
     */
    @Column(name = "price_list", nullable = false)
    private Integer priceList;

    /**
     * Product code identifier.
     */
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    /**
     * Price priority.
     */
    @Column(name = "priority", nullable = false)
    private Short priority;

    /**
     * Final sale price.
     */
    @Column(name = "price", nullable = false, scale = 2)
    private Float price;

    /**
     * ISO coin
     */
    @Column(name = "curr", nullable = false, length = 50)
    private String curr;
}
