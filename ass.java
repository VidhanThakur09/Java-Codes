import java.util.*;
import java.util.LinkedList;

import javax.management.Query;


public class ass {
    public static class edge{
        int src;
        int dest;
        int wt;
        edge(int s , int d , int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<edge>graph[]){
        for(int i = 0 ;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0,1,1));
        graph[0].add(new edge(0,3,1));
        graph[1].add(new edge(1,2,1));
        graph[2].add(new edge(2,0,1));
        graph[2].add(new edge(2,1,1));
        graph[3].add(new edge(3,0,1));
        graph[3].add(new edge(3,4,1));
        graph[4].add(new edge(4,3,1));
    }
    public static boolean detectCycle(ArrayList<edge>graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0 ;i<graph.length;i++){
            if(!visited[i]){
                return detectCycleUtil(graph, i, -1,visited);
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<edge>graph[],int src,int parent,boolean visited[]){
        Queue<Integer>q = new LinkedList<>();
        q.add(src);
        visited[src] = true;
        
        while(!q.isEmpty()){
            int curr = q.remove();
            
            for(int i = 0;i<graph[curr].size();i++){
                edge e = graph[curr].get(i);
                
                if(!visited[e.dest]){
                    visited[e.dest] = true; q.add(e.dest);
                    detectCycleUtil(graph, e.dest, curr, visited);
                }
                else if(visited[e.dest]&&e.dest!=parent){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String arg[]){
        int v = 5;
        ArrayList<edge>graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.print(detectCycle(graph));
    }
}
