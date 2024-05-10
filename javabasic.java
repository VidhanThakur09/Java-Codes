import java.util.*;
public class javabasic{
    public static void printarr(int arr[]){
        System.out.print("[");
        for(int i = 0; i<arr.length;i++){
            
            System.out.print(arr[i]+" ");
            
        }
        System.out.print("]");
    }
    public static int getkey(int arr[],int key){
        for(int i = 0 ; i<arr.length-1;i++){
            if(arr[i]==key){
                return i;
            }
        }return -1;
    }
    public static int largest(int arr[]){
        int larg = Integer.MIN_VALUE;
        for(int i = 0 ; i<=arr.length-1;i++){
            if(arr[i]>larg){
                larg = arr[i];
            }
        }return larg;
    }
    public static int smallest(int arr[]){
        int small = Integer.MAX_VALUE;
        for(int i = 0 ; i<=arr.length-1;i++){
            if(arr[i]<small){
                small = arr[i];
            }
        }return small;
    }
    public static int binarysearch(int arr[],int key){
        int start = 0;
        int end = arr.length;
        
        while(start<end){
            int mid = (start+end)/2;
            if(arr[mid]==key){
                return mid;
            }
            if(arr[start]<key&&key<arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }return -1;
    }
    public static void reversearr(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
    }
    public static void pairarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            int curr = arr[i];
            for(int j = i;j<arr.length;j++){
                System.out.print("{"+curr+" "+arr[j]+"}");
            }System.out.println();
        }
    }
    public static void subpair(int arr[]){
        for(int i = 0;i<arr.length;i++){
            for(int j = i ;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]);
                }System.out.println();
            }System.out.println();
        }
    }
    public static int subpairsum(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            
            for(int j = i ;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum +=arr[k];
                }if(sum>largest){
                    largest=sum;
                }
                
            }
        }return largest;
    }
    public static int prefixarr(int arr[]){
        int largest = Integer.MIN_VALUE;
        int prefixarr[]=new int[arr.length];
        prefixarr[0]= arr[0];
        for(int i = 1 ;i<arr.length;i++){
            prefixarr[i]= prefixarr[i-1]+arr[i];

        }for(int i = 0;i<arr.length;i++){
            for(int j = i;j<=arr.length-1;j++){
                int temp = i==0?prefixarr[j]:prefixarr[j]-prefixarr[i-1];
                if(temp>largest){
                    largest =temp;
                }
            }
        }return largest;
    }
    public static int kadancerule(int arr[]){
        int largest = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum=sum+arr[i];
            System.out.println("array at ith possition ->"+arr[i]);
            System.out.println("sum ->"+sum);
            if(sum<0){
                sum = 0;
            }
            largest= Math.max(largest,sum);
            System.out.println("largest ->"+largest);
        }return largest;
    }
    public static int taapingrainwater(int height[]){
        int leftmax[] = new int[height.length];
        leftmax[0] = height[0];
        int rightmax[]= new int [height.length];
        rightmax[height.length-1] = height[height.length-1];
        //left max
        for(int i = 1 ;i<height.length;i++){
            leftmax[i] = Math.max(leftmax[i-1],height[i]);
        }
        //right max
        for(int i=height.length-2;i>=0;i--){
            rightmax[i] = Math.max(rightmax[i+1],height[i]);
        }
        //trap water
        int trapwater = 0;
        for(int i= 0 ; i<height.length;i++){
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            trapwater += waterlevel-height[i];
        }return trapwater;


    }
    public static int highstock(int arr[]){
        int buyprice = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            if(buyprice<arr[i]){
                int profit = arr[i]-buyprice;
                max = Math.max(max,profit);
            }else{
                buyprice = arr[i];
            }
        }return max;


    }
    public static int reverbarr(int arr[],int target){
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[start]<arr[mid]){

                if(arr[start]<=target&&target<=arr[mid]){
                    end = mid-1;

                }else{
                    start = mid+1;
                } 
            }else{
                if(arr[end]>=target&&target>=arr[mid]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
            
        }return-1;
    }
    public static void Bubble_Sort(int arr[]){
        int sort = 0;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]= arr[j];
                    arr[j]=temp;sort++;
                }
            }
            if(sort == 0){
                break;
            }
            
        }
    }
    public static void selectsort(int arr[]){
        for(int i = 0;i<arr.length;i++){
            int store = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[store]>arr[j]){
                    store = j;
                }
            }
            int temp = arr[store];
            arr[store]=arr[i];
            arr[i]= temp;
        }
    }
    public static void insertion_sort(int arr[]){
        for(int i = 1;i<arr.length;i++){
            int current = arr[i];
            int prevous = i-1;
            while(prevous>=0&&arr[prevous]>current){
                //here we will be shifting larger element forward
                arr[prevous+1] = arr[prevous];
                prevous--;
            }//here we are shifting small element backword
            arr[prevous+1] = current;
        }
    }
    public static void countersort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i = 0 ; i<arr.length;i++){
            if(largest<arr[i]){
                largest = arr[i];
            }
        }
        int frequency[]= new int[largest+1];
        for(int i = 0;i<arr.length;i++){
            frequency[arr[i]]++;

        }
        int j =0;
        for(int i = 0;i<arr.length;i++){
            while(frequency[i]>0){
                arr[j]=i;
                frequency[i]--;j++;
            }
        }

    }

    // 2d arrays
    public static void prinf2d(int arr[][]){
        for(int i = 0 ; i<arr.length;i++){
            for(int j = 0; j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
    }
    public static int larger(int arr[][]){
        int larger = Integer.MIN_VALUE;
        for(int i = 0 ; i<arr.length;i++){
            for(int j = 0; j<arr[i].length;j++){
                if(arr[i][j]>larger){
                    larger = arr[i][j];
                }
                
                
            }
        }return larger;
    }
    public static int small(int arr[][]){
        int smaller = Integer.MAX_VALUE;
        for(int i = 0 ; i<arr.length;i++){
            for(int j = 0; j<arr[i].length;j++){
                if(arr[i][j]<smaller){
                    smaller = arr[i][j];
                }
                
                
            }
        }return smaller;
    }
    public static void spiral_matrix(int arr[][]){
        int Startrow = 0;
        int Startcolumn = 0;
        int Endrow = arr.length-1;
        int Endcolumn = arr.length-1;

        while(Startrow<=Endrow&&Startcolumn<=Endcolumn){
            for(int i = Startcolumn ;i<=Endcolumn;i++){
                System.out.print(arr[Startrow][i]);
            }
            for(int i = Startrow+1;i<=Endrow;i++){
                System.out.print(arr[i][Startcolumn]);
            }
            for(int i = Endcolumn-1;i>=Startcolumn;i++){
                if(Startrow==Endrow){
                    break;
                }
                System.out.print(arr[Endrow][i]);
            }
            for(int i = Endrow-1;i>=Startrow;i++){
                if(Startcolumn==Endcolumn){
                    break;
                }
                System.out.print(arr[i][Endcolumn]);
            }
            System.out.println();
            Startcolumn++;
            Startrow++;
            Endcolumn++;
            Endrow++;
        }
    }
    public static int sum_of_diginal(int arr[][]){
        int sum = 0 ;
        for( int i = 0 ; i<arr.length;i++){
            sum+=arr[i][i];
            if(i!=arr.length-1-i){
                sum+=arr[i][arr.length-1-i];
            }
        }return sum;
    }
    public static boolean searchkey(int arr[][],int key){
        int row = 0; int column = arr.length-1;
        while(row<=arr.length-1&&column>=0){
            if(arr[row][column]==key){
                System.out.print("["+row+" "+column+"]");return true;
            }
            else if(key<arr[row][column]){
                column--;
            }else{
                row++;
            }
        }
        System.out.print("not found");
        return false;
    }
    public static boolean searchkey2(int arr[][],int key){
        int row = arr.length-1; int column = 0;
        while(row>=0&&column<=arr.length-1){
            if(arr[row][column]==key){
                System.out.print("["+row+" "+column+"]");return true;
            }
            else if(key<arr[row][column]){
                row--;;
            }else{
                column++;
            }
        }
        System.out.print("not found");
        return false;
    }
    public static void trampos2d(int arr[][]){
        
    }
    public static void indexstr(String str){
        for(int i = 0;i<str.length();i++){
            System.out.println(str.charAt(i));
        }
    }
    public static boolean palafrom(String str){
        int n = str.length();
        for(int i =0;i<n/2;i++){
            if(str.charAt(i)!=str.charAt(n-1-i)){
                return false;
            }
        }return true;
    }
     public static float shoertestdis(String str){
        int x,y;
        x = 0;y=0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)=='N'){
                y++;
            }else if(str.charAt(i)=='S'){
                y--;
            }else if(str.charAt(i)=='E'){
                x++;
            }else{
                x--;
            }
        }
        int x2 = x*x;int y2 = y*y;
        
        float sum = (float)(Math.sqrt(x2+y2));
        return sum;
     }
     public static void substr(String str,int start,int end){
        StringBuilder build = new StringBuilder();
        for(int i = start;i<end;i++){
            build.append(str.charAt(i));
        }
        System.out.print(build.toString());
     }
     public static void lartgest(String str[]){
        String largest = str[0];
        for(int i = 1;i<str.length;i++){
            if(largest.compareToIgnoreCase(str[i])<0){
                largest = str[i];
            }
        }System.out.print(largest);
     }
     public static void uppercase(String str){
        StringBuilder build = new StringBuilder();
        char ch = str.charAt(0);
        build.append(Character.toUpperCase(ch));
        for(int i = 1;i<str.length();i++){
            if((i<str.length()-1)&&str.charAt(i)==' '){
                build.append(str.charAt(i));
                i++;build.append(Character.toUpperCase(str.charAt(i)));
            }else{
                build.append(str.charAt(i));
            }
            
        }
        System.out.print(build.toString());
     }
     public static void campress(String str){
        
        StringBuilder build = new StringBuilder();
        for(int i = 0;i<str.length();i++){
            Integer count =1;
            while(i<str.length()-1&&str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            build.append(str.charAt(i));
            if(count>1){
                build.append(count.toString());
            }
        }System.out.print(build.toString());
     }
     public static void odd_even_bit(int n){
        if((n & 1 )==1){
            System.out.print("odd");
        }else{
            System.out.print("even");
        }
     }
     public static int get_ith(int n,int i){ 
        int one = 1<<i;
        if((n&one)==0){return 0;}else{return 1;}
     }
     public static int set_ith(int n,int i){
        return ((n|1<<i));
     }
     public static int clear_ithbit(int n,int i){
        return(n^1<<i);
     }
     public static int update_ithbit(int n , int i, int nc ){
        if(nc == 0){return(clear_ithbit(n, i));}else{return(set_ith(n, i));}
     }
     public static int clear_last_ithbit(int n,int i){
        return(n&(~0<<i));
     }
     public static int clear_range(int n,int i, int j){
        int ith = 1<<i;
        int jth = 1<<j;
        return(n&~(ith|jth));
     }
     public static boolean check_power_2(int n){
        if((n&n-1)==0){
            return true;
        }else{return false;}
     }
     public static int set_bit(int n){
        int count = 0;
        while(n!=0){
            if((n&1)==1){
                count++;
            }n=n>>1;
        }return count;
     }public static int fast_expon(int n , int power){
        int ans =1;
        while(power!=0){
            if((power&1)==1){
                ans *=n;
            }
            n=n*n;
            power=power>>1;
        }return ans;
     }
     public static void swap_2_without_extra_varable(int n , int n2){
        n = n^n2;
        n2 = n2^n;
        n=n^n2;
        System.out.print("A = "+n +" , "+"B = "+n2);
     }
     public static int add_1(int n){
        return(-~n);
     }
    //  1.Lower to Upper Case This method simply subtracts a 
    // value of 32 from the ASCII value of lowercase letter 
    // by Bitwise ANDing (&) with negation (~) of 32 
    // converting the letter to uppercase. 
    
     public static void lowercase_uppercase_alphbate(){
        for(char i = 'a';i<='z';i++){
            System.out.println((char)(i&~32));
        }
     }

     public static void uppercase_lowercase_alphbate(){
        for(char i = 'A';i<='Z';i++){
            System.out.println((char)(i|' '));
        }
     }


    public static void main(String arg[]){
        Scanner scan = new Scanner(System.in);
        
        // 
        String s= "vidhan";
        String s2 = new String("vidhan");
        // String s3 = s2.intern();
        // System.out.print(add_1(5 ));
        // swap_2_without_extra_varable(5, 3);
        
        
            
        
        
        
        
        
        


        


    }
}