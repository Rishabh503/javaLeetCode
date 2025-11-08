class Solution {
    class Pair{
        int first;
        int second;
        Pair(int f,int  s){
            first=f;
            second=s;
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        boolean[][] isVisited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!isVisited[i][j] && grid[i][j]=='1'){
                    bfs(grid,isVisited,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void bfs(char[][] grid,boolean[][] isVisited,int row,int col){
        int rowLen=grid.length;
        int colLen=grid[0].length;
        int dirs[][]={{0,1},{0,-1},{1,0},{-1,0}};

        Queue<Pair> qt=new LinkedList<Pair>();
        qt.add(new Pair(row,col));
        isVisited[row][col]=true;

        while(!qt.isEmpty()){
            Pair curr=qt.remove();
            for(int d[]:dirs){
                int newr=curr.first+d[0];
                int newc=curr.second+d[1];

                if(newr>=0 && newr<rowLen &&
                    newc>=0 && newc<colLen &&
                    !isVisited[newr][newc] &&
                    grid[newr][newc]=='1'
                ){
                    qt.add(new Pair(newr,newc));
                    isVisited[newr][newc]=true;
                }

            }
        }
    }
}