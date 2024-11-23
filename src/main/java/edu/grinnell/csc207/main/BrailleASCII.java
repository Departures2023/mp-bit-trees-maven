package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import java.util.Scanner;
import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 *
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   *
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    BrailleAsciiTables reference = new BrailleAsciiTables();
    String targetStr = args[0];
    String sourceStr = args[1];
    if (targetStr.equals("braille")) {
      char[] tmp = sourceStr.toCharArray();
      for (char ch : tmp) {
        System.out.print(reference.toBraille(ch));
      }
      System.exit(0);
    } else if (targetStr.equals("ascii")) {
      System.out.println(reference.toAscii(sourceStr));
      System.exit(0);
    } else if (targetStr.equals("unicode")) {
      System.out.println(reference.toUnicode(sourceStr));
      System.exit(0);
    } else {
      System.err.println("Invalid target character");
      System.exit(1);
    }

    pen.close();
  } // main(String[]

} // class BrailleASCII
