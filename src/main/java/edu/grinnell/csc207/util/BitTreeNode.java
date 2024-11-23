package edu.grinnell.csc207.util;

public class BitTreeNode {
  int bit;
  BitTreeNode leftNode;
  BitTreeNode rightNode;

  public BitTreeNode(int bit) {
    this.bit = bit;
    this.leftNode = null;
    this.rightNode = null;
  }

  public BitTreeNode(int bit, BitTreeNode leftNode, BitTreeNode rightNode) {
    this.bit = bit;
    this.leftNode = leftNode;
    this.rightNode = rightNode;
  }

  public int getBit() {
    return this.bit;
  }

  public BitTreeNode getLeftNode() {
    return this.leftNode;
  }

  public BitTreeNode getRightNode() {
    return this.rightNode;
  }

  public int setBit(int bit) {
    return this.bit = bit;
  }

  public BitTreeNode getLeftNode(BitTreeNode leftNode) {
    return this.leftNode;
  }

  public BitTreeNode getRightNode(BitTreeNode rightNode) {
    return this.rightNode = rightNode;
  }
}
