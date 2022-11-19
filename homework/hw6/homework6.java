package homework.hw6;

public class homework6 {
    public static void main(String[] arg) {

        Node r1 = new Node(1);
        Node r2 = new Node(2);
        Node r3 = new Node(3);
        Node r4 = new Node(4);
        Node r5 = new Node(5);
        Node r6 = new Node(6);
        Node r7 = new Node(7);
        Node r8 = new Node(8);
        Node r9 = new Node(9);
        Node r10 = new Node(10);
        Node r11 = new Node(11);

        r1.left = r2;
        r1.right = r3;

            r2.left = r4;
            r2.right = r5;

            r3.right = r6;

                r4.left = r7;

                r5.left = r8;

                    r8.right = r9;

                r6.left = r10;
                r6.right = r11;

        preOrder(r1);
        System.out.println();
        inOrder(r1);
        System.out.println();
        postOrder(r1);
        System.out.println();
        rePreOrder(r1);
        System.out.println();
        reInOrder(r1);
        System.out.println();
        rePostOrder(r1);

    }

    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.value + "  ");
            preOrder(root.left);
            preOrder(root.right);
        }
        
    }

    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + "  ");
            inOrder(root.right);
            
        }
        
    }

    static void rePostOrder(Node root) {
        if (root != null) {
            postOrder(root.right);
            postOrder(root.left);
            System.out.print(root.value + "  ");
        }
        
    }

    static void rePreOrder(Node root) {
        if (root != null) {
            System.out.print(root.value + "  ");
            rePreOrder(root.right);
            rePreOrder(root.left);
        }
        
    }

    static void reInOrder(Node root) {
        if (root != null) {
            reInOrder(root.right);
            System.out.print(root.value + "  ");
            reInOrder(root.left);
            
        }
        
    }

    static void postOrder(Node root) {
        if (root != null) {
            rePostOrder(root.right);
            rePostOrder(root.left);
            System.out.print(root.value + "  ");
        }
        
    }
}

class Node {
    int value;

    public Node(int value) {
        this.value = value;
    }

    Node left;
    Node right;
}