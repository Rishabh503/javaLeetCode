class Pair{
     int first;
     int second ;
     Pair(int f,int s){
        this.first=f;
        this.second=s;
     }   
    }
class Solution {
    public int numEnclaves(int[][] grid) {
        // extract the variables 
        int m=grid.length;
        int n=grid[0].length;
        // lets make a visited array/
        int visited[][]=new int[m][n];
        //lets make the queue
        Queue<Pair> qt=new LinkedList<Pair>();
        // initlly adding all the pairs having corner 1 in the visited array as 1
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(grid[i][j]==1){
                        qt.add(new Pair(i,j));
                    visited[i][j]=1;
                    }
                }
            }
        }
        // now we do bfs and we wil mark all the joining ones as 1 in the visited array 
        //bfs
        int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
        while(!qt.isEmpty()){
            Pair curr=qt.remove();
            // 4 dishao me jana hai 
            for(int d[]:dirs){
                int newr=curr.first+d[0];
                int newc=curr.second+d[1];
                // ab ye agr rnage me hai to 
                if(newr<m && newr>=0 
                && newc<n && newc>=0
                && grid[newr][newc]==1 
                && visited[newr][newc]==0
                ){
                    qt.add(new Pair(newr,newc));
                    visited[newr][newc]=1;
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==0) count++;
            }
        }
        return count;
    }
}