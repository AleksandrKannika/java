package homework.hw5;

import java.util.ArrayList;


public class homework5 {
    public static void main(String[] arg) {
        Tree r1 = new Tree(1);
        Tree r2 = new Tree(2);
        Tree r3 = new Tree(3);
        Tree r4 = new Tree(4);
        Tree r5 = new Tree(5);
        Tree r6 = new Tree(6);
        Tree r7 = new Tree(7);
        Tree r8 = new Tree(8);
        Tree r9 = new Tree(9);
        Tree r10 = new Tree(10);
        Tree r11 = new Tree(11);
        
        r1.add(r2);
        r1.add(r3);
        r1.add(r4);
        r2.add(r5);
        r2.add(r6);
        r3.add(r7);
        r4.add(r8);
        r8.add(r9);
        r8.add(r10);
        r8.add(r11);
        
       preOrder(r1, "");
        
    }
    
    static class Tree {
        int value;

        public ArrayList<Tree> list= new ArrayList<>();
        
        public Tree(int value){
            this.value = value;
        }

        public void add(Tree nodes){
            list.add(nodes);
        }      
    }

    static void preOrder(Tree root, String sp) {
        if (root != null) {
          System.out.println(sp + root.value);
          for (Tree c : root.list) {
            preOrder(c, sp + "  ");
          }
        }
      }

}