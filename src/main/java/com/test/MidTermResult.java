package com.test;

public class MidTermResult implements TestResult {
  private final String name; 
  private final int math;
  private final int japanese;
  private final int english;

  public MidTermResult(String name, int math, int japanese, int english){
    this.name = name;
    this.math = math;
    this.japanese = japanese;
    this.english = english;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getTotalScore() {
    return math + japanese + english;
  }

  @Override
  public int compareTo(TestResult o) {
    return this.getTotalScore() > o.getTotalScore() ? -1 : 1;
  }
}
