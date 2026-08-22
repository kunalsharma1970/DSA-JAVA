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
    List<Integer> list= new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        int sum=0;
        fun(root,sum);
        int total=0;
        for(int i=0;i<list.size();i++){
            total+=list.get(i);
        }
        return total;
    }
    public void fun(TreeNode root,int sum){
        if(root==null) return;
        sum=sum*10+root.val;
        if(root.left==null && root.right==null){
            list.add(sum);
            return;
        }
        fun(root.left,sum);
        fun(root.right,sum);
    }
}