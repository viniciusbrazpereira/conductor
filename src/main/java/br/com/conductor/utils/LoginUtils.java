package br.com.conductor.utils;

import java.util.Objects;

public class LoginUtils {

    private static LoginUtils uniqueInstance;

    private LoginUtils() {

    }

    public static synchronized LoginUtils getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new LoginUtils();
        }

        return uniqueInstance;
    }

    public static boolean isValid(String password) {
        return uniqueInstance.isNineOrMoreCaracter(password)
                && uniqueInstance.isNineOrMoreCaracter(password)
                && !uniqueInstance.isContainsNumberCaracter(password)
                && !uniqueInstance.isContainsCaracterRepeated(password)
                && !uniqueInstance.isContainsSpecialCaracters(password);
    }

    public static boolean isNineOrMoreCaracter(String password){
        return Objects.nonNull(password) && password.replace(" ", "").matches(".{9,}");
    }

    public static boolean isContainsSpecialCaracters(String password){
        return password.matches("(?=.*[!@#$%^&*)(])");
    }

    public static boolean isContainsNumberCaracter(String password){
        return password.matches("\\D+");
    }

    public static boolean isContainsCaracterRepeated(String password) {
        boolean isValid = false;

        char result[] = password.toCharArray();
        for(int index=0; index < result.length; index++){
            String caracter = String.valueOf(result[index]);
            for(int indexInternal=0; indexInternal <= result.length -1; indexInternal++){
                if(index != indexInternal && String.valueOf(result[indexInternal]).equals(caracter)){
                    isValid = true;
                }
            }
        }

        return isValid;
    }

}
