package lecture.chapter12;

public class DoubleLinkedList<T> {

    private Node<T> firstNode = null;
    private Node<T> lastNode = null;

    public void add(T data){
        Node<T> newNode = new Node<T>(data);

        if(firstNode == null && lastNode == null){
            this.firstNode = newNode;
            this.lastNode = newNode;
        }else{
            this.lastNode.setNextNode(newNode);
            newNode.setPrevNode(lastNode);
            lastNode = newNode;
        }
    }


    public boolean remove(T data){
        Node<T> nodeToDelete = findNode(data);

        if(nodeToDelete != null){

            if(nodeToDelete.getPrevNode() != null){
                nodeToDelete.getPrevNode().setNextNode(nodeToDelete.getNextNode());
            }else{
                firstNode = nodeToDelete.getNextNode();
                firstNode.setPrevNode(null);
            }

            if(nodeToDelete.getNextNode() != null) {
                nodeToDelete.getNextNode().setPrevNode(nodeToDelete.getPrevNode());
            }else{
                lastNode = nodeToDelete.getPrevNode();
                lastNode.setNextNode(null);
            }
        }

        return false;
    }

    public boolean contains(T data){
        Node<T> dataNode = findNode(data);
        if(dataNode != null){
            return true;
        }

        return false;
    }

    private Node<T> findNode(T data){
        if(firstNode != null){
            Node<T> currenNode = firstNode;
            if(currenNode.getData().equals(data)){
                return currenNode;
            }

            while(currenNode.getNextNode() != null){
                currenNode = currenNode.getNextNode();
                if(currenNode.getData().equals(data)){
                    return currenNode;
                }
            }
        }

        return null;
    }


    private class Node<D>{

        private D data;
        private Node<D> prevNode;
        private Node<D> nextNode;

        public Node(D data){
            this.data = data;
            this.nextNode = null;
            this.prevNode = null;
        }

        public D getData(){
            return this.data;
        }

        public Node<D> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node<D> prevNode) {
            this.prevNode = prevNode;
        }

        public Node<D> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<D> nextNode) {
            this.nextNode = nextNode;
        }
    }
}
