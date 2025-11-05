import java.util.*;
public class Shortest_Path
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the n x n Matrix: ");
		int n=sc.nextInt();
		char[][] matrix=new char[n][n];
		
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				matrix[i][j]='0';
			}
		}
		
		System.out.println("Enter Adventure position: (row X column)");
		int row=sc.nextInt();
		int col=sc.nextInt();

		matrix[row][col]='A';
	
		System.out.println("Enter Destination position: (Row X column)");
		int drow=sc.nextInt();
		int dcol=sc.nextInt();
		matrix[drow][dcol]='D';

		System.out.println("matrix: ");
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
		System.out.println();
		}

		int shortPath=FindMinPath(row,col,drow,dcol);

		System.out.println("Shortest Path: "+shortPath);
	}
	private static int FindMinPath(int row,int col,int drow,int dcol)

	{
		return Math.max(Math.abs(row-drow),Math.abs(col-dcol));
	}

}