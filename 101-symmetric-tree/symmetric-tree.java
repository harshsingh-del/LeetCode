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

    public boolean  mirror(TreeNode p,TreeNode q){
         if(p==null && q==null) return true; 
        if(p==null || q==null) return false; 
        if(p.val!=q.val) return false;
        if(mirror(p.left,q.right)==false) return false;
        if(mirror(p.right,q.left)==false ) return false;
        return true;
        // return (p.val==q.val) && mirror(p.left,q.right) &&  mirror(p.right,q.left);
        
    }
    public boolean isSymmetric(TreeNode root) {
        // mirror(p,q);
        return mirror(root.left,root.right) ;
        
    }
}