package lecture.chapter12;

public class BinaryTreeExample {

    public static void main(String[] args) {

        BinaryTree<Integer> numberTree = new BinaryTree<>();

        numberTree.add(100);
        numberTree.add(200);
        numberTree.add(50);
        numberTree.add(300);
        numberTree.add(250);
        numberTree.add(10);
        numberTree.add(90);

        System.out.println("Binary Tree befüllt!");

        numberTree.printInOrder();

        numberTree.printPreOrder();

        numberTree.printPostOrder();
    }
}
