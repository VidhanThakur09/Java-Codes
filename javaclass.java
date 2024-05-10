import java.util .*;

import javax.xml.stream.events.Characters;

public class javaclass {
    public static void mergesort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergesort(arr, start, mid);
        mergesort(arr, mid + 1, end);
        merging(arr, start, mid, end);
    }
    
    public static void merging(int arr[], int start, int mid, int end) {
        int s = start;
        int m = mid + 1;
        int e = end;
        int i = 0;
        int temp[] = new int[(end - start) + 1];
        while (s <= mid && m <= e) {
            if (arr[s] < arr[m]) {
                temp[i] = arr[s++];
            } else {
                temp[i] = arr[m++];
            }
            i++;
        }
        while (s <= mid) {
            temp[i++] = arr[s++];
        }
        while (e >= m) {
            temp[i++] = arr[m++];
        }
        for (i = 0, s = start; i < temp.length; i++, s++) {
            arr[s] = temp[i];
        }
    }
    public static void quicksort(int arr[],int start,int end){
        if(start>=end){
            return;
        }
        int pivet = pivet(arr,start,end);
        quicksort(arr, start, pivet-1); quicksort(arr, pivet+1, end);
    }
    public static int pivet(int arr[], int start,int end){
        int piv = arr[end];
        int s = start-1;
        for(int i = start;i<end;i++){
            if(arr[i]<=piv){
                s++;
                int temp = arr[i];
                arr[i]= arr[s];
                arr[s]= temp;
                
            }
        }s++;
        int temp = piv;
        arr[end]= arr[s];
        arr[s]= temp;
        return s;
    }
    public static int sraa(int arr[],int target,int start,int end){
        if(start>end){
            return -1;
        }
        int mid = start +(end -start)/2;
        if(target==arr[mid]){
            return  mid;
        }
        if(arr[start]<=arr[mid]){
            if(arr[start]<=target&&target<=arr[mid]){
                return sraa(arr, target, start, mid-1);
            }else{
                return sraa(arr, target, mid+1, end);
            }
        }else{
            if(arr[mid]<=target&&target<=arr[end]){
                return sraa(arr, target, mid+1, end);
            }
            else{
                return  sraa(arr, target, start, mid-1);
            }
        }
        
    }
    public static void subset(String str, String ans,int i){
        
       if(i==str.length()){
        if(ans.length()==0){
            System.out.print("null");
        }
        System.out.println(ans);
        return;
       }
        subset(str, ans+str.charAt(i),i+1);
        subset(str, ans, i+1);
    }
    public static void permutation (String str , String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            String newStr = str.substring(0, i)+str.substring(i+1);
            permutation(newStr, ans+ch);
        }

    }
    static int count;
    //nqueens
    public static boolean issafe(char board[][] , int row , int col){
        for (int i = row -1,j = col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i = row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i = row -1,j =col+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static boolean nQueen(char board[][],int row){
        if(row == board.length){
            count++;
            
            return true;
        }
        for(int i = 0;i<board.length;i++){
            if(issafe(board, row, i)){
                board[row][i] ='Q';
                if(nQueen(board, row+1)){
                    return true;
                }
                board[row][i] ='X';
            }
        }
        return false;
    }
    public static void printnQueen(char board[][]){
        System.out.println                         ("----------------");
        for(int i = 0;i<board.length;i++){
            for (int j = 0;j<board.length;j++){
                System.out.print(board[j][i]);
            }System.out.println();
        }
    }
    public static int grid (int i , int j, int n , int m){
        if(i==n-1&j==m-1){
            return 1;
        }else if(i==n||j==m){
            return 0;
        }
        int row = grid(i+1, j, n, m);int col = grid(i, j+1, n, m);
        return row +col;
    }
    public static int factorial (int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int gridfact(int i,int j){
        
        int row = factorial(i-1);
        int col = factorial(j-1);
        int tot = factorial((i-1)+(j-1));
        return tot/(row*col);
    }
    public static boolean isSafesudo(int arr[][],int row,int col , int digit){
        for(int i = 0 ; i<9;i++){
            if(arr[row][i]==digit){
                return false;
            }
        }
        for(int i = 0 ; i<9;i++){
            if(arr[i][col]==digit){
                return false;
            }
        }
        int sr = (row/3)*3; int sc = (col/3)*3;
        for(int i= sr;i<sr+3;i++ ){
            for(int j = sc ; j<sc+3;j++){
                if(arr[i][j]==digit){
                    return false;
                }
            }
        }return true;

    }
    public static boolean sudoku(int arr[][],int row , int col){
        if(row == 9){
            return true;
        }
        int newrow = row;int newcol = col+1; 
        if(col+1==9){
            newrow++;
            newcol = 0;
        }
        if(arr[row][col]!=0){
            return sudoku(arr, newrow, newcol);

        }
        for(int i = 1;i<=9;i++){
            if(isSafesudo(arr, row, col, i)){
                arr[row][col] = i;
                if(sudoku(arr, newrow, newcol)){
                    return true;
                }
                arr[row][col] =0;
            }
        }return false;
    }
    public static void printsudoku(int su[][]){
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                System.out.print(su[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void printSolution(int sol[][]){
        for(int i = 0;i<sol.length;i++){
            for(int j = 0;j<sol.length;j++){
                System.out.print(" "+sol[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean issafe(int maze[][],int row,int col){
        return(row>=0&&row<maze.length&&col>=0&&col<maze.length&&maze[row][col]==1);
    }
    public static boolean solvmaze(int maze[][],int row , int col,int sol[][]){
        if(row == maze.length-1&col == maze.length-1&&maze[row][col]==1){
            sol[row][col]=1;
            return true;
        }
        if(issafe(maze, row, col)==true){
            if(sol[row][col]==1){
                return false;
            }
            sol[row][col]=1;
            if(solvmaze(maze, row+1, col, sol)){
                return true;
            }
            if(solvmaze(maze, row, col+1, sol)){
                return true;
            }
            sol[row][col]=0;
            return false;
        }
        return false;
    }
    public static boolean maze(int maze[][]){
        int n = maze.length;
        int ans[][]= new int [n][n];
        if(solvmaze(maze, 0, 0, ans)==false){
            System.out.println("no solution");
            return false;
        }
        
        printSolution(ans);
            return true;
    }
    final static char[][]L= {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public static void lettercombination(String D){
        int len = D.length();
        if(len==0){
            System.out.println("");
            return;
        }
        bfs(0, len,new StringBuilder(), D);
    }
    public static void bfs(int pos,int len,StringBuilder sb , String D){
        if(pos == len){
            System.out.println(sb.toString());
            
        }
        else{
            char letter[]= L[Character.getNumericValue(D.charAt(pos))];
            for(int i = 0;i<letter.length;i++){
                bfs(pos+1, len, new StringBuilder(sb).append(letter[i]), D);
            }
        }
    }
    public static int containwater(ArrayList<Integer>hight){
        int i = 0;
        int j = hight.size()-1;
        int waterheight = 0;
        while(i<j){
            int h = Math.min(hight.get(i),hight.get(j));
            int with = j-i;
            int result = with*h;
            waterheight= Math.max(waterheight,result);
            if(hight.get(i)<hight.get(j)){
                i++;
            }else{
                j--;
            }
        }return waterheight;
    }
    public static boolean  pair1(ArrayList<Integer>n,int key){
        int s = 0;
        int e = n.size()-1;
        while(s!=e){
            if(n.get(s)+n.get(e)==key){
                
                return true;
            }
            if(n.get(s)+n.get(e)<key){
                s++;
            }else{
                e--;
            }
        }return false;

    }
    public static boolean par2(ArrayList<Integer>n,int key){
        int bp = -1;
        for(int i = 0;i<n.size();i++){
            if(n.get(i)>n.get(i+1)){
                bp=i;
                break;
            }
        }
        int r = bp;
        int l = bp +1;
        while(l!=r){
            if(n.get(l)+n.get(r)==key){
                
                return true;
            }
            if(n.get(l)+n.get(r)<key){
                l = (l+1)%n.size();
            }else{
                r=(r-1)%n.size();
            }
        }return false;


    }

    public static void  main(String arg[]){
        ArrayList<Integer> height = new ArrayList<Integer>();
        
        height.add(8);height.add(9);
        height.add(1);height.add(2);height.add(3);
        height.add(4);height.add(5);height.add(6);
        height.add(7);
        System.out.print(pair1(height, 101));
        
    
        
    }
    
}






              