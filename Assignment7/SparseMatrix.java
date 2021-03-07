package Assignment7;
import java.util.*;
class SparseMatrix{
	
	Scanner sc=new Scanner(System.in);
	private int matrix[][];
	private int row,col;
	
	// to create matrix
	public SparseMatrix(){
		System.out.println("Enter number of rows in a matrix");
		this.row=sc.nextInt();
		System.out.println("Enter number of columns in a matrix");
		this.col=sc.nextInt();
		int[][] mat=new int[this.row][this.col];
		for(int i=0;i<this.row;i++){
			for(int j=0;j<this.col;j++){
				System.out.println("Enter row "+ (i+1) +" col "+(j+1));
				mat[i][j]=sc.nextInt();
			}
		}
		this.matrix=mat;
		System.out.println("Matrix is : \n");
		printMatrix(mat,this.row,this.col);
	}
	
	// to print matrix
	public static void printMatrix(int[][] mat, int row, int col){
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
			   System.out.print(mat[i][j]+"\t");	
			}
			System.out.println();
		}
	}
	 
	// cheking Symmetry of matrix.
	public void checkSymmetry(){
		int flag=0;
	  try{
		for(int i=0;i<this.row;i++){
			for(int j=0;j<this.col;j++){
				if(this.matrix[i][j]!=this.matrix[j][i]){
  		          flag=1;
  		          break;
	            }
			}
		}
		if(flag==0){
  	       System.out.println("matrix is symmetric");
        }
  	    else
           System.out.println("matrix is not symmetric");
	  }
	  catch(Exception e){
	  	System.out.println("To check Symmetricity matrix should be of n*n order");
	  }
	}
	    
	public int[][] transpose(){
		int[][] mat=new int[this.row][this.col];
		try{
		 for(int i=0;i<this.row;i++){
			for(int j=0;j<this.col;j++){
				mat[i][j]=this.matrix[j][i];
			}
		 }
		} 
		catch(Exception e){
	  	  System.out.println("To Transpose matrix should be of n*n order");
	    }
	    return mat;	 
	}
	
	public static int[][] addMatrix(SparseMatrix mat1, SparseMatrix mat2){
		int row1=mat1.row;
		int col1=mat1.col;
		int row2=mat2.row;
		int col2=mat2.col;
		int res[][]=new int[row1][col1];
		for(int i=0;i<row1;i++){
			for(int j=0;j<col1;j++){
				res[i][j]=mat1.matrix[i][j]+mat2.matrix[i][j];
			}
		}
		return res;
	}
	
	public static void multMatrix(SparseMatrix mat1, SparseMatrix mat2){
		int row1=mat1.row;
		int col1=mat1.col;
		int row2=mat2.row;
		int col2=mat2.col;
		int res[][]=new int[row1][col2];
		for(int i=0;i<row1;i++){
			for(int j=0;j<col2;j++){
				for(int k=0;k<row2;k++){
				  res[i][j] += mat1.matrix[i][k] * mat2.matrix[k][j];
				}  
			}
		}
		System.out.println("Multiplication of matrix : \n");
		printMatrix(res,row1,col2);
	}
	
	public static void main(String args[]){
		
		System.out.println("FOR FIRST MATRIX");
		SparseMatrix mat1=new SparseMatrix();
		
		System.out.println();
		mat1.checkSymmetry();
		
		System.out.println();
		int res[][]=mat1.transpose();
		System.out.println("Transpose Of Matrix is : \n");	
		printMatrix(res,mat1.row,mat1.col);
		
		System.out.println("\n");
		System.out.println("FOR SECOND MATRIX");
		SparseMatrix mat2=new SparseMatrix();
		
		if(mat1.row!=mat2.row || mat1.col!=mat2.col){
			System.out.println("Matrix cannot be add \n");
		}
		else{
		    int add[][]=addMatrix(mat1,mat2);
		    System.out.println("Addition of Matrix is : \n");	
		    printMatrix(add,mat1.row,mat1.col);
		}
		
		if(mat1.row!=mat2.col || mat1.col!=mat2.row){
			System.out.println("Matrix cannot be multiply \n");
		}
		else{
		    multMatrix(mat1,mat2);
		}
	}
}
