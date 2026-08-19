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
    public List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        dfs(root, 0, map);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    void dfs(TreeNode root, int level, HashMap<Integer, List<Integer>> map) {
        if (root == null) return;
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.val);
        dfs(root.left, level + 1, map);
        dfs(root.right, level + 1, map);
    }
}