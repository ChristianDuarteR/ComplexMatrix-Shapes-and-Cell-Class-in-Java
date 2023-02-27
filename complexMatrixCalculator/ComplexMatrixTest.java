

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ComplexMatrixTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ComplexMatrixTest
{
    @Test
    public void ShouldCreateAkey(){
        ComplexMatrixCalculator cn = new ComplexMatrixCalculator();
        cn.create("llave prueba");
        assertEquals("llave prueba",cn.variables.firstKey());
    }
    
    @Test
    public void ShouldAssingAmatrixToAnExistingKey(){
        ComplexMatrixCalculator cn = new ComplexMatrixCalculator();
        cn.create("llaveConValor");
        cn.create("llaveSinValor");
        
        double datos[][][] = {{{0,0,0}},{{3,4,1}}};
        cn.assign("llaveConValor",datos);
        
        assertTrue(cn.variables.get("llaveConValor").data.equals(datos));
        assertNull(cn.variables.get("llaveSinValor"));
    }
    
    @Test
    public void ShouldKnowWhenAKeyHasAMatrix(){
        ComplexMatrixCalculator cn = new ComplexMatrixCalculator();
        
        cn.create("llave prueba 1");
        cn.create("llave prueba 2");
        
        double[][][] datos1 = {{{0,0,0}}};
        double[][][] datos2 = {{{0,1,0}}};    
        double[][][] datos3 = {{{1,0,1}}};
        
        Matrix matrix1 = new Matrix(datos1);
        Matrix matrix2 = new Matrix(datos2);
        Matrix matrix3 = new Matrix(datos3);
        cn.variables.put("llave prueba 1", matrix1);
        cn.variables.put("llave prueba 2", matrix2);
        
        assertTrue(cn.variables.containsValue(matrix1));
        assertTrue(cn.variables.containsValue(matrix2));
        assertFalse(cn.variables.containsValue(matrix3));
    }
    
    @Test
    public void ShouldKnowWhenHaveTwoSimilarMatrix(){
        ComplexMatrixCalculator cn = new ComplexMatrixCalculator();
        cn.create("llave prueba 1");
        cn.create("llave prueba 2");

        double datos[][][] = {{{0,0,0}},{{1,1,1}}};
        cn.assign("llave prueba 1",datos);
        cn.assign("llave prueba 2",datos);
        
        assertEquals(cn.toString("llave prueba 1",true),cn.toString("llave prueba 2",true));
        
    }
    
    @Test
    public void ShouldAssignANewOperatedMatrix(){
        ComplexMatrixCalculator cn = new ComplexMatrixCalculator();
        cn.create("llaveProbar");
        cn.create("llaveGuardar");
        
        cn.create("llaveOperador1");
        cn.create("llaveOperador2");

        double datos1[][][] = {{{1,2,0}},{{0,0,-1}}};
        double datos2[][][] = {{{2,0,-2}},{{1,0,-2}}};
        
        double datosSuma[][][] =  {{{3,2,-2}},{{1,0,-3}}};
        cn.assign("llaveOperador1", datos1);
        cn.assign("llaveOperador2", datos2);
        
        cn.assign("llaveProbar",datosSuma);
        //Elegir la operacion que se hara, y el lugar donde se guardara
        cn.assign("llaveGuardar","llaveOperador1",'+',"llaveOperador2");
        
        assertEquals(cn.toString("llaveGuardar",true),cn.toString("llaveProbar",true));
        
    }
    
}
