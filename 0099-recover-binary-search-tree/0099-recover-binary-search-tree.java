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
    public void recoverTree(TreeNode root) {
        List<TreeNode>list= new ArrayList<>();
        inorder(root,list);
        int galat=0;
        TreeNode galat1first=null; TreeNode galat1second=null;
        TreeNode galat2first=null; TreeNode galat2second=null;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i).val>list.get(i+1).val){
                if(galat==0){
                    galat1first=list.get(i);
                    galat1second=list.get(i+1);
                    galat++;
                }else{
                    galat2first=list.get(i);
                    galat2second=list.get(i+1);
                    galat++;
                }
            }
        }
        if(galat==1){
                int temp=galat1first.val;
                galat1first.val=galat1second.val;
                galat1second.val=temp;
        }else{
                int temp=galat1first.val;
                galat1first.val=galat2second.val;
                galat2second.val=temp;
        }
    }
    public void inorder(TreeNode root,List<TreeNode>list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
}