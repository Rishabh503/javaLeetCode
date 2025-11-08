class Solution {
    class Pair{
        int first;
        int second;
        Pair(int f,int s){
            first=f;
            second=s;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int val=image[sr][sc];
         if (val == color) return image;
        Queue<Pair> qt=new LinkedList<Pair>();
        image[sr][sc]=color;
        qt.add(new Pair(sr,sc));
        while(!qt.isEmpty()){
            Pair curr=qt.remove();
            int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
            for(int d[]:dirs){
                int newr=curr.first+d[0];
                int newc=curr.second+d[1];
                if(newr>=0 && newr<m 
                && newc>=0 && newc<n
                && image[newr][newc]==val
                ){
                    qt.add(new Pair(newr,newc));
                    image[newr][newc]=color;
                }
            }
        }
        return image;
    }
}