import java.util.*;
import java.util.LinkedList;
public class Dijkstra_algorithm{
    public static class edge{
        int src;
        int dist;
        int wt;
        edge(int s ,int  d , int w){
            this.src = s;
            this.dist = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<edge>graph[]){

        for(int i = 0; i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new edge(0,1,2));
        graph[0].add(new edge(0,2,4));

        graph[1].add(new edge(1,3,7));
        graph[1].add(new edge(1,2,1));

        graph[2].add(new edge(2,4,3));

        graph[3].add(new edge(3,5,1));

        graph[4].add(new edge(4,3,2));
        graph[4].add(new edge(4,5,5));
  
    }
    public static class pair implements Comparable<pair>{
        int node;
        int path;
        pair(int n,int path){
            this.node = n;
            this.path = path;
        }
        @Override
        public int compareTo(pair p2){
            return this.path-p2.path;
        }
    }
    public static void DijkstraALgo(ArrayList<edge>graph[],int src){
        int dist[] = new int [graph.length];
        boolean vist[] =  new boolean [graph.length];
        for(int i = 0 ; i<graph.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;///infinity in neighbors;
            }
        }
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src,0));
        while(!pq.isEmpty()){
            pair curr = pq.remove();
            if(!vist[curr.node]){
                vist[curr.node] = true;
                for(int i = 0 ; i<graph[curr.node].size();i++){
                    edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dist;
                    int w = e.wt;
                    if(dist[u]+w<dist[v]){
                        dist[v] = dist[u]+w;
                        pq.add(new pair(v,dist[v]));
                    }
                }
            }
        }
        for(int i = 0 ;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }


    public static void createGraph2(int flight[][],ArrayList<edge>graph[]){
        for(int i = 0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i<flight.length;i++){
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];
            graph[src].add(new edge(src,dest,wt));
        }
    }
    static class info{
        int node;
        int cost;
        int stop;

        info(int n,int c,int s){
            this.node = n;
            this.cost = c;
            this.stop = s;
        }
    }
    public static void cheapestFlight(
        int v,int flight[][],int src,int dest,int k){
            ArrayList<edge>graph[] = new ArrayList[v];
            createGraph2(flight, graph);

            int dist[] = new int[v];
            Queue<info>q = new LinkedList<>();

            for(int i = 0;i<dist.length;i++){
                if(i!=src){
                    dist[i] = Integer.MAX_VALUE;
                }
            }

            q.add(new info(src, 0, 0));

            while(!q.isEmpty()){
                info curr = q.remove();
                if(curr.stop>k){
                    break;
                }

                for(int i=0;i<graph[curr.node].size();i++){
                    edge e = graph[curr.node].get(i);

                    int s = e.src;
                    int destony = e.dist;
                    int weigth = e.wt;

                    if(curr.cost+weigth<dist[destony]&& curr.stop<=k){
                        dist[destony] = curr.cost+weigth;
                        q.add(new info(destony, dist[destony], curr.stop+1));
                    }
                }
            }

            if(dist[dest]== Integer.MAX_VALUE){
                System.out.print(-1);
            }else{
                System.out.print(dist[dest]);
            }
    }
    public static void main(String arg[]){
        int v = 4;
        int flight[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0,dest = 3,k=1;

        cheapestFlight(v, flight, src, dest, k);
    }
}