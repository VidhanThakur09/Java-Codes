import java.util.*;

public class LinkedList{
    // public static void arrayprint(int arr[]){
    //     for(int i=0; i<arr.length;i++){
    //         System.out.print(arr[i]);
    //     }
    // }
    // public static int fact (int num ){
    //     if(num==0){
    //         return 1;
    //     }
    //     return num*fact(num-1);
    // }
    // public static void mergesort(int arr[],int start , int end){
    //     if(start>=end){
    //         return;
    //     }
    //     int mid = start +(end-start)/2;

    //     // left

    //     mergesort(arr, start, mid);

    //     // right

    //     mergesort(arr, mid+1, end);

    //     // merge
    //     merge(arr, start, mid, end);
    // }
    // public static void merge(int arr[], int start, int mid, int end){
    //     int s = start;
    //     int m = mid+1;
    //     int e = end;
    //     int n = 0;
    //     int temp[]= new int[(end-start)+1];
    //     while(s<=mid&&m<=e){
    //         if(arr[s]<arr[m]){
    //             temp[n]=arr[s++];
    //         }
    //         else{
    //             temp[n]=arr[m++];
    //         }
    //         n++;
    //     }
    //     while(s<=mid){
    //         temp[n++]=arr[s++];
    //     }
    //     while(m<=e){
    //         temp[n++]=arr[m++];
    //     }
    //     for(int i=0,j=start;i<temp.length;i++,j++){
    //         arr[j]=temp[i];
    //     }
    // }

    // public static void  quicksort(int arr[],int start , int end){
    //     if(start>=end){
    //         return;
    //     }
    //     int pivetindx = pivet(arr,start,end);
    //     quicksort(arr, start, pivetindx-1);
    //     quicksort(arr, pivetindx+1, end);
    // }


    // public static int pivet(int arr[],int start,int end){
    //     int pivet = arr[end];
    //     int i = start-1;
    //     for(int j = start ; j<arr.length;j++){
    //         if(arr[j]<pivet){
    //             i++;
    //             int temp = arr[i];
    //             arr[i]= arr[j];
    //             arr[j] = temp;
    //         }
    //     }
    //     i++;
    //     int temp = pivet;
    //     arr[end]= arr[i];
    //     arr[i]= temp;
    //     return i;

    // }
    // public static void backtrackarray(int arr[],int i,int value){
    //     if(i==arr.length){
    //         arrayprint(arr);
    //         return;
    //     }
    //     arr[i]=value;
    //     backtrackarray(arr,i+1,value+1);
    //     arr[i]=arr[i]-2;
    // }
    // public static void substring(String s ,String ans , int i){
    //     if(i==s.length()){
    //         if(ans.length()==0){
    //         System.out.println("null");
    //         }else{
    //         System.out.println(ans);
    //         }
    //         return;
    //     }
        
