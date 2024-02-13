import java.util.ArrayList;
import java.util.List;

class BinaryTree {

    private List<Integer> nodes = new ArrayList<>();

    public void setRoot(int root) {
        System.out.println(0 + " " + root);
        nodes.add(root);
    }

    public void setLeft(int at, int node) {
        System.out.println(at * 2 + 1 + " " + node);
        nodes.add(at * 2 + 1, node);
    }

    public void setRight(int at, int node) {
        System.out.println(at * 2 + 2 + " " + node);
        nodes.add(at * 2 + 2, node);
    }

    public Integer getLeft(int at) {
        return nodes.get(at * 2 + 1);
    }
    
    public Integer getRight(int at) {
        return nodes.get(at * 2 + 2);
    }

    public Integer getRoot(int at) {
        return nodes.get(at);
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
    }    
}
