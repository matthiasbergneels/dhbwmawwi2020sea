package lecture.chapter12;

public class BinaryTree<T> {

    private Node<T> root;

    public boolean add(T data){
        Node<T> newNode = new Node<T>(data);

        if(root == null){
            root = newNode;
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
                return true;
            }
        } else if(compareToResult < 0){
            if(currentNode.getRightNode() != null){
                return add(currentNode.getRightNode(), newNode);
            }else{
                currentNode.setRightNode(newNode);
                return true;
            }
        } else{
            // compareToResult == 0 --> identische Objekte
            return false;
        }
    }

    // TODO: public int size()

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
