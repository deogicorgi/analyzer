package com.deogicorgi.lotto.jpa.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 조합 히스토리
 */
@Entity
@Data
public class CombinationHistory {
    /**
     * PK
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 추첨회차
     */
    @Column(nullable = false)
    private Integer round;

    /**
     * 조합일자
     */
    @Column(nullable = false)
    private LocalDate combinationDate;
}
