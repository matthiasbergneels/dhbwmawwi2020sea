package lecture.chapter12;

public class LinkedList {

    private Node firstNode;

    public void add(Object data){
        Node newNode = new Node(data);


        if(firstNode == null){
            // Liste ist noch leer
            firstNode = newNode;
            return;
        }

        Node currentNode = firstNode;
        while(currentNode.getNextNode() != null){
            currentNode = currentNode.getNextNode();
        }

        currentNode.setNextNode(newNode);
    }

    public boolean contains(Object data){

        if(firstNode == null){
            // liste ist leer
            return false;
        }

        Node currentNode = firstNode;
        if(currentNode.getData().equals(data)){
            return true;
        }
        while(currentNode.getNextNode() != null){
            currentNode = currentNode.getNextNode();
            if(currentNode.getData().equals(data)){
                return true;
            }
        }

        return false;
    }

    // contains --> rekursiv

    // remove Methode: public boolean remove(Object data)

    private class Node{

        private Object data;
        private Node nextNode;

        public Node(Object data){
            this.data = data;
            this.nextNode = null;
        }

        public void setNextNode(Node nextNode){
            this.nextNode = nextNode;
        }

        public Node getNextNode(){
            return this.nextNode;
        }

        public Object getData(){
            return this.data;
        }
    }
}
