package com.deogicorgi.lotto.jpa.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 당첨금 정보 클래스
 */
@Entity
@Data
public class WinningAmount {

    /**
     * PK
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 등수
     */
    @Column(nullable = false)
    private Integer ranking;

    /**
     * 당첨자수
     */
    @Column(nullable = false)
    private Integer winnerCount;

    /**
     * 당첨금액
     */
    @Column(nullable = false)
    private Long amount;

}
