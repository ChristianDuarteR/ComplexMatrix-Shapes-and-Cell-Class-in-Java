import java.lang.Math;

/**
 *
 */
public class ComplexNumber{
    
    private double real;
    private double imaginary;
    private final static char squareUnderOne = 'i';

    /**
     * Create a new fractional given the real and imaginary part
     * @param real the real part of the complex number
     * @param imginary the imaginary part of the complex number
     */
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    
    /**
     * Returns the real part of this complex number
     * @return the real part
     */
    
    public double getReal(){
        return real;
    }
    
    /**
     * Returns the imaginary part of this complex number
     * @return
     */
    
    public double getImaginary(){
        return imaginary;
    }
    
    /**
     * Add this with other 
     * @param other  the complex number with which to operate
     * @return this+other
     */
    public ComplexNumber add(ComplexNumber other) {
        this.real+= other.real;
        this.imaginary+= other.imaginary;
        return this;
    }
    

    /**
     * Substract other from this 
     * @param other  the complex number with which to operate
     * @return this-other
     */
    public ComplexNumber substract(ComplexNumber other) {
        this.real-= other.real;
        this.imaginary-= other.imaginary;
        return this;
    }
    
    /**
     * Multiply this by other 
     * @param other  the complex number with which to operate
     * @return this*other
     */
    public ComplexNumber multiply(ComplexNumber other) {
        double aux1 = ((this.real*other.real)-(this.imaginary*other.imaginary));
        double aux2 = ((this.real*other.imaginary)+(this.imaginary*other.real));
        
        this.real = aux1;
        this.imaginary = aux2;
        return this;
    }    
    
    /**
     * Divide this by other 
     * @param other  the complex number with which to operate
     * @return this/other
     */
    public ComplexNumber divide(ComplexNumber other) {
        double div = (Math.pow(other.real,2) + Math.pow(other.imaginary,2));
        other.imaginary = (-1)*other.imaginary;
        multiply(other);
        this.real = this.real/div;
        this.imaginary = this.imaginary/div;
        return this;
    }  
    
    /**Indicates whether some other complex number is "equal to" this one.
     * @param other the complex number with which to comparate
     * @return  if this complex number is the same as the other 
     */
    public boolean equals (ComplexNumber other) {
        if(this.real ==other.real){
            if(this.imaginary==other.imaginary){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean equals(Object obj) {
        return equals((ComplexNumber)obj);
    }  
    
    
    @Override
    public String toString() {
        String SIMaginary;

        if(real!=0 && imaginary > 0){
            SIMaginary = String.valueOf(this.real)+"+"+String.valueOf(this.imaginary) + squareUnderOne;
        }
        else if(real!=0 && imaginary < 0){
            SIMaginary = String.valueOf(this.real)+String.valueOf(this.imaginary) + squareUnderOne;
            
        }else if(real==0 && imaginary==0){
            SIMaginary = "0";
            
        }else if(real==0){
            SIMaginary = String.valueOf(this.imaginary) + squareUnderOne;
            
        }else{
            SIMaginary = String.valueOf(this.real);
            
        }
        return SIMaginary;
    }
    

}