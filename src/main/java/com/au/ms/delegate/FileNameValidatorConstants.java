package com.au.ms.delegate;

public enum FileNameValidatorConstants {
 ;
 public static  final String TEST = "Test";
 public static  final String FILE_PARTS_NOT_4 = "File Parts not 4 ";
 public static  final String DD_MM_YYYY = "ddMMyyyy";
 public static  final String INVALID_FILE_NAME_PART_1 = "invalid file name first part  %s, has to be  Test – hardcoded string prefix ";
 public static  final String INVALID_FILE_NAME_PART_2 = "invalid file name second part  %s, has to be <portfoliocode> - can only be A,B,C ";
 public static  final String INVALID_FILE_NAME_PART_3 = "invalid file name third part  %s, has to be <ddmmyyyy>– is valuation date format dd e.g 07, mm e.g 12, yyyy e.g 1987. ";
 public static  final String INVALID_FILE_NAME_PART_4 = "invalid file name fourth part  %s, <2digit-sequencenumber> - is 2 digit sequence number ";
}
