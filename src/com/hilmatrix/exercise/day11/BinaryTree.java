package com.hilmatrix.exercise.day11;

public class BinaryTree{
    private static class TreeNode {
        private final int data;
        private TreeNode leftNode, rightNode;

        TreeNode(int data) {
            this.data = data;
            this.leftNode = this.rightNode = null;
        }
    }

    private TreeNode rootNode;

    public void insert(int data) {
        if (rootNode == null) {
            rootNode = new TreeNode(data);
            return;
        }

        boolean finish = false;
        TreeNode currentNode = rootNode;

        while (!finish) {
            if (data < currentNode.data) {
                if (currentNode.leftNode == null) {
                    currentNode.leftNode = new TreeNode(data);
                    finish = true;
                } else {
                    currentNode = currentNode.leftNode;
                }
            } else if (data > currentNode.data) {
                if (currentNode.rightNode == null) {
                    currentNode.rightNode = new TreeNode(data);
                    finish = true;
                } else {
                    currentNode = currentNode.rightNode;
                }
            } else  { // data == nextRoot.data
                System.out.printf("Data %d already exist, skipping \n", data);
                finish = true;
            }
        }
    }

    public int existData(int input) {
        TreeNode currentNode = rootNode;
        int steps = 1;

        while (currentNode != null) {
            if (input > currentNode.data)
                currentNode = currentNode.rightNode;
            else if (input < currentNode.data)
                currentNode = currentNode.leftNode;
            else // input == nextRoot.data
                return steps;

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
            printTree(node.rightNode,false, steps + 1);
            printTree(node.leftNode, true, steps + 1);
        }
    }

    public void printTree() {
        printTree(rootNode, false, 0);
    }
}
