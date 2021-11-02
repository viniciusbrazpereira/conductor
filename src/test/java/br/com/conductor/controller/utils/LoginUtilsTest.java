package br.com.conductor.controller.utils;

import br.com.conductor.utils.LoginUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

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
        Assert.assertTrue(utils.isContainsNumberCaracter(password));
    }

    @Test
    public void testContainsNumberCaracter() {
        String password = "AbTp9@fok";
        Assert.assertFalse(utils.isContainsNumberCaracter(password));

        password = "2AAAaA@Z1";
        Assert.assertFalse(utils.isContainsNumberCaracter(password));

        password = "AbTp1@fok";
        Assert.assertFalse(utils.isContainsNumberCaracter(password));

        password = "3AAAAA";
        Assert.assertFalse(utils.isContainsNumberCaracter(password));

        password = "4@#$#$";
        Assert.assertFalse(utils.isContainsNumberCaracter(password));

        password = "A5Z";
        Assert.assertFalse(utils.isContainsNumberCaracter(password));

        password = "6";
        Assert.assertFalse(utils.isContainsNumberCaracter(password));

        password = "17";
        Assert.assertFalse(utils.isContainsNumberCaracter(password));

        password = "GG81";
        Assert.assertFalse(utils.isContainsNumberCaracter(password));
    }

    @Test
    public void testSpecialCaracter() {

        String password = "!";
        Assert.assertFalse(utils.isContainsSpecialCaracters(password));

        password = "@";
        Assert.assertFalse(utils.isContainsSpecialCaracters(password));

        password = "#";
        Assert.assertFalse(utils.isContainsSpecialCaracters(password));

        password = "$";
        Assert.assertFalse(utils.isContainsSpecialCaracters(password));

        password = "%";
        Assert.assertFalse(utils.isContainsSpecialCaracters(password));

        password = "^";
        Assert.assertFalse(utils.isContainsSpecialCaracters(password));

        password = "&";
        Assert.assertFalse(utils.isContainsSpecialCaracters(password));

        password = "*";
        Assert.assertFalse(utils.isContainsSpecialCaracters(password));

        password = "(";
        Assert.assertFalse(utils.isContainsSpecialCaracters(password));

        password = ")";
        Assert.assertFalse(utils.isContainsSpecialCaracters(password));

        password = "-";
        Assert.assertFalse(utils.isContainsSpecialCaracters(password));

        password = "+";
        Assert.assertFalse(utils.isContainsSpecialCaracters(password));
    }

    @Test
    public void testIsValidMoreNineCaracters() {
        String password = "123456789";
        Assert.assertTrue(utils.isNineOrMoreCaracter(password));
    }

    @Test
    public void testCaracterRepeated() throws UnsupportedEncodingException {
        String password = "aa";
        Assert.assertTrue(utils.isContainsCaracterRepeated(password));

        password = "1b1";
        Assert.assertTrue(utils.isContainsCaracterRepeated(password));

        password = "abc";
        Assert.assertFalse(utils.isContainsCaracterRepeated(password));

        password = "bb";
        Assert.assertTrue(utils.isContainsCaracterRepeated(password));

        password = "AA";
        Assert.assertTrue(utils.isContainsCaracterRepeated(password));

        password = "AAbTp9fo";
        Assert.assertTrue(utils.isContainsCaracterRepeated(password));

        password = "AbTp9!fo9";
        Assert.assertTrue(utils.isContainsCaracterRepeated(password));

        password = "AbTp9 fok";
        Assert.assertFalse(utils.isContainsCaracterRepeated(password));

        password = "AbTp9!fok";
        Assert.assertFalse(utils.isContainsCaracterRepeated(password));
    }

    @Test
    public void testIsValidFalse() throws UnsupportedEncodingException {

        String password = " ";
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
    public void testIsValidTrue() {
        String password = "AbTp9!fok";
        Assert.assertTrue(utils.isValid(password));
    }
}
