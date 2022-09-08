package com.recruit.task.bob.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EurUsdRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double rate;

    //    TODO zmienić String na Date
    private String rateDate;

    @CreationTimestamp
    private Date searchDate;
}
