package com.deogicorgi.lotto.jpa.service;

import com.deogicorgi.lotto.jpa.model.dto.LottoDto;
import com.deogicorgi.lotto.jpa.model.entity.Lotto;
import com.deogicorgi.lotto.jpa.repository.LottoJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Dedicated service classes for JPA processes.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class LottoJpaService extends JpaService {

    private final LottoJpaRepository lottoJpaRepository;

    // ==================================================
    // ================      Create      ================
    // ==================================================

    /**
     * Save lotto.
     *
     * @param lottoDto Lotto information for save.
     * @return Saved Lotto entity.
     */
    public Lotto save(LottoDto lottoDto) {
        Lotto lotto = getMapper().map(lottoDto, Lotto.class);
        return lottoJpaRepository.save(lotto);
    }

    /**
     * Save multiple lotto.
     *
     * @param lottoDtoSet Lotto information Set for save.
     * @return Saved Lotto entities.
     */
    public List<Lotto> saveAll(Set<LottoDto> lottoDtoSet) {
        List<Lotto> collect = lottoDtoSet.stream().map(lottoDto -> getMapper().map(lottoDto, Lotto.class)).sorted(Comparator.comparing(Lotto::getRound)).collect(Collectors.toList());
        return lottoJpaRepository.saveAll(collect);
    }

    // ==================================================
    // ================      Select      ================
    // ==================================================

    /**
     * Find by PK.
     *
     * @param id Pk
     * @return Lotto entity
     */
    public Lotto findById(Long id) {
        Optional<Lotto> lottoOptional = lottoJpaRepository.findById(id);

        if (lottoOptional.isPresent()) {
            return lottoOptional.get();
        } else {
            log.warn("[{}] Lotto entity does not exist. -> id : [{}] ", this.getClass().getSimpleName(), id);
            return null;
        }
    }

    /**
     * Find by Round.
     *
     * @param round Round number.
     * @return Lotto entity
     */
    public Lotto findByRound(Integer round) {
        Optional<Lotto> lottoOptional = lottoJpaRepository.findByRound(round);

        if (lottoOptional.isPresent()) {
            return lottoOptional.get();
        } else {
            log.warn("[{}] Lotto entity does not exist. -> round : [{}] ", this.getClass().getSimpleName(), round);
            return null;
        }
    }

    /**
     * Find by Max round.
     *
     * @return Lotto entity
     */
    public Lotto findFirstByRoundAsc() {
        Optional<Lotto> lottoOptional = lottoJpaRepository.findFirstByOrderByRoundAsc();
        return lottoOptional.orElse(null);
    }

    /**
     * Find all.
     *
     * @return Lotto entity list
     */
    public Set<Lotto> findAll() {
        return lottoJpaRepository.findAllByOrderByRoundAsc();
    }

    // ==================================================
    // ================      Update      ================
    // ==================================================
    // TODO: 2021/03/20 Update methods. 

    // ==================================================
    // ================      Delete      ================
    // ==================================================
    // TODO: 2021/03/20 Delete methods.
}
