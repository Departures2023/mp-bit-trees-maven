package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Trees intended to be used in storing mappings between fixed-length
 * sequences of bits and corresponding values.
 *
 * @author Kevin Tang
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * root of BitTree.
   */
  BitTreeNode root;
  /**
   * size of BitTree.
   */
  int size;
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * constructor of BitTree.
   * @param n size of BitTree
   */
  public BitTree(int n) {
    this.root = null;
    this.size = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+
  /**
   * Helper function of set method.
   * @param bits input bits (directory)
   * @param value input value to be set
   * @param root root of BitTree
   * @return Updated root node
   */
  private BitTreeNode setHelper(String bits, String value, BitTreeNode root) {
    if (root == null) {
      root = new BitTreeNode(null);
    } // if
    if (bits.length() == 0) {
      root.value = value;
      return root;
    } // if
    String bit = bits.substring(0, 1);
    if (bit.equals("0")) {
      root.leftNode = setHelper(bits.substring(1), value, root.getLeftNode());
    } else if (bit.equals("1")) {
      root.rightNode = setHelper(bits.substring(1), value, root.getRightNode());
    } else {
      throw new IndexOutOfBoundsException(bit);
    } // if
    return root;
  } // setHelper

  /**
   * Helper function of get method.
   * @param bits input bits (directory)
   * @param root root of BitTree
   * @return string in that node
   */
  private String getHelper(String bits, BitTreeNode root) {
    if (bits.length() == 0) {
      if (root == null) {
        return "Trouble translating because No corresponding value";
      } // if
      return root.getValue();
    } // if
    String bit = bits.substring(0, 1);
    if (bit.equals("0")) {
      if (root.getLeftNode() == null) {
        return "\nTrouble translating because No corresponding value";
      } // if
      return getHelper(bits.substring(1), root.getLeftNode());
    } else if (bit.equals("1")) {
      if (root.getRightNode() == null) {
        return "\nTrouble translating because No corresponding value";
      } // if
      return getHelper(bits.substring(1), root.getRightNode());
    } else {
      throw new IndexOutOfBoundsException();
    } // else
  } // getHelper

  /**
   * Helper function of dump method.
   * @param bits input bits (directory)
   * @param pen printwriter
   * @param root root of BitTree
   */
  private void dumpHelper(PrintWriter pen, BitTreeNode root, String bits) {
    if (root == null) {
      pen.println("");
    } // if
    if (root.value != null) {
      pen.println(bits + "," + root.getValue());
    } // if
    if (root.getLeftNode() != null) {
      dumpHelper(pen, root.getLeftNode(), bits + "0");
    } // if
    if (root.getRightNode() != null) {
      dumpHelper(pen, root.getRightNode(), bits + "1");
    } // if
  } // dumpHelper

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * set a node in bitTree.
   * @param bits input bits (directory)
   * @param value input value to be set
   */
  public void set(String bits, String value) {
    this.root = setHelper(bits, value, this.root);
  } // set(String, String)

  /**
   * get a node in bitTree.
   * @param bits input bits (directory)
   * @return string stored in the node
   */
  public String get(String bits) {
    return getHelper(bits, this.root);
  } // get(String, String)

  /**
   * print out the whole tree.
   * @param pen printwriter
   */
  public void dump(PrintWriter pen) {
    dumpHelper(pen, this.root, null);
  } // dump(PrintWriter)

  /**
   * load conversion reference into the tree.
   * @param source conversion reference
   */
  public void load(InputStream source) {
    Scanner input = new Scanner(source);
    while (input.hasNextLine()) {
      String[] rawRow = input.nextLine().split(",");
      this.set(rawRow[0], rawRow[1]);
    } // while
    input.close();
  } // load(InputStream)

} // class BitTree
