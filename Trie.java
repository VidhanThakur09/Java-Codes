import java.util.*;
public class Trie {
    public static class Node{
        Node child[] = new Node[26];
        Boolean eow = false ;
        int frequency; 

        Node(){
            for(int i = 0 ; i< 26 ; i++){
                child[i] = null;
            }
            // frequency = 1;
        }
    }
    public static Node root = new Node();
    // public static void insert(String s){
    //     Node curr = root;
    //     for(int i = 0 ; i<s.length();i++){
    //         int idx = s.charAt(i)-'a';
    //         if(curr.child[idx]==null){
    //             curr.child[idx] = new Node();
    //         }else{
    //             curr.child[idx].frequency++;;
    //         }
    //         curr = curr.child[idx];
    //     }
    //     curr.eow = true;
    // }
    // public static void shortestPrefix(Node root , String ans){
    //     if(root == null){
    //         return;
    //     }
    //     if(root.frequency == 1){
    //         System.out.println(ans);
    //         return;
    //     }
    //     for(int i = 0;i<root.child.length;i++){
    //         if(root.child[i]!=null){
    //             shortestPrefix(root.child[i], ans+(char)(i+'a'));

    //         }
    //     }
    // }
    public static void insert(String s){
        Node curr = root;
        for(int level = 0 ; level<s.length();level++){
            int idx = s.charAt(level)-'a';
            if(curr.child[idx]==null){
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
        }
        curr.eow = true;
    }
    public static boolean search(String key){
        Node curr = root;
        for(int level = 0 ; level<key.length();level++){
            int idx = key.charAt(level)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr = curr.child[idx];
        }
        return curr.eow == true;
    }

    public static boolean wordbreaker(String key){
        if(key.length()==0){
            return true;
        }
        for(int i = 1;i<=key.length();i++){
            if(search(key.substring(0,i))&&wordbreaker(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static boolean startWithPref(String pref){
        Node curr = root;
        for(int i = 0 ; i<pref.length();i++){
            int idx = pref.charAt(i)-'a';
            if(curr.child[idx] == null){
                return false;
            }
            curr = curr.child[idx];
        }
        return true;
    }
    public static int countNode(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i = 0 ; i<root.child.length;i++){
            if(root.child[i]!=null){
                count+=countNode(root.child[i]);
            }
        }
        return count+1;
    }
    public static String ans = "";
    public static void longestPrefix(Node root, StringBuilder temp){
        if(root == null){
            return;
        }
        for(int i = 0 ; i<root.child.length;i++){
            if(root.child[i]!=null&&root.child[i].eow==true){
                char c = (char)(i+'a');
                temp.append(c);
                if(temp.length()>ans.length()){
                    ans = temp.toString();
                }
                longestPrefix(root.child[i], temp);
                temp.deleteCharAt(temp.length()-1); // backtrackes
            }
        }
    }
    public static void main(String arg[]){
        String arr[] = {"a" , "banana", "app", "appl", "ap", "apply", "apple"};
        for(int i = 0 ; i<arr.length;i++){
            insert(arr[i]);
        }
        longestPrefix(root,new StringBuilder(""));
        System.out.println(ans);
    }    
}
