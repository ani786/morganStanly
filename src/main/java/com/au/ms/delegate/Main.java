package com.au.ms.delegate;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {


    static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        String fileName;
        try {

            LOGGER.log(Level.INFO, "Enter input file name in valid format[case Sensitive] with _ as separator , Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber> portfoliocode is A or B or C");

            Scanner scr = new Scanner(System.in);
            String filePathStr = scr.nextLine();
            // create object of Path
            Path filePath = Paths.get(filePathStr);

            // call getFileName() and get FileName path object
            Path fileNamePath = filePath.getFileName();
            fileName = fileNamePath.toString();
            LOGGER.log(Level.INFO, "you have supplied the input path {0} and file {1} to Validate the file name", new String[]{filePathStr, fileName});


            FileNameValidator fileNameValidator = FileNameValidator.class.getDeclaredConstructor().newInstance();


            if (fileNameValidator.validateFileName(fileName)) {
                LOGGER.log(Level.INFO, "the input file name is valid :{0} ", fileName);
            }
        } catch (FileNameNotValidException | ParseException | ArrayIndexOutOfBoundsException fileNameNotValidException) {

            LOGGER.log(Level.SEVERE, "File Name is not in valid format ", fileNameNotValidException);


        }

    }


}

