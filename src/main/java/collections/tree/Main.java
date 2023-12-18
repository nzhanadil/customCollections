package collections.tree;

public class Main {

    public static void main(String[] args) {
        TreeNode drinks = new TreeNode("drinks");

        TreeNode hotDrinks = new TreeNode("hot");
        TreeNode coldDrinks = new TreeNode("cold");

        drinks.addChild(hotDrinks);
        drinks.addChild(coldDrinks);

        TreeNode tea = new TreeNode("tea");
        TreeNode coffee = new TreeNode("coffee");

        TreeNode wine = new TreeNode("wine");
        TreeNode beer = new TreeNode("beer");


        hotDrinks.addChild(tea);
        hotDrinks.addChild(coffee);

        coldDrinks.addChild(wine);
        coldDrinks.addChild(beer);






        System.out.println(drinks.print(0));
    }
}