    //     substring(s, ans+s.charAt(i), i+1);
    //     substring(s, ans, i+1);
    // }
    // public static void findpermutation(String s , String ans){
    //     if(s.length()==0){
    //         System.out.println(ans);
    //         return;
    //     }
    //     for(int i = 0;i<s.length();i++){
    //         char ch = s.charAt(i);
    //         String newString = s.substring(0, i)+s.substring(i+1);
    //         findpermutation(newString, ans+ch);
    //     }
    // }
    // // ------------------- N QUEEN CODE ---------------------
    // public static void printnqueens(char board[][]){
    //     System.out.println("---------------- chess board ---------");
    //     for(int i = 0;i<board.length;i++){
    //         for(int j = 0;j<board.length;j++){
    //             System.out.print(board[i][j]+"  ");
    //         }
    //         System.out.println();
    //     }
    // }
    // public static boolean issafe(char board[][],int row , int column){
    //     for(int i = row-1;i>=0;i--){
    //         if(board[i][column]=='Q'){
    //             return false;
    //         }
    //     }
    //     for (int i = row-1 ,j = column-1; i>=0 && j>=0;i--,j--){
    //         if(board[i][j]=='Q'){
    //             return false;
    //         }
    //     }
    //     for (int i = row-1 ,j = column+1; i>=0 && j<board.length;i--,j++){
    //         if(board[i][j]=='Q'){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // static int count;
    // public static boolean nqueens(char board[][],int row){
    //     if(row==board.length){
    //         // printnqueens(board);
    //         count++;
    //         return true;
    //     }
    //     for(int i = 0;i<board.length;i++){
    //         if(issafe(board,row,i)){
    //             board[row][i]='Q';
    //             if (nqueens(board, row+1)){
    //                 return true;
    //             }
    //             board[row][i]='x';
    //         }
    //     }
    //     return false;
    // }
    // public static int gridout(int i , int j , int n , int m){
    //     if(i==n-1&&j==m-1){
    //         return 1;
    //     }
    //     else if(i==n||j==m){
    //         return 0;
    //     }
    //     int fw1=fact(n-1);
    //     int fw2 = fact(m-1);
    //     int ftotal = fact(n-1+m-1);
    //     return (ftotal/(fw1*fw2));
    // }
    // //--------------- sudoko code-----------------------------
    // public static boolean issafesudoku(int sudoku[][],int row, int column,int index){
    //     for(int i = 0;i<=8;i++){
    //         if(sudoku[i][column]==index){
    //             return false;
    //         }
    //     }
    //     for(int i = 0;i<=8;i++){
    //         if(sudoku[row][i]==index){
    //             return false;
    //         }
    //     }
    //     int sr = (row/3)*3;
    //     int sc = (column/3)*3;
    //     for(int i = sr;i<sr+3;i++){
    //         for(int j=sc;j<sc+3;j++){
    //             if(sudoku[i][j]==index){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    // public static boolean sudoku(int sudoku[][],int row , int column){
    //     if(row==9&&column==0){
    //         return true;
    //     }
        
    //     int newrow = row; int newcolumn = column+1;
    //     if(column+1==9){
    //         newrow = row + 1;
    //         newcolumn=0;
    //     }
        
    //     if(sudoku[row][column]!=0) {
    //         return sudoku(sudoku, newrow, newcolumn);
    //     }
    //     for(int index = 1;index<=9;index++){
    //         if(issafesudoku(sudoku,row,column,index)){
    //             sudoku[row][column]= index;
    //             if(sudoku(sudoku, newrow, newcolumn)){
    //                 return true;
    //             }
    //             sudoku[row][column]=0;
    //         }
    //     }
    //     return false;
    // }
    // public static void printsudoku(int sudoku[][]){
    //     for(int i = 0;i<9;i++){
    //         for(int j = 0;j<9;j++){
    //             System.out.print(sudoku[i][j]+"  ");
    //         }
    //         System.out.println();
    //     }
    // }
    // public static void main(String arg[]){
    //     int sudoku[][] = {  {7, 0, 0, 0, 0, 0, 2, 0, 0},   
    //     {4, 0, 2, 0, 0, 0, 0, 0, 3},   
    //     {0, 0, 0, 2, 0, 1, 0, 0, 0},   
    //     {3, 0, 0, 1, 8, 0, 0, 9, 7},   
    //     {0, 0, 9, 0, 7, 0, 6, 0, 0},   
    //     {6, 5, 0, 0, 3, 2, 0, 0, 1},   
    //     {0, 0, 0, 4, 0, 9, 0, 0, 0},   
    //     {5, 0, 0, 0, 0, 0, 1, 0, 6},   
    //     {0, 0, 6, 0, 0, 0, 0, 0, 8}   
    //     };
    //     if(sudoku(sudoku, 0, 0)){
    //         System.out.println("exicted");
    //         printsudoku(sudoku);
            
    //     }
    //     else{
    //         System.out.println("not exicted");
    //     }
    // }
    // public static void printchessmaze(int maze[][]){
    //     for(int i = 0;i<maze.length;i++){
    //         for (int j = 0 ; j<maze.length;j++){
    //             System.out.print(" "+maze[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    // }
    // public static boolean issafe(int maze[][],int row , int col){
    //     int n = maze.length;
    //     return (row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1);
        
