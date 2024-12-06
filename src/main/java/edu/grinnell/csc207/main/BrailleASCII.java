package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 *
 */
public class BrailleASCII {

  /**
   * Convert string to braille.
   *
   * @param input input string
   * @return the braille conversion of string
   * @throws Exception if input string is invalid
   */
  static String toBraille(String input) throws Exception {
    StringBuilder str = new StringBuilder();

    for (char c : input.toCharArray()) {
      str.append(BrailleAsciiTables.toBraille(c));
    } // for

    return str.toString();
  } // toBraille(String)

  /**
   * Convert string to ASCII.
   *
   * @param input input string
   * @return the ASCII conversion of string
   * @throws Exception if input string is invalid
   */
  static String toASCII(String input) throws Exception {
    StringBuilder str = new StringBuilder();

    for (int i = 0; i <= input.length() - 6; i += 6) {
      str.append(BrailleAsciiTables.toAscii(input.substring(i, i + 6)));
    } // for

    return str.toString();
  } // toASCII(String)

  /**
   * Convert string to Unicode.
   *
   * @param input input string
   * @return the unicode conversion string
   * @throws Exception if input string is invalid
   */
  static String toUnicode(String input) throws Exception {
    StringBuilder str = new StringBuilder();
    String[] arr = input.split(" ");
    for (String bits : arr) {
      String braille = toBraille(bits);
      for (int i = 0; i <= braille.length() - 6; i += 6) {
        str.append(BrailleAsciiTables.toUnicode(braille.substring(i, i + 6)));
      } // for
      str.append(" ");
    } // for

    return str.toString();
  } // toUnicode(String)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * @throws Exception Exception.
   * @param args command line arguments.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 2) {
      throw new Exception("Invalid input length");
    } // if

    switch (args[0]) {
      case "ascii":
        pen.println(toASCII(args[1]));
        break;
      case "braille":
        pen.println(toBraille(args[1]));
        break;
      case "unicode":
        pen.println(toUnicode(args[1]));
        break;
      default:
        throw new Exception("Trouble translating because No corresponding value");
    } // switch

    pen.close();
  } // main(String[]

} // class BrailleASCII
