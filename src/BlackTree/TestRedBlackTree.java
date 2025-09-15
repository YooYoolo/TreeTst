package BlackTree;

public class TestRedBlackTree {
    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        int[] values = {10, 20, 30, 15, 25, 35, 44, 61, 14, 26, 13, 1, 19, 10};
        for (var value : values) {
            System.out.println("Adding " + value);
            tree.add(value);
            tree.printInOrder();
        }
    }
}
