import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.management.Query;



public class BinaryTree {
    static class Node{
        int data;
        Node  left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static class Binarytree{
        static int indx = -1; 
        public static Node buildtree(int arr[]){
            indx++;
            if(arr[indx]==-1){
                return null;
            }
            Node newNode = new Node(arr[indx]);
            newNode.left=buildtree(arr);
            newNode.right=buildtree(arr);
            return newNode;
        }
        public static void PrintTree(Node root){
            if(root == null){
                System.out.println(-1);
                return;
            }
            System.out.println(root.data);
            PrintTree(root.left);
            PrintTree(root.right);
        }
        public static void InorderTree(Node root){
            if(root == null){
                // System.out.println(-1);
                return;
            }InorderTree(root.left); //left NOde

            System.out.print(root.data+" "); //root Node
            
            InorderTree(root.right); // right Node
        }
        public static void postOrderTree(Node root){
            if(root==null){
                return;
            }
            postOrderTree(root.left); //left NOde
            postOrderTree(root.right); // right Node
            System.out.print(root.data); //root Node
        }
        public static void levelTree(Node root){
            if(root == null){
                return;
            }
            Queue<Node>q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node curr = q.remove();
                if(curr== null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }else{
                    System.out.print(curr.data+" ");
                    if(curr.left!= null){
                        q.add(curr.left);
                    }
                    if(curr.right!= null){
                        q.add(curr.right);
                    }
                }
            }
            
        }
        public static int HightOfTree(Node root){
            if(root==null){
                return 0;
            }
            int lh = HightOfTree(root.left);
            int rh = HightOfTree(root.right);
            return Math.max(lh,rh)+1;
        }
        public static int CountOfTree(Node root){
            if(root==null){
                return 0;
            }
            int cl = CountOfTree(root.left);
            int cr = CountOfTree(root.right);
            return cl+cr+1;
        }
        public static int SumOfTree(Node root){
            if(root==null){
                return 0;
            }
            int sl = SumOfTree(root.left);
            int sr = SumOfTree(root.right);
            return sl+sr+root.data ;
        }
        public static int DiameterOfTree(Node root){
            if(root==null){
                return 0;
            }
            int leftDiameter = DiameterOfTree(root.left);
            int leftHight = HightOfTree(root.left);
            int RightDiameter = DiameterOfTree(root.right);
            int rightHight = HightOfTree(root.right);
            int Self = leftHight+rightHight+1;
            return Math.max(Self,Math.max(RightDiameter,leftDiameter));
        }
    }
    public static class Info{
        int Diameter;
        int hight;
        Info(int d , int h){
            this.Diameter=d;
            this.hight = h;
        }
    }
    public static Info DiameterOfTree2(Node root){
        if(root==null){

            return new Info(0,0);
        }
        Info leftInfo = DiameterOfTree2(root.left);
        Info rightInfo = DiameterOfTree2(root.right);
        int self = leftInfo.hight+rightInfo.hight+1;
        int maxDia = Math.max(self,Math.max(leftInfo.Diameter,rightInfo.Diameter));
        int maxHig = Math.max(leftInfo.hight,rightInfo.hight)+1;
        return new Info(maxDia,maxHig);
    }
    public static boolean isIdentical(Node root, Node subroot){
        if(root==null && subroot==null){ // if both are null which means they are same
            return true;
        }
        else if(subroot==null|| root==null|| root.data!= subroot.data){ // we will check whether subroot is empty or main root is empty or the data in subroot is not equal in main root 
            return false;
        }
        if(!isIdentical(root.left, subroot.left)){ // checking in left subroot and main root 
            return false;
        }
        if(!isIdentical(root.right, subroot.right)){ // checking in right subroot and main root
            return false;
        }
        return true;
    } 
    public static boolean isSame(Node root, Node subroot){
        if(root==null){
            return false;
        }
        if(root.data==subroot.data){ // findint the root node which is same in root as well as Subnode
            if(isIdentical(root,subroot)){
                return true;
            }
        }
        return isSame(root.left, subroot)||isSame(root.right, subroot); //  checking in left & right Node
    }
    public static class MapInfo{
        //creating a class which store all the Horizontal distance and Node info
        Node node;
        int Hd;
        public MapInfo(Node node , int Hd){
            this.node = node;
            this.Hd = Hd;
        }
    }
    public static void topViewOfTree(Node root){
        if(root==null){ //checking if node is not empty
            return;
        }
        Queue<MapInfo>q = new LinkedList<>(); // using concept of level travacel to check level by level and adding its Horizontal value (-x,+x)

        HashMap<Integer,Node> map = new HashMap<>(); // using some concepts of hashmaps to store value with key value pair to check and call specific value

        int min = 0;int max = 0; // min and max will help us to iterate in horizontal distance as the left element lay on -x coodinates and right elements lays on +x coodinates

        q.add(new MapInfo(root, 0)); // add root node value and its Horizontal distance
        q.add(null);
        while(!q.isEmpty()){ // check if queue is not empty
            MapInfo curr = q.remove(); // removiing front value to check  wheather it null or its Horizontal Distance is present in Hashmap
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }else{ // checking if it exists in Hashmap or not if not then add its Node value and Its Horizontal Distance
                if(!map.containsKey(curr.Hd)){
                    map.put(curr.Hd,curr.node);
                }
                if(curr.node.left!=null){ // checking if it left Node exists in Hashmap or not if not then add its Node value and Its Horizontal Distance and change the min value from prev Min value and Horizontal Distance of left Node
                    q.add(new MapInfo(curr.node.left, curr.Hd-1));
                    min = Math.min(min,curr.Hd-1);
                }
                if(curr.node.right!=null){ // checking if it RightNode exists in Hashmap or not if not then add its Node value and Its Horizontal Distance and change the max value from prev Max value and Horizontal Distance of right Node
                    q.add(new MapInfo(curr.node.right, curr.Hd+1));
                    max = Math.max(max,curr.Hd+1);
                }
            }
        }
        for(int i = min ; i<=max;i++){ // printing all the Node value which is store in HashMap
            System.out.print(map.get(i).data);
        }
    }
    public static void KthNodes(Node root , int level , int k ){
        // Using recursive method
        if(root==null){
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }
        KthNodes(root.left, level+1, k);
        KthNodes(root.right, level+1, k);
    }
    public static void KthNode(Node root,int k){
        // Using level travecal method
        if(root == null){
            return ;
        }
        int level = 1;
        Queue<Node>q  = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr==null){
                level++;
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }else{
                if(level == k){
                    System.out.print(curr.data+" ");
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }
    public static boolean getNode(Node root , int n , ArrayList<Node> AL){
        if(root == null){ // if we reached to the end of the node and there is no value then we will return false
            return false;
        }
        AL.add(root); // first we will add Root node then by the recursion all the left and right node will be added
        if(root.data==n){ // if the data at root is equal or not
            return true;
        }
        boolean NodeLeft = getNode(root.left, n, AL); // checking for left half if we get true then we have found the node we want and add all its parents in the arrayList or if we get false then it may be in right half or don't exist

        boolean NodeRight = getNode(root.right, n, AL); //checking for right half if we get true then we have found the node we want and add all its parents in the arrayList or if we get false then it don't exist
        if(NodeLeft||NodeRight){ // if  any of the left or right half return true then we have found the node we want and add all its parents in the arrayList
            return true;
        } // if the Node we are isn't the Node we want then we need to delete that node and need to check in other half or return back
        AL.remove(AL.size()-1);
        return false;
    }

    public static Node LcN(Node root , int n1 , int n2){
        ArrayList<Node> al1 = new ArrayList<>();
        ArrayList<Node> al2 = new ArrayList<>();

        getNode(root,n1,al1);
        getNode(root,n2,al2);
        int i = 0;
        for(;i<al1.size()&&i<al2.size();i++){
            if(al1.get(i)!=al2.get(i)){
                break;
            }
        }
        return al1.get(i-1);
    }
    public static Node lca2(Node root , int n1,int n2){
        if(root==null||root.data==n1||root.data==n2){ // base case for where we check whether the node is null or if it's equal to N1 or N2 value;
            return root; // if it get true then we need to return the Node
        }
        Node LeftHalf = lca2(root.left, n1, n2); // checking for the left half and storing the Node value
        Node RightHalf = lca2(root.right, n1, n2); // checking for the Right half and storing the Node value
        if(LeftHalf==null){ // if the left part is null then it mean that the value is present in the right half
            return RightHalf;
        }
        if(RightHalf==null){ // if the right part is null then it mean that the value is present in the left half
            return LeftHalf;
        }
        // if left half and right half of any parent node is not null that mean that its the least common Ancestor
        return root;
    }
    //----------------------------------------------------------------
    public static int distanceHelp(Node root , int n ){
        if(root == null){
            return -1;
        } // if node is null then we need to return -1
        if(root.data == n){
            return 0;
        } // if we fond the node then we need to return the 0 as the distance is overlaping so start counting from 0
        int leftHalf = distanceHelp(root.left, n); // checking  for left and right half of the tree
        int rightHalf = distanceHelp(root.right, n);
        if(leftHalf==-1&&rightHalf==-1){ // if both left and right are -1 then return -1
            return -1;
        }
        else if(leftHalf==-1){ //  if left half is -1 then it means that value exist in right hali and vice versa
            return rightHalf+1;
        }else{
            return leftHalf+1;
        }
    }
    public static int minDist(Node root , int n1 , int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = distanceHelp(lca,n1);
        int dist2 = distanceHelp(lca,n2);
        return dist1+dist2;
    }
    public static int KthAncester(Node root ,int n , int k ){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftHalf = KthAncester(root.left, n, k);
        int rightHalf = KthAncester(root.right, n, k);
        if(leftHalf==-1&&rightHalf==-1){
            return -1;
        }
        int max = Math.max(leftHalf,rightHalf);
        if(max+1 == k){
            System.out.println(root.data+" ");
        }
        return max+1;
    }
    public static int transform(Node root){
        if(root == null){
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);
        int data = root.data;
        int newleft = root.left== null?0:root.left.data;
        int newright = root.right== null?0:root.right.data;
        root.data = newleft+leftChild+newright+rightChild;  
        return data;      
    }
    public static void preOrder(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String arg[]){
        int arr[]={1,2,4,-1,-1,5,-1,-1,3,7,-1,-1,6,-1,-1,};
        
        Binarytree tree = new Binarytree();
        //Main node
        Node root = tree.buildtree(arr);
        transform(root);
        preOrder(root);
        
    }
}
