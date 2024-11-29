package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 *
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
     * @throws Exception
     * @param args
     */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    BrailleAsciiTables reference = new BrailleAsciiTables();
    String targetStr = args[0];
    String sourceStr = args[1];
    if (targetStr.equals("braille")) {
      char[] tmp = sourceStr.toCharArray();
      for (char ch : tmp) {
        pen.print(reference.toBraille(ch));
      } // for
      System.exit(0);
    } else if (targetStr.equals("ascii")) {
      pen.println(reference.toAscii(sourceStr));
      System.exit(0);
    } else if (targetStr.equals("unicode")) {
      pen.println(reference.toUnicode(sourceStr));
      System.exit(0);
    } else {
      System.err.println("Invalid target character");
      System.exit(1);
    } // if

    pen.close();
  } // main(String[]

} // class BrailleASCII
