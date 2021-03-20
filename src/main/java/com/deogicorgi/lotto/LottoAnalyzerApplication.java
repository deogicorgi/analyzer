package com.deogicorgi.lotto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.deogicorgi.lotto")
public class LottoAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LottoAnalyzerApplication.class, args);
    }

}
