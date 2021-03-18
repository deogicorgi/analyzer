package com.deogicorgi.lotto.jpa.model.dto;

import com.deogicorgi.lotto.jpa.model.entity.WinningAmount;
import com.deogicorgi.lotto.jpa.model.entity.WinningNumber;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
public class LottoDto {

    private Long id;

    /**
     * 회차
     */
    @NotNull
    private Long round;

    /**
     * 추첨 일자
     */
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate drawDate;

    /**
     * 당첨금 정보
     */
    private Set<WinningAmount> winningAmounts;

    /**
     * 당첨 번호 정보
     */
    private Set<WinningNumber> winningNumbers;
}
