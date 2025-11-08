class Solution {
    class Pair{
        int first;
        int second;
        int time;
        Pair(int f,int s,int t){
            first=f;
            second=s;
            time=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> qt=new LinkedList<Pair>();
        int realFresh=0;
        int visited[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    qt.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }else {
                    visited[i][j]=0;
                }
                if(grid[i][j]==1) realFresh++;
            }
        }

        //bfs

        int tm=0;
        int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
        int rotten=0;
        while(!qt.isEmpty()){
            Pair curr=qt.remove();
            for(int d[]:dirs){
                int newr=curr.first+d[0];
                int newc=curr.second+d[1];
                int t=curr.time;
                tm=Math.max(tm,t);
                if(newr>=0 && newr<m 
                && newc>=0 && newc<n
                && grid[newr][newc]==1
                && visited[newr][newc]==0
                ){
                    qt.add(new Pair(newr,newc,t+1));
                    visited[newr][newc]=2;
                    rotten++;
                }

            }
        }

        if(realFresh!=rotten) return -1;
        return tm;
    }
}