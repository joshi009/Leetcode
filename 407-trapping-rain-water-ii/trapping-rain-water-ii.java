class Solution {
    static class Cell{
            int x, y, height;
            Cell(int x,int y, int height){
                this.x=x;
                this.y=y;
                this.height=height;
            }
    }

    public int trapRainWater(int[][] heightMap) {

        //Row ka length
        int m=heightMap.length;

        //Column ka length
        int n=heightMap[0].length;

        //Base Case - cell is smaller than 3*3 bcz water can't store in 2*2 matrix
        if(n<=2 || m<=2) return 0;
        
        //Create minHeap
        PriorityQueue<Cell> minHeap=new PriorityQueue<>((a,b)->a.height-b.height);

        //Create visited array
        boolean[][] visited=new boolean[m][n];

        //Push all boundary cells in minHeap
        //Push first and last column-vertical boudary
        for(int i=0;i<m;i++){
            visited[i][0]=true ;
            minHeap.offer(new Cell(i , 0 , heightMap[i][0]));
            visited[i][n-1]=true;
            minHeap.offer(new Cell(i , n-1 , heightMap[i][n-1]));
        } 
        //Push first and last row-horizontal boundary
        for(int i=0;i<n;i++){
            visited[0][i]=true ;
            minHeap.offer(new Cell(0 , i, heightMap[0][i]));
            visited[m-1][i]=true;
            minHeap.offer(new Cell(m-1 , i , heightMap[m-1][i]));
        }        
        //Define directions-down,up,right,left
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        int trappedWater=0;

        //Process heap
        while(!minHeap.isEmpty()){

           //poll the minimum cell
           Cell curr=minHeap.poll(); //0,0

           //find its neighbours 
           for(int[] dir:directions){ //i={1,0}
            int nx=curr.x+dir[0];  //nx=0+1=1 
            int ny=curr.y+dir[1];  //ny=0+0=0
           

           //if the cell is outside the boundary or already visited then continue;
            if (nx<0 || nx>=m || ny<0 || ny>=n || visited[nx][ny]) {
                 continue;
            }
            
            visited[nx][ny]=true;

            // If neighbor is lower, water can be trapped
            if(curr.height>heightMap[nx][ny]){ 
                trappedWater+= curr.height-heightMap[nx][ny];
            }

            //push that cell with updated height in minHeap
            minHeap.offer(new Cell(nx ,ny, Math.max(curr.height , heightMap[nx][ny])));
           }
        }
        return trappedWater;
    }
}