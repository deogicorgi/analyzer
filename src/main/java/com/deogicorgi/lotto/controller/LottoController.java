package com.deogicorgi.lotto.controller;

import com.deogicorgi.lotto.jpa.model.dto.LottoDto;
import com.deogicorgi.lotto.jpa.model.entity.Lotto;
import com.deogicorgi.lotto.service.LottoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/lotto")
@RequiredArgsConstructor
@Api(tags = "lotto")
public class LottoController extends BaseController {

    private final LottoService lottoService;

    @PostMapping
    @ApiOperation(value = "로또 정보 저장", notes = "로또 정보 저장")
    public Lotto save(@RequestBody @Valid LottoDto lottoDto, BindingResult result) {

        if (result.hasErrors()) {
            error(result, lottoDto);
        }
        return lottoService.save(lottoDto);
    }

    @PutMapping
    @ApiOperation(value = "로또 정보 수정", notes = "로또 정보 수정")
    public Lotto update(@RequestBody @Valid LottoDto lottoDto, BindingResult result) {
        if (result.hasErrors()) {
            error(result, lottoDto);
        }
        return lottoService.save(lottoDto);
    }

    @GetMapping("/round/{round}")
    @ApiOperation(value = "회차 기준 로또 한건 조회", notes = "로또 정보 조회")
    public Lotto findByRound(@PathVariable Integer round) {
        return lottoService.findByRound(round);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "아이디 기준 로또 한건 조회", notes = "로또 정보 조회")
    public Lotto findById(@PathVariable Long id) {
        return lottoService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "모든 로또 조회", notes = "로또 정보 조회")
    public Set<Lotto> findAll() {
        return lottoService.findAll();
    }

    @PostMapping("/upload")
    @ApiOperation(value = "로또 엑셀 파일 업로드", notes = "로또 정보 저장")
    public List<Lotto> upload(@RequestParam(name = "file", required = false) MultipartFile file) throws IOException {
        return lottoService.upload(file);
    }
}
