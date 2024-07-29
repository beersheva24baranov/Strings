package strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static strings.Strings.*;
import org.junit.jupiter.api.Test;

public class RegularExpressionsTest {
    @Test
    void javaVariableTest() {
        // TODO
        assertTrue("varname".matches(javaVariable()));
        assertTrue("varName".matches(javaVariable()));
        assertTrue("varnamEvvijvji".matches(javaVariable()));
        assertTrue("varNAme".matches(javaVariable()));
        assertTrue("floattt".matches(javaVariable()));
        assertTrue("int12".matches(javaVariable()));
        assertFalse("varNAme ".matches(javaVariable()));
        assertFalse("String_".matches(javaVariable()));
        assertFalse("___".matches(javaVariable()));
        assertFalse("___123".matches(javaVariable()));
        assertFalse("$$$$".matches(javaVariable()));
        assertFalse("{___}".matches(javaVariable()));
        assertFalse("varname[_".matches(javaVariable()));
        assertFalse("|".matches(javaVariable()));
        assertFalse("1".matches(javaVariable()));
        assertFalse("1Q".matches(javaVariable()));
        assertFalse("Z".matches(javaVariable()));
        assertFalse("".matches(javaVariable()));
        assertFalse("__||".matches(javaVariable()));
        assertFalse("_".matches(javaVariable()));
        assertFalse("$varname".matches(javaVariable()));
        assertFalse("_varname".matches(javaVariable()));
        assertFalse("$$$__varname".matches(javaVariable()));
        assertFalse("var_Name".matches(javaVariable()));
        assertFalse("var_n_ame".matches(javaVariable()));
        assertFalse("varname_$".matches(javaVariable()));
        assertFalse("A1".matches(javaVariable()));
        assertFalse("_$$$$A1".matches(javaVariable()));
    }
}
