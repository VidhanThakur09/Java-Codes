import java.util.*;



public class Kosaraju_Algorithm {
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
        graph[2].add(new  edge(2,1));
        graph[3].add(new edge(3,4));
    }
    public static void topoSort(ArrayList<edge>graph[],int curr,boolean vis[],Stack<Integer>s){
        vis[curr] = true;
        for(int i = 0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topoSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<edge>graph[],boolean vis[],int curr){
        vis[curr] = true;
        System.out.print(curr+" ");
        for(int i = 0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,vis,e.dest);
            }
        }  
    }
    public static void KosarajuAlgo(ArrayList<edge>graph[],int v){
        //step 1;
        Stack<Integer>s = new Stack<>();
        boolean vis[] = new boolean[v];

        for(int i = 0;i<graph.length;i++){
            if(!vis[i]){
                topoSort(graph, i, vis, s);
            }
        }

        //step 2;

        ArrayList<edge>graphTrav[] = new ArrayList[v];
        for(int i = 0;i<graph.length;i++){
            graphTrav[i] = new ArrayList<>();
            vis[i] = false;
        }
        for(int i =0;i<graph.length;i++){
            for(int j = 0;j<graph[i].size();i++){
                edge e = graph[i].get(j);
                graphTrav[e.dest].add(new edge(e.dest, e.src));
            }
        }

        // step 3;

        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                System.out.print("SCC -> ");
                dfs(graphTrav, vis, curr);
                System.out.println();
            }
        }
    }
    public static void main(String arg[]){
        int v = 5;
        ArrayList<edge>graph[] = new ArrayList[v];
        createGraph(graph);
        KosarajuAlgo(graph,v);
    }
}
