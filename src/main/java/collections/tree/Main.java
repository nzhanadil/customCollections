package collections.tree;

import nodes.BinaryNode;

public class Main {

    public static void main(String[] args) {
//        Basic Tree
//        TreeNode drinks = new TreeNode("drinks");
//
//        TreeNode hotDrinks = new TreeNode("hot");
//        TreeNode coldDrinks = new TreeNode("cold");
//
//        drinks.addChild(hotDrinks);
//        drinks.addChild(coldDrinks);
//
//        TreeNode tea = new TreeNode("tea");
//        TreeNode coffee = new TreeNode("coffee");
//
//        TreeNode wine = new TreeNode("wine");
//        TreeNode beer = new TreeNode("beer");
//
//
//        hotDrinks.addChild(tea);
//        hotDrinks.addChild(coffee);
//
//        coldDrinks.addChild(wine);
//        coldDrinks.addChild(beer);
//
//        System.out.println(drinks.print(0));

        BinaryTreeLL binaryTree = new BinaryTreeLL();

        BinaryNode N1 = new BinaryNode();
        N1.value = "N1";

        BinaryNode N2 = new BinaryNode();
        N2.value = "N2";

        BinaryNode N3 = new BinaryNode();
        N3.value = "N3";

        BinaryNode N4 = new BinaryNode();
        N4.value = "N4";

        BinaryNode N5 = new BinaryNode();
        N5.value = "N5";

        BinaryNode N6 = new BinaryNode();
        N6.value = "N6";

        binaryTree.root = N1;

        N1.left = N2;
        N1.right = N3;
        N2.left = N4;
        N2.right = N5;
        N3.left = N6;

        binaryTree.levelOrder();

        System.out.println(binaryTree.contains("N4"));

        binaryTree.add("yoyo");
        binaryTree.levelOrder();
    }
}
