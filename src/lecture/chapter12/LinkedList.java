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
    public boolean recursiveContains(Object data){
        if(firstNode != null){
            return recursiveContains(data, firstNode);
        }

        return false;
    }

    private boolean recursiveContains(Object data, Node currentNode){
        if(currentNode.getData().equals(data)){
            return true;
        }

        if(currentNode.getNextNode() != null){
            return recursiveContains(data, currentNode.getNextNode());
        }

        return false;
    }

    // remove Methode: public boolean remove(Object data)
    public boolean remove(Object data){

        if(firstNode != null){

            if(firstNode.getData().equals(data)){
                firstNode = firstNode.getNextNode();
                return true;
            }

            Node currentNode = firstNode;
            while(currentNode.getNextNode() != null){
                if(currentNode.getNextNode().getData().equals(data)){
                    currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                    return true;
                }
                currentNode = currentNode.getNextNode();
            }
        }

        return false;
    }

    public void printList(){
        if(firstNode == null){
            System.out.println("Liste ist leer");
            return;
        }

        System.out.println("Liste:");
        printList(firstNode);

    }

    private void printList(Node currentNode){
        System.out.println("- " + currentNode.data);
        if(currentNode.getNextNode() != null){
            printList(currentNode.getNextNode());
        }else{
            System.out.println("Ende der Liste");
        }
    }

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
