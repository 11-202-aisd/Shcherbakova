public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    private class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(T value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node node, T value) {
        if (node == null) {
            return new Node(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.left = insertNode(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insertNode(node.right, value);
        }

        return node;
    }

    public boolean search(T value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node node, T value) {
        if (node == null) {
            return false;
        }

        if (value.compareTo(node.value) == 0) {
            return true;
        } else if (value.compareTo(node.value) < 0) {
            return searchNode(node.left, value);
        } else {
            return searchNode(node.right, value);
        }
    }

    public void delete(T value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(Node node, T value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.value) < 0) {
            node.left = deleteNode(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                T minValue = findMinValue(node.right);
                node.value = minValue;
                node.right = deleteNode(node.right, minValue);
            }
        }

        return node;
    }

    private T findMinValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }
}
