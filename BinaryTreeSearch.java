import java.util.*;

public class BinaryTreeSearch {
    static class Node{
        int data;
        Node left;
        Node right;
        Node( int data){
            this.data = data;
        }
    }
    public static Node buildBst(Node root , int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data >val){
            root.left = buildBst(root.left, val);
        }else{
            root.right = buildBst(root.right, val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root == null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static boolean searchKey(Node root , int key ){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data>key){
            return searchKey(root.right, key);
        }
        else{
            return searchKey(root.left, key);
        }
    }
    public static Node dltNode(Node root , int n){
        if(root.data>n){
            root.right = dltNode(root.right, n);
        }
        else if(root.data <n){
            root.left = dltNode(root.left, n);
        }
        else{
            //case 1 - if Node is leaf node having left and right Node null then return null;
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2 - if Node have single child then check if its right child is null then return left child or if left child is null then return right child;
            if(root.right == null){
                return root.left;
            }
            if(root.right == null){
                return root.right;
            }
            // case 3 - if the node have subtree and to dlt its next child we need to find its successor then replace its value to prev node ;
            else{
                Node Is = nextSuccer(root.right);
                root.data = Is.data;
                root.right  = dltNode(root.right, n);
            }
        }
        return root;
    }
    public static Node nextSuccer(Node root){
        while (root.left!= null){
            root = root.left;
        }
        return root;
    }
    public static void rangePrint(Node root , int k1 , int k2){
        if(root== null){
            return;
        }
        if(root.data>=k1&&root.data<=k2){
            rangePrint(root.left, k1, k2);
            System.out.print(root.data+" ");
            rangePrint(root.right, k1, k2);
        }
        else if(root.data<k1){
            rangePrint(root.left, k1, k2);
        }
        else{
            rangePrint(root.right, k1, k2);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i<path.size();i++){
            System.out.print(path.get(i)+" -->");

        }
        System.out.println("null");
    }
    public static void printPathRoot( Node root , ArrayList<Integer> path){
        if(root == null){
            return ;
        }
        path.add(root.data);
        if(root.left == null&&root.right==null){
            printPath(path);
        }
        printPathRoot(root.left, path);
        printPathRoot(root.right, path);
        path.remove(path.size()-1);
    }
    public static boolean isValid(Node root,Node min , Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        if(max!=null && root.data>=max.data){
            return false;
        }
        return isValid(root.left,null, root)&& isValid(root.right, root, null); 
    }
    public static Node mirrorNode(Node root){
        if(root==null){
            return root;
        }
        Node left = mirrorNode(root.left);
        Node right = mirrorNode(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    public static Node createBST(int arr[], int s , int e){
        if(s>e){
            return null;
        }
        int mid = (s+e)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, s, mid-1);
        root.right = createBST(arr, mid+1, e);
        return root;
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node createBST2(ArrayList<Integer>arr , int s, int e){
        if(s>e){
            return null;
        }
        int mid = (s+e+1)/2;
        Node root = new Node (arr.get(mid));
        root.left = createBST2(arr, s, mid-1);
        root.right = createBST2(arr, mid+1, e);
        return root;
    }
    public static void inOrderBst(Node root , ArrayList<Integer>arr){
        if(root==null){
            return;
        }
        inOrderBst(root.left, arr);
        arr.add(root.data);
        inOrderBst(root.right, arr);
    }
    public static Node balanceBst(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        inOrderBst(root,arr);
        return createBST2(arr, 0, arr.size()-1);
    }
    
    public static class Info{
        boolean IsBST;
        int size;
        int min;
        int max;
        Info(boolean IsBST , int size , int min , int max){
            this.IsBST = IsBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxsize = 0;
    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info left = largestBST(root.left);
        Info right = largestBST(root.right);
        int size = left.size+right.size+1;
        int max = Math.max(root.data,Math.max(left.max,right.max));
        int min = Math.min(root.data,Math.min(left.min,right.min));
        if(root.data<=left.max||root.data>=right.min){
            return new Info(false, size, min, max);
        }
        if(left.IsBST&&right.IsBST){
            maxsize = Math.max(maxsize,size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }
   
    public static Node mergeNode(Node root1 , Node root2 ){
        //geting sorted Node data to ArrayList
        ArrayList<Integer> arr1 = new ArrayList<>();
        inOrderBst(root1,arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        inOrderBst(root2,arr2);

        // merging

        int i =0,j=0;
        ArrayList<Integer> finalArray = new ArrayList<>();
        while(i<arr1.size()&&j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                finalArray.add(arr1.get(i));
                i++;
            }
            else{
                finalArray.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            finalArray.add(arr1.get(i));
            i++;
        }
        while (j<arr2.size()) {
            finalArray.add(arr2.get(j));
            j++;
        }
        // creating BST
        return createBST2(finalArray, 0, finalArray.size()-1);
    }
    public static void main(String[]args){
        int arr[] = {2,1,4};
        int arr2[] = {9,3,12};
        Node root1= null;
        Node root2 = null;
        for(int i = 0;i<arr.length ; i++){
            root1 = buildBst(root1,arr[i]);
        }
        for(int i = 0;i<arr2.length ; i++){
            root2 = buildBst(root2,arr2[i]);
        }
        Node root = mergeNode(root1, root2);
        preOrder(root);
        
        
        

    }
}
