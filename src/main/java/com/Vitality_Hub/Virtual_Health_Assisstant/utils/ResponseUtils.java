package com.Vitality_Hub.Virtual_Health_Assisstant.utils;

public class ResponseUtils {
    public static final String USER_EXISTS_CODE="001";
    public static final String USER_EXISTS_MESSAGE="User already exist";
    public static final String USER_CREATED_CODE="002";
    public static final String USER_CREATED_MESSAGE="Successfully Created";
    public static final String USER_DOES_NOT_EXISTS_CODE="003";
    public static final String USER_DOES_NOT_MESSAGE="User does not exists";
    public static final String SUCCESSFUL_LOGIN_RESPONSE_CODE="004";
    public static final String SUCCESSFULLY_RESET_PASSWORD_CODE="005";
    public static final String  SUCCESSFULLY_RESET_PASSWORD_MESSAGE="password rest successfully ";
    public static final String SUCCESSFUL_LOGIN_MESSAGE = "Successfully Login";
    public static final String SUCCESS_MESSAGE = "Successful";
    public static final String SUCCESS_MESSAGE_CODE = "006";
    public static final String USER_NOT_FOUND_MESSAGE = "User Not Found";
    public static final String USER_NOT_FOUND_CODE = "007";
    public static final String UNSUCCESSFUL_LOGIN_RESPONSE_CODE = "008";
    public static final String EMAIL_DOES_NOT_EXIST_MESSAGE = "User does not exist";
    public static final String UNSUCCESSFUL_LOGIN_STATUS = "False";
    public static final String USERNAME_OR_PASSWORD_INCORRECT_MESSAGE = "Username or Password Incorrect";


    public static double calculateIdealWeight(double height, double weight, String gender){

        double heightInInches = height * 39.37;
        double idealWeight;
        if (gender.equalsIgnoreCase("male")){
            double baseWeight = 52;
            double inchesOver5Feet = heightInInches - 60;
            idealWeight = baseWeight + 1.81 * inchesOver5Feet;
            return idealWeight;

        } else if (gender.equalsIgnoreCase("female")) {
            double baseWeight = 49;
            double inchesOver5Feet = heightInInches - 60;
            idealWeight = baseWeight + 1.51 * inchesOver5Feet;
            return idealWeight;
        }else {
            throw new IllegalArgumentException("Invalid gender! Please specify 'male' or 'female'  ");
        }
    }

    public static double calculateAdjustedWeight(double idealWeight, double weight){
        double adjustedWeight;
        adjustedWeight = idealWeight + 0.4*(weight - idealWeight);
        return adjustedWeight;
    }
//
//    public static void main(String[] args) {
//        double weight = 66;
//        double height = 1.7;
//        String gender = "female";
//        double idealWeight= calculateIdealWeight(height, weight,gender);
//        System.out.println(idealWeight);
//
////        System.out.println(calculateIdealWeight(1.72,66,gender));
//
//        System.out.println(calculateAdjustedWeight( idealWeight,66));
//
//    }

}
