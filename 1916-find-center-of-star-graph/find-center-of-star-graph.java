class Solution {
    public int findCenter(int[][] edges) {
        int a=edges[0][0];
        int b=edges[0][1];
        if(a==edges[1][0] || b==edges[1][0]){
            return edges[1][0];}
        else if(a==edges[1][1] || b==edges[1][1]){
            return edges[1][1];}
        return -1;
    }
}