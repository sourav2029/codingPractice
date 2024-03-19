package com.sourav.leetcode.easy.easy.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/
public class AverageLevel {

    public class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        queue.offer(new Pair(root, 1));
        int prevLevel = 1;
        double sum = 0L;
        int count = 0;
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int currLevel = curr.level;
            TreeNode currNode = curr.node;
            if (currLevel > prevLevel){
                ans.add(sum/count);
                sum = 0L;
                count = 0;
                prevLevel = currLevel;
            }
            sum+= currNode.val;
            count++;
            if (currNode.left != null){
                queue.offer(new Pair(currNode.left, currLevel+1));
            }
            if (currNode.right != null){
                queue.offer(new Pair(currNode.right, currLevel+1));
            }
            // for(int i=0; i<ans.size(); i++){
            //     System.out.print(ans.get(i));
            // }
            // System.out.println();
        }
        if(count>0){
            ans.add(sum/count);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
