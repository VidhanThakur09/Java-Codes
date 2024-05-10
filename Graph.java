import java.util.*;
import java.util.LinkedList;

public class Graph {
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
        // //0 edge
        // graph[0].add(new edge(0,1,1));
        // graph[0].add(new edge(0,2,1));
        // //1 edge
        // graph[1].add(new edge(1,0,1));
        // graph[1].add(new edge(1,3,1));
        // //2 edge
        // graph[2].add(new edge(2,0,1));
        // graph[2].add(new edge(2,4,1));
        // //3 edge
        // graph[3].add(new edge(3,1,1));
        // graph[3].add(new edge(3,4,1));
        // // 4 edge
        // graph[4].add(new edge(4,2,1));
        // graph[4].add(new edge(4,3,1));
        graph[0].add(new edge(0,3,1));
        graph[2].add(new edge(2,3,1));
        graph[3].add(new edge(3,1,1));
        graph[4].add(new edge(4,0,1));
        graph[4].add(new edge(4,1,1));
        graph[5].add(new edge(5,2,1));
        graph[5].add(new edge(5,0,1));

        
    }
    public static void DFS(ArrayList<edge>graph[]){
        boolean verify[] = new boolean[graph.length];
        for(int i = 0 ; i<graph.length;i++){
            if(!verify[i]){
                DFSUtil(graph, i, verify);
            }
        }
    }
    public static void DFSUtil(ArrayList<edge>graph[],int curr , boolean verify[]){
        System.out.println(curr+"");
        verify[curr] = true;

        for(int i = 0 ; i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!verify[e.dist]){
                DFSUtil(graph, e.dist, verify);
            }
        }
    }

    public static void BFS(ArrayList<edge>graph[]){
        boolean bfs_check[] = new boolean[graph.length];
        for(int i = 0 ; i<graph.length;i++){
            if(!bfs_check[i]){
                BFSUtil(graph, bfs_check);
            }
        }
    }
    public static void BFSUtil(ArrayList<edge>graph[],boolean bfs_check[]){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(graph[0].get(0).src);

        while(!q.isEmpty()){
            int value = q.poll();
            if(!bfs_check[value]){
                bfs_check[value] = true;
                System.out.println(value);
                for(int i = 0 ; i<graph[value].size();i++){
                    edge e=graph[value].get(i);
                    q.add(e.dist); 
                }
            }
        }
    }
    public static boolean path(ArrayList<edge>graph[],int src , boolean verify[] , int distony){
        if(src == distony ){
            return true;
        }
        verify[src] = true;

        for(int i = 0 ; i<graph[src].size();i++){
            edge e = graph[src].get(i);
            if(!verify[e.dist]&&path(graph, e.dist, verify, distony)){
                return true;
            }
        }
        return false;
    }
    public static boolean searchCycle(ArrayList<edge>graph[],int size){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0 ; i< graph.length;i++){
            if(!visited[i]){
                return searchCycleUtil(graph,visited,i,-1,size);
            }
        }
        return false;
    }
    public static boolean searchCycleUtil(ArrayList<edge>graph[],boolean verify[],int curr , int parent , int size){
        verify[curr] = true;

        for(int i = 0 ; i<graph[curr].size();i++){
            edge e = graph[curr].get(i);

            if(!verify[e.dist]){
                if(searchCycleUtil(graph, verify, e.dist, curr,size+1)){
                    return true;
                }
            }
            else if(verify[e.dist]&&e.dist!=parent){
                return true;
            }
        }
        return false;
    }

    public static boolean Bipartation(ArrayList<edge>graph[]){
        int Colorfill[]= new int[graph.length];
        for(int i = 0 ; i<Colorfill.length;i++){
            Colorfill[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i<graph.length;i++){
            if(Colorfill[i] == -1){ // No color
                
                q.add(i);
                Colorfill[i] = 0; // color yellow
                while(!q.isEmpty()){
                    int curr = q.remove(); //  > important to use REMOVE() not PULL() it will return error if not use properly
                    for(int j = 0 ; j<graph[curr].size();j++){
                        edge e = graph[curr].get(j);

                        if(Colorfill[e.dist] == -1){ // case 3
                            int nextColor = Colorfill[curr] == 0?1:0; // changing color to opposite color
                            Colorfill[e.dist] = nextColor;
                            q.add(e.dist);
                        }
                        else if(Colorfill[e.dist] == Colorfill[curr]){ // case 1
                            return false;
                        }
                        // case 2 continoue
                    }
                }
            }
        }
        return true;
    }
    public static boolean isBIPartite(ArrayList<edge> graph[]){
        int size = 0;
        if(searchCycle(graph,size)){
            if(size%2 == 0){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public static boolean isCyclic(ArrayList<edge>graph[]){
        boolean verify[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i = 0 ; i<graph.length;i++){
            return isCyclicUtil(graph,verify, i,stack);
        }
        return false;
    }
    public static boolean isCyclicUtil(ArrayList<edge>graph[],boolean verify[],int curr,boolean stack[]){
        verify[curr] = true;
        stack[curr] = true;

        for(int i = 0 ; i<graph[curr].size();i++){
            edge e = graph[curr].get(i);

            if(stack[e.dist]){
                return true;
            }
            else if(!verify[e.dist]&&isCyclicUtil(graph, verify, e.dist, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topSort(ArrayList<edge>graph[]){
        boolean verify[] = new boolean[graph.length];
        Stack<Integer>s = new Stack<>();
        for(int i = 0 ; i<graph.length;i++){
            if(!verify[i]){
                topSortUtil(graph,i,verify,s);
            }
        }
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void topSortUtil(ArrayList<edge>graph[],int curr,boolean verify[],Stack<Integer>s){
        verify[curr] = true;
        for(int i = 0 ; i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!verify[e.dist]){
                topSortUtil(graph, e.dist, verify, s);
            }
        }
        s.push(curr);
    }

    public static void inncomingCount(ArrayList<edge>graph[],int inncoming[]){
        for(int i=0;i<graph.length;i++){
            for(int j = 0 ;j<graph[i].size();j++){
                edge e = graph[i].get(j);
                inncoming[e.dist]++;
            }
        }
    }
    public static void topSortByBfs(ArrayList<edge>graph[]){
        int incoming[] = new int[graph.length];
        inncomingCount(graph, incoming);
        Queue<Integer>q = new LinkedList<>();

        for(int i = 0 ; i<incoming.length;i++){
            if(incoming[i]==0){
                q.add(i);
            }
        }
        //bst

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i = 0 ; i<graph[curr].size();i++){
                edge e = graph[curr].get(i);
                incoming[e.dist]--;
                if(incoming[e.dist]==0){
                    q.add(e.dist);
                }
            }
        }
    }

    public static void Allpath(ArrayList<edge>graph[],int src,int dest,String path){
        if(src == dest){
            System.out.println(path+dest);
        }
        
        for(int i = 0 ; i<graph[src].size();i++){
            edge e = graph[src].get(i);
            Allpath(graph, e.dist, dest, path+src);
        }
        
    }

    public static void main(String arg[]){
        int v = 6;
        ArrayList<edge>graph[] = new ArrayList[v];
        createGraph(graph);
        // System.out.println(isCyclic(graph));
        Allpath(graph,5,1,"");
    }
}
