import java.util.Scanner;
import java.util.Stack;

public class BSTInorder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BST bst = new BST();

        System.out.print("Enter 10 integers: ");
        for (int i = 0; i < 10; i++) {
            int value = input.nextInt();
            bst.insert(value);
        }

        bst.inorder();
    }
}

class BST {
    private TreeNode root;

    public BST() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
        } else if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public void inorder() {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.value + " ");
            current = current.right;
        }
    }

    private class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}