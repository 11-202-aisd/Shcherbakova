package optional;

public class Tree {
    public Node root;
    public void add(int  x){
        Node newNode = new Node(x);

        if(root == null){
            root = newNode;
        } else {
            Node currentNode = root;
            Node parentNode;
            while (true)
            {
                parentNode = currentNode;
                if(x == currentNode.value) {
                    return;
                }
                else  if (currentNode.value > x) {
                    currentNode = currentNode.leftChild;
                    if (currentNode == null){
                        parentNode.leftChild = newNode;
                        parentNode.parent = currentNode.parent;
                        return;
                    }
                }
                else {
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        parentNode.rightChild = newNode;
                        parentNode.rightChild = currentNode.parent;
                        return;
                    }
                }
            }
        }
    }
    public boolean contains(int x){
        Node n = root;
        Node thisNode = new Node(x);
        if(root == null){
            return false;
        }
        boolean flag = false;
        while(!(flag)){
            if(x == n.value) {
                return true;
            }
            else  if (n.value > x) {
                n = n.leftChild;
            }
            else {
                n = n.rightChild;
            }
        }
        return flag;}
    public boolean remove(int x){
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = true;
        while (currentNode.value != x) {
            parentNode = currentNode;
            if (x < currentNode.value) {
                isLeftChild = true;
                currentNode = currentNode.leftChild;
            }
            else {
                isLeftChild = false;
                currentNode = currentNode.rightChild;
            }
            if (currentNode == null)
                return false;
        }

        if (currentNode.leftChild == null && currentNode.rightChild == null) {
            if (currentNode == root)
                root = null;
            else if (isLeftChild)
                parentNode.leftChild = null;
            else
                parentNode.rightChild = null;
        }
        else if (currentNode.rightChild == null) {
            if (currentNode == root){
                root = currentNode.leftChild;
            }else if (isLeftChild){
                currentNode.parent = parentNode;
                parentNode.leftChild = currentNode.leftChild;
            }else{
                currentNode.parent = parentNode;
                parentNode.rightChild = currentNode.leftChild;
            }
        }
        else if (currentNode.leftChild == null) {
            if (currentNode == root) {
                root = currentNode.rightChild;
            }else if (isLeftChild) {
                currentNode.parent = parentNode;
                parentNode.leftChild = currentNode.rightChild;
            }else {
                currentNode.parent = parentNode;
                parentNode.rightChild = currentNode.rightChild;
            }
        }
        else {
            Node heir = receiveHeir(currentNode);
            if (currentNode == root) {
                root = heir;
            }else if (isLeftChild) {
                heir.parent = (parentNode);
                parentNode.leftChild = (heir);
            }else{
                heir.parent = (parentNode);
                parentNode.rightChild = (heir);
            }
        }
        return true;
    }
    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.rightChild;
        while (currentNode != null)
        {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.rightChild;
        }
        if (heirNode != node.rightChild)
        {
            parentNode.leftChild = heirNode.rightChild;
            heirNode.rightChild = node.rightChild;
        }
        return heirNode;
    }

}
