import java.util.*;

public class Tarjan_Algorithm {
    public static class edge{
        int src;
        int dest;
        edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<edge>graph[]){
        for(int i = 0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0,2));
        graph[0].add(new edge(0,3));

        graph[1].add(new edge(1,0));
        graph[1].add(new edge(1,2));

        graph[2].add(new  edge(2,0));
        graph[2].add(new  edge(2,1));

        graph[3].add(new edge(3,0));
        graph[3].add(new edge(3,4));
        graph[3].add(new edge(3,5));

        graph[4].add(new edge(4,3));
        graph[4].add(new edge(4,5));

        graph[5].add(new edge(5,3));
        graph[5].add(new edge(5,4));

    }
    public static void dfs(ArrayList<edge>graph[],boolean vis[],int dt[],int low[],int curr,int parent,int time){
        vis[curr] = true;
        dt[curr]=low[curr] = ++time;
        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(neigh == parent){
                continue;
            }
            else if(!vis[neigh]){
                dfs(graph, vis, dt, low, neigh, curr, time);
                low[curr] = Math.min(low[curr],low[neigh]);
                if(dt[curr]<low[neigh]){
                    System.out.println("bright: "+curr+" <-----> "+neigh);
                }
            }
            else if(vis[neigh]){
                low[curr] = Math.min(low[curr],dt[neigh]);
            }
        }
    }
    public static void trajanAlgo_Bridge(ArrayList<edge>graph[],int v){
        int dt[] = new int[v];
        int low[] = new int [v];
        boolean vist[] = new boolean [v];
        int time = 0;

        for(int i = 0;i<graph.length;i++){
            if(!vist[i]){
                dfs(graph, vist, dt, low, i, -1, time);
            }
        }
    }
    public static void dfsAP(ArrayList<edge>graph[],
                            boolean vis[],
                            boolean ap[],
                            int dt[],
                            int low[],
                            int curr,
                            int parent,
                            int time)
    {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for(int i = 0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(neigh == parent){
                continue;
            }
            else if(vis[neigh]){
                low[curr] = Math.min(low[curr],dt[neigh]);
            }else{
                dfsAP(graph, vis, ap, dt, low, neigh, curr, time);
                low[curr] = Math.min(low[curr],low[neigh]);
                if(parent !=-1 && dt[curr]<=low[neigh]){
                    ap[curr] = true;
                }
            }
            children++;
        }
        if(parent == -1 && children>1){
            ap[curr]=true;
        }
    }
    public static void articulationPoint(ArrayList<edge>graph[],int v){
        int dt[] = new int[v];
        int low[] = new int[v];
        boolean visted[] = new boolean[v];
        boolean ap[] = new boolean[v];
        int time = 0;

        for(int i = 0;i<graph.length;i++){
            if(!visted[i]){
                dfsAP(graph, visted, ap, dt, low, i, -1, time);
            }
        }
        for(int i = 0;i<ap.length;i++){
            if(ap[i]){
                System.out.println("AP : "+ i);
            }
        }
    }
    public static void main(String arg[]){
        int v = 6;
        ArrayList<edge>graph[] = new ArrayList[v];
        createGraph(graph);
        articulationPoint(graph, v);
    }
}
