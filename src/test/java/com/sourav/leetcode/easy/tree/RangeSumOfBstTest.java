package com.sourav.leetcode.easy.tree;

import org.junit.jupiter.api.Test;

import static com.sourav.leetcode.easy.tree.RangeSumOfBst.rangeSumBST;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangeSumOfBstTest {
    @Test
    public void RangeSumOfBst_Test1(){
        TreeNode left = new TreeNode(14);
        TreeNode right = new TreeNode(20);
        TreeNode root = new TreeNode(16, left, right);
        final int expected = 36;
        final int obtained = rangeSumBST(root, 15, 30);
        assertEquals(expected, obtained);
    }
}
