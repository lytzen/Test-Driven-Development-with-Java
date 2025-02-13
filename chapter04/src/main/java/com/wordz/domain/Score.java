package com.wordz.domain;

import java.util.ArrayList;
import java.util.List;

public class Score {

  private final String correct;

  private final List<Letter> results = new ArrayList<Letter>();

  private int position;

  public Score(String correct) {
    this.correct = correct;
  }

  public Letter letter(int position) {
    return results.get(position);
  }

  public void assess(String attempt) {
    for (char currentLetter : attempt.toCharArray()) {
      results.add(scoreFor(currentLetter));
      position++;
    }
  }

  private Letter scoreFor(char currentLetter) {
    if (isCorrectLetter(currentLetter)) {
      return Letter.CORRECT;
    }
    if (occursInWord(currentLetter)) {
      return Letter.PART_CORRECT;
    }
    return Letter.INCORRECT;
  }

  private boolean occursInWord(char currentLetter) {
    return correct.contains(String.valueOf(currentLetter));
  }

  private boolean isCorrectLetter(char currentLetter) {
    return correct.charAt(position) == currentLetter;
  }
}
