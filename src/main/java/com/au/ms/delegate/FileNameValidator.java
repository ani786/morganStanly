package com.au.ms.delegate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import static com.au.ms.delegate.FileNameValidatorConstants.*;

public class FileNameValidator {


    public boolean validateFileName(final String fileName) throws FileNameNotValidException, ArrayIndexOutOfBoundsException {
        String[] fileNameTokens = fileName.split(UNDERSCORE, 4);
        if (fileNameTokens.length == 4) {
            List<Boolean> validations = List.of(validatePrefix(fileNameTokens[0]), validatePortfolioCode(fileNameTokens[1]), validateDateFormat(fileNameTokens[2]), validate2DigitSequenceNumber(fileNameTokens[3]));
            if (validations.stream().allMatch(validations.get(0)::equals)) {
                return true;
            }
        }
        throw new FileNameNotValidException(String.format(INVALID_FILE_FORMAT, fileName));
    }


    private boolean validatePrefix(final String prefix) throws FileNameNotValidException {
        if (TEST.equals(prefix)) {
            return true;
        }
        throw new FileNameNotValidException(String.format(INVALID_FILE_NAME_PREFIX, prefix));
    }

    private boolean validatePortfolioCode(final String portfolioCode) throws FileNameNotValidException {
        List<String> validPortfolioCodes = List.of("A", "B", "C");

        if (validPortfolioCodes.contains(portfolioCode)) {
            return true;
        }
        throw new FileNameNotValidException(String.format(INVALID_FILE_NAME_PORTFOLIO_CODE, portfolioCode));
    }

    private boolean validateDateFormat(final String date) throws FileNameNotValidException {
        try {
            if (LocalDate.parse(date, DateTimeFormatter.ofPattern(DD_MM_YYYY)) != null) {
                return true;
            }
        } catch (DateTimeParseException dateTimeParseException) {

            throw new FileNameNotValidException(String.format(INVALID_FILE_NAME_DATE_FORMAT, date));
        }
        return false;
    }


    private boolean validate2DigitSequenceNumber(String twoDigitSequenceNumber) throws FileNameNotValidException {
        twoDigitSequenceNumber= twoDigitSequenceNumber.contains(".")? Arrays.asList(twoDigitSequenceNumber.split("\\.")).get(0):twoDigitSequenceNumber;
        if (twoDigitSequenceNumber.matches("\\d{2}")) {
            return true;
        }
        throw new FileNameNotValidException(String.format(INVALID_FILE_NAME_2_DIGIT_SEQ, twoDigitSequenceNumber));
    }


}
