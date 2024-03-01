import util.Util;

import java.util.Arrays;
import java.util.Stack;

public class BinaryTree {
    public static void main(String[] args) {
        //long start = System.currentTimeMillis();

        Tree tree = new Tree();
        tree.insert(15);
        tree.insert(25);
        tree.insert(10);
        tree.insert(12);
        tree.insert(6);
        tree.insert(20);
        tree.getTreeInOrderRec();
        //System.out.println(tree.getRoot());

        //long end = System.currentTimeMillis();
        //System.out.println("Tempo: "+(end - start));
    }

}

class Node {
    int value;
    Node left;
    Node right;
    Node(int value) { this.value = value; };
}
class Tree {
    Node root;
    public Tree() {}
    public Tree(Node value) { this.root = value; }
    void insert(int value) {
        Node newNode = new Node(value);
        Node tempRoot = root;

        if (root == null) {
            root = newNode;
            return;
        }
//        Node present = null;
//        while (tempRoot != null) {
//            present = tempRoot;
//            if (value > tempRoot.value)
//                tempRoot = tempRoot.right;
//            else if (value < tempRoot.value)
//                tempRoot = tempRoot.left;
//        }

        Node present = getCurrentNodeRec(tempRoot, value);

        if (value > present.value)
            present.right = newNode;
        else
            present.left = newNode;

    }

    Node getCurrentNodeRec(Node tempRoot, int value) {
        Node present = tempRoot;
        if (value > tempRoot.value)
            tempRoot = tempRoot.right;
        else if (value < tempRoot.value)
            tempRoot = tempRoot.left;

        if (tempRoot == null)
            return present;

        return getCurrentNodeRec(tempRoot, value);
    }

    void getTreeInOrder() {
        Node tempRoot = root;
        Stack<Node> stack = new Stack<>();
        while (tempRoot != null || !stack.isEmpty()) {
            if (tempRoot != null) {
                stack.add(tempRoot);
                tempRoot = tempRoot.left;
            } else {
                tempRoot = stack.pop();
                System.out.println(tempRoot.value);
                tempRoot = tempRoot.right;
            }
        }
    }

    void getTreeInOrderRec() {
        getTreeInOrderRec(root);
    }
    void getTreeInOrderRec(Node root) {
        if (root != null) {
            getTreeInOrderRec(root.left);
            System.out.print(root.value + "  ");
            getTreeInOrderRec(root.right);
        }
    }
}
