import java.util.*;
import java.util.LinkedList; // Important verrry verrry
public class HashmapCode{
    public static void majorityElemet(int arr[]){
        HashMap<Integer, Integer>hm = new HashMap<>();
        for(int i = 0 ; i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(hm.get(arr[i]), 0)+1);
        }
        int n = arr.length;
        for(Integer k:hm.keySet()){
            if(hm.get(k)>n/3){
                System.out.print(k);
            }
        }
    }
    public static boolean validAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i = 0 ; i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(map.get(ch), 0)+1);
        }
        for(int i = 0 ; i<t.length();i++){
            char ch = t.charAt(i);
            if(map.get(ch)!=null){
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
    
    public static void main(String arg[]){
        int arr[] = {1,3,2,5,1,3,1,5,1};
        String s = "race";
        String t = "cark";
        System.out.println(validAnagram(s, t));
    }
}