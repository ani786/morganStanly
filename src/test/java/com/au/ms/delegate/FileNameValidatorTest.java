package com.au.ms.delegate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.jupiter.api.Assertions.assertThrows;


@RunWith(PowerMockRunner.class)
@PrepareForTest
public class FileNameValidatorTest {

    @Test
    public void testValidateFileName_PASS() throws Exception {
        FileNameValidator fileNameValidator = new FileNameValidator();
        boolean returnedTypeActual = fileNameValidator.validateFileName("Test_A_19092082_44");
        Assert.assertSame(true, returnedTypeActual);
    }

    @Test
    public void testValidateFileName_FAIL() {
        FileNameValidator fileNameValidator = new FileNameValidator();
        String invalidFileName = "Test_D_19092082";
        FileNameNotValidException thrown = assertThrows(
                FileNameNotValidException.class,
                () -> fileNameValidator.validateFileName(invalidFileName),
                "Error message"
        );
        Assert.assertTrue(thrown.getMessage().contains("invalid file format"));
    }


    @Test
    public void test_validatePrefix_PASS() throws Exception {
        FileNameValidator fileNameValidator = new FileNameValidator();
        String prefix = "Test";
        boolean returnedTypeActual = Whitebox.invokeMethod(fileNameValidator, "validatePrefix", prefix);
        Assert.assertSame(true, returnedTypeActual);
    }

    @Test
    public void test_validatePrefix_FAIL() {
        FileNameValidator fileNameValidator = new FileNameValidator();
        String invalidPrefix = "notTest";
        FileNameNotValidException thrown = assertThrows(
                FileNameNotValidException.class,
                () -> Whitebox.invokeMethod(fileNameValidator, "validatePrefix", invalidPrefix),
                "Error message"
        );
        Assert.assertTrue(thrown.getMessage().contains("invalid prefix"));
    }


    @Test
    public void test_validatePortfolioCode_PASS() throws Exception {
        FileNameValidator fileNameValidator = new FileNameValidator();
        String portfolioCode = "A";
        boolean returnedTypeActual = Whitebox.invokeMethod(fileNameValidator, "validatePortfolioCode", portfolioCode);
        Assert.assertSame(true, returnedTypeActual);
    }

    @Test
    public void test_validatePortfolioCode_FAIL() {
        FileNameValidator fileNameValidator = new FileNameValidator();
        String inValidPortfolioCode = "X";
        FileNameNotValidException thrown = assertThrows(
                FileNameNotValidException.class,
                () -> Whitebox.invokeMethod(fileNameValidator, "validatePortfolioCode", inValidPortfolioCode),
                "Error message"
        );
        Assert.assertTrue(thrown.getMessage().contains("invalid portfolio code"));
    }


    @Test
    public void test_validateDateFormat_PASS() throws Exception {
        FileNameValidator fileNameValidator = new FileNameValidator();
        String validDateFormat = "13092082";
        boolean returnedTypeActual = Whitebox.invokeMethod(fileNameValidator, "validateDateFormat", validDateFormat);
        Assert.assertSame(true, returnedTypeActual);
    }

    @Test
    public void test_validateDateFormat_FAIL() {
        FileNameValidator fileNameValidator = new FileNameValidator();
        String inValidDateFormat = "13992082";
        FileNameNotValidException thrown = assertThrows(
                FileNameNotValidException.class,
                () -> Whitebox.invokeMethod(fileNameValidator, "validateDateFormat", inValidDateFormat),
                "Error message"
        );
        Assert.assertTrue(thrown.getMessage().contains("invalid date format"));
    }


    @Test
    public void test_validate2DigitSequenceNumber_PASS() throws Exception {
        FileNameValidator fileNameValidator = new FileNameValidator();
        String valid2DigitSequenceNumber = "22";
        boolean returnedTypeActual = Whitebox.invokeMethod(fileNameValidator, "validate2DigitSequenceNumber", valid2DigitSequenceNumber);
        Assert.assertSame(true, returnedTypeActual);
    }

    @Test
    public void test_validate2DigitSequenceNumber_FAIL() {
        FileNameValidator fileNameValidator = new FileNameValidator();
        String inValid2DigitSequenceNumber = "pp";
        FileNameNotValidException thrown = assertThrows(
                FileNameNotValidException.class,
                () -> Whitebox.invokeMethod(fileNameValidator, "validate2DigitSequenceNumber", inValid2DigitSequenceNumber),
                "Error message"
        );
        Assert.assertTrue(thrown.getMessage().contains("invalid 2 digit Sequence"));
    }

}
