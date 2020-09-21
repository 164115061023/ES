package com.zl.composize;

public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode branchNode1 = new BranchNode("1-1");
        BranchNode branchNode2 = new BranchNode("2-1");
        LeafNode leafNode1 = new LeafNode("1-1-1");
        LeafNode leafNode2 = new LeafNode("1-1-2");
        BranchNode branchNode3 = new BranchNode("2-1-1");
        LeafNode leafNode3 = new LeafNode("2-1-1-1");
        LeafNode leafNode4 = new LeafNode("2-1-1-2");


        root.add(branchNode1);
        root.add(branchNode2);
        branchNode1.add(leafNode1);
        branchNode1.add(leafNode2);
        branchNode2.add(branchNode3);
        branchNode3.add(leafNode3);
        branchNode3.add(leafNode4);

        tree(root);


    }

    public static void tree(Node node) {
        node.print();
        if (node instanceof BranchNode) {
            BranchNode branchNode = (BranchNode)node;
            for (Node branchNode1: branchNode.nodes)
                tree(branchNode1);
        }
    }
}
