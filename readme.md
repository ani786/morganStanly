This programme validates the file name only. 
Runs on jdk15.
Enter input file name in valid format[case Sensitive] with _ as separator, Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber> where portfoliocode is A or B or C
   
You can have an actual file on a path on your machine or just the name of the file has to be supplied on the commandline as;
   Microsoft Windows [Version 10.0.22000.978]
   (c) Microsoft Corporation. All rights reserved.

C:\Users\anigh\.m2\repository\com\au\morganStanly\1.0-SNAPSHOT>java -jar morganStanly-1.0-SNAPSHOT.jar
Sep 23, 2022 11:31:37 AM com.au.ms.delegate.Main main
INFO: Enter input file name in valid format[case Sensitive] with _ as separator and 4 parts, Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber> where portfoliocode is A or B or C
Test_C_22032084_46
Sep 23, 2022 11:32:35 AM com.au.ms.delegate.Main main
INFO: you have supplied the input File path Test_C_22032084_46 . And to Validate file name Test_C_22032084_46
Sep 23, 2022 11:32:35 AM com.au.ms.delegate.Main main
INFO: the input file name is valid :Test_C_22032084_46

C:\Users\anigh\.m2\repository\com\au\morganStanly\1.0-SNAPSHOT>java -jar morganStanly-1.0-SNAPSHOT.jar
Sep 23, 2022 11:32:57 AM com.au.ms.delegate.Main main
INFO: Enter input file name in valid format[case Sensitive] with _ as separator and 4 parts, Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber> where portfoliocode is A or B or C
Test_C_2203992084_35
Sep 23, 2022 11:33:27 AM com.au.ms.delegate.Main main
INFO: you have supplied the input File path Test_C_2203992084_35 . And to Validate file name Test_C_2203992084_35
Sep 23, 2022 11:33:27 AM com.au.ms.delegate.Main main
SEVERE: File Name is not in valid format
com.au.ms.delegate.FileNameNotValidException: invalid date format  2203992084, has to be <ddmmyyyy>û date format dd e.g 07, mm e.g 12, yyyy e.g 1987.
at com.au.ms.delegate.FileNameValidator.validateDateFormat(FileNameValidator.java:48)
at com.au.ms.delegate.FileNameValidator.validateFileName(FileNameValidator.java:16)



