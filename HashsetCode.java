import java.util.*;

public class HashsetCode {
    public static void countDist(int arr[]){
        HashSet<Integer>hs = new HashSet<>();
        for(int i : arr){
            hs.add(i);
        }
        System.out.println("The answer is "+hs.size());
    }
    public static void unionOfSet(int arr1[],int arr2[]){
        HashSet<Integer>hs = new HashSet<>();
        for(int i :arr1){
            hs.add(i);
        }
        for(int i :arr2){
            hs.add(i);
        }
        System.out.println("size is "+hs.size()+ " elements-> "+hs);
    }
    public static void intersectionOfSet(int arr1[],int arr2[]){
        HashSet<Integer>hs = new HashSet<>();
        int count=0;
        for(int i :arr1){
            hs.add(i);
        }
        for(int i :arr2){
            if(hs.contains(i)){
                count++;
                System.out.println(" elements-> "+i);
                hs.remove(i);
            }
        }
        System.out.println("size is "+count);
    }
    public static String findStart(HashMap<String,String>tickets){
        HashMap<String,String>revMap = new HashMap<>();
        for(String key:tickets.keySet()){
            revMap.put(tickets.get(key),key);
        }
        for(String key:tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    
    public static void maxSubarryWithzero(int arr[]){
        HashMap<Integer,Integer>hm = new HashMap<>();
        int length = 0;
        int sum = 0;
        for(int j = 0 ; j<arr.length;j++){
            sum+=arr[j];
            if(hm.containsKey(sum)){
                length = Math.max(length,j-hm.get(sum));
            }else{
                hm.put(sum,j);
            }
        }
        System.out.println("Max subarry with sum zero is "+length);
    }
    public static void maxSubarraySumK(int arr[],int k){
        HashMap<Integer,Integer>hm = new HashMap<>();
        int ans = 0;
        int sum = 0;
        hm.put(0,1);
        for(int i = 0 ; i<arr.length;i++){
            sum+=arr[i];
            if(hm.containsKey(sum-k)){
                ans+=hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum, 0)+1);
        }
        System.out.print("maxSubarraySumK is "+ans);
    }
    public static void main(String arg[]){
        // HashMap<String,String>tickets = new HashMap<>() ;
        // tickets.put("Chennai","Bengaluru");
        // tickets.put("Mumbai","Delhi");
        // tickets.put("Goa","Chennai");
        // tickets.put("Delhi","Goa");
        // String start = findStart(tickets);
        // System.out.print(start);
        // for(String key : tickets.keySet()){
        //     System.out.print("-> "+tickets.get(start));
        //     start = tickets.get(start);
        // }

        int arr[] = {10, 2, -2, -20, 10};
        maxSubarraySumK(arr, -10);
    }
}
