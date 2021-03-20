package com.deogicorgi.lotto.controller;

import com.deogicorgi.lotto.jpa.model.dto.LottoDto;
import com.deogicorgi.lotto.jpa.model.entity.Lotto;
import com.deogicorgi.lotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/lotto")
@RequiredArgsConstructor
public class LottoController extends BaseController {

    private final LottoService lottoService;

    @PostMapping
    public Lotto save(@RequestBody @Valid LottoDto lottoDto, BindingResult result) {

        if (result.hasErrors()) {
            error(result, lottoDto);
        }
        return lottoService.save(lottoDto);
    }

    @GetMapping("/round/{round}")
    public Lotto findByRound(@PathVariable Long round) {
        return lottoService.findByRound(round);
    }

    @GetMapping("/{id}")
    public Lotto findById(@PathVariable Long id) {
        return lottoService.findById(id);
    }

    @GetMapping
    public Set<Lotto> findAll() {
        return lottoService.findAll();
    }
}
