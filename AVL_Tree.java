public class AVL_Tree {
    static class Node{
        int data , height;
        Node left , right ; 


        Node (int data){
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root ){
        if(root== null){
            return 0;
        }
        return root.height;
    }

    public static Node rightRotate(Node y){
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right))+1;
        x.height = Math.max(height(x.left),height(x.right))+1;

        return x;

    }

    public static Node leftRotate(Node x){
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left),height(x.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;

        return y;

    }

    public static int getBalance(Node root){
        if(root==null){
            return 0 ;
        }
        return height(root.left)-height(root.right);
    }

    public static Node insert(Node root , int key){
        if(root == null){
            return new Node(key);
        }
        if(key<root.data){
            root.left = insert(root.left, key);
        }
        else if(key>root.data){
            root.right = insert(root.right, key);
        }
        else{
            return root;
        }

        root.height = 1+Math.max(height(root.left),height(root.right));

        int bf = getBalance(root);

        if(bf>1 && key<root.left.data){
            return rightRotate(root);
        }
        if(bf<-1 && key >root.right.data){
            return leftRotate(root);
        }
        if(bf>1 && key>root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(bf<-1 && key<root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;

    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");

        preorder(root.left);
        preorder(root.right);
    }





    public static Node getMinNode(Node root){
        Node curr = root;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    public static Node dltNode(Node root , int key){
        if(root == null){
            return null;
        }

        if(key<root.data){
            root.left = dltNode(root.left, key);
        }
        else if(key>root.data){
            root.right = dltNode(root.right, key);
        }else{
            if((root.left == null)|| (root.right == null)){
                return null;
            }
            if(root.right == null){
                return root.left;
            }
            if(root.left == null){
                return root.right;
            }
            else{
                Node temp = getMinNode(root.right);
                root.data = temp.data;
                root.right = dltNode(root.right, temp.data);
            }
        }
        
        root.height = 1+Math.max(height(root.left),height(root.right));

        int bf = getBalance(root);

        if(bf>1 && key<root.left.data){
            return rightRotate(root);
        }
        if(bf<-1 && key >root.right.data){
            return leftRotate(root);
        }
        if(bf>1 && key>root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(bf<-1 && key<root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
        
    }
    
    public static void main(String arg[]){
        
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        
        preorder(root);


    }


}
