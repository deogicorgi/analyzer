package com.deogicorgi.lotto.jpa.service;

import com.deogicorgi.lotto.jpa.model.dto.LottoDto;
import com.deogicorgi.lotto.jpa.model.entity.Lotto;
import com.deogicorgi.lotto.jpa.repository.LottoJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LottoJpaService extends JpaService {

    private final LottoJpaRepository lottoJpaRepository;

    public Lotto findById(Long id) {
        Optional<Lotto> lottoOptional = lottoJpaRepository.findById(id);

        if (lottoOptional.isPresent()) {
            return lottoOptional.get();
        } else {
            log.warn("[{}] Lotto entity does not exist. -> id : [{}] ", this.getClass().getSimpleName(), id);
            return null;
        }
    }

    public Lotto findByRound(Long round) {
        Optional<Lotto> lottoOptional = lottoJpaRepository.findByRound(round);

        if (lottoOptional.isPresent()) {
            return lottoOptional.get();
        } else {
            log.warn("[{}] Lotto entity does not exist. -> round : [{}] ", this.getClass().getSimpleName(), round);
            return null;
        }
    }

    public List<Lotto> findAll() {
        return lottoJpaRepository.findAllByOrderByRoundAsc();
    }

    public Lotto save(LottoDto lottoDto) {
        Lotto lotto = getMapper().map(lottoDto, Lotto.class);
        return lottoJpaRepository.save(lotto);
    }
}
