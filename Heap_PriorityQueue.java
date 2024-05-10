import java.util.*;
import java.util.LinkedList;
public class Heap_PriorityQueue {
    
    static class heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            arr.add(data); // 0(1)
            int i = arr.size()-1; // const.
            int parentIndx = (i-1)/2; // const.
            while(arr.get(parentIndx)<arr.get(i)){ // 0(N)
                int temp = arr.get(i);
                arr.set(i,arr.get(parentIndx));
                arr.set(parentIndx,temp);

                i = parentIndx;
                parentIndx = (i-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i ){

            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx  = i;
            if(left<arr.size() && arr.get(minIdx)<arr.get(left)){
                minIdx = left;
            }
            if(right<arr.size()&& arr.get(minIdx)<arr.get(right)){
                minIdx = right;
            }
            if(minIdx!=i){
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);
                heapify(minIdx);
            }
        }
        public  int remove(){
            int data = arr.get(0);

            //step 1 swap last to first;

            int temp = data;
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //step 2 remove last

            arr.remove(arr.size()-1);

            //heapify .... to fix the heap

            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size() == 0 ; 
        }
    }
    public static void heapifySort(int arr[], int i , int n){
        int left = i*2+1;
        int right = i*2+2;
        int minIndx = i;
        if(left<n && arr[minIndx]<arr[left]){
            minIndx = left;
        } 
        if(right<n && arr[minIndx]<arr[right]){
            minIndx = right;
        }
        if(minIndx!=i){
            int temp = arr[i];
            arr[i] = arr[minIndx];
            arr[minIndx] = temp;
            heapifySort(arr, minIndx, n);
        }
    }

    public static void heapSort(int arr[]){
        int n = arr.length;
        //step 1 get Max Heap;
        for(int i = n/2;i>=0;i--){
            // heapify will give us the max Heap by swaping and checking the last ancestor and putting it in correct place to form Max Heap;
            heapifySort(arr,i,n);
        }
        // step 2 Sorting like selection Sort where we take largest value and swap with smallest value and decrease the size so that we can swap second largest and second smallest element vise versa;
        for(int i = n-1 ; i>0;i--){
            int temp = arr[0];
            arr[0]= arr[i];
            arr[i] = temp;
            heapifySort(arr,0,i);
        }
    }   
    public static class nearByCarInfo implements Comparable<nearByCarInfo>{
        int x,y,indx,dist;
        nearByCarInfo(int x , int y , int indx , int dist){
            this.x = x;
            this.y = y;
            this.indx = indx;
            this.dist = dist;
        }
        @Override
        public int compareTo(nearByCarInfo d2){
            return this.dist - d2.dist;
        }
    }
    public static void nearByCar(int arr[][],int k ){
        PriorityQueue<nearByCarInfo> pq = new PriorityQueue<>();
        for(int i = 0 ; i<arr.length; i++){
            int dist = arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1];
            pq.add(new nearByCarInfo(arr[i][0], arr[i][1], i, dist));
        }
        for(int i = 0 ; i<k;i++){
            System.out.println("car "+pq.remove().indx);
        }
    }
    public static void nRopes(int arr[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i<arr.length;i++){
            pq.add(arr[i]);
        }
        int cost = 0;
        while(pq.size()>1){
            int min1rope = pq.remove();
            int min2rope = pq.remove();
            cost+=min1rope+min2rope;
            pq.add(min1rope+min2rope);
        }
        System.out.println("rope cost  "+cost);
    }
    public static class Nosoldiers implements Comparable<Nosoldiers> {
        int soldiers;
        int indx;
        Nosoldiers(int count  , int indx){
            this.soldiers = count;
            this.indx = indx;
        }
        @Override
        public int compareTo(Nosoldiers s2){
            if(this.soldiers == s2.soldiers){
                return this.indx-s2.indx;
            }
            else{
                return this.soldiers-s2.soldiers;
            }
        }
    }
    public static void kSoldiers(int arr[][],int k){
        
        PriorityQueue<Nosoldiers>pq = new PriorityQueue<>();
        for(int i = 0 ; i<arr.length;i++){
            int count=0;
            for(int j = 0 ; j<arr[0].length;j++){
                count += arr[i][j]==1?1:0;
            }
            pq.add(new Nosoldiers(count, i));
        }
        for(int i = 0 ; i<k;i++){
            System.out.println("weakest solders row"+pq.remove().indx);
        }
    }
    public static class pair implements Comparable<pair>{
        int val,indx;
        pair(int val,int indx){
            this.val = val;this.indx = indx;
        }
        @Override
        public int compareTo(pair p2){
            return p2.val-this.val;
        }
    }
    public static void slidingWindow(int arr[],int k){
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int ans[] = new int[arr.length-k+1];

        for(int i = 0 ; i<k;i++){
            pq.add(new pair(arr[i],i));
        }
        ans[0]=pq.peek().val;
        for(int i = k;i<arr.length;i++){
            while(pq.size()>0&&pq.peek().indx<=(i-k)){
                pq.remove();
            }
            pq.add(new pair(arr[i],i));
            ans[i-k+1] = pq.peek().val;
        }

        for(int i = 0 ; i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public static void printMax(int arr[],int n , int k){
        Deque<Integer>dq = new LinkedList<>();
        int i ;
        for(i=0;i<k;i++){
            while(!dq.isEmpty()&&arr[i]>=arr[dq.peekLast()]){
                dq.removeLast();
                
            }
            dq.addLast(i);
        }
        for(;i<n;i++){
            System.out.print(arr[dq.peek()]+" ");
            while(!dq.isEmpty()&&arr[i]>=arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        System.out.print(arr[dq.peek()]+" ");
    }
    public static void main(String arg[]){
        int arr[] = {1,3,-1,-3,5,3,6,7};
        slidingWindow(arr, 3);
        System.out.println();
        printMax(arr, arr.length, 3);
    }
    
}
