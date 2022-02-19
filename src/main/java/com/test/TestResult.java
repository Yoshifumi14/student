package com.test;

public interface TestResult extends Comparable<TestResult> {
  public String getName();
  public int getTotalScore();
}
