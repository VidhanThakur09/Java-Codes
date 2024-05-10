public class Disjoint_Set_Union_Algorithm {
    static int n = 7; 
    static int parent[] = new int [n];
    static int rank[] = new int [n];

    public static void inIt(){
        for(int i = 0;i<parent.length;i++ ){
            parent[i] = i;
        }
    }
    public static int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    public static void union(int A,int B){
        int parA =  find(A);
        int parB = find(B);

        if(rank[parA]==rank[parB]){
            parent[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA]<rank[parB]){
            parent[parA] = parB;
        }else{
            parent[parB] = parA;
        }
    }
    public static void main(String arg[]){
        inIt();
        System.out.println(find(3));
        union(1,3);
        find(3);
        union(2,4);
        union(3,6);
        System.out.println(find(6));
        union(1,4);
        union(1,5);
        System.out.println(find(5));
        

    }
}