    // }
    // public static boolean solvmaze(int maze[][]){
    //     int n = maze.length;
    //     int sol[][]= new int [n][n];
    //     if(cheesemaze(maze, 0, 0, sol)==false){
    //         System.out.print("no solution");
    //         return false;
    //     }
    //     printchessmaze(sol);
    //     return true;
    // }
    // public static boolean cheesemaze(int maze[][],int row,int column,int sol[][]){
    //     if(row == maze.length-1&&column==maze.length-1&&maze[row][column]==1){
    //         sol[row][column]=1;
    //         return true;
    //     }
    //     if(issafe(maze, row, column)==true){
    //         if(sol[row][column]==1){
    //             return false;
    //         }
    //         sol[row][column]=1;
    //         if(cheesemaze(maze, row+1, column, sol)){
    //             return true;
    //         }
    //         if(cheesemaze(maze, row, column+1, sol)){
    //             return true;
    //         }
    //         sol[row][column]=0;
    //         return false;
    //     } 
    //     return false;       

    // }
    // final static char[][] l = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}}; 
    // public static void lettercombination(String D){
    //     int len = D.length();
    //     if((len==0)){
    //         System.out.print("");
    //         return;
    //     }
    //     bfs(0, len, new StringBuilder(), D);
    // }
    // public static void bfs(int pos, int len , StringBuilder sb , String D){
    //     if(pos==len){
    //         System.out.println(sb.toString());
    //     }
    //     else{
    //         char[] letter = l[Character.getNumericValue(D.charAt(pos))];
    //         for(int i = 0; i<letter.length;i++){
    //             bfs(pos+1,len,new StringBuilder(sb).append(letter[i]),D);
    //         }
    //     }
    // }
    // static int n = 8;
    // public static boolean issafe(int x , int y , int sol[][]){
    //     return(x>=0&&x<n&&y>=0&&y<n&&sol[x][y]==-1);
    // }
    // public static void printsolution(int sol[][]){
    //     for( int i = 0;i<n;i++){
    //         for(int j = 0;j<n;j++){
    //             System.out.print(sol[i][j]+" ");
    //         }
    //     }
    //     System.out.println();
    // }
    // public static boolean solvekt(){
    //     int sol[][]= new int [n][n];
    //     for(int x = 0 ; x<n;x++){
    //         for(int y = 0; y<n;y++){
    //             sol[x][y]=-1;
    //         }
    //     }
    //     int xMove[] = {2,1, -1, -2, -2, -1,1,2};
    //     int yMove[] = {1,2,2,1, -1, -2, -2, -1};

    //     sol[0][0]= 0;

    //     if(!solvektutil(0,0,1,sol,xMove,yMove)){
    //         System.out.println("no sol.");
    //         return false;
    //     }
    //     else{
    //         printsolution(sol);
    //     }
    //     return true;
    // }
    // public static boolean solvektutil(int x , int y , int movei,int sol[][],int xmove[],int ymove[] ){
    //     int k , nextx,nexty;
    //     if(movei==n*n){
    //         return true;
    //     }
    //     for(k = 0 ; k<8;k++){
    //         nextx= x+xmove[k];
    //         nexty=y+ymove[k];
    //         if(issafe(nextx, nexty, sol)){
    //             sol[nextx][nexty]=movei;
    //             if(solvektutil(nextx, nexty, movei+1, sol, xmove, ymove)){
    //                 return true;
    //             }else{
    //                 sol[nextx][nexty]=-1;
    //             }
    //         }
    //     }
    //     return false;

    // }
    // // public static int waterstored(ArrayList<Integer>height){
    // //     int max = 0;
    // //     for(int i = 0;i<height.size();i++){
    // //         for(int j = i+1;j<height.size();j++){
    // //             int h = Math.min(height.get(i),height.get(j));
    // //             int w = j-i;
    // //             int watertrap = h*w;
    // //             max = Math.max(max,watertrap);
    // //         }
    // //     }
    // //     return max;
    // // }
    // public static int waterstore(ArrayList<Integer>height){
    //     int max = 0;
    //     int left = 0;
    //     int right = height.size()-1;
    //     while(left<right){
    //         int h = Math.min(height.get(left),height.get(right));
    //         int w = right-left;
    //         int watertrap = h*w;
    //         max = Math.max(max,watertrap); 
    //         if(height.get(left)<height.get(right)){
    //             left++;
    //         }else{
    //             right--;
    //         }   

