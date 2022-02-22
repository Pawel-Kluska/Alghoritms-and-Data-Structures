package glowny;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph<T> {

    private class Node {
        T value;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    private class Edge {
        T start;
        T end;

        public Edge(T start, T end) {
            this.start = start;
            this.end = end;
        }

        public T getStart() {
            return start;
        }

        public void setStart(T start) {
            this.start = start;
        }

        public T getEnd() {
            return end;
        }

        public void setEnd(T end) {
            this.end = end;
        }
    }

    Main.choose c;
    ArrayList<Node> nodeSet = new ArrayList<>();
    ArrayList<Edge> edgeSet = new ArrayList<>();
    int[][] matrixNe;
    LinkedList<T>[] list;
    int[][] matrixIn;

    public Graph(Main.choose c) {
        this.c = c;
    }

    public void addNode(T newVertex) {
        Node v = new Node(newVertex);
        boolean found = false;
        for (int i = 0; i < nodeSet.size(); i++) {
            if (nodeSet.get(i).getValue().equals(newVertex)) {
                found = true;
                break;
            }
        }
        if (!found)
            nodeSet.add(v);

        refresh();
    }

    public void addEdge(T startVertex, T endVertex) {
        boolean startIs = false;
        boolean endIs = false;

        if (!startVertex.equals(endVertex)) {

            for (Node v : nodeSet) {
                if (v.getValue().equals(startVertex)) startIs = true;
                if (v.getValue().equals(endVertex)) endIs = true;
            }

            if (startIs && endIs) {
                Edge e = new Edge(startVertex, endVertex);
                edgeSet.add(e);

            }
        }
        refresh();
    }

    private void refresh(){
        switch(c){

            case MacierzSasiedztwa:
                makeMatrixNe();
                break;

            case ListaSasiedztwa:
                makeList();
                break;

            case MacierzIncydencji:
                makeMatrixIn();
                break;
        }
    }

    public void show(){
        switch(c){

            case MacierzSasiedztwa:
                showMatrixNe();
                break;

            case ListaSasiedztwa:
                showList();
                break;

            case MacierzIncydencji:
                showMatrixIn();
                break;
        }
    }

    public void removeNode(T ver) {
        for (Iterator<Node> i = nodeSet.iterator(); i.hasNext(); ) {
            Node element = i.next();
            if (element.getValue().equals(ver)) {
                i.remove();

                for (Iterator<Edge> j = edgeSet.iterator(); j.hasNext(); ) {
                    Edge element2 = j.next();
                    if (element2.getStart().equals(ver) || element2.getEnd().equals(ver)) {
                        j.remove();
                    }
                }

            }
        }
        refresh();
    }

    public void removeEdge(T st, T end) {
        for (Iterator<Edge> i = edgeSet.iterator(); i.hasNext(); ) {
            Edge element = i.next();
            if (element.getStart().equals(st) && element.getEnd().equals(end)) {
                i.remove();
            }

        }
        refresh();
    }

    public void showVertex() {
        for (Node v : nodeSet) {
            System.out.println(v.value);
        }
    }

    public void showEdges() {
        for (Edge v : edgeSet) {
            System.out.println(v.start + " --> " + v.end);
        }

    }

    private boolean containsEdge(T start, T end) {
        for (Iterator<Edge> i = edgeSet.iterator(); i.hasNext(); ) {
            Edge element = i.next();
            if (element.getStart().equals(start) && element.getEnd().equals(end)) {
                return true;
            }
        }
        return false;
    }


    private void makeMatrixNe() {
        matrixNe = new int[nodeSet.size()][nodeSet.size()];

        for (int j = 0; j < matrixNe.length; j++) {

            for (int k = 0; k < matrixNe.length; k++) {

                if (containsEdge(nodeSet.get(j).value, nodeSet.get(k).getValue()))
                    matrixNe[j][k] = 1;

                else
                    matrixNe[j][k] = 0;
            }
        }
    }

    private void showMatrixNe() {
        System.out.print("  ");
        for (int i = 0; i < nodeSet.size(); i++) {
            System.out.print(nodeSet.get(i).value + " ");
        }

        System.out.print("\n");

        for (int j = 0; j < matrixNe.length; j++) {
            System.out.print(nodeSet.get(j).value + " ");
            for (int k = 0; k < matrixNe.length; k++) {

                System.out.print(matrixNe[j][k] + " ");
            }
            System.out.print("\n");
        }
    }

    private void makeList() {

        list = new LinkedList[nodeSet.size()];

        for (int i = 0; i < nodeSet.size(); i++) {
            list[i] = new LinkedList<>();
            list[i].add(nodeSet.get(i).value);
        }

        for (int i = 0; i < list.length; i++) {

            for (int j = 0; j < list.length; j++) {
                if (containsEdge(list[i].get(0), nodeSet.get(j).value)) {
                    list[i].add(nodeSet.get(j).value);
                }
            }
        }
    }

    private void showList() {
        for (int i = 0; i < list.length; i++) {

            for (int j = 0; j < list[i].size(); j++) {
                System.out.print(list[i].get(j) + " ");
            }
            System.out.print("\n");
        }
    }

    private void makeMatrixIn() {

        matrixIn = new int[nodeSet.size()][edgeSet.size()];

        for (int i = 0; i < nodeSet.size(); i++) {

            for (int j = 0; j < edgeSet.size(); j++) {

                if (edgeSet.get(j).start.equals(nodeSet.get(i).value)) {
                    matrixIn[i][j] = -1;
                } else if (edgeSet.get(j).end.equals(nodeSet.get(i).value)) {
                    matrixIn[i][j] = 1;
                } else
                    matrixIn[i][j] = 0;
            }
        }
    }

    private void showMatrixIn() {

        System.out.print("  ");
        for (int i = 0; i < edgeSet.size(); i++) {
            System.out.print("e" + i + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < matrixIn.length; i++) {
            System.out.print(nodeSet.get(i).value + " ");
            for (int j = 0; j < matrixIn[i].length; j++) {
                System.out.print(matrixIn[i][j] + " ");
            }
            System.out.print("\n");
        }


    }
}






