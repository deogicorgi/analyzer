package com.deogicorgi.lotto.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class LottoDto {

    private Long id;

    /**
     * 회차
     */
    @NotNull
    private Integer round;

    /**
     * 추첨 일자
     */
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate drawDate;

    /**
     * 당첨금 정보
     */
    private Set<WinningAmountDto> winningAmounts = new HashSet<>();

    /**
     * 당첨 번호 정보
     */
    private Set<WinningNumberDto> winningNumbers = new HashSet<>();
}