    //     }
    //     return max;
    // }
    // public static void pairsum(ArrayList<Integer>list,int target){
    //     int n = list.size();
    //     int bp = -1;
    //     for(int i = 0 ; i<n-1;i++){
    //         if(list.get(i)>list.get(i+1)){
    //             bp = i;
    //             break;
    //         }
    //     }
    //     int left = bp+1;
    //     int right = bp;
    //     while(left!=right){
    //         if(list.get(left)+list.get(right) == target){
    //             System.out.print(list.get(left)+","+list.get(right));
    //         }
    //         if(list.get(left)+list.get(right)>target){
    //             right = (n+right-1)%n;
    //         }else{
    //             left = (left+1)%n;
    //         }
    //     }
    // }
    // public static boolean mo (ArrayList<Integer>list){
    //     boolean inc = true;
    //     boolean dec = true;

    //     for(int i = 0 ; i<list.size()-1;i++){
    //         if(list.get(i)>=list.get(i+1)){
    //             inc = false;
    //         }
    //         if(list.get(i)<=list.get(i+1)){
    //             dec = false;
    //         }

    //     }
        
    //     return inc||dec;
    // }
    // public static void lonly(ArrayList<Integer>list){
    //     Collections.sort(list);
    //     ArrayList<Integer> list2 = new ArrayList<>();
    //     for(int i = 1 ; i<list.size()-1;i++){
    //         if(list.get(i-1)+1<list.get(i)&&list.get(i)+1<list.get(i+1)){
    //             list2.add(list.get(i));
    //         }
    //     }
    //     if(list.size() == 1){
    //         list2.add(list.get(0));
    //     }
    //     if(list.size()>1){
    //         if(list.get(0)+1<list.get(list.size()-1)){
    //             list2.add(list.get(0));
    //         }
    //         if(list.get(list.size()-2)+1<list.get(list.size()-1)){
    //             list2.add(list.get(list.size()-1));
    //         }
    //     }
    //     System.out.print(list2);

    // }
    // public static void maxx (ArrayList<Integer>list,int key){
    //     int count = 0;
    //     int a = 0;
    //     for(int i = 0 ; i< list.size()-1;i++){
    //         if(list.get(i)==key){
    //             a = list.get(i+1);
    //             for(int j = i+1;j<list.size();j++){
    //                 if(a==list.get(j)){
    //                     count++;
    //                 }
    //             }
    //             break;
    //         }
    //     }
    //     if(count>1){
    //         System.out.print(a);
    //     }
    // }
    
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;

        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    // public void addFirst(int data){
    //     Node newnode = new Node(data);
    //     size++;
    //     if(head == null){
    //         head=tail=newnode;
    //         return;
    //     }
        
    //     newnode.next=head;
    //     head = newnode;


    // }
    // public void addLast(int data){
    //     Node newnode = new Node(data);
    //     size++;
    //     if(head == null){
    //         head=tail=newnode;
    //         return;
    //     }
        
    //     tail.next=newnode;
    //     tail = newnode;

    // }
    // public static void printLl(){
    //     if(head == null){
    //         System.out.println("ll is emplty");
    //         return;
    //     }
    //     Node temp = head;

    //     while(temp!=null){
    //         System.out.print(temp.data+" -->");
    //         temp=temp.next;
    //     }
    //     System.out.println("null");
    // }
    // public void addMiddle(int data , int target){
    //     if(target == 0){
    //         addFirst(data);
    //         return;
    //     }
        
    //     Node temp = head; int i = 0;
    //     size++;
    //     while(i==target-1){
    //         temp=temp.next; 
    //         i++;
    //     }
    //     Node newnode = new Node(data);
    //     newnode.next=temp.next;
    //     temp.next=newnode;
    // }
    // public void length(){
    //     Node temp = head;int i = 0;while(temp!=null){temp = temp.next;i=i+1;}System.out.println("null");System.out.println(i);
    // }
    // public int removefirst(){
    //     if(size == 0){
    //         System.out.print("empty ll "); return Integer.MIN_VALUE;
    //     }else if(size==1){
    //         int var = head.data;
    //         size = 0;
    //         head=tail=null;
    //         return var;
    //     }int var = head.data;head=head.next;size--;return var;
    // }
    // public int removelast(){
    //     if(size == 0){
    //         System.out.print("empty ll "); return Integer.MIN_VALUE;
    //     }else if(size==1){
    //         int var = head.data;
    //         size = 0;
    //         head=tail=null;
    //         return var;
    //     }
    //     Node prev = head;
    //     for(int i = 0;i<size-2;i++){
    //         prev = prev.next;
    //     }
    //     int var = tail.data;
    //     tail = prev;
    //     prev.next = null;
    //     size--;
    //     return var;

