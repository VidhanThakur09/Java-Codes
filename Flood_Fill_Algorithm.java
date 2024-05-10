import java.util.*;
public class Flood_Fill_Algorithm {
    public static void helper(int [][]image,int sr,int sc,int color,boolean[][] visited,int orgColor){
        if(sr<0||sc<0 
        ||sr>=image.length||sc>=image[0].length
        ||visited[sr][sc]
        ||image[sr][sc]!=orgColor){
            return;
        }
        image[sr][sc] = color;
        visited[sr][sc] = true;

        helper(image, sr-1, sc, color, visited, orgColor); //top
        helper(image, sr+1, sc, color, visited, orgColor);  //bottom
        helper(image, sr, sc-1, color, visited, orgColor); //left
        helper(image, sr, sc+1, color, visited, orgColor); //right
    }
    public static  int[][] fillFloor(int image[][],int sr , int sc ,int color){
        boolean[][] visited = new boolean[image.length][image[0].length];
        helper(image,sr,sc,color,visited,image[sr][sc]);
        return image;
    }
    public static void main(String arg[]){
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        fillFloor(image, 1, 1, 2);
        for(int i= 0;i<image.length;i++){
            for(int j =0;j<image[0].length;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}
