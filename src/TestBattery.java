import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TestBattery {
    @org.junit.Test
    //Test empty array validation
    public void testNone() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String[] arr = {};
        Inspector ins = new Inspector();
        ins.checkNone(arr, "\t");
        assertEquals("\tnone\r\n", outContent.toString());
    }

    @org.junit.Test
    //Test tabbing function
    public void testIndent() {
        Inspector ins = new Inspector();
        String tab = ins.indent(1);
        assertEquals("\t", tab);
    }

    @org.junit.Test
    //Test tabbing function (edge case)
    public void testIndentNone() {
        Inspector ins = new Inspector();
        String tab = ins.indent(0);
        assertEquals("", tab);
    }

    @org.junit.Test
    //Test array inspection
    public void testArrayInspector() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Inspector ins = new Inspector();
        int[] arr = {1,2,3,4,5};
        ins.inspectArr(arr,false,0);
        String exp = "";
        Class c = arr.getClass();
        exp += ("Class name: " + c.getName() + "\n");
        exp += ("Type: " + arr.getClass().getComponentType() + "\n\n");
        exp += ("Length: " + arr.length + "\n");
        exp += ("-Array: [1, 2, 3, 4, 5, ]");

        assertEquals(exp,outContent.toString().trim().replace("\r",""));
    }
}

/**References
https://stackoverflow.com/questions/32241057/how-to-test-a-print-method-in-java-using-junit
 https://stackoverflow.com/questions/36324452/assertequalsstring-string-comparisonfailure-when-contents-are-identical
 **/