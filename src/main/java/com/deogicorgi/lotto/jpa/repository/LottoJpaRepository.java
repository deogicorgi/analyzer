package com.deogicorgi.lotto.jpa.repository;

import com.deogicorgi.lotto.jpa.model.entity.Lotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

/**
 * Lotto JPA Repository.
 */
public interface LottoJpaRepository extends JpaRepository<Lotto, Long> {

    // ==================================================
    // =============      Single Select     =============
    // ==================================================

    // By Round
    Optional<Lotto> findByRound(Long round);

    // By Max round
    Optional<Lotto> findFirstByOrderByRoundAsc();


    // ==================================================
    // ============      Multiple Select     ============
    // ==================================================

    // By Round Asc
    Set<Lotto> findAllByOrderByRoundAsc();
}