    // }
    // public int findkey(int key){
    //     int i  = 0;
    //     Node temp = head;
    //     while(temp!=null){
    //         if(temp.data == key){
                
    //             return i;
    //         }else{
    //             temp = temp.next;
    //             i++;
    //         }
    //     }
    //     return -1;
    // }
    // public int helper(Node head,int key){
    //     if(head==null){
    //         return -1;
    //     }
    //     if(head.data==key){
    //         return 0;
    //     }
    //     int index = helper(head.next, key);
    //     if(index==-1){
    //         return -1;
    //     }
    //     return index+1;
    // }
    // public int recfindkey(int key){
    //     return helper(head,key);
    // }
    // public void reverse(){
    //     Node prev = null;
    //     Node curr = tail=head;
    //     Node next;
    //     while(curr != null){
    //         next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr=next;
    //     }
    //     head = prev;
    // }
    // public void removenth(int n){
    //     int size = 0;
    //     Node temp = head;
    //     while(temp!=null){
    //         size++;
    //         temp=temp.next;
    //     }
    //     if(n==size){
    //         head = head.next;
    //         return;
    //     }
    //     int i = 1;
    //     int p = size-n;
    //     Node prev = head;
    //     while(i<p){
    //         prev = prev.next;
    //         i++;
            
    //     }
    //     prev.next = prev.next.next;
    //     return;
    // }
    // public Node findmid(Node head){
    //     Node slow = head;
    //     Node fast = head;
    //     while(fast!=null&&fast.next!=null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }return slow;
    // }
    // public boolean checkpalo(){
    //     if(head==null||head.next==null){
    //         return true;
    //     }
    //     Node mid = findmid(head);
    //     Node curr = mid;
    //     Node prev = null;
    //     Node next;
    //     while(curr != null){
    //         next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
    //     Node right = prev;
    //     Node left = head;
    //     while(right!=null){
    //         if(left.data != right.data){
    //             return false;
    //         }
    //         left = left.next;
    //         right = right.next;
    //     }return true;
    // }
    // public boolean iscycle(){
    //     Node slow = head;
    //     Node fast = head;
    //     while(fast!=null && fast.next!=null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //         if(slow == fast){
    //             return true;
    //         }
    //     }return false;
    // }
    // public void removecycle(){
    //     // check is there anycycle;
    //     Node slow = head;
    //     Node fast = head;
    //     boolean cycle = false;
    //     while(fast!=null && fast.next!=null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //         if(slow == fast){
    //             cycle = true;
    //             break;
    //         }
    //     }
    //     if(cycle == false){
    //         return;
    //     }
    //     // change the position
    //     slow = head;
    //     // find the second meet
    //     Node prev = null;
    //     while(fast!=slow){
    //         prev = fast;
    //         slow = slow.next;
    //         fast = fast.next;

    //     }
    //     // change the value of last node next to null;
    //     prev.next = null;
    // }
    // private Node getmidd(Node head){
    //     Node fast= head.next;
    //     Node slow = head;
    //     while(fast!=null && fast.next!=null){
    //         fast = fast.next.next;
    //         slow = slow.next;
    //     }
    //     return slow;
    // }
    // private Node marge(Node h1 , Node h2){
    //     Node margell = new Node(-1);
    //     Node temp = margell;
    //     while(h1!=null&&h2!=null){
    //         if(h1.data<=h2.data){
    //             temp.next = h1;h1= h1.next;
    //             temp = temp.next;
                
    //         }else{
    //             temp.next = h2;h2 = h2.next;
    //             temp = temp.next;
                
    //         } 
    //     }
    //     while(h1!=null){
    //             temp.next = h1;h1= h1.next;
    //             temp = temp.next;
                
    //     }
    //     while (h2!=null){
    //         temp.next = h2;h2 = h2.next;
    //         temp = temp.next;
            
