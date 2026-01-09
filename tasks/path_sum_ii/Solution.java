package path_sum_ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> results = new ArrayList<>();

        Queue<QueueValue> queue = new ArrayDeque<>();
        queue.add(new QueueValue(root, root.val, null));

        while (!queue.isEmpty()) {
            QueueValue current = queue.poll();
            TreeNode currentNode = current.value;

            if (currentNode.left != null) {
                queue.add(new QueueValue(currentNode.left, current.valueSum + currentNode.left.val, current));
            }
            if (currentNode.right != null) {
                queue.add(new QueueValue(currentNode.right, current.valueSum + currentNode.right.val, current));
            }

            if (currentNode.left == null
                    && currentNode.right == null
                    && current.valueSum == targetSum) {
                results.add(buildPath(current));
            }
        }

        return results;
    }

    private List<Integer> buildPath(QueueValue current) {
        List<Integer> path = new ArrayList<>();
        while (current != null) {
            path.add(current.value.val);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static final class QueueValue {
        final TreeNode value;
        final int valueSum;
        final QueueValue parent;

        QueueValue(TreeNode value, int valueSum, QueueValue parent) {
            this.value = value;
            this.valueSum = valueSum;
            this.parent = parent;
        }
    }

    public static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}