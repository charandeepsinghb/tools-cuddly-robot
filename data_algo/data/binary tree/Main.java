import java.util.ArrayList;
import java.util.List;

class BinaryTree {

    private List<Integer> nodes = new ArrayList<>();

    public void setRoot(int root) {
        System.out.println(0 + " " + root);
        nodes.add(root);
    }

    public void setLeft(int parentAt, int nodeValue) {
        System.out.println(parentAt * 2 + 1 + " " + nodeValue);
        nodes.add(parentAt * 2 + 1, nodeValue);
    }

    public void setRight(int parentAt, int nodeValue) {
        System.out.println(parentAt * 2 + 2 + " " + nodeValue);
        nodes.add(parentAt * 2 + 2, nodeValue);
    }

    public Integer getLeft(int parentAt) {
        return nodes.get(parentAt * 2 + 1);
    }
    
    public Integer getRight(int parentAt) {
        return nodes.get(parentAt * 2 + 2);
    }

    public Integer getRoot(int parentAt) {
        return nodes.get(parentAt);
    }

    public void inOrderPrint(int at) {
        if (at > nodes.size() - 1) {
            return;
        }
        if (at == 0) {
            System.out.print("Inorder: ");
        }

        inOrderPrint(at * 2 + 1);
        System.out.print(nodes.get(at) + " ");
        inOrderPrint(at * 2 + 2);
    }
}

class Main {    
    public static void main(String[] args) {
        
        // 1, 2, 3, 4, 5
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(1);
        binaryTree.setLeft(0, 2);
        binaryTree.setRight(0, 3);
        binaryTree.setLeft(1, 4);
        binaryTree.setRight(1, 5);

        binaryTree.inOrderPrint(0);

        // Run with javac Main.java && java Main
        /**
        
        Output:
        
        0 1
        1 2
        2 3
        3 4
        4 5
        Inorder: 4 2 5 1 3
        
        */
    }    
}
