import java.util.*;
import java.util.ArrayList;

public class Kruskal_Algorithm {
    public static class edge implements Comparable<edge>{
        int src;
        int dest;
        int wt;

        edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        @Override
        public int compareTo(edge e2){
            return this.wt-e2.wt;
        }
    }
    public static void createGraph(ArrayList<edge>edges){
        edges.add(new edge (0,1,10));
        edges.add(new edge(0,2,15));
        edges.add(new edge(0,3,30));
        edges.add(new edge(1,3,40));
        edges.add(new edge(2,3,50));
    }
    static int n = 4;
    static int parent[] = new int [n];
    static int rank[] = new int [n];

    public static void inIt(){
        for(int i =0;i<parent.length;i++){
            parent[i] = i;
        }
    }
    public static int find(int X){
        if(parent[X] == X){
            return X;
        }
        return parent[X]=find(parent[X]);
    }
    public static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            parent[parB] = parA;
            rank[parA]++;
        }
        if(rank[parA] > rank[parB]){
            parent[parB] = parA;
        }else{
            parent[parA] = parB;
        }
    }
    public static void Kruskal_Algo(ArrayList<edge>edges,int v){
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;

        for(int i=0;count<v-1;i++){
            edge e = edges.get(i);
            // e.src , e.dest , e.wt
            int parA = find(e.src);
            int parB = find(e.dest);
            if(parA!=parB){ // to check for cycles;
                mstCost+=e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }
    public static void main(String arg[]){
        inIt();
        int v = 4;
        ArrayList<edge>edges = new ArrayList<>();
        createGraph(edges);
        Kruskal_Algo(edges,v);
    }
}
