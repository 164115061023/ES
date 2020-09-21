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
}
