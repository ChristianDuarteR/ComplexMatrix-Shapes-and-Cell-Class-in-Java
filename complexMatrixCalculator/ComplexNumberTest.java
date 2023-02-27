import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ComplexNumberTest {


    @Test
    public void shouldCreateComplexNumbers() {
        ComplexNumber cn = new ComplexNumber(1234,567);
        assertEquals(1234,cn.getReal(),0.1);
        assertEquals(567,cn.getImaginary(),0.1);
    }


    @Test
    public void shouldKnowWhenTwoComplexNumbersAreEquals () {
        assertTrue (new ComplexNumber(5405400,4158000).equals(new ComplexNumber(5405400,4158000)));
        assertFalse(new ComplexNumber(13,10).equals(new ComplexNumber(54054,41580)));
        assertEquals (new ComplexNumber(5405400,4158000),(new ComplexNumber(5405400,4158000)));
        assertEquals(new ComplexNumber(-3,100), new ComplexNumber(-3,100));
        assertEquals(new ComplexNumber(3,-100), new ComplexNumber(3,-100));
        assertEquals(new ComplexNumber(-3,-100), new ComplexNumber(-3,-100));
        assertEquals(new ComplexNumber(0,0), new ComplexNumber(0,0));
    }
    

    @Test
    public void shouldRepresentAComplexNumberAsAString() {
        assertEquals("1.0+2.0i", new ComplexNumber(1,2).toString());
        assertEquals("-1.0+2.0i", new ComplexNumber(-1,2).toString());
        assertEquals("-1.0-2.0i", new ComplexNumber(-1,-2).toString());
        assertEquals("1.0", new ComplexNumber(1,0).toString());
        assertEquals("3.0i", new ComplexNumber(0,3).toString());
        assertEquals("-3.0i", new ComplexNumber(0,-3).toString());
        assertEquals("0", new ComplexNumber(0,0).toString());
    }    
    

    @Test
    public void shouldAdd() {
        assertEquals (new ComplexNumber(110,200),new ComplexNumber(50,100).add(new ComplexNumber(60,100)));
        assertEquals (new ComplexNumber(39,42),new ComplexNumber(39,0).add(new ComplexNumber(0,42)));
        assertEquals (new ComplexNumber(0,0),new ComplexNumber(7,-13).add(new ComplexNumber(-7,13)));
    }
    
    @Test
    public void shouldSubstract() {
        assertEquals (new ComplexNumber(90,150),new ComplexNumber(100,200).substract(new ComplexNumber(10,50)));
        assertEquals (new ComplexNumber(0,0),new ComplexNumber(39,-45).substract(new ComplexNumber(39,-45)));
        assertEquals (new ComplexNumber(30,56),new ComplexNumber(20,60).substract(new ComplexNumber(-10,4)));       
    }
    
    @Test
    public void shouldMultiply(){
        assertEquals (new ComplexNumber(-210,660),new ComplexNumber(30,-20).multiply(new ComplexNumber(-15,12)));
        assertEquals (new ComplexNumber(-58,-165),new ComplexNumber(-10,9).multiply(new ComplexNumber(-5,12)));
        assertEquals (new ComplexNumber(0,58),new ComplexNumber(7,3).multiply(new ComplexNumber(3,7)));        
    }

}
