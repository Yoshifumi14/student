package com.test;

public class EndTermResult implements TestResult {
  private final String name; 
  private final int math;
  private final int japanese;
  private final int english;
  private final int science;
  private final int social;

  public EndTermResult(String name, int math, int japanese, int english, int science, int social){
    this.name = name;
    this.math = math;
    this.japanese = japanese;
    this.english = english;
    this.science = science;
    this.social = social;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getTotalScore() {
    return math + japanese + english + science + social;
  }

  @Override
  public int compareTo(TestResult o) {
    return this.getTotalScore() > o.getTotalScore() ? -1 : 1;
  }
}
