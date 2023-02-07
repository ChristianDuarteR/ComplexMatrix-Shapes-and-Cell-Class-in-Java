import java.util.Random;
/**
 * A molecula is a structure which have connectors like (A,B,C,D,E,F,G) and also have a sign (+,-)
 * They are two tipes of special connectos (**) and (00).
 *
 * @Christian Duarte, Miguel Tellez
 */
public class molecule
{
    private Rectangle cuadradoGrande=new Rectangle();
    private Rectangle cuadradoPequeño=new Rectangle();
    private String conector12;
    private String conector3;
    private String conector6;
    private String conector9;
    
    
    /**
     * Constructor for class molecule without connectors
     */
    public molecule(){        
        cuadradoGrande.changeColor("black");
        cuadradoPequeño.changeColor("white");
        cuadradoPequeño.xPosition = cuadradoGrande.xPosition + 3;
        cuadradoPequeño.yPosition = cuadradoGrande.yPosition + 3;
        cuadradoPequeño.height = cuadradoGrande.height-6;
        cuadradoPequeño.width = cuadradoGrande.width-6;
        
        setRandomsConectors();
        conector12+= "1";
        conector3+= "3";
        conector6+= "6";
        conector9+= "9";
        this.makeVisible();
        this.setConector(conector12);
        this.setConector(conector3);
        this.setConector(conector6);
        this.setConector(conector9);
    }
    
    /**
     * Constructor fo class molecule with connectors
     */
    public molecule(String conector12, String conector3, String conector6, String conector9){
        this.conector12 = conector12;
        this.conector3 = conector3;
        this.conector6 = conector6;
        this.conector9 = conector9;
        
        cuadradoGrande.changeColor("black");
        cuadradoPequeño.changeColor("white");
        cuadradoPequeño.xPosition = cuadradoGrande.xPosition + 3;
        cuadradoPequeño.yPosition = cuadradoGrande.yPosition + 3;
        cuadradoPequeño.height = cuadradoGrande.height-6;
        cuadradoPequeño.width = cuadradoGrande.width-6;
        
        conector12+='1';
        conector3+='3';
        conector6+='6';
        conector9+='9';
        
        this.makeVisible();
        this.setConector(conector12);
        this.setConector(conector3);
        this.setConector(conector6);
        this.setConector(conector9);
        
    }
    
    /** 
     * Initialize de conectors in the randoms letters and signs: (A,B,C,D,E,F,G) and (+,-,*,+)
     */
    private void setRandomsConectors(){ 
        String conectores1 [] = {"a","b","c","d","e","f","g"};
        String conectores2 [] = {"-","+","0","*"};
        
        conector12 = conectores1[getRamdomIndex(conectores1)] + conectores2[getRamdomIndex(conectores2)];
        conector3 = conectores1[getRamdomIndex(conectores1)] + conectores2[getRamdomIndex(conectores2)];
        conector6 = conectores1[getRamdomIndex(conectores1)] + conectores2[getRamdomIndex(conectores2)];
        conector9 = conectores1[getRamdomIndex(conectores1)] + conectores2[getRamdomIndex(conectores2)];
        
        
        if (conector12.charAt(1)=='0'||conector12.charAt(1)=='*'){
            conector12 = conector12.substring(1) + conector12.substring(1);
        }

        if (conector3.charAt(1)=='0'||conector3.charAt(1)=='*'){
            conector3 = conector3.substring(1) + conector3.substring(1);
        }

        if (conector6.charAt(1)=='0'||conector6.charAt(1)=='*'){
            conector6 = conector6.substring(1) + conector6.substring(1);
        }
        
        if (conector9.charAt(1)=='0'||conector12.charAt(1)=='*'){
            conector9 = conector9.substring(1) + conector9.substring(1);
        }

    }

    
    /**
     * give a random index of a list of strings
     * @Param List of strings 
     */
    private int getRamdomIndex(String [] lista){
        Random numRamdom = new Random();
        int randomIndex = numRamdom.nextInt(lista.length);
        return randomIndex;
    }
    
