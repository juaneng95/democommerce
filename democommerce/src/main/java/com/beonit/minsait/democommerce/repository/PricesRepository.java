package com.beonit.minsait.democommerce.repository;

import com.beonit.minsait.democommerce.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Long> {
}
