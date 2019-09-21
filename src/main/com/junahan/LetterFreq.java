package com.junahan;

import java.util.Objects;

public class LetterFreq implements Comparable {
  private char letter;
  private int freq;

  public LetterFreq(char letter, int freq) {
    this.letter = letter;
    this.freq = freq;
  }

  public char getLetter() {
    return letter;
  }

  public int getFreq() {
    return freq;
  }

  @Override
  public int compareTo(Object o) {
    int r= 0;
    LetterFreq lf = (LetterFreq)o;
    if (this.freq > lf.getFreq()) {
      r = 1;
    } else if (this.freq < lf.getFreq()) {
      r = -1;
    }
    return r;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LetterFreq)) {
      return false;
    }
    LetterFreq that = (LetterFreq) o;
    return getLetter() == that.getLetter() &&
        getFreq() == that.getFreq();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getLetter(), getFreq());
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("LetterFreq{");
    sb.append("letter=").append(letter);
    sb.append(", freq=").append(freq);
    sb.append('}');
    return sb.toString();
  }
}
