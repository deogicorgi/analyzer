package com.deogicorgi.lotto.model.dto;

import lombok.Data;

@Data
public class WinningNumberDto {

    /**
     * PK
     */
    private Long id;

    /**
     * 순서
     */
    private Integer sequence;

    /**
     * 당첨번호
     */
    private Integer number;
}
