package com.junahan;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Huffman coding tree.
 */
public class HuffmanTree {
  private BinNode root;        // Root of the Huffman coding tree.

  public HuffmanTree(LetterFreq value) {
    root = new BinNodePtr(value);
  }

  public HuffmanTree(LetterFreq value, HuffmanTree left, HuffmanTree right) {
    root = new BinNodePtr(value, left.root, right.root);
  }

  public BinNode getRoot() {
    return root;
  }

  public int weight() {
    return ((LetterFreq)root.element()).getFreq();
  }

  /**
   * Build the Huffman coding tree from all leaf node list.
   *
   * @param huffmanList
   * @return
   */
  public static HuffmanTree buildTree(List<HuffmanTree> huffmanList) {
    HuffmanTree temp1, temp2, temp3;
    LetterFreq tempNode;
    HuffmanTreeCompator compator = new HuffmanTreeCompator();

    Collections.sort(huffmanList,compator);

    for (;huffmanList.size() >= 2;) {
      temp1 = huffmanList.remove(0);
      temp2 = huffmanList.remove(0);
      tempNode = new LetterFreq('0',temp1.weight() + temp2.weight());
      temp3 = new HuffmanTree(tempNode, temp1, temp2);

      // insert the new node and sorted it.
      huffmanList.add(temp3);
      Collections.sort(huffmanList,compator);
    }
    return huffmanList.remove(0);
  }

  public static Map<Character,String> genEncodingTable(HuffmanTree root) {
    Map<Character,String> encodingTable = new HashMap<>();
    genEncodingHelp(root.getRoot(), encodingTable, "");
    return encodingTable;
  }

  public static String encoding(HuffmanTree root, String text) {
    if (root == null) return null;
    Map<Character,String> encodingTable = genEncodingTable(root);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < text.length(); i++ ) {
      sb.append(encodingTable.get(text.charAt(i)));
    }
    return sb.toString();
  }

  public static String decoding(HuffmanTree root, boolean[] codes) {
    if (root == null) return null;
    StringBuilder sb = new StringBuilder();
    BinNode temp = root.getRoot();
    for (boolean code:codes) {
      if (!code) {
        temp = temp.left();
      } else {
        temp = temp.right();
      }
      if (temp.isLeaf()) {
        sb.append(((LetterFreq)temp.element()).getLetter());
        temp = root.getRoot();
      }
    }
    return sb.toString();
  }

  private static void genEncodingHelp(BinNode node, Map<Character,String> encodingTable, String path) {
    if (node == null) return;
    if (node.isLeaf()) {
      LetterFreq lf = (LetterFreq)node.element();
      encodingTable.put(lf.getLetter(),path);
    } else {
      genEncodingHelp(node.left(), encodingTable, path + "0");
      genEncodingHelp(node.right(), encodingTable, path + "1");
    }
  }

  static class HuffmanTreeCompator implements Comparator<HuffmanTree> {
    @Override
    public int compare(HuffmanTree o1, HuffmanTree o2) {
      if (o1.weight() > o2.weight()) {
        return 1;
      } else if (o1.weight() < o2.weight()) {
        return -1;
      }
      return 0;
    }
  }
}
