package com.deogicorgi.lotto.jpa.entity;

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

    @Column(name = "lotto_id")
    private Long lottoId;

    /**
     * 등수
     */
    @Column(nullable = false, length = 1)
    private Integer ranking;

    /**
     * 당첨자수
     */
    @Column(nullable = false, length = 10)
    private Integer winnerCount;

    /**
     * 당첨금액
     */
    @Column(nullable = false, length = 12)
    private Long amount;

}
