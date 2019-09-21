package com.junahan.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.junahan.HuffmanTree;
import com.junahan.LetterFreq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class HuffmanTreeTest {
  private List<HuffmanTree> huffmanTreeList = new ArrayList<>();

  @Before
  public void setup() {
    huffmanTreeList.add(new HuffmanTree(new LetterFreq('C',32)));
    huffmanTreeList.add(new HuffmanTree(new LetterFreq('D',42)));
    huffmanTreeList.add(new HuffmanTree(new LetterFreq('E',120)));
    huffmanTreeList.add(new HuffmanTree(new LetterFreq('F',24)));
    huffmanTreeList.add(new HuffmanTree(new LetterFreq('K',7)));
    huffmanTreeList.add(new HuffmanTree(new LetterFreq('L',42)));
    huffmanTreeList.add(new HuffmanTree(new LetterFreq('U',37)));
    huffmanTreeList.add(new HuffmanTree(new LetterFreq('Z',2)));
  }

  @Test
  public void genEnocdingTableTest() {
    int expected = huffmanTreeList.size();
    HuffmanTree hft = HuffmanTree.buildTree(huffmanTreeList);
    Map<Character,String> encodingTable = HuffmanTree.genEncodingTable(hft);
    assertTrue(encodingTable.size() > 0);
    assertEquals(expected,encodingTable.size());
  }

  @Test
  public void encodingTest() {
    String text = "CDEEEEEEEFKLUZ";
    String expected = "1110" + "101" + "0000000" + "11111" + "111101" + "110" + "100" + "111100";
    HuffmanTree root = HuffmanTree.buildTree(huffmanTreeList);
    String r = HuffmanTree.encoding(root,text);
    assertNotNull(r);
    assertEquals(expected,r);
  }

  @Test
  public void decodingTest() {
    String expected = "CDEEEEEEEFKLUZ";
    String codeText = "1110" + "101" + "0000000" + "11111" + "111101" + "110" + "100" + "111100";
    HuffmanTree root = HuffmanTree.buildTree(huffmanTreeList);
    boolean[] codes = new boolean[codeText.length()];
    for (int i = 0; i < codeText.length(); i++) {
      codes[i] = (codeText.charAt(i) == '1');
    }
    String r = HuffmanTree.decoding(root, codes);
    assertNotNull(r);
    assertEquals(expected, r);
  }
}
