package com.deogicorgi.lotto.jpa.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 당첨 번호 정보
 */
@Entity
@Data
@EqualsAndHashCode(of = "number")
public class WinningNumber {

    /**
     * PK
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lotto_id")
    private Long lottoId;

    /**
     * 순서
     */
    @Column(nullable = false, length = 1)
    private Integer sequence;

    /**
     * 당첨번호
     */
    @Column(nullable = false, length = 2)
    private Integer number;
}
