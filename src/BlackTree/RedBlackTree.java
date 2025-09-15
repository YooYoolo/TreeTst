package BlackTree;

public class RedBlackTree<T extends Comparable<T>> {
    private Node<T> root;

    private static class Node<T> {
        T data;
        Node<T> left, right, parent;
        boolean color;

        public Node(T data) {
            this.data = data;
            this.color = true;
        }
    }

    public RedBlackTree() {
        root = null;
    }

    public boolean contains(T data) {
        Node<T> node = root;
        while (node != null) {
            if (data.compareTo(node.data) == 0) {
                return true;
            } else if (data.compareTo(node.data) < 0) {
                node = node.left;
            } else node = node.right;
        }
        return false;
    }

    private void leftRotate(Node<T> x) {
        Node<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        }
        else if (x.parent.left == x) {
            x.parent.left = y;
        }
        else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node<T> x) {
        Node<T> y = x.left;
        x.left= y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        }
        else if (x.parent.right == x) {
            x.parent.right= y;
        }
        else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            root.color = false;
            return;
        }

        Node<T> current = root;
        Node<T> parent = null;

        while (current != null) {
            parent = current;
            if (data.compareTo(current.data) < 0) {
                current = current.left;
            }
            else if (data.compareTo(current.data) > 0) {
                current = current.right;
            }
            else return;
        }
        
        newNode.parent = parent;
        if (data.compareTo(parent.data) < 0) {
            parent.left = newNode;
        }
        else {
            parent.right = newNode;
        }

        fixAfterInsertion(newNode);
    }

    private void fixAfterInsertion(Node<T> node) {
        while (node != root && node.parent.color) {
            if (node.parent == node.parent.parent.left) {
                Node<T> uncle = node.parent.parent.right;

                if (uncle != null && uncle.color == true) {
                    node.parent.color = false;
                    uncle.color = false;
                    node.parent.parent.color = true;
                    node = node.parent.parent;
                }
                else {
                    if (node == node.parent.right){
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.color = false;
                    node.parent.parent.color = true;
                    rightRotate(node.parent.parent);
                }
            }
            else {
                Node<T> uncle = node.parent.parent.left;

                if (uncle != null && uncle.color == true){
                    node.parent.color = false;
                    uncle.color = false;
                    node.parent.parent.color = true;
                    node = node.parent.parent;
                }
                else {
                    if (node == node.parent.left){
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = false;
                    node.parent.parent.color = true;
                    leftRotate(node.parent.parent);
                }
            }

        }
        root.color = false;
    }

    private void inorderTraversal(Node<T> node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + "(" + (node.color ? "R" : "B") + ") ");
            inorderTraversal(node.right);
        }
    }

    public void printInOrder() {
        inorderTraversal(root);
        System.out.println();
    }
}
