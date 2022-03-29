# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        max_depth = 1
        stack = [(1, root)]

        while stack:
            current_depth, element = stack.pop()

            if current_depth > max_depth:
                max_depth = current_depth

            if element.left:
                stack.append((current_depth + 1, element.left))

            if element.right:
                stack.append((current_depth + 1, element.right))

        return max_depth
