package com.deogicorgi.lotto.service;

import com.deogicorgi.lotto.jpa.model.dto.LottoDto;
import com.deogicorgi.lotto.jpa.model.dto.WinningAmountDto;
import com.deogicorgi.lotto.jpa.model.dto.WinningNumberDto;
import com.deogicorgi.lotto.jpa.model.entity.Lotto;
import com.deogicorgi.lotto.jpa.service.LottoJpaService;
import com.deogicorgi.lotto.value.ExcelExtension;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
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

    public List<Lotto> upload(MultipartFile file) throws IOException {

        // Only if the file exists.
        if (!ObjectUtils.isEmpty(file)) {
            // Analyze extensions of uploaded files.
            ExcelExtension extension = ExcelExtension.getExtension(FilenameUtils.getExtension(file.getOriginalFilename()));

            // Only if the uploaded file type is Excel type..
            if (!ObjectUtils.isEmpty(extension) && (extension == ExcelExtension.XLSX || extension == ExcelExtension.XLS)) {

                Workbook workbook = extension == ExcelExtension.XLSX ?
                        new XSSFWorkbook(file.getInputStream()) : new HSSFWorkbook(file.getInputStream());

                Sheet worksheet = workbook.getSheetAt(0);
                int rowSize = worksheet.getPhysicalNumberOfRows();

                Set<LottoDto> lottoDtos = new HashSet<>();

//                Integer maxRound = lottoJpaService.findFirstByRoundAsc().getRound();

                for (int i = 0; i < rowSize; i++) {

                    LottoDto lottoDto = new LottoDto();

                    Row row = worksheet.getRow(i);

                    lottoDto.setRound((int) row.getCell(0).getNumericCellValue());
                    System.out.println(row.getCell(1).getStringCellValue());
                    lottoDto.setDrawDate(LocalDate.parse(row.getCell(1).getStringCellValue().replaceAll("\\.", "-"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

                    WinningAmountDto winningAmountDto = new WinningAmountDto();
                    winningAmountDto.setRanking(1);
                    winningAmountDto.setWinnerCount((int) row.getCell(2).getNumericCellValue());
                    winningAmountDto.setAmount(Long.valueOf(row.getCell(3).getStringCellValue().replaceAll("[^\\d.]", "")));
                    lottoDto.getWinningAmounts().add(winningAmountDto);

                    winningAmountDto = new WinningAmountDto();
                    winningAmountDto.setRanking(2);
                    winningAmountDto.setWinnerCount((int) row.getCell(4).getNumericCellValue());
                    winningAmountDto.setAmount(Long.valueOf(row.getCell(5).getStringCellValue().replaceAll("[^\\d.]", "")));
                    lottoDto.getWinningAmounts().add(winningAmountDto);

                    winningAmountDto = new WinningAmountDto();
                    winningAmountDto.setRanking(3);
                    winningAmountDto.setWinnerCount((int) row.getCell(6).getNumericCellValue());
                    winningAmountDto.setAmount(Long.valueOf(row.getCell(7).getStringCellValue().replaceAll("[^\\d.]", "")));
                    lottoDto.getWinningAmounts().add(winningAmountDto);

                    winningAmountDto = new WinningAmountDto();
                    winningAmountDto.setRanking(4);
                    winningAmountDto.setWinnerCount((int) row.getCell(8).getNumericCellValue());
                    winningAmountDto.setAmount(Long.valueOf(row.getCell(9).getStringCellValue().replaceAll("[^\\d.]", "")));
                    lottoDto.getWinningAmounts().add(winningAmountDto);

                    winningAmountDto = new WinningAmountDto();
                    winningAmountDto.setRanking(5);
                    winningAmountDto.setWinnerCount((int) row.getCell(10).getNumericCellValue());
                    winningAmountDto.setAmount(Long.valueOf(row.getCell(11).getStringCellValue().replaceAll("[^\\d.]", "")));
                    lottoDto.getWinningAmounts().add(winningAmountDto);

                    WinningNumberDto winningNumberDto = new WinningNumberDto();
                    winningNumberDto.setSequence(1);
                    winningNumberDto.setNumber((int) row.getCell(12).getNumericCellValue());
                    lottoDto.getWinningNumbers().add(winningNumberDto);

                    winningNumberDto = new WinningNumberDto();
                    winningNumberDto.setSequence(2);
                    winningNumberDto.setNumber((int) row.getCell(13).getNumericCellValue());
                    lottoDto.getWinningNumbers().add(winningNumberDto);

                    winningNumberDto = new WinningNumberDto();
                    winningNumberDto.setSequence(3);
                    winningNumberDto.setNumber((int) row.getCell(14).getNumericCellValue());
                    lottoDto.getWinningNumbers().add(winningNumberDto);

                    winningNumberDto = new WinningNumberDto();
                    winningNumberDto.setSequence(4);
                    winningNumberDto.setNumber((int) row.getCell(15).getNumericCellValue());
                    lottoDto.getWinningNumbers().add(winningNumberDto);

                    winningNumberDto = new WinningNumberDto();
                    winningNumberDto.setSequence(5);
                    winningNumberDto.setNumber((int) row.getCell(16).getNumericCellValue());
                    lottoDto.getWinningNumbers().add(winningNumberDto);

                    winningNumberDto = new WinningNumberDto();
                    winningNumberDto.setSequence(6);
                    winningNumberDto.setNumber((int) row.getCell(17).getNumericCellValue());
                    lottoDto.getWinningNumbers().add(winningNumberDto);

                    winningNumberDto = new WinningNumberDto();
                    winningNumberDto.setSequence(7);
                    winningNumberDto.setNumber((int) row.getCell(18).getNumericCellValue());
                    lottoDto.getWinningNumbers().add(winningNumberDto);

                    lottoDtos.add(lottoDto);
                }

                return lottoJpaService.saveAll(lottoDtos);

            } else {
                log.error("[{}] Invalid type of upload file. -> required : [xlsx, xls], provided : [{}]", this.getClass().getSimpleName(), FilenameUtils.getExtension(file.getOriginalFilename()));
                throw new IOException("Invalid type of upload file");
            }
        }
        return null;
    }

    public Lotto findByRound(@PathVariable Integer round) {
        return lottoJpaService.findByRound(round);
    }

    public Lotto findById(@PathVariable Long id) {
        return lottoJpaService.findById(id);
    }

    public Set<Lotto> findAll() {
        return lottoJpaService.findAll();
    }
}
