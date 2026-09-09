class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orignalcolor=image[sr][sc];
        if(orignalcolor==color) return image;
        fun(image,sr,sc,orignalcolor,color);
        return image;
    }
    public void fun(int[][]image,int r,int c,int orignalcolor,int color){
        if(r<0 || c<0 || r==image.length || c==image[0].length || image[r][c]!=orignalcolor) return;
        image[r][c]=color;
        fun(image,r+1,c,orignalcolor,color);
        fun(image,r-1,c,orignalcolor,color);
        fun(image,r,c+1,orignalcolor,color);
        fun(image,r,c-1,orignalcolor,color);
    }
}