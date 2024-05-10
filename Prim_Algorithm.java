import java.util.*;
public class Prim_Algorithm {
    public static class edge{
        int src;
        int dest;
        int wt;
        edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<edge>graph[]){
        for(int i = 0 ;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0,1,10));
        graph[0].add(new edge(0,2,15));
        graph[0].add(new edge(0,3,30));

        graph[1].add(new edge(1,0,10));
        graph[1].add(new edge(1,3,40));

        graph[2].add(new edge(2,0,15));
        graph[2].add(new edge(2,3,50));

        graph[3].add(new edge(3,1,40));
        graph[3].add(new edge(3,2,50));
        
    }
    public static class pair implements Comparable<pair>{
        int v;
        int c;
        pair(int v,int c){
            this.v = v;
            this.c = c;
        }
        @Override
        public int compareTo(pair p2){
            return this.c-p2.c;
        }
    }
    public static void primsAlgo(ArrayList<edge>graph[]){
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<pair>pq = new PriorityQueue<>();
        int minCost = 0;
        // ArrayList<edge> minCostedge = new ArrayList<>(); // for edge printing case
        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            pair curr = pq.poll();
            if(!visited[curr.v]){
                visited[curr.v] = true;
                minCost+=curr.c;
                // minCostedge.add(new edge(curr.v,0,curr.c)); // for edge printing case
                for(int i = 0 ;i<graph[curr.v].size();i++){
                    edge e= graph[curr.v].get(i);
                    pq.add(new pair(e.dest,e.wt));
                }
            }
        }
        // for(edge e:minCostedge){ // for edge printing case
        //     System.out.println("the min cost is > "+e.wt);
        // }
        System.out.println("the min cost is > "+minCost);
    }
    static class connection implements Comparable<connection>{
        int dest;
        int cost;
        connection(int d,int c){
            this.dest=d;
            this.cost=c;
        }
        @Override
        public int compareTo(connection c2){
            return this.cost-c2.cost;
        }
    }
    public static void connectingCities(int cities[][]){
        boolean visited[] = new boolean[cities.length];
        PriorityQueue<connection>pq = new PriorityQueue<>();
        int finalCost = 0;

        pq.add(new connection(0,0));
        while(!pq.isEmpty()){
            connection curr = pq.remove();
            if(!visited[curr.dest]){
                visited[curr.dest] = true;
                finalCost+=curr.cost;

                for(int i = 0 ;i<cities[curr.dest].length;i++){
                    if(cities[curr.dest][i]!=0){
                        pq.add(new connection(i,cities[curr.dest][i]));
                    }
                    
                }
            }
        }System.out.println("the min cost is > "+finalCost);
    }
    public static void main(String arg[]){
        int cities[][] = {{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        connectingCities(cities);
    }
}
