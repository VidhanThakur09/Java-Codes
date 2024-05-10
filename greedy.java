import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class greedy {

    public static void Activity(int s[],int e[]){
        int tdarr[][]=new int [s.length][3];
        for(int i = 0;i<s.length;i++){
            tdarr[i][0]=i;
            tdarr[i][1]=s[i];
            tdarr[i][2]=e[i];
        }
        //Lambda is java comparator for sorting arrayin sort time period
        //why we are using this 
        // we are using this to sort our 2darray base on ending time so that we can perform our algorithem to find best solution
        //-----------------------------------
        Arrays.sort(tdarr,Comparator.comparingDouble(o->o[2]));
        //-----------------------------------

        ArrayList<Integer>arr=new ArrayList<>();
        
        // when end array is not sorted
        // arr.add(tdarr[0][0]);
        // int maxcount = 1;
        // int prevend = tdarr[0][2];
        // for(int i = 1;i<e.length;i++){
        //     if(tdarr[i][1]>=prevend){
        //         maxcount++;
        //         arr.add(tdarr[i][0]);
        //         prevend=tdarr[i][2];
        //     }
        // }

        // when end array is sorted
        arr.add(0);
        int maxcount = 1;
        int prevend = e[0];
        for(int i = 1;i<e.length;i++){
            if(s[i]>=prevend){
                maxcount++;
                arr.add(i);
                prevend=e[i];
            }
        }
        System.out.println("COunt"+maxcount+" ");
        for(int i=0;i<arr.size();i++){
            System.out.print("A"+arr.get(i)+" ");
        }
    }
    public static void knapsack(int value[], int weight[] ,int n){
        double arr[][]=new double [value.length][2];
        for(int i=0;i<value.length;i++){
            arr[i][0]=i;
            arr[i][1]=(double)(value[i]/weight[i]);
        }
        int capacity = n;
        int ans = 0;
        Arrays.sort(arr,Comparator.comparingDouble(o->o[1]));
        for(int i =arr.length-1;i>=0;i--){
            int index = (int)arr[i][0];
            if(capacity>=weight[index]){
                capacity=capacity-weight[index];
                ans += value[index];
            }
            else{
                ans+=(int)arr[i][1]*capacity;
            }
        }
        System.out.println("total profit is "+ans);

    }
    public static void absoluteDiffrence(int arr1[],int arr2[]){
        Arrays.sort(arr1);Arrays.sort(arr2);
        int ans=0;
        for(int i = 0; i<arr1.length;i++){
            ans +=Math.abs(arr1[i] - arr2[i]);
        }
        System.out.println("absolute diffrence is "+ans);
    }
    public static void rope(int arr[][]){
        Arrays.sort(arr,Comparator.comparingDouble(o->o[1]));
        int lastend = arr[0][1];
        int ans =  1;
        for(int i = 1;i<arr.length;i++){
            if(arr[i][0]>lastend){
                ans++;
                lastend = arr[i][1];
            }
        }
        System.out.println(ans);
    }
    public static void coins(int target,Integer arr[]){
        Arrays.sort(arr, Comparator.reverseOrder());
        int count = 0;
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<=target){
                while(arr[i]<=target){
                    target -=arr[i];
                    count++;
                    arrl.add(arr[i]);
                }
            }
        }
        System.out.println("no.of coins "+count);
        for(int i  = 0;i<arrl.size();i++){
            System.out.print(arrl.get(i)+" ");
        }
    }
    static class job{
        int idx;
        int deadline;
        int profit;
        public job(int i , int d , int p){
            this.idx = i;
            this.deadline = d;
            this.profit = p;

        }
    }
    
    public static void jobSequence(int arr[][]){
        int time = 0;
        ArrayList<job>jobs =new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            jobs.add(new job(i,arr[i][0],arr[i][1]));
        }
        Collections.sort(jobs,(obj1,obj2)->(obj2.profit-obj1.profit));//dec
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<jobs.size();i++){
            job curr = jobs.get(i);
            if(curr.deadline>time){
                time++;
                ans.add(curr.idx);
            }
        }
        System.out.println("time : "+ time);
        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    public static void chocolatebar(Integer virtical[],Integer horizontal[]){
        Arrays.sort(virtical,Comparator.reverseOrder()); Arrays.sort(horizontal,Comparator.reverseOrder());
        int h = 0; int v = 0;
        int hp=1;int vp = 1;
        int cost=0;
        while(h<horizontal.length&&v<virtical.length){
            if(virtical[v]<=horizontal[h]){
                cost += horizontal[h]*vp;
                h++;hp++;
            }
            else{
                cost += virtical[v]*hp;
                v++;vp++;
            }
        }
        while(h<horizontal.length){
            cost += horizontal[h]*vp;
                h++;hp++;
        }
        while(v<virtical.length){
            cost += virtical[v]*hp;
            v++;vp++;
        }
        System.out.println("the cost of the pices "+cost);
    }
    public static int kthodd(int arr[],int k){
        if(k<=0){
            return 0;
        }
        int l = arr[0];int r = arr[1];
        if((r&1)>0){
            int count = (int)Math.ceil((r-l+1)/2);
            if(k>count){
                return 0;
            }
            else{
                return (r-2*k+2);
            }
        }else{
            int count = ((r-l+1)/2);
            if(k>count){
                return 0;
            }
            else{
                return (r-2*k+1);
            }

        }
    }
    public static void main(String arg[]){
        int arr[]={-10,10};
        int k = 8;
        System.out.println(kthodd(arr, k));
    }
}

