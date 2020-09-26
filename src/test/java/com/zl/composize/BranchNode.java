package com.zl.composize;

import java.util.ArrayList;
import java.util.List;

public class BranchNode extends Node{
    String name;
    public List<Node> nodes = new ArrayList<>();
    public BranchNode(String name) {
        this.name = name;
    }
    @Override
    public void print() {
        System.out.println(name);
    }
    @Override
    public void add(Node node) {
        nodes.add(node);
    }
}
