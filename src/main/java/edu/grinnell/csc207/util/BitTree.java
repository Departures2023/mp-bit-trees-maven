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
  BitTreeNode root;
  int size;
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   *
   */
  public BitTree(int n) {
    this.root = null;
    this.size = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  private void setHelper(String bits, String value, BitTreeNode root) {
    if (this.root == null) {
      this.root = new BitTreeNode(null);
    }
    if (bits.length() == 0) {
      root.setValue(value);
    }
    String bit = bits.substring(0, 1);
    if (bit.equals("0")) {
      setHelper(bits.substring(1), value, root.getLeftNode());
    } else if (bit.equals("1")) {
      setHelper(bits.substring(1), value, root.getRightNode());
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  private String getHelper(String bits, BitTreeNode root) {
    if (bits.length() == 0) {
      return this.root.getValue();
    }
    String bit = bits.substring(0, 1);
    if (bit.equals("0")) {
      return getHelper(bits.substring(1), root.getLeftNode());
    } else if (bit.equals("1")) {
      return getHelper(bits.substring(1), root.getRightNode());
    } else {
      throw new IndexOutOfBoundsException();
    }

  }

  private void dumpHelper(PrintWriter pen, BitTreeNode root, String bits) {
    if (root == null) {
      pen.println("");
    }
    if (root.value != null) {
      pen.println(bits + "," + root.getValue());
    }
    if (root.getLeftNode() != null) {
      dumpHelper(pen, root.getLeftNode(), bits + "0");
    }
    if (root.getRightNode() != null) {
      dumpHelper(pen, root.getRightNode(), bits + "1");
    }
  }

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   *
   */
  public void set(String bits, String value) {
    setHelper(bits, value, this.root);
  } // set(String, String)

  /**
   *
   */
  public String get(String bits) {
    return getHelper(bits, root);
  } // get(String, String)

  /**
   *
   */
  public void dump(PrintWriter pen) {
    dumpHelper(pen, this.root, null);
  } // dump(PrintWriter)

  /**
   *
   */
  public void load(InputStream source) {
    Scanner input = new Scanner(source);
    while (input.hasNextLine()) {
      String[] rawRow = input.nextLine().split(",");
      this.set(rawRow[0], rawRow[1]);
    }
    input.close();
  } // load(InputStream)

} // class BitTree