    /**initializes the conectors for one molecule which has already his conectors
     * and then paint them at the molecule
     * @param conector to set
     */
    private void setConector(String conector){
        
        Rectangle conectorType1 = new Rectangle();
        conectorType1.height=5;
        conectorType1.width=5;

        switch(conector.charAt(0)){
            case 'a':
                conectorType1.changeColor("red");
                break;
            case 'b':
                conectorType1.changeColor("yellow");
                break;
            case 'c':
                conectorType1.changeColor("green");
                break;
            case 'd':
                conectorType1.changeColor("magenta");
                break;
            case 'e':
                conectorType1.changeColor("orange");
                break;
            case 'f':
                conectorType1.changeColor("gray");
                break;
            case 'g':
                conectorType1.changeColor("cyan");
                break;
            default:
                conectorType1.changeColor("pink");
                break;
        }
        
        pintarConector1(conector,conectorType1);
        
        if(conector.charAt(1)=='+'){
            Circle conectorType2 = new Circle();
            conectorType2.diameter=5;
            pintarConector2(conector,conectorType2);
        }else if(conector.charAt(1)=='-'){
            Triangle conectorType2 = new Triangle();
            conectorType2.height=5;
            conectorType2.width=5;
            pintarConector2(conector,conectorType2);
        }else{
            Rectangle conectorType2 = new Rectangle();
            conectorType2.height=5;
            conectorType2.width=5;
            conectorType2.changeColor(conectorType1.color);
            pintarConector2(conector,conectorType2);
        }
    
    }
    
    
    /**
     * paint the first conector(A,B,C,D,E,F,G) in the molecula
     * @Param conector 
     * @Param conector(form) 
     * 
     */
    public void pintarConector1(String conector, Rectangle conectorType){
        switch(conector.charAt(2)){
            case '6':
                conectorType.xPosition = -7 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = -9 + cuadradoGrande.yPosition + (cuadradoGrande.height);
                break;
            case '3':
                conectorType.xPosition = -9 + cuadradoGrande.xPosition + (cuadradoGrande.width);
                conectorType.yPosition = -5 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
            case '1':
                conectorType.xPosition = -7 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = 4 +cuadradoGrande.yPosition; 
                break;
            case '9':
                conectorType.xPosition = 4 +cuadradoGrande.xPosition;
                conectorType.yPosition = -5 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
        }
        conectorType.makeVisible();
    }
    
    /**
     * paint the second conector(+,-,0,*) in the molecula
     * @Param conector 
     * @Param conector(form) 
     */
    public void pintarConector2(String conector, Figure conectorType){
        switch(conector.charAt(2)){
            case '6':
                conectorType.xPosition = 2 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = -9 + cuadradoGrande.yPosition + (cuadradoGrande.height);
                break;
            case '3':
                conectorType.xPosition = -9 + cuadradoGrande.xPosition + (cuadradoGrande.width);
                conectorType.yPosition =  2 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
            case '1':
                conectorType.xPosition = 2 + cuadradoGrande.xPosition + (cuadradoGrande.width)/2;
                conectorType.yPosition = 4 + cuadradoGrande.yPosition;
                break;
            case '9':
                conectorType.xPosition = 4 + cuadradoGrande.xPosition;
                conectorType.yPosition = 2 + cuadradoGrande.yPosition + (cuadradoGrande.height)/2;
                break;
        }
        conectorType.makeVisible();
    }
    
    /**
     * Changes the conectors of the molecule (if it is possible)
     */
    public void change(){
        char conectors[] = {'a','b','c','d','e','f','g'};

        if(conector12.charAt(0)!='0'&& conector12.charAt(0)!='*'){
            if(conector12.charAt(0) == 'g'){
                conector12 = conectors[0] + conector12.substring(1);
            }else{
                conector12 = conectors[indexOf(conector12)+1] + conector12.substring(1);
            }
        }
        
        if(conector3.charAt(0)!='0'&& conector3.charAt(0)!='*'){
            if(conector3.charAt(0) == 'g'){
                conector3 = conectors[0] + conector3.substring(1);
            }else{
                conector3 = conectors[indexOf(conector3)+1] + conector3.substring(1);
            }    
            
        }
        
        if(conector6.charAt(0)!='0'&& conector6.charAt(0)!='*'){
            if(conector6.charAt(0) == 'g'){
                conector6 = conectors[0] + conector6.substring(1);
            }else{
                conector6 = conectors[indexOf(conector6)+1] + conector6.substring(1);
            }
        }
        
        if(conector9.charAt(0)!='0'&& conector9.charAt(0)!='*'){
            if(conector9.charAt(0) == 'g'){
                conector9 = conectors[0] + conector9.substring(1);
            }else{
                conector9 = conectors[indexOf(conector9)+1] + conector9.substring(1);
            }
        }
        
        setConector(conector12);
        setConector(conector3);
        setConector(conector6);
        setConector(conector9);
    }
    
    /**
     * return the index where is located the letter of the conector
     * @Param the conector (A+,B-,D+,etc) 
     */
    private int indexOf(String conector){
        char conectors[] = {'a','b','c','d','e','f'};
        for (int i = 0; i < conectors.length; i++){
            if (conectors[i] == conector.charAt(0)){
                return i;
            }
        }return -1;
    }
    /**
     * return the conector in the position.
     * @Param position, the position has to be 12,3,6 or 9 in other case return "invalid number"
     */
    public String getConector(int position){
        switch(position){
            case 12:
                return conector12;
            case 3:
                return conector3;
            case 6:
                return conector6;
            case 9:
                return conector9;
            default:
                return "numero invalido";
        }
    }
    
    /**
     * Makes the molecule visible at the canvas.
     */
    public void makeVisible(){
        cuadradoGrande.makeVisible();
        cuadradoPequeño.makeVisible();
    }

    /**
     * Makes the molecule invisible at the canvas.
     */
    public void makeInvisible(){
        cuadradoGrande.makeInvisible();
        cuadradoPequeño.makeInvisible();
    }
    
    public void erase(){
        
    }
    
    public void draw(){
    
    }
}
