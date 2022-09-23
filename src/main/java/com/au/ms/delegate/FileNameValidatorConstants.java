package com.au.ms.delegate;

public enum FileNameValidatorConstants {
 ;
 public static  final String TEST = "Test";
 public static  final String UNDERSCORE = "_";
 public static  final String INVALID_FILE_FORMAT = "invalid file format %s, has to be Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>";
 public static  final String DD_MM_YYYY = "ddMMyyyy";
 public static  final String INVALID_FILE_NAME_PREFIX = "invalid prefix  %s, has to be Test ";
 public static  final String INVALID_FILE_NAME_PORTFOLIO_CODE = "invalid portfolio code  %s, <portfolioCode> has to be A or B or C ";
 public static  final String INVALID_FILE_NAME_DATE_FORMAT = "invalid date format  %s, has to be <ddmmyyyy>– date format dd e.g 07, mm e.g 12, yyyy e.g 1987. ";
 public static  final String INVALID_FILE_NAME_2_DIGIT_SEQ = "invalid 2 digit Sequence  %s, has to be <2digit-sequencenumber> - is 2 digit sequence number ";
}
