import java.util.TreeMap;

/** ComplexMatrixCalculator.java
 * 
 * @author CIS 2023-01
 */
    
public class ComplexMatrixCalculator{
    
    private TreeMap<String, Matrix> variables;
    private boolean wasGood; 
    
    public ComplexMatrixCalculator(){
        this.variables = new TreeMap<String,Matrix>();
    }

    /**
     * @param name, the name of the new key at the TreemMap
     * Create a new key for the TreeMap an then a value for that key which is null.
     */
    public void create(String name){
        variables.put(name,null);
    }
     
    
    /**
     * @param name,complexNumbers. 
     * if there is a key which name is the parameter then asign a new matirix to that key   
     */
    public void assign(String name, double complexNumbers[][][] ){
          Matrix nuevaMatrix = new Matrix(complexNumbers);
          variables.put(name,nuevaMatrix);  
          wasGood = true;
    }    
    
    /**
     * @Param a,b,op,c the keys and the operator
     * Takes the Matrixs that have been saved in our TreeMap and do the operation that op says
     * The Op can be "+", "-" or "t" it we want to traspone our Matrix.
     * The matrix that will be operate is "b with c" and it will save it in key "a".
     */
    public void assign(String a, String b, char op, String c){
        Matrix nuevaMatrix;
        
        switch(op){
            case '+':
                nuevaMatrix = variables.get(b).add(variables.get(c));
                variables.put(a,nuevaMatrix);
                wasGood = true;
                break;
                
            case '-':
                nuevaMatrix = variables.get(b).substract(variables.get(c));
                variables.put(a,nuevaMatrix);
                wasGood = true;
                break;
                
            case 't':
                nuevaMatrix = variables.get(b).transpone();
                variables.put(a,nuevaMatrix);
                wasGood = true;
                break;
                
            default:
                wasGood = false;
            }
        }
    
    /**
     * Takes two matrix in the TreeMap and then multiply them, takes c and put the results in another key 
     */
    public void multiply(String a,String b,String c){
        Matrix miMatrix = variables.get(a).multiply(variables.get(b));
        variables.put(c,miMatrix);
        wasGood = true; 
    }
    /**
     * @param a b c, the keys for the Matrix that will be special multiply
     * Do an especial Multiply for a complexMatrix and save the result in another key c
     */
    public void ComplexMultiply(String a,String b, String c){
        Matrix miMatrix = variables.get(a).ComplexMultiply(variables.get(b));
        variables.put(c,miMatrix);
        wasGood = true; 
    }
  
    //Assigns the value of an operation to a variable (unary matrix aggregation operations)
    // a := op type b
    //The operator characters are:  +, * 
    //The type characters are: r (row), c(column), a (all)
    
    // public void assign(String a, char op, char type, String b){
        // Matrix nuevaMatrix;
        // variables.get(b).setOp(op);
        
        // nuevaMatrix = variables.get(b).add(type);
        // variables.put(a,nuevaMatrix);        
    // }    
    
    /**
     * @param set, the key at the TreeMap that have an existing array
     * Print that array like an array of ComplexNumbers.
     */
    public void toString(String set){
    
        Matrix impresa = variables.get(set);
        
        for(int i=0;i<impresa.rows;i++){
            
            System.out.print("\n");
            
            for(int j=0; j< impresa.columns;j++){    
                System.out.print("Numero Complejo " + (j+1) + ": " + impresa.get(i,j).toString() + "\n\n");
            }
        }
    }
    
    /**
     * Says if the last operation has been done.
     * @return false if the last operation was not successfull, else return true
     */
    public boolean ok(){
        return wasGood;
    }
}
    



