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
    public  int level(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
    public void lvl(TreeNode root, int cur,int tar,List<Integer> ans){
        if(root==null) return ;
        if(cur==tar) {
            ans.add(root.val) ;
            return;
        }
        lvl(root.left,cur+1,tar, ans);
        lvl(root.right,cur+1,tar,ans);

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        int h=level(root);
        for(int i=0;i<=h-1;i++){
            List<Integer> arr= new ArrayList<>();
            lvl(root,0,i,arr);
            ans.add(arr);
        }
   return ans;
        
    }
}