import java.util.*;
import java.io.*;
public class USACO{
	public static int bronze(String filename){
		int total=0;
		try{
			File text = new File(filename);
			Scanner inf = new Scanner(text);
			int numRow = inf.nextInt();
			int numCol = inf.nextInt();
			int e = inf.nextInt();
			int n = inf.nextInt();
			int[][] field = new int[numRow][numCol];
			for (int row=0; row<numRow;row++){
				for (int col=0; col<numCol; col++){
					field[row][col]=inf.nextInt();
				}
			}
			for (int count=0; count<n;count++){
				int R = inf.nextInt();
				int C = inf.nextInt();
				int D_s = inf.nextInt();
				int max=0;
				for (int r=0; r<3; r++){
					for (int c=0; c<3; c++){
						if (R+r<numRow&& C+c<numCol&&field[R+r][C+c]>max){
							max=field[R+r][C+c];
						}
					}
				}
				int newValue= max-D_s;
				for (int r=0; r<3; r++){
					for (int c=0; c<3; c++){
						if (R+r<numRow&& C+c<numCol&&field[R+r][C+c]>newValue){
							field[R+r][C+c]=newValue;
						}
					}
				}
			}
			for (int r=0; r<numRow; r++){
				for (int c=0; c<numCol; c++){
					if (field[r][c]<e){
						total+=e-field[r][c];
					}
				}
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Error");
		}
		return total * 72 * 72;
	}
	public static int silver(String filename){
		try{
			File text = new File(filename);
			Scanner inf = new Scanner(text);
			int rows = inf.nextInt();
			int cols = inf.nextInt();
			char[][] map = new char[rows][cols];
			int[][] current = new int[rows][cols];
			int[][] past = new int[rows][cols];
			int time = inf.nextInt();
			inf = inf.useDelimiter("");
			for (int r=0; r<rows; r++){
				String s = inf.nextLine();
				for (int c=0; c< cols; c++){
					map[r][c]=s.charAt(c);
				}
			}
			int startRow=inf.nextInt();
			int startCol= inf.nextInt();
			int endRow = inf.nextInt();
			int endCol = inf.nextInt();
			current[startRow][startCol]=1;
			for (int count=1; count<time; count++){
				past= current;
				current = new int[rows][cols];
				for (int r=0; r<rows;r++){
					for (int c=0; c< cols; c++){
						int total =0;
						if (map[r][c]!='*' && past[r][c]==0){
							if (r+1<rows&&map[r+1][c]!='*'){
								total+=past[r][c];
							}
							if (rows-1>-1&&map[r-1][c]!='*'){
								total+=past[r][c];
							}
							if (c+1<cols&&map[r][c+1]!='*'){
								total+=past[r][c];
							}
							if (c-1>-1&&map[r][c-1]!='*'){
								total+=past[r][c];
							}
						}
						current[r][c]=total;
					}
				}
			}
			return current[endRow][endCol];
		}
		catch (FileNotFoundException e){
			System.out.println("File not found");
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(USACO.bronze("test.txt"));
	}
}
