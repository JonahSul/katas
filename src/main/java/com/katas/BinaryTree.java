package com.katas;

import java.util.*;

/**
 * Binary Tree Kata
 * 
 * Problem Description:
 * Implement a binary tree data structure with various operations and algorithms.
 * 
 * Features to implement:
 * - Insert nodes
 * - Tree traversals (inorder, preorder, postorder, level-order)
 * - Find maximum depth
 * - Check if tree is balanced
 * - Find lowest common ancestor
 * - Validate binary search tree
 * 
 * Constraints:
 * - Handle null nodes gracefully
 * - Support duplicate values
 * - Optimize for common operations
 */
public class BinaryTree {
    
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode() {}
        
        public TreeNode(int val) {
            this.val = val;
        }
        
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    private TreeNode root;
    
    /**
     * Inserts a value into the binary search tree.
     * @param val the value to insert
     */
    public void insert(int val) {
        root = insertRec(root, val);
    }
    
    private TreeNode insertRec(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        
        if (val <= node.val) {
            node.left = insertRec(node.left, val);
        } else {
            node.right = insertRec(node.right, val);
        }
        
        return node;
    }
    
    /**
     * Performs inorder traversal (left, root, right).
     * @return list of values in inorder
     */
    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderRec(root, result);
        return result;
    }
    
    private void inorderRec(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderRec(node.left, result);
            result.add(node.val);
            inorderRec(node.right, result);
        }
    }
    
    /**
     * Performs preorder traversal (root, left, right).
     * @return list of values in preorder
     */
    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorderRec(root, result);
        return result;
    }
    
    private void preorderRec(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preorderRec(node.left, result);
            preorderRec(node.right, result);
        }
    }
    
    /**
     * Performs postorder traversal (left, right, root).
     * @return list of values in postorder
     */
    public List<Integer> postorderTraversal() {
        List<Integer> result = new ArrayList<>();
        postorderRec(root, result);
        return result;
    }
    
    private void postorderRec(TreeNode node, List<Integer> result) {
        if (node != null) {
            postorderRec(node.left, result);
            postorderRec(node.right, result);
            result.add(node.val);
        }
    }
    
    /**
     * Performs level-order traversal (breadth-first).
     * @return list of values level by level
     */
    public List<Integer> levelOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        
        return result;
    }
    
    /**
     * Finds the maximum depth of the tree.
     * @return the maximum depth
     */
    public int maxDepth() {
        return maxDepthRec(root);
    }
    
    private int maxDepthRec(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(maxDepthRec(node.left), maxDepthRec(node.right));
    }
    
    /**
     * Checks if the tree is height-balanced.
     * @return true if balanced, false otherwise
     */
    public boolean isBalanced() {
        return isBalancedRec(root) != -1;
    }
    
    private int isBalancedRec(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = isBalancedRec(node.left);
        if (leftHeight == -1) return -1;
        
        int rightHeight = isBalancedRec(node.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    /**
     * Validates if the tree is a valid binary search tree.
     * @return true if valid BST, false otherwise
     */
    public boolean isValidBST() {
        return isValidBSTRec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBSTRec(TreeNode node, long minVal, long maxVal) {
        if (node == null) return true;
        
        if (node.val <= minVal || node.val >= maxVal) return false;
        
        return isValidBSTRec(node.left, minVal, node.val) && 
               isValidBSTRec(node.right, node.val, maxVal);
    }
    
    /**
     * Finds the lowest common ancestor of two nodes.
     * @param p first node value
     * @param q second node value
     * @return the LCA node value, or null if not found
     */
    public Integer lowestCommonAncestor(int p, int q) {
        TreeNode lca = lcaRec(root, p, q);
        return lca != null ? lca.val : null;
    }
    
    private TreeNode lcaRec(TreeNode node, int p, int q) {
        if (node == null) return null;
        
        // If both p and q are smaller than node, LCA is in left subtree
        if (p < node.val && q < node.val) {
            return lcaRec(node.left, p, q);
        }
        
        // If both p and q are greater than node, LCA is in right subtree
        if (p > node.val && q > node.val) {
            return lcaRec(node.right, p, q);
        }
        
        // If we reach here, then node is the LCA
        return node;
    }
    
    public TreeNode getRoot() {
        return root;
    }
    
    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
