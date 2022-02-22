package glowny;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class RedBlackTree <E,T> {

    Comparator<E> com;
    public RedBlackTree(Comparator<E> com) {
        this.com = com;
    }

    private class Node {

        E key;
        Node left;
        Node right;
        Node parent;
        T value;
        String color;

        public Node(E key, Node left, Node right, Node parent, T value, String color) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.value = value;
            this.color = color;
        }

        public E getKey() {
            return key;
        }

        public void setKey(E key) {
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    Node nil = new Node(null, null, null, null, null, "BLACK");
    Node root = nil;

    public void leftRotate(Node x) {

        Node y = x.right;
        x.right = y.left;

        if (y.left != nil) {
            y.left.parent = x;
        }
        y.parent = x.parent;

        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;

    }

    public void rightRotate(Node x) {

        Node y = x.left;
        x.left = y.right;

        if (y.right != nil) {
            y.right.parent = x;
        }
        y.parent = x.parent;

        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;

    }

    private void add1(Node n) {

        boolean added = false;
        Node actNode;

        if (root == nil) {
            root = n;

        } else {
            actNode = root;

            while (!added) {

                if (com.compare(n.key,actNode.key) < 0) { //n.key < actNode.key

                    if (actNode.left == nil) {
                        n.parent = actNode;
                        actNode.left = n;
                        added = true;
                    } else
                        actNode = actNode.left;

                } else if (com.compare(n.key,actNode.key) > 0) {
                    if (actNode.right == nil) {
                        n.parent = actNode;
                        actNode.right = n;
                        added = true;
                    } else
                        actNode = actNode.right;

                } else {
                    break;
                }
            }
        }
    }

    public void add(T value, E key) {
        Node x = new Node(key, nil, nil, nil, value, "RED");
        Node y;

        add1(x); // Dodawanie normalne jak w BST

        while (x != root && x.parent.color.equals("RED")) {

            if (x.parent == x.parent.parent.left) {
                y = x.parent.parent.right;

                if(y.color.equals("RED")){
                    x.parent.color = "BLACK";
                    y.color = "BLACK";
                    x.parent.parent.color = "RED";
                    x = x.parent.parent;
                }
                else{
                    if(x == x.parent.right){
                        x = x.parent;
                        leftRotate(x);
                    }
                    x.parent.color = "BLACK";
                    x.parent.parent.color = "RED";
                    rightRotate(x.parent.parent);
                }
            }
            else{
                y = x.parent.parent.left;

                if(y.color.equals("RED")){
                    x.parent.color = "BLACK";
                    y.color = "BLACK";
                    x.parent.parent.color = "RED";
                    x = x.parent.parent;
                }
                else{
                    if(x == x.parent.left){
                        x = x.parent;
                        rightRotate(x);
                    }
                    x.parent.color = "BLACK";
                    x.parent.parent.color = "RED";
                    leftRotate(x.parent.parent);
                }
            }
        }
        root.color = "BLACK";

    }

    public void InOrderWalk(){
        InOrderWalk2(root);
    }

    private void InOrderWalk2(Node node){

        if(node!=nil){
            InOrderWalk2(node.left);
            System.out.println("Klucz: " + node.key + " Wartosc: " + node.value + " Kolor:" + node.color);
            InOrderWalk2(node.right);
        }

    }

    private Node findMin(Node actNode){


        while(actNode.left!=nil){
            actNode=actNode.left;
        }
        return actNode;
    }

    private Node findValue(E key){

        Node actNode= root;

        while(actNode!=nil){

            if(com.compare(key,actNode.key) == 0) {
                return actNode;
            }

            else if(com.compare(key,actNode.key) < 0){
                actNode = actNode.left;
            }

            else if(com.compare(key,actNode.key) > 0){
                actNode = actNode.right;
            }

        }
        return nil;
    }

    private Node findNext(Node node){

        if(node.right!=nil){
            return findMin(node.right);
        }

        Node par = node.parent;

        while(par != nil && node == par.right){
            node = par;
            par = par.parent;
        }
        return par;
    }

    public void remove(E key){

        Node rem = findValue(key);
        if(rem!=nil)
            remove1(rem);
        else throw new NoSuchElementException();
    }

    private void remove1(Node remNode){

        Node del;
        Node child;

        if(remNode.left == nil || remNode.right == nil)
            del = remNode;
        else
            del = findNext(remNode);

        if(del.left != nil)
            child = del.left;
        else
            child = del.right;

            child.parent = del.parent;

        if(del.parent == nil)
            root = child;
        else if(del == del.parent.left)
            del.parent.left = child;
        else
            del.parent.right = child;

        if(del != remNode)
            swap(del,remNode);

        if(del.color.equals("BLACK")){
            delFix(child);
        }
    }

    private void swap(Node node1, Node node2){

        E key = node1.key;
        T value = node1.value;

        node1.key=node2.key;
        node1.value=node2.value;

        node2.key=key;
        node2.value=value;
    }

    private void delFix(Node x){

        Node w;
        while(x != root && x.color.equals("BLACK")){

            if(x == x.parent.left){
                w = x.parent.right;

                if(w.color.equals("RED")){
                    w.color = "BLACK";
                    x.parent.color = "RED";
                    leftRotate(x.parent);
                    w = x.parent.right;
                }

                if(w.left.color.equals("BLACK") && w.right.color.equals("BLACK")){
                    w.color = "RED";
                    x = x.parent;
                }
                else if(w.right.color.equals("BLACK")) {
                    w.left.color = "BLACK";
                    w.color = "RED";
                    rightRotate(w);
                    w = x.parent.right;

                }
                    w.color = x.parent.color;
                    x.parent.color = "BLACK";
                    w.right.color = "BLACK";
                    leftRotate(x.parent);
                    x = root;

            }
            else{
                w = x.parent.left;

                if(w.color.equals("RED")){
                    w.color = "BLACK";
                    x.parent.color = "RED";
                    rightRotate(x.parent);
                    w = x.parent.left;
                }

                if(w.right.color.equals("BLACK") && w.left.color.equals("BLACK")){
                    w.color = "RED";
                    x = x.parent;
                }
                else if(w.left.color.equals("BLACK")) {
                    w.right.color = "BLACK";
                    w.color = "RED";
                    leftRotate(w);
                    w = x.parent.left;

                }
                    w.color = x.parent.color;
                    x.parent.color = "BLACK";
                    w.left.color = "BLACK";
                    rightRotate(x.parent);
                    x = root;

            }

        }
        x.color = "BLACK";
    }

    public T getValue(E key){

        Node actNode= root;

        while(actNode!=nil){

            if(com.compare(key,actNode.key) == 0) {
                return actNode.value;
            }

            else if(com.compare(key,actNode.key) < 0){
                actNode = actNode.left;
            }

            else if(com.compare(key,actNode.key) > 0){
                actNode = actNode.right;
            }

        }
        return null;

    }

    private double getBlack(Node node){

        int nBl = 0;
        if (node == nil) {
            return 0;
        }
        nBl += getBlack(node.left);
        nBl += getBlack(node.right);

        if(node.color.equals("BLACK") && node.right==nil && node.left==nil){
            nBl++;
        }
        return nBl;
    }

    private double getAll(Node node){
        int n = 0;
        if (node == nil) {
            return 0;
        }
        n += getAll(node.left);
        n += getAll(node.right);

        if( node.right==nil && node.left==nil){
            n++;
        }

        return n;
    }

    public void getPercentage(){
        double p = Math.round(100.0 * getBlack(root)/getAll(root)*100.0)/100.0;
        System.out.println("Procent czarnych lisci wynosi: " + p + " %");
    }

}
