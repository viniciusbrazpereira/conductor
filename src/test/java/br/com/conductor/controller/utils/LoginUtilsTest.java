package br.com.conductor.controller.utils;

import br.com.conductor.utils.LoginUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LoginUtilsTest {

    private LoginUtils utils;

    @Before
    public void instances(){
        this.utils = LoginUtils.getInstance();
    }

    @Test
    public void testNullCaracters() {
        Assert.assertFalse(utils.isNineOrMoreCaracter(null));
    }

    @Test
    public void testNoMoreNineCaracters() {
        String password = "12345678";
        Assert.assertFalse(utils.isNineOrMoreCaracter(password));
    }

    @Test
    public void testNoContainsNumberCaracter() {
        String password = "ABCDEFGHI";
        Assert.assertFalse(utils.isContainsNumberCaracter(password));
    }

    @Test
    public void testContainsNumberCaracter() {
        String password = "AbTp9@fok";
        Assert.assertTrue(utils.isContainsNumberCaracter(password));

        password = "2AAAaA@Z1";
        Assert.assertTrue(utils.isContainsNumberCaracter(password));

        password = "AbTp1@fok";
        Assert.assertTrue(utils.isContainsNumberCaracter(password));

        password = "3AAAAA";
        Assert.assertTrue(utils.isContainsNumberCaracter(password));

        password = "4@#$#$";
        Assert.assertTrue(utils.isContainsNumberCaracter(password));

        password = "5";
        Assert.assertTrue(utils.isContainsNumberCaracter(password));

        password = "6";
        Assert.assertTrue(utils.isContainsNumberCaracter(password));

        password = "17";
        Assert.assertTrue(utils.isContainsNumberCaracter(password));

        password = "81";
        Assert.assertTrue(utils.isContainsNumberCaracter(password));
    }

    @Test
    public void testIsValidFalse() {

        String password = "";
        Assert.assertFalse(utils.isValid(password));

        password = "aa";
        Assert.assertFalse(utils.isValid(password));

        password = "ab";
        Assert.assertFalse(utils.isValid(password));

        password = "AAAbbbCc";
        Assert.assertFalse(utils.isValid(password));

        password = "AbTp9!foo";
        Assert.assertFalse(utils.isValid(password));

        password = "AbTp9!foA";
        Assert.assertFalse(utils.isValid(password));

        password = "AbTp9 fok";
        Assert.assertFalse(utils.isValid(password));
    }

    @Test
    public void testSpecialCaracter() {

        String password = "!";
        Assert.assertTrue(utils.isContainsSpecialCaracters(password));

        password = "@";
        Assert.assertTrue(utils.isContainsSpecialCaracters(password));

        password = "#";
        Assert.assertTrue(utils.isContainsSpecialCaracters(password));

        password = "$";
        Assert.assertTrue(utils.isContainsSpecialCaracters(password));

        password = "%";
        Assert.assertTrue(utils.isContainsSpecialCaracters(password));

        password = "^";
        Assert.assertTrue(utils.isContainsSpecialCaracters(password));

        password = "&";
        Assert.assertTrue(utils.isContainsSpecialCaracters(password));

        password = "*";
        Assert.assertTrue(utils.isContainsSpecialCaracters(password));

        password = "(";
        Assert.assertTrue(utils.isContainsSpecialCaracters(password));

        password = ")";
        Assert.assertTrue(utils.isContainsSpecialCaracters(password));

        password = "-";
        Assert.assertTrue(utils.isContainsSpecialCaracters(password));

        password = "+";
        Assert.assertTrue(utils.isContainsSpecialCaracters(password));
    }

    @Test
    public void testIsValidMoreNineCaracters() {
        String password = "123456789";
        Assert.assertTrue(utils.isNineOrMoreCaracter(password));
    }

    @Test
    public void testIsValidTrue() {
        String password = "AbTp9!fok";
        Assert.assertTrue(utils.isValid(password));
    }
}
