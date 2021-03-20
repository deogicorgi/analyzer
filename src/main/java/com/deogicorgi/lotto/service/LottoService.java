package com.deogicorgi.lotto.service;

import com.deogicorgi.lotto.jpa.model.dto.LottoDto;
import com.deogicorgi.lotto.jpa.model.entity.Lotto;
import com.deogicorgi.lotto.jpa.service.LottoJpaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * Lotto Business Process Service Class.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class LottoService {

    private final LottoJpaService lottoJpaService;

    @Transactional
    public Lotto save(LottoDto lottoDto) {
        return lottoJpaService.save(lottoDto);
    }

    public Lotto findByRound(@PathVariable Long round) {
        return lottoJpaService.findByRound(round);
    }

    public Lotto findById(@PathVariable Long id) {
        return lottoJpaService.findById(id);
    }

    public Set<Lotto> findAll() {
        return lottoJpaService.findAll();
    }
}
