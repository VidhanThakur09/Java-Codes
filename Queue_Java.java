import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Queue_Java {
    public static class stack{
        static Deque<Integer> dq = new LinkedList<Integer>();
        public static void push(int data){
            dq.addLast(data);
        }
        public static int pop(){
            return dq.removeLast();
        }
        public static int peek(){
            return dq.getLast();
        }
    }
    public static class queue{
        static Deque<Integer> dq = new LinkedList<Integer>();
        public static void add(int data){
            dq.addLast(data);
        }
        public static int remove(){
            return dq.removeFirst();
        }
        public static int peek(){
            return dq.getFirst();
        }
    }
    public static void FirstNon_Repeatingletter(String str){
        int frequency[]= new int[26];
        Queue<Character>q = new LinkedList<>();
        for(int i = 0 ; i<str.length();i++){
            char c = str.charAt(i);
            q.add(c);
            frequency[c-'a']++;
            while(!q.isEmpty()&&frequency[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.println(-1);
            }
            else{
                System.out.println(q.peek());
            }
        }
    }
    public static void InterLink(Queue<Integer>q){
        Queue<Integer>helping = new LinkedList<>();
        int size = q.size();
        for(int i = 0; i<size/2;i++){
            helping.add(q.remove());
        }
        while(!helping.isEmpty()){
            q.add(helping.remove());
            q.add(q.remove());
        }

    }
    public static void Rev(Queue<Integer>q){
        //useing recursion to reverse the queue
        if(q.isEmpty()){
            return;
        }
        int x = q.remove();
        Rev(q);
        System.out.println(x);
    }
    public static void rev2(Queue<Integer>q){
        // use stack to reverse the queue
        Stack<Integer>s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void Minrop(int n,int arr[]){
        PriorityQueue<Integer>q = new PriorityQueue<>();
        for(int i =0;i<n;i++){
            q.add(arr[i]);
        }
        int res = 0;
        while(q.size()>1){
            int first = q.poll();
            int second = q.poll();
            res+=first+second;
            q.add(first+second);
        }
        System.out.println("the resulted cost -->"+res);
    }

    public static void binaraynum(int n){
        Queue<String>q = new LinkedList<>();
        q.add("1");
        while(n-->0){
            String s1 = q.remove();
            System.out.println(s1);
            String s2 = s1;
            q.add(s1+"0");
            q.add(s2+"1");
        }
    }
    public static void sameorder(Queue<Integer>q,int n ){
        if(q.isEmpty()){
            return;
        }
        Queue<Integer>helping = new LinkedList<>();
        for(int i = 0 ; i<n;i++){
            helping.add(q.remove());
        }
        rev2(helping);
        
        while(!helping.isEmpty()){
            q.add(helping.remove());
        }
        int i=0;
        while(i<n){
            i++;
            q.add(q.remove());
        }
    }
    public static void Maxnum(int arr[],int k , int n,Queue<Integer>q){
        
        Deque<Integer>dq = new LinkedList<>();
        int i;
        for(i=0;i<k;i++){
            while(!dq.isEmpty()&&arr[i]>=arr[dq.peekLast()]){
                dq.remove();
            }
            dq.addLast(i);
        }
        for(;i<n;++i){
            System.out.println(arr[dq.peek()]+" ");

            while(!dq.isEmpty()&&dq.peek()<=i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty()&&arr[i]>=arr[dq.peekLast()]){
                dq.remove();
            }
            dq.addLast(i);

        }
        System.out.println(arr[dq.peek()]+" ");

        
    }
    public static void main(String arg[]){
        Queue<Integer>q = new LinkedList<>();
        // q.add(10);q.add(20);q.add(30);q.add(40);q.add(50);q.add(60);q.add(70);q.add(80);q.add(90);q.add(100);
        // int n = 5;
        // sameorder(q, n);
        int arr[]= {1,2,3,1,4,5,2,3,6};
        Maxnum(arr, 3, 9, q);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
        System.out.println();

    }
}
