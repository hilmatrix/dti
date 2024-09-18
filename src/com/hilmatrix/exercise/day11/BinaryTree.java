package com.hilmatrix.exercise.day11;

public class BinaryTree{
    private class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private TreeNode root;

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }

        boolean finish = false;
        TreeNode nextRoot = root;

        while (!finish) {
            if (data < nextRoot.data) {
                if (nextRoot.left == null) {
                    nextRoot.left = new TreeNode(data);
                    finish = true;
                } else {
                    nextRoot = nextRoot.left;
                }
            } else if (data > nextRoot.data) {
                if (nextRoot.right == null) {
                    nextRoot.right = new TreeNode(data);
                    finish = true;
                } else {
                    nextRoot = nextRoot.right;
                }
            } else if (data == nextRoot.data) {
                System.out.printf("Data %d already exist, skipping \n", data);
                finish = true;
            }
        }
    }

    public int existData(int input) {
        TreeNode nextRoot = root;
        int steps = 1;

        while (nextRoot != null) {
            if (nextRoot.data == input)
                return steps;
            else if (input > nextRoot.data)
                nextRoot = nextRoot.right;
            else if (input < nextRoot.data)
                nextRoot = nextRoot.left;

            steps++;
        }

        return -1;
    }

    private void printTree(TreeNode node, boolean isLeft, int steps) {
        if (node != null) {
            System.out.printf("\t".repeat(steps));
            steps++;

            if (steps == 1)
                System.out.println("C:" + node.data);
            else
                System.out.println((isLeft ? "L:" : "R:") + node.data);
            printTree(node.right,false, steps + 1);
            printTree(node.left, true, steps + 1);
        }
    }

    public void printTree() {
        printTree(root, false, 0);
    }
}
