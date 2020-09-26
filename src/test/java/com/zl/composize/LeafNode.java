package com.zl.composize;

public class LeafNode extends Node{

    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }

    @Override
    public void add(Node node) {
        System.out.println("这是叶子结点，不能添加元素");
    }
}
