// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here
// BFS
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root== null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        boolean x_found = false;
        boolean y_found = false;
        
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            x_found = false;
            y_found = false;
            while(size>0){
                root = q.poll();
                if(root.val==x) x_found=true;
                if(root.val==y) y_found=true;

                if(root.left!=null && root.right!=null){
                    if(root.left.val==x && root.right.val==y) return false;
                    if(root.left.val==y && root.right.val==x) return false;
                }
                if(root.left!=null){
                    q.add(root.left);
                }
                if(root.right!=null){
                    q.add(root.right);
                }
                if(x_found==true && y_found==true) return true;
                size--;
            }
        }
        return false;
    }
}

// DFS
// Time Complexity : O(n)
// Space Complexity : O(h) where h is height of tree for recursive stack
class Solution {
    TreeNode x_parent = null;
    TreeNode y_parent = null;
    int x_depth = -1;
    int y_depth = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, null, 0);
        if(x_parent!=y_parent && x_depth==y_depth) return true;
        return false;
    }
    private void dfs(TreeNode root, int x, int y, TreeNode par, int lvl){
        if(root==null) return;

        if(root.val == x) {
            x_parent = par;
            x_depth = lvl;
        }
        if(root.val == y) {
            y_parent = par;
            y_depth = lvl;
        }

        if(x_parent==null || y_parent==null) dfs(root.left, x, y, root, lvl+1);
        if(x_parent==null || y_parent==null) dfs(root.right, x, y, root, lvl+1);
    }
}