    //     }
    //     return margell.next;
    // }
    // public Node mergesort(Node head){
    //     if(head == null|| head.next == null){
    //         return head;
    //     }
    //     Node mid = getmidd(head);
        
    //     Node righthalf = mid.next;
    //     mid.next = null;
    //     Node newlefthalf = mergesort(head);
    //     Node newrighthalf = mergesort(righthalf);
    //     return marge(newlefthalf, newrighthalf);
    // }
    // public Node midforzigzac(Node head){
    //     Node slow = head;
    //     Node fast = head.next;
    //     while(fast!=null && fast.next!= null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     return slow;
    // }
    // public void zigzag(){
    //     if(head==null||head.next==null){
    //         return;
    //     }
    //     Node mid = midforzigzac(head);
    //     Node curr = mid.next;
    //     mid.next = null;
    //     Node prev = null;
    //     Node next;
    //     while(curr!=null){
    //         next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
    //     Node left = head;
    //     Node right = prev;
    //     Node nextleft , nextright;
    //     while(left!=null && right!= null){
    //         nextleft = left.next;
    //         left.next = right;
    //         nextright = right.next;
    //         right.next = nextleft;

    //         left = nextleft;
    //         right = nextright;
    //     }
    // }
    // public void removemn(int m , int n){
    //     Node prev = null;
    //     Node curr = head;
    //     int a = m;
    //     int b = n;
    //     while(curr!=null&&curr.next!=null){
    //         while(a!=0){
    //             if(curr==null){
    //                 return;
    //             }
    //             a--;
    //             prev = curr;
    //             curr = curr.next;
    //         }
    //         while(b!=0){
    //             if(curr==null){
    //                 return;
    //             }
    //             b--;
    //             curr = curr.next;
    //         }
    //         prev.next = curr;
    //         a=m;
    //         b=n;
    //     }
    // }
    // public void replacenodes(int x , int y){
    //     if(x == y){
    //         return;
    //     }
    //     Node currx = head;
       
    //     Node prev_x = null;
        
    //     while(currx!=null&&currx.data != x){
            
    //         prev_x=currx;
    //         currx = currx.next;
            
    //     }
    //      Node curry = head;Node prev_y = null;
    //     while(curry!=null&&curry.data != y){
            
    //         prev_y = curry;
    //         curry = curry.next;
            
    //     }
    //    if(currx==null||curry == null){
    //     return;
    //    }
    //    if(prev_x!=null){
    //     prev_x.next = curry;

    //    }else{
    //     head = curry;
    //    }
    //    if(prev_y!=null){
    //     prev_y.next = currx;

    //    }else{
    //     head = currx;
    //    }
    //    Node temp = currx.next;
    //    currx.next = curry.next;
    //    curry.next = temp;
    // }
    // public void oddeven(){
    //     Node end = head;
    //     Node prev = null;
    //     Node curr = head;

    //     while(end.next!=null){
    //         end = end .next;
    //     }
    //     Node new_end = end;

    //     while(curr.data%2!=0&&curr!=end){
    //         new_end.next = curr;
    //         curr = curr.next;
    //         new_end.next.next = null;
    //         new_end = new_end.next; 
    //     }
    //     if(curr.data%2 == 0){
    //         head = curr;
    //         while(curr!=end){
    //             if(curr.data%2==0){
    //                 prev = curr;
    //                 curr = curr.next;
    //             }
    //             else{
    //                 prev.next = curr.next;
    //                 curr.next = null;
    //                 new_end.next = curr;

    //                 new_end = curr;
    //                 curr = prev.next;
    //             }
    //         }
    //     }
    //     else{
    //         prev = curr;
            
    //     }
    //     if(new_end!=end && end.data % 2 !=0){

    //         prev.next = end.next;
    //         end.next = null;
    //         new_end.next = end;
    //     }


    // }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;size++;
        }
        size++;
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode; size++;
            return;
        }
        size++;
        tail.next = newNode;
        tail = newNode;
        
    }

    public void printLL(){
        if(head==null){
            System.out.println("empty head"); return;
            
        }
        Node temp = head;
        while(temp!=null){
            
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void addMid(int data, int target){
        if(target==0){
            addFirst(data); size++; return;
        }
        int i = 0;
        Node newNode = new Node(data);
        Node prev = head;
        while(i==target-1){
            prev = prev.next;
            i++;
        }
        size++;
        newNode.next = prev.next;
        prev.next = newNode;
        


    }
    public int removeFirst(){
        if(size == 0){
            System.out.println("empty head"); return -1;
        }
        else{
            if(size == 1){
                size = 0;
                int val = head.data;
                head=tail=null;
                return val;
            }
            int val = head.data; size--;
            head = head.next;
            return val;
        }
    }
    public int removeLast(){
        if(size == 0){
            System.out.println("empty head"); return -1;
        }
        else{
            if(size == 1){
                size = 0;
                int val = head.data;
                head=tail=null;
                return val;
            }
            int i = 0;
            Node temp = head;
            while(i<size-2){
                temp = temp.next; i++;
            }
            int val = tail.data;size--;
            tail = temp;
            temp.next = null;
            return val;
            
        }
        

    }
    public int findKey(int key){
        Node temp = head ; int i = 0;
        while(temp!=null){
            if(temp.data == key){
                return i;
            }else{
                temp = temp.next;i++;
            }
        }return -1;
    } 
    public int findKeyRec(int key){
        return helping(head, key);
    }
    public int helping(Node head , int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int val = helping(head.next, key);
        if(val==-1){
            return -1;
        }
        
        return val+1;
    }
    public Node reverseLL(){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }return prev;
    }
    public void removeNthelement(int n){
        int s = 0;
        Node c = head;
        while(c!=null){
            c=c.next;
            s++;
        }
        if(n==s){
            head = head.next;return;
        }
        int p = s-n;
        Node temp = head ;int i = 1;
        while(i<p){
            temp = temp.next;i++;
        }
        temp.next = temp.next.next; return;

    }
    public boolean Paladrome (){
        if(head==null||head.next==null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        Node curr = slow;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        Node left = head;
        Node right = prev;
        while(right !=null){
            if(left.data!=right.data){
                return false;
            }
            left = left.next;right = right.next;
        }
        return true;
    }
    public boolean cycleLL(){
        Node slow = head;
        Node fast = head;
        while(fast!=null&&fast.next != null){
            if(slow == fast){
                return true;

            }
            slow= slow.next;fast = fast.next.next;
        }
        return false;
    }
    public void removeCycleLL(){
        boolean cycle = false;
        Node slow = head;
        Node fast = head;
        while(fast!=null&&fast.next != null){
            if(slow == fast){
                cycle= true;break;

            }
            slow= slow.next;fast = fast.next.next;
        }
        if(cycle == false){
            return;
        }
        Node prev = null;
        slow = head;
        while (fast!=slow){
            prev=fast;
            fast = fast.next; slow = slow.next;
        }
        prev.next=null;
    }
    public Node Mid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null&&fast.next != null){
            slow = slow.next; fast = fast.next.next;
        } 
        return slow;
    }
    public Node merging(Node head1, Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while(head1!=null&&head2!=null){
            if(head1.data<=head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;               
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;     
            }
        }
        while(head1!=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next; 
        }
        while(head2!=null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;   
        }
        return mergeLL.next;
    }
    public Node mergeSort(Node head){
        if(head == null||head.next == null){
            return head;
        }
        Node mid = Mid(head);
        
        Node righthalf = mid.next;
        mid.next = null;
        Node newleft = mergeSort(head); Node newright = mergeSort(righthalf);
        return merging(newleft,newright);
    }
    public void ZiggZag(Node head){
        Node mid = Mid(head);
        Node leftHalf = head;
        
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        Node rightnext;Node leftnext;
        Node rightHalf = prev;
        while(leftHalf!=null&&rightHalf!=null){
            leftnext = leftHalf.next;
            rightnext = rightHalf.next;
            rightHalf.next = leftnext;
            leftHalf.next = rightHalf;
            leftHalf = leftnext;
            rightHalf = rightnext;
            
        }
    }

    
    public static void main(String arg[]){
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        // ll.addLast(6);
        // ll.addLast(7);
        ll.ZiggZag(ll.head);
        // ll.printLL();
        
        ll.printLL();
        
        
        

    }
    public boolean Paladromell(LinkedList.Node head2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Paladromell'");
    }
    

}