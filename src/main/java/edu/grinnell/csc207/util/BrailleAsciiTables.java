package edu.grinnell.csc207.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

/**
 *
 *
 * @author Your Name Here
 * @author Samuel A. Rebelsky
 */
public class BrailleAsciiTables {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * Conversions from braille to ASCII.
   */
  static final String b2a = 
      """
      100000,A
      110000,B
      100100,C
      100110,D
      100010,E
      110100,F
      110110,G
      110010,H
      010100,I
      010110,J
      101000,K
      111000,L
      101100,M
      101110,N
      101010,O
      111100,P
      111110,Q
      111010,R
      011100,S
      011110,T
      101001,U
      111001,V
      101101,X
      101111,Y
      101011,Z
      010111,W
      000000, 
      """;

  /**
   * Conversions from ASCII to braille.
   */
  static final String a2b = 
      """
      01000001,100000
      01000010,110000
      01000011,100100
      01000100,100110
      01000101,100010
      01000110,110100
      01000111,110110
      01001000,110010
      01001001,010100
      01001010,010110
      01001011,101000
      01001100,111000
      01001101,101100
      01001110,101110
      01001111,101010
      01010000,111100
      01010001,111110
      01010010,111010
      01010011,011100
      01010100,011110
      01010101,101001
      01010110,111001
      01010111,010111
      01011000,101101
      01011001,101111
      01011010,101011
      01100001,100000
      01100010,110000
      01100011,100100
      01100100,100110
      01100101,100010
      01100110,110100
      01100111,110110
      01101000,110010
      01101001,010100
      01101010,010110
      01101011,101000
      01101100,111000
      01101101,101100
      01101110,101110
      01101111,101010
      01110000,111100
      01110001,111110
      01110010,111010
      01110011,011100
      01110100,011110
      01110101,101001
      01110110,111001
      01110111,010111
      01111000,101101
      01111001,101111
      01111010,101011
      00100000,000000
      """;


  /**
   * Conversions from ASCII to braille.
   */
  static final String b2u = 
      """
      000000,2800
      100000,2801
      010000,2802
      110000,2803
      001000,2804
      101000,2805
      011000,2806
      111000,2807
      000100,2808
      100100,2809
      010100,280A
      110100,280B
      001100,280C
      101100,280D
      011100,280E
      111100,280F
      000010,2810
      100010,2811
      010010,2812
      110010,2813
      001010,2814
      101010,2815
      011010,2816
      111010,2817
      000110,2818
      100110,2819
      010110,281A
      110110,281B
      001110,281C
      101110,281D
      011110,281E
      111110,281F
      000001,2820
      100001,2821
      010001,2822
      110001,2823
      001001,2824
      101001,2825
      011001,2826
      111001,2827
      000101,2828
      100101,2829
      010101,282A
      110101,282B
      001101,282C
      101101,282D
      011101,282E
      111101,282F
      000011,2830
      100011,2831
      010011,2832
      110011,2833
      001011,2834
      101011,2835
      011011,2836
      111011,2837
      000111,2838
      100111,2839
      010111,283A
      110111,283B
      001111,283C
      101111,283D
      011111,283E
      111111,283F
      """;


  // +---------------+-----------------------------------------------
  // | Static fields |
  // +---------------+

  /**
   *
   */
  static BitTree a2bTree = null;

  /**
   *
   */
  static BitTree b2aTree = null;

  /**
   *
   */
  static BitTree b2uTree = null;

  // +-----------------------+---------------------------------------
  // | Static helper methods |
  // +-----------------------+

  // +----------------+----------------------------------------------
  // | Static methods |
  // +----------------+

  /**
   *
   */
  public String toBraille(char letter) {
    // Make sure we've loaded the braille-to-ASCII tree.
    if (null == a2bTree) {
      a2bTree = new BitTree(8);
      InputStream a2bStream = new ByteArrayInputStream(a2b.getBytes());
      a2bTree.load(a2bStream);
      try {
        a2bStream.close();
      } catch (IOException e) {
        // We don't care if we can't close the stream.
      } // try/catch
    } // if
    return a2bTree.get(Integer.toBinaryString(letter));
  } // toBraille(char)

  /**
   *
   */
  public String toAscii(String bits) {
    // Make sure we've loaded the braille-to-ASCII tree.
    if (null == b2aTree) {
      b2aTree = new BitTree(6);
      InputStream b2aStream = new ByteArrayInputStream(b2a.getBytes());
      b2aTree.load(b2aStream);
      try {
        b2aStream.close();
      } catch (IOException e) {
        // We don't care if we can't close the stream.
      } // try/catch
    } // if
    return b2aTree.get(bits);
  } // toAscii(String)

  /**
   *
   */
  public String toUnicode(String bits) {
    // Make sure we've loaded the braille-to-ASCII tree.
    if (null == b2uTree) {
      b2uTree = new BitTree(6);
      InputStream b2uStream = new ByteArrayInputStream(b2u.getBytes());
      b2uTree.load(b2uStream);
      try {
        b2uStream.close();
      } catch (IOException e) {
        // We don't care if we can't close the stream.
      } // try/catch
    } // if
    return b2uTree.get(bits);
  } // toUnicode(String)
} // BrailleAsciiTables
