class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original=image[sr][sc];
        if(original==color) return image;
        fun(image,sr,sc,original,color);
        return image;
    }
    public void fun(int[][] image,int r,int c,int original,int color){
        if(r<0 || c<0 || r==image.length || c==image[0].length || image[r][c]!=original) return;

        image[r][c]=color;
        fun(image,r+1,c,original,color);
        fun(image,r-1,c,original,color);
        fun(image,r,c+1,original,color);
        fun(image,r,c-1,original,color);
    }
}