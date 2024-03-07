import util.Util;

import java.util.Arrays;
import java.util.Stack;

public class BinaryTree {
    public static void main(String[] args) {
        //long start = System.currentTimeMillis();

        Tree tree = new Tree();
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(12);
        tree.insert(6);
        tree.insert(18);
        tree.insert(25);
        tree.insert(5);
        tree.insert(9);
        tree.insert(16);
        tree.insert(19);
        tree.insert(30);
        tree.insert(8);
        tree.insert(17);
        tree.insert(27);

        tree.remove(20);

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
    void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node present = getCurrentNodeRec(root, value);

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

    void remove(int value) {
        Node prev = getPrevNodeRec(root, root, value);
        Node present = null;

        if (prev.left != null && prev.left.value == value)
            present = prev.left;
        if (prev.right != null && prev.right.value == value)
            present = prev.right;
        if (present == null) {
            present = prev;
            prev = null;
        }
        if (prev != null) {
            removeChildless(prev, present);
            removeOneChild(prev, present);
        }

        removeTwoChild(prev, present, value);

    }

    private void removeTwoChild(Node prev, Node present, int value) {
        Node biggerNode = getBiggerNodeLeftRec(present, present, value);
        Node prevBigger = getPrevBiggerRec(present, biggerNode, value);

        removeChildless(prevBigger, biggerNode);
        removeOneChild(prevBigger, biggerNode);

        present.value = biggerNode.value;
        prev.left = present;
    }

    void removeChildless(Node prev, Node present) {
        if (present.left == null && present.right == null) {
            if (prev.left == present)
                prev.left = null;
            if (prev.right == present)
                prev.right = null;
        }
    }
    void removeOneChild(Node prev, Node present) {
        if (present.left != null) {
            if (present.value < prev.value)
                prev.left = present.left;
            else
                prev.right = present.left;
        }
        if (present.right != null) {
            if (present.value < prev.value)
                prev.left = present.right;
            else
                prev.right = present.right;
        }
    }
    Node getPrevNodeRec(Node tempRoot, Node prev, int value) {
        if ((tempRoot.right != null && tempRoot.right.value == value)
                || (tempRoot.left != null && tempRoot.left.value == value)) {
            prev = tempRoot;
        }

        if (value > tempRoot.value)
            tempRoot = tempRoot.right;
        else if (value < tempRoot.value)
            tempRoot = tempRoot.left;
        else
            return prev;

        if (tempRoot == null) {
            System.out.print("Value not found!");
            return null;
        }
        return getPrevNodeRec(tempRoot, prev, value);
    }
    Node getBiggerNodeLeftRec(Node tempRoot, Node bigger, int value) {
        if (tempRoot.value > bigger.value) {
            bigger = tempRoot;
        }

        if (tempRoot.value == value) {
            bigger = tempRoot.left;
            tempRoot = tempRoot.left;
        }

        if (value > tempRoot.value)
            tempRoot = tempRoot.right;
        else if (value < tempRoot.value)
            tempRoot = tempRoot.left;

        if (tempRoot == null)
            return bigger;

        return getBiggerNodeLeftRec(tempRoot, bigger, value);
    }

    Node getPrevBiggerRec(Node tempRoot, Node bigger, int value) {

        if (tempRoot.value == value) {
            tempRoot = tempRoot.left;
        }

        if (tempRoot.right.value == bigger.value || tempRoot.left.value == bigger.value) {
            return tempRoot;
        }

        if (value > tempRoot.value)
            tempRoot = tempRoot.right;
        else if (value < tempRoot.value)
            tempRoot = tempRoot.left;

        if (tempRoot == null)
            return null;

        return getBiggerNodeLeftRec(tempRoot, bigger, value);
    }


}
