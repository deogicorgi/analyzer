package com.deogicorgi.lotto.jpa.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 당첨 번호 정보
 */
@Entity
@Data
public class WinningNumber {

    /**
     * PK
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 순서
     */
    @Column(nullable = false)
    private Integer sequence;

    /**
     * 당첨번호
     */
    @Column(nullable = false)
    private Integer number;
}
