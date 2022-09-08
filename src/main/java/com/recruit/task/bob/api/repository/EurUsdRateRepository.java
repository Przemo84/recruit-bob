package com.recruit.task.bob.api.repository;

import com.recruit.task.bob.api.entity.EurUsdRate;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EurUsdRateRepository extends CrudRepository<EurUsdRate, Integer> {

    List<EurUsdRate> findAllByOrderByRateDateAsc();
}