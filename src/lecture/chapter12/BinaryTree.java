package lecture.chapter12;

public class BinaryTree<T> {

    private Node<T> root;
    private int size;

    public boolean add(T data){
        Node<T> newNode = new Node<T>(data);

        if(root == null){
            root = newNode;
            size++;
            return true;
        }

        return add(root, newNode);
    }

    private boolean add(Node<T> currentNode, Node<T> newNode){

        int compareToResult = ((Comparable)currentNode.getData()).compareTo(newNode.getData());

        if(compareToResult > 0){
            if(currentNode.getLeftNode() != null){
                return add(currentNode.getLeftNode(), newNode);
            }else{
                currentNode.setLeftNode(newNode);
                size++;
                return true;
            }
        } else if(compareToResult < 0){
            if(currentNode.getRightNode() != null){
                return add(currentNode.getRightNode(), newNode);
            }else{
                currentNode.setRightNode(newNode);
                size++;
                return true;
            }
        } else{
            // compareToResult == 0 --> identische Objekte
            return false;
        }
    }

    public boolean contains(T data){
        return contains(root, data);
    }

    private boolean contains(Node<T> currentNode, T data){
        if(currentNode == null){
            return false;
        }

        if(currentNode.getData().equals(data)){
            return true;
        }

        if(((Comparable)currentNode.getData()).compareTo(data) > 0){
            return contains(currentNode.getLeftNode(), data);
        }else{
            return contains(currentNode.getRightNode(), data);
        }
    }

    public int size(){
        return this.size;
    }

    // traversel

    // inOrder - left-root-right
    public void printInOrder(){
        if(root == null){
            System.out.println("Baum ist leer");
        }else{
            System.out.println("In-Order Ausgabe:");
            printInOrder(root);
        }
    }

    public void printInOrder(Node<T> currentNode){
        if(currentNode.getLeftNode() != null){
            printInOrder(currentNode.getLeftNode());
        }

        System.out.println(currentNode.getData());

        if(currentNode.getRightNode() != null){
            printInOrder(currentNode.getRightNode());
        }
    }

    // preOrder - root-left-right
    public void printPreOrder(){
        if(root == null){
            System.out.println("Baum ist leer");
        }else{
            System.out.println("Pre-Order Ausgabe:");
            printPreOrder(root);
        }
    }

    public void printPreOrder(Node<T> currentNode){
        System.out.println(currentNode.getData());

        if(currentNode.getLeftNode() != null){
            printPreOrder(currentNode.getLeftNode());
        }

        if(currentNode.getRightNode() != null){
            printPreOrder(currentNode.getRightNode());
        }
    }

    // postOrder - left-right-root
    public void printPostOrder(){
        if(root == null){
            System.out.println("Baum ist leer");
        }else{
            System.out.println("Post-Order Ausgabe:");
            printPostOrder(root);
        }
    }

    public void printPostOrder(Node<T> currentNode){
        if(currentNode.getLeftNode() != null){
            printPostOrder(currentNode.getLeftNode());
        }

        if(currentNode.getRightNode() != null){
            printPostOrder(currentNode.getRightNode());
        }

        System.out.println(currentNode.getData());
    }

    private class Node<D>{

        private D data;
        private Node<D> leftNode;
        private Node<D> rightNode;

        public Node(D data){
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }

        public D getData(){
            return this.data;
        }

        public Node<D> getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node<D> leftNode) {
            this.leftNode = leftNode;
        }

        public Node<D> getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node<D> rightNode) {
            this.rightNode = rightNode;
        }
    }
}
