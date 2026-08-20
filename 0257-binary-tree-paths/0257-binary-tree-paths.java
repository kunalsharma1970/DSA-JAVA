/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root==null) return list;
        fun(root,"",list);
        return list;
    }
    public static void fun(TreeNode root,String s,List<String>list){
        if(root==null) return;
        s+=root.val;
        if(root.left==null && root.right==null){
            list.add(s);
            return;
        }
        s+="->";
        fun(root.left,s,list);
        fun(root.right,s,list);
    }
}