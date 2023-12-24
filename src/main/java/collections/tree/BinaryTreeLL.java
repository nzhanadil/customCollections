package collections.tree;

import nodes.BinaryNode;

import java.util.*;

public class BinaryTreeLL {

    BinaryNode root;

    public BinaryTreeLL() {
        this.root = null;
    }

    // PreOrder Traversal
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // InOrder Traversal
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // PostOrder Traversal
    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Level Order Traversal
    public void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        System.out.println();
    }

    // Search in tree
    public boolean contains(String value) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();

            if (presentNode.value.equals(value)) {
                return true;
            }
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        return false;
    }

    //Insert
    public void add(String value) {
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;

        if (root == null) {
            root = newNode;
            System.out.println("Inserted new node at Root");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode tempNode = queue.remove();

            if (tempNode.left == null) {
                tempNode.left = newNode;
                System.out.println("Inserted Successfully");
                break;
            } else if (tempNode.right == null) {
                tempNode.right = newNode;
                System.out.println("Inserted Successfully");
                break;
            } else {
                queue.add(tempNode.left);
                queue.add(tempNode.right);
            }
        }
    }

    //get Deepest Node
    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();

        queue.add(root);
        BinaryNode tempNode = null;

        while (!queue.isEmpty()) {
            tempNode = queue.remove();

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }

        return tempNode;
    }

    //get Deepest Node
    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();

        queue.add(root);
        BinaryNode previousNode, presentNode = null;

        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();

            if (presentNode.left == null) {
                previousNode.right = null;
                return;
            } else if (presentNode.right == null) {
                presentNode.left = null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }

    public void deleteNode(String value) {
        Queue<BinaryNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode tempNode = queue.remove();

            if (tempNode.value.equals(value)) {
                tempNode.value = getDeepestNode().value;
                deleteDeepestNode();
                return;
            } else {
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.left != null) queue.add(tempNode.left);
            }
        }
    }

    // Delete Binary Tree
    public void deleteBT() {
        root = null;
    }


}
