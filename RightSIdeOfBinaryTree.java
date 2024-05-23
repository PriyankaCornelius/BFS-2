// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here
// BFS
class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode cur = null;

        while (!q.isEmpty()) {
            int level = q.size();

            while (level > 0) {
                cur = q.poll();
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
                level--;
            }
            list.add(cur.val);
        }
        return list;
    }
}

// DFS
// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of recursive stack
class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 1);
        return list;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null)
            return;

        if (level > list.size())
            list.add(root.val);
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}