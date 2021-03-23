package com.deogicorgi.lotto.value;

import java.util.Arrays;
import java.util.Locale;

public enum ExcelExtension {
    XLSX("XLSX"),
    XLS("XLS");

    String extension;

    ExcelExtension(String extension) {
        this.extension = extension;
    }

    public static ExcelExtension getExtension(String extension) {
        return Arrays.stream(ExcelExtension.values())
                .filter(excelExtension -> excelExtension.name().equals(extension.toUpperCase()))
                .findAny()
                .orElse(null);
    }
}
