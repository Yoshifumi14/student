package com.aggregate;

/**
  * 順位表の1レコード
  */
public class RankingRecord {
  private final String name;
  private final int totalScore;
  private final int rank;
  
  public RankingRecord(String name, int totalScore, int rank){
    this.name = name;
    this.totalScore = totalScore;
    this.rank = rank;
  }
  
  public String getName() {
    return name;
  }

  public int getTotalScore() {
    return totalScore;
  }

  public int getRank() {
    return rank;
  }
}
