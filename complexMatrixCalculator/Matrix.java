/**
 * @author ECI, 2023
 *
 */
public class Matrix{
    
    protected double[][][] data;
    protected int rows;
    protected int columns;
    protected int depth;
    private char op;
   
    /**
     * @param data[][[][] the data with the valors of the matrix. 
     * Create a new matrix. If there is an error in the data, {{{0,0}}} is assumed
     */
    public Matrix (double data[][][]) {
        this.data = data;
        depth = data.length;
        rows = data[0].length;
        columns = data[0][0].length;
    }
    
    public void setOp(char op){
        this.op = op;
    }
    
    public char getOp(){
        return op;
    }
    
    /**
     * Get the dimension of the Matrix
     * @return an array 1D. 
     */
    public double [] dimension(){
        return data[0][0];
    }
    
    /**
     * @param f,c indicates the position at the matrix (f: "filas"), (c: "columnas")
     * Create a ComplexNumber with the first element real ant the other imaginary,
     * in the Matrix those elements are in [f][c]--->[0] and [f][c]--->[1]
     * @return a ComplexNumber
     */
    public ComplexNumber get(int f, int c){
        ComplexNumber MyNumber = new ComplexNumber(data[0][f][c],data[1][f][c]);
        return MyNumber;
    }
    
    public Matrix ComplexMultiply(Matrix other){
        
        if(this.rows == other.columns){
            for(int i=0;i<this.rows;i++){
                for(int j=0;j<other.columns;j++){
                    ComplexNumber miNumber = this.get(i,j).multiply(other.get(i,j));
                    this.data[0][i][j] = miNumber.getReal();
                    this.data[1][i][j] = miNumber.getImaginary();
                }
            }
        }
        return this;
    }
    
    /**
     * @param m another Matrix which it will be sum with our Matrix
     * Sum two matrix 
     * @return our matrix that has been sum.
     */
    public Matrix add(Matrix m){
        
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;i++){
                data[0][i][j] += m.data[0][i][j];
                data[1][i][j] += m.data[1][i][j];
            }
        }
        return this;
    }

    /**
     * @param m another Matrix which it will be substract with our Matrix
     * substract two matrix 
     * @return our matrix that has been substract.
     */
    public Matrix substract(Matrix m){
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;i++){
                data[0][i][j] -= m.data[0][i][j];
                data[1][i][j] -= m.data[1][i][j];
            }
        }
        return this;
    }
    
    /**
     * Traspone our Matrix if the Matrix has as rows as columns (the rows will be our columns and the columns will be our rows)
     * @return  Our transponed Matrix
     */
    public Matrix transpone(){

        if(this.rows == this.columns){
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;i++){
                    data[0][i][j] = data[0][j][i];
                    data[1][i][j] = data[1][j][i];
                }
            }
        }else{
            return this;
        }
        return this;
    }
    
    
    /**
     * @param other another object of type Matrix
     * Multiply our matrix with another Matrix (if it is possible)
     * @return our matrix that has been multiply (if it is possible);
     */
    public Matrix multiply(Matrix other){
        
        Matrix nuevaMatrix;
        double datos[][][] = new double[depth][rows][columns];
        if (this.rows == other.columns){
            for(int i=0;i<rows;i++){
                for(int j=0;j<other.columns;j++){
                    for(int k=0;k<other.rows;k++){
                        datos[0][i][j] = this.data[0][i][k]*other.data[0][k][j];
                        datos[1][i][j] = this.data[1][i][k]*other.data[1][k][j];
                    }
                }
            }
        }
        
        nuevaMatrix = new Matrix(datos);
        return nuevaMatrix;
    }
    
    // public Matrix multy(char rca){
        // switch(rca){
            // case 'r':
                
            // case 'c':
                
            // case 'a':
        // }      
        // return this;
    // }
    
    // /**
     // * @param rca indicates the type of the operation (r:row, c:column or a:all)
     // */
    // public Matrix add(char rca){
        // if (op != '+'){
            // this.multy(rca);
        // }
        
        // switch(rca){
            // case 'r':
                
            // case 'c':
                
            // case 'a':
                
        // }
        // return this;
    // }
    
    /**
     * @param other another Matrix to compare if our matrix and the other are equals
     * Compare every number and array in the matrix to know if the Matrixs are equals
     * @return true if are equals, else false 
     */
    public boolean equals(Matrix other) {
        for(int i = 0;i<data.length;i++){
            if(data[i] == other.data[i]){
                
                for(int j=0; j<data[i].length;j++){
                    if(data[i][j] == other.data[i][j]){
                        
                        for(int k=0;k<other.data[i][j].length;k++){
                            if(data[i][j][k] != other.data[i][j][k]){
                                return false;
                            }
                        }
                        
                    }else return false;
                }
                
            }else return false;
        }return true;
    }
    
    @Override
    public boolean equals(Object otra) {
            return equals((Matrix)otra);
    }
    
    
    public void imprimirMatriz () {
        for(int i=0;i<data.length;i++){
            
            System.out.print("\n capa "+ i + "\n\t");

            for(int j=0;j<data[i].length;j++){
                
                for(int k=0;k<data[i][j].length;k++){  
                    
                System.out.print(data[i][j][k] + "   "); 
                    
                }
                System.out.print("\n\n\t");
            }
        }
        
    }   
 
}
