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
    public void postOrder(BinaryNode node){
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Level Order Traversal
    public void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value +" ");
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
        System.out.println();
    }

    // Search in tree
    public boolean contains(String value){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();

            if(presentNode.value.equals(value)){
                return true;
            }
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
        return false;
    }

    //Insert
    public void add(String value){
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;

        if(root == null) {
            root = newNode;
            System.out.println("Inserted new node at Root");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BinaryNode tempNode = queue.remove();

            if(tempNode.left == null){
                tempNode.left = newNode;
                System.out.println("Inserted Successfully");
                break;
            } else if(tempNode.right == null){
                tempNode.right = newNode;
                System.out.println("Inserted Successfully");
                break;
            } else {
                queue.add(tempNode.left);
                queue.add(tempNode.right);
            }
        }
    }




}
