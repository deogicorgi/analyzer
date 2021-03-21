package com.deogicorgi.lotto.jpa.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * 로또 기본 정보
 */
@Entity
@Data
public class Lotto {

    /**
     * PK
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 회차
     */
    @Column(nullable = false)
    private Integer round;

    /**
     * 추첨 일자
     */
    @Column(nullable = false)
    private LocalDate drawDate;

    /**
     * 당첨금 정보
     */
    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("ranking asc ")
    private Set<WinningAmount> winningAmounts;

    /**
     * 당첨 번호 정보
     */
    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("sequence asc ")
    private Set<WinningNumber> winningNumbers;

}
