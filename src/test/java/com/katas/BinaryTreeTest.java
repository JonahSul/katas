package com.katas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class BinaryTreeTest {
    
    private BinaryTree tree;
    
    @BeforeEach
    void setUp() {
        tree = new BinaryTree();
    }
    
    @Test
    void shouldInsertNodesInBSTOrder() {
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        
        List<Integer> inorder = tree.inorderTraversal();
        assertThat(inorder).containsExactly(2, 3, 4, 5, 6, 7, 8);
    }
    
    @Test
    void shouldPerformInorderTraversal() {
        // Create tree: 
        //       2
        //      / \
        //     1   3
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(2);
        root.left = new BinaryTree.TreeNode(1);
        root.right = new BinaryTree.TreeNode(3);
        tree.setRoot(root);
        
        List<Integer> result = tree.inorderTraversal();
        assertThat(result).containsExactly(1, 2, 3);
    }
    
    @Test
    void shouldPerformPreorderTraversal() {
        // Create tree: 
        //       1
        //      / \
        //     2   3
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        root.left = new BinaryTree.TreeNode(2);
        root.right = new BinaryTree.TreeNode(3);
        tree.setRoot(root);
        
        List<Integer> result = tree.preorderTraversal();
        assertThat(result).containsExactly(1, 2, 3);
    }
    
    @Test
    void shouldPerformPostorderTraversal() {
        // Create tree: 
        //       3
        //      / \
        //     1   2
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(3);
        root.left = new BinaryTree.TreeNode(1);
        root.right = new BinaryTree.TreeNode(2);
        tree.setRoot(root);
        
        List<Integer> result = tree.postorderTraversal();
        assertThat(result).containsExactly(1, 2, 3);
    }
    
    @Test
    void shouldPerformLevelOrderTraversal() {
        // Create tree: 
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(3);
        root.left = new BinaryTree.TreeNode(9);
        root.right = new BinaryTree.TreeNode(20);
        root.right.left = new BinaryTree.TreeNode(15);
        root.right.right = new BinaryTree.TreeNode(7);
        tree.setRoot(root);
        
        List<Integer> result = tree.levelOrderTraversal();
        assertThat(result).containsExactly(3, 9, 20, 15, 7);
    }
    
    @Test
    void shouldCalculateMaxDepth() {
        // Create tree: 
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(3);
        root.left = new BinaryTree.TreeNode(9);
        root.right = new BinaryTree.TreeNode(20);
        root.right.left = new BinaryTree.TreeNode(15);
        root.right.right = new BinaryTree.TreeNode(7);
        tree.setRoot(root);
        
        assertThat(tree.maxDepth()).isEqualTo(3);
    }
    
    @Test
    void shouldReturnZeroDepthForEmptyTree() {
        assertThat(tree.maxDepth()).isEqualTo(0);
    }
    
    @Test
    void shouldDetectBalancedTree() {
        // Create balanced tree: 
        //       1
        //      / \
        //     2   3
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        root.left = new BinaryTree.TreeNode(2);
        root.right = new BinaryTree.TreeNode(3);
        tree.setRoot(root);
        
        assertThat(tree.isBalanced()).isTrue();
    }
    
    @Test
    void shouldDetectUnbalancedTree() {
        // Create unbalanced tree: 
        //       1
        //      /
        //     2
        //    /
        //   3
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        root.left = new BinaryTree.TreeNode(2);
        root.left.left = new BinaryTree.TreeNode(3);
        tree.setRoot(root);
        
        assertThat(tree.isBalanced()).isFalse();
    }
    
    @Test
    void shouldValidateBinarySearchTree() {
        // Create valid BST: 
        //       5
        //      / \
        //     3   7
        //    / \ / \
        //   2  4 6  8
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(5);
        root.left = new BinaryTree.TreeNode(3);
        root.right = new BinaryTree.TreeNode(7);
        root.left.left = new BinaryTree.TreeNode(2);
        root.left.right = new BinaryTree.TreeNode(4);
        root.right.left = new BinaryTree.TreeNode(6);
        root.right.right = new BinaryTree.TreeNode(8);
        tree.setRoot(root);
        
        assertThat(tree.isValidBST()).isTrue();
    }
    
    @Test
    void shouldDetectInvalidBinarySearchTree() {
        // Create invalid BST: 
        //       5
        //      / \
        //     3   7
        //    / \ / \
        //   2  6 4  8  (6 > 5, violates BST property)
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(5);
        root.left = new BinaryTree.TreeNode(3);
        root.right = new BinaryTree.TreeNode(7);
        root.left.left = new BinaryTree.TreeNode(2);
        root.left.right = new BinaryTree.TreeNode(6); // Invalid: 6 > 5
        root.right.left = new BinaryTree.TreeNode(4);
        root.right.right = new BinaryTree.TreeNode(8);
        tree.setRoot(root);
        
        assertThat(tree.isValidBST()).isFalse();
    }
    
    @Test
    void shouldFindLowestCommonAncestor() {
        // Create BST: 
        //       6
        //      / \
        //     2   8
        //    / \ / \
        //   0  4 7  9
        //     / \
        //    3   5
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(6);
        root.left = new BinaryTree.TreeNode(2);
        root.right = new BinaryTree.TreeNode(8);
        root.left.left = new BinaryTree.TreeNode(0);
        root.left.right = new BinaryTree.TreeNode(4);
        root.left.right.left = new BinaryTree.TreeNode(3);
        root.left.right.right = new BinaryTree.TreeNode(5);
        root.right.left = new BinaryTree.TreeNode(7);
        root.right.right = new BinaryTree.TreeNode(9);
        tree.setRoot(root);
        
        assertThat(tree.lowestCommonAncestor(2, 8)).isEqualTo(6);
        assertThat(tree.lowestCommonAncestor(2, 4)).isEqualTo(2);
        assertThat(tree.lowestCommonAncestor(3, 5)).isEqualTo(4);
    }
}
