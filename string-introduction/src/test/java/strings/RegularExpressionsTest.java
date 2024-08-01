package strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static strings.Strings.*;
import org.junit.jupiter.api.Test;

public class RegularExpressionsTest {
    @Test
    void javaVariableTest() {
            assertTrue("varname".matches(javaVariable()));
        assertTrue("varName".matches(javaVariable()));
        assertTrue("varnamEvvijvji".matches(javaVariable()));
        assertTrue("varNAme".matches(javaVariable()));
        assertTrue("floattt".matches(javaVariable()));
        assertTrue("int12".matches(javaVariable()));
        assertFalse("varNAme ".matches(javaVariable()));
        assertTrue("String_".matches(javaVariable()));
        assertTrue("___".matches(javaVariable()));
        assertTrue("___123".matches(javaVariable()));
        assertTrue("$$$$".matches(javaVariable()));
        assertFalse("{___}".matches(javaVariable()));
        assertFalse("varname[_".matches(javaVariable()));
        assertFalse("|".matches(javaVariable()));
        assertFalse("1".matches(javaVariable()));
        assertFalse("1Q".matches(javaVariable()));
        assertTrue("Z".matches(javaVariable()));
        assertFalse("".matches(javaVariable()));
        assertFalse("__||".matches(javaVariable()));
        assertFalse("_".matches(javaVariable()));
        assertTrue("$varname".matches(javaVariable()));
        assertTrue("_varname".matches(javaVariable()));
        assertTrue("$$$__varname".matches(javaVariable()));
        assertTrue("var_Name".matches(javaVariable()));
        assertTrue("var_n_ame".matches(javaVariable()));
        assertTrue("varname_$".matches(javaVariable()));
        assertTrue("A1".matches(javaVariable()));
        assertTrue("_$$$$A1".matches(javaVariable()));
    }
    @Test
    void number0_300TrueTest(){
        String regex = Strings.number0_300();
        assertTrue("0".matches(regex));
        assertTrue("300".matches(regex));
        assertTrue("250".matches(regex));
        assertTrue("25".matches(regex));
        assertTrue("12".matches(regex));
        assertTrue("299".matches(regex));
        assertTrue("1".matches(regex));

    }
    @Test
    void number0_300FalseTest(){
        String regex = Strings.number0_300();
        assertFalse("00".matches(regex));
        assertFalse("301".matches(regex));
        assertFalse("01".matches(regex));
        assertFalse("00".matches(regex));
        assertFalse("1(".matches(regex));
        assertFalse("1000".matches(regex));
        assertFalse(" 20".matches(regex));
        assertFalse("1001".matches(regex));
    }
    @Test
    void ipV4OctetTrueTest(){
        String regex = Strings.ipV4Octet();
        assertTrue("0".matches(regex));
        assertTrue("00".matches(regex));
        assertTrue("000".matches(regex));
        assertTrue("10".matches(regex));
        assertTrue("100".matches(regex));
        assertTrue("255".matches(regex));
        assertTrue("199".matches(regex));
        assertTrue("249".matches(regex));
    }
    @Test
    void ipV4OctetFalseTest(){
        String regex = Strings.ipV4Octet();
        assertFalse("0000".matches(regex));
        assertFalse("t".matches(regex));
        assertFalse("-1".matches(regex));
        assertFalse("1111".matches(regex));
        assertFalse("0001".matches(regex));
        assertFalse("256".matches(regex));
        assertFalse("300".matches(regex));
        assertFalse("*".matches(regex));
        assertFalse("1 ".matches(regex));
    }
    @Test
    void ipV4AddressTrueTest() {
        String regex = Strings.ipV4Address();
        assertTrue("0.0.0.0".matches(regex));
        assertTrue("255.255.255.255".matches(regex));
    }
    @Test
    void ipV4AddressFalseTest() {
        String regex = Strings.ipV4Address();
        assertFalse("0.0.0".matches(regex));
        assertFalse("0.0.0+0".matches(regex));
        assertFalse("0".matches(regex));
        assertFalse("0.-".matches(regex));
        assertFalse("0.0.0*0".matches(regex));
        assertFalse("0.0.0 0".matches(regex));
    }
    @Test
    void stringWithJavaNamesTest() {
        String names = "123 1a _ abs int enum null lmn";
        String expected = "abs lmn";
        assertEquals(expected, Strings.stringWithJavaNames(names));
    }
    @Test
    void isArithmeticExpressionTest() {
         assertTrue(isArithmeticExpression("2*(2-1)*3"));
        assertTrue(isArithmeticExpression("2*3"));
        assertTrue(isArithmeticExpression("5*(3+(2/2))"));
        
        assertFalse(isArithmeticExpression(""));
        assertFalse(isArithmeticExpression(" + "));
        assertFalse(isArithmeticExpression("++"));
        assertFalse(isArithmeticExpression("abc"));
        assertFalse(isArithmeticExpression("1 + 1 -"));
        assertFalse(isArithmeticExpression("1 1+1"));
        assertFalse(isArithmeticExpression("()"));
        assertFalse(isArithmeticExpression("(1+1"));
        assertFalse(isArithmeticExpression("(1+1("));
        assertFalse(isArithmeticExpression("(1)+1)"));
        assertFalse(isArithmeticExpression("int+number"));
        assertFalse(isArithmeticExpression("a b+c"));

    }
}
