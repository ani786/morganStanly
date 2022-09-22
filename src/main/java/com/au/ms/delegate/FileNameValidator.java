package com.au.ms.delegate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.au.ms.delegate.FileNameValidatorConstants.DD_MM_YYYY;
import static com.au.ms.delegate.FileNameValidatorConstants.FILE_PARTS_NOT_4;
import static com.au.ms.delegate.FileNameValidatorConstants.INVALID_FILE_NAME_PART_1;
import static com.au.ms.delegate.FileNameValidatorConstants.INVALID_FILE_NAME_PART_2;
import static com.au.ms.delegate.FileNameValidatorConstants.INVALID_FILE_NAME_PART_3;
import static com.au.ms.delegate.FileNameValidatorConstants.INVALID_FILE_NAME_PART_4;
import static com.au.ms.delegate.FileNameValidatorConstants.TEST;

public class FileNameValidator {


    public boolean validateFileName(final String fileName) throws FileNameNotValidException, ParseException,ArrayIndexOutOfBoundsException {

        String[] fileNameTokens = fileName.split("_", 4);

        if (fileNameTokens.length == 4) {

            validatePrefix(fileNameTokens[0]);
            validatePortfolioCode(fileNameTokens[1]);
            validateDateFormat(fileNameTokens[2]);
            validate2DigitSequenceNumber(fileNameTokens[3]);
            return true;
        }
        throw new FileNameNotValidException(FILE_PARTS_NOT_4);
    }


    private void validatePrefix(final String inputFilePart1) throws FileNameNotValidException {
        if (TEST.equals(inputFilePart1)) {
            return;
        }
        throw new FileNameNotValidException(String.format(INVALID_FILE_NAME_PART_1, inputFilePart1));
    }

    private void validatePortfolioCode(final String inputFilePart2) throws FileNameNotValidException {
        List<String> validPortfolioCodes = List.of("A", "B", "C");

        if (validPortfolioCodes.contains(inputFilePart2)) {
            return;
        }
        throw new FileNameNotValidException(String.format(INVALID_FILE_NAME_PART_2, inputFilePart2));
    }

    private void validateDateFormat(final String inputFilePart3) throws FileNameNotValidException, ParseException {
        DateFormat validDateFormat = new SimpleDateFormat(DD_MM_YYYY);
        if (validDateFormat.parse(inputFilePart3) != null) {
            return;
        }
        throw new FileNameNotValidException(String.format(INVALID_FILE_NAME_PART_3, inputFilePart3));
    }


    private void validate2DigitSequenceNumber(final String inputFilePart4) throws FileNameNotValidException {
        if (inputFilePart4.matches("\\d{2}")) {
            return;
        }
        throw new FileNameNotValidException(String.format(INVALID_FILE_NAME_PART_4, inputFilePart4));
    }


}
