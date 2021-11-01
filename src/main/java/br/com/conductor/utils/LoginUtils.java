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

    public static boolean isValid(String password){
        return uniqueInstance.isNineOrMoreCaracter(password)
                && password.matches("(?=.*[}{!@#$%^&*()-+\\-_\\/*\\-+.\\|])");
    }

    public static boolean isNineOrMoreCaracter(String password){
        return Objects.nonNull(password) && password.matches(".{9,}");
    }

    public static boolean isContainsSpecialCaracters(String password){
        return password.matches("(?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])");
    }

    public static boolean isContainsNumberCaracter(String password){
        return false;
    }

}
