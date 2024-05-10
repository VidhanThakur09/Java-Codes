import java.util.*;
public class javastack {
    public static class Node{
        Character data;
        Node next;
        public Node(Character data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public static void addFirst(Character data){
        Node newNode = new Node(data);
        if(head ==null){
            head = tail = newNode; return;
        }
        newNode.next = head;
        head = newNode;
    }
    public static void addLast(Character data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail=newNode;return;
        }
        tail.next = newNode;
        tail= newNode;
    }
    public static void printLL(){
        if(head == null){
            System.out.println("Emplty");return;
        }
        Node temp = head;
        while(temp != null){
            System.out.println((temp.data));temp = temp.next;
        }
        System.out.print("null");
    }
    
    public static void PushAtBottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data); return;
        }
        int top = s.pop();
        PushAtBottom(s, data);
        s.push(top);
    }
    public static void revString(String str , Stack<Character>s){
        for (int i = 0;i<str.length();i++){
            s.push(str.charAt(i));
        }
        while(!s.isEmpty()){
            System.out.print(s.peek());
            s.pop();
        }
    }
    public static void PushRevStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        PushRevStack(s);
        PushAtBottom(s, top);
    }
    public static void PrintStack(Stack<Integer>s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void printStocks(int stocks[], Stack<Integer>s,int ans[]){
        ans[0]=1;
        s.push(0);
        for(int i = 1;i<stocks.length;i++){
            int currPrice = stocks[i];
            while(!s.isEmpty()&&currPrice>stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i]= i+1;
            }else{
                int prevPriceIndix = s.peek();
                ans[i]=i-prevPriceIndix;
            }
            s.push(i);
        }
    }
    public static void greatestRight(int arr[], Stack<Integer>stack,int ans[]){
        ans[arr.length-1]=arr[arr.length-1];
        for(int i = arr.length-1;i>=0;i--){
            // step 1  --> while loop
            while(!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
                stack.pop();
            }
            // step 2 --> if-else
            if(stack.isEmpty()){
                ans[i]=arr[i];
            }
            else{
                ans[i]= arr[stack.peek()];
            }
            // step 3 --> Push
            stack.push(i);
        }
    }
    public static void smallestRight(int arr[], Stack<Integer>stack,int ans[]){
        for(int i = arr.length-1;i>=0;i--){
            // step 1  --> while loop
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            // step 2 --> if-else
            if(stack.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]= arr[stack.peek()];
            }
            // step 3 --> Push
            stack.push(i);
        }
    }
    public static void greatestLeft(int arr[], Stack<Integer>stack,int ans[]){
        ans[0] = arr[0];
        for(int i = 0;i<arr.length;i++){
            // step 1  --> while loop
            while(!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
                stack.pop();
            }
            // step 2 --> if-else
            if(stack.isEmpty()){
                ans[i]=arr[i];
            }
            else{
                ans[i]= arr[stack.peek()];
            }
            // step 3 --> Push
            stack.push(i);
        }
    }
    public static void smallestLeft(int arr[], Stack<Integer>stack,int ans[]){
        for(int i = 0;i<arr.length;i++){
            // step 1  --> while loop
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            // step 2 --> if-else
            if(stack.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]= arr[stack.peek()];
            }
            // step 3 --> Push
            stack.push(i);
        }
    }
    public static boolean validParenthese(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<str.length();i++){
            Character ch = str.charAt(i);
            // Putting all the opening brackets
            if(ch=='('||ch=='{'||ch=='['){ 
                stack.push(ch);
            }
            else{
                // checking the stack is not empty
                if(stack.isEmpty()){
                    return false;
                }
                // checking pairs by matching opening and closing brackets
                if((stack.peek()=='('&&ch==')') //()
                ||(stack.peek()=='['&&ch==']')//[]
                ||(stack.peek()=='{'&&ch=='}'))//{}
                {
                    stack.pop();
                }
                else{
                    return false;
                }
            }

        }
        //checking for any element is not left
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean duplicateParenthese(String str){
        Stack <Character> stack = new Stack<>();
        for(int i = 0 ; i<str.length();i++){
            Character ch = str.charAt(i);
            if(ch==')'){
                int count = 0;
                while(stack.peek()!='('){
                    stack.pop(); count++;
                }
                if(count<1){
                    return true;
                }else{
                    stack.pop(); 
                }
                
            }
            else{
                stack.push(ch);
            }
        } return false;
    }
    public static int MaxAreaInHinstrogram(int arr[]){
        int max = 0;
        Stack<Integer>s = new Stack<>();
        int snl[]= new int[arr.length];
        int snr[] = new int[arr.length]; 
        //small number left
        for(int i =0;i<arr.length;i++){
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                snl[i]=-1;
            }else{
                snl[i]= s.peek();
            }
            s.push(i);

        }
        //small number right
        s = new Stack<>();
        for(int i =arr.length-1;i>=0;i--){
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                snr[i]=arr.length;
            }else{
                snr[i]= s.peek();
            }
            s.push(i);

        }
        //max area 
        for(int i = 0 ;i<arr.length;i++){
            int weight = snr[i]-snl[i]-1; //weight
            int height = arr[i];
            int currarea = (height * weight);
            max = Math.max(max,currarea);
        }
        return max;

    }
    public static boolean PaladromeLL1(Node head){
        Stack<Character>s = new Stack<>();
        boolean result = true;
        Node temp = head;
        while(temp!=null){
            s.push(temp.data);temp = temp.next;
        }
        while(head!=null){
            int i = s.pop();
            if(head.data==i){
                result = true;
            }
            else{
                result = false;break;
            }
            head = head.next;
        }
        return result; 
    }
    public static String SPath(String Path){
        Stack<String> stack = new Stack<String>();
        StringBuilder res = new StringBuilder();
        String[] p = Path.split("/");

        for(int i = 0;i<p.length;i++){
            if(!stack.isEmpty()&&p[i].equals("..")){
                stack.pop();
            }
            else if(!p[i].equals(".")&&!p[i].equals("")){
                stack.push(p[i]);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        while(!stack.isEmpty()){
            res.insert(0,stack.pop()).insert(0,"/");
        }
        return res.toString();
    }
    
    public static int maxWater(int height[]){
        Stack<Integer>stack = new Stack<>();
        int n = height.length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            while((!stack.isEmpty())&&(height[stack.peek()]<height[i])){
                int  popHight = height[stack.pop()];
                if(stack.isEmpty()){
                    break;
                }
                int distance = i-stack.peek()-1;
                int minHeight = Math.min(height[stack.peek()],height[i])-popHight;
                ans +=distance*minHeight;
            }
            stack.push(i);
        }
        return ans;

    }
    public static void main(String arg[]){
        int height[] = {4,2,0,6,3,2,5};
        System.out.println(maxWater(height));
        

        // int arr[]= {2,1,5,6,2,3};
        // System.out.print(MaxAreaInHinstrogram(arr));
        
        

    }
}
