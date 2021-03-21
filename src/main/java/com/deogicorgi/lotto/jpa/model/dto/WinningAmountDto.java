package com.deogicorgi.lotto.jpa.model.dto;

import lombok.Data;

@Data
public class WinningAmountDto {
    /**
     * PK
     */
    private Long id;

    /**
     * 등수
     */
    private Integer ranking;

    /**
     * 당첨자수
     */
    private Integer winnerCount;

    /**
     * 당첨금액
     */
    private Long amount;
}
