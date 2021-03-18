package com.deogicorgi.lotto.jpa.repository;

import com.deogicorgi.lotto.jpa.model.entity.Lotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LottoJpaRepository extends JpaRepository<Lotto, Long> {
    Optional<Lotto> findByRound(Long round);

    List<Lotto> findAllByOrderByRoundAsc();
}
