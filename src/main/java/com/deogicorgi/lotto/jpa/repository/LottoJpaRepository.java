package com.deogicorgi.lotto.jpa.repository;

import com.deogicorgi.lotto.jpa.entity.Lotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
    @Query("select a from Lotto a join fetch a.winningAmounts s join fetch a.winningNumbers where a.id = :id")
    Optional<Lotto> findById(Long id);

    // By Round
    @Query("select a from Lotto a join fetch a.winningAmounts s join fetch a.winningNumbers where a.round = :round")
    Optional<Lotto> findByRound(Integer round);

    // By Max round
    Optional<Lotto> findFirstByOrderByRoundAsc();


    // ==================================================
    // ============      Multiple Select     ============
    // ==================================================

    // By Round Asc
    @Query("select a from Lotto a join fetch a.winningAmounts s join fetch a.winningNumbers order by a.round asc")
    Set<Lotto> findAllByOrderByRoundAsc();
}
