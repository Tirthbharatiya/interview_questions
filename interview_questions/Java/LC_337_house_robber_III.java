/*

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree.
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

Example 1:
Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:
Input: root = [3,4,5,1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 10^4

*/



// Brute Approach
class Solution {
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int profit = root.val;
        if(root.left != null) {
            profit += (rob(root.left.left) + rob(root.left.right));
        }
        if(root.right != null) {
            profit += (rob(root.right.left) + rob(root.right.right));
        }
        return Math.max(profit, rob(root.left) + rob(root.right));
    }
}



// DFS - Optimized Approach
class Solution {
    public int rob(TreeNode root) {
        if(root.left == null && root.right==null) {
            return root.val;
        } 
        int[] ans = maxProfit(root);
        return Math.max(ans[0], ans[1]);
    }
    
    public int[] maxProfit(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        }
       
        int[] left = maxProfit(root.left);
        int[] right = maxProfit(root.right);
        
        int leftMax = Math.max(left[0], left[1]);
        int rightMax = Math.max(right[0], right[1]);

        return new int[]{root.val+left[1]+right[1], leftMax+rightMax};
    } 
}