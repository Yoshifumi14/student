package com.aggregate;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.ArrayList;
import java.util.Collections;

import com.test.TestResult;

/**
  * テストの集計
  */
public class Aggregate implements Aggregatable {
  private final List<TestResult> testResultList;

  public Aggregate(List<TestResult> testResultList){
    this.testResultList = testResultList;
  }
  public List<TestResult> getTestResultList() {
    return testResultList;
  }

  @Override
  public int getMeans() {
    OptionalDouble result = testResultList.stream().mapToInt(testResult -> testResult.getTotalScore()).average();
    return (int) Math.round(result.getAsDouble());
  }
  
  @Override
  public List<RankingRecord> getRankingRecordList() {
    List<TestResult> sortTargetList = this.testResultList;
    Collections.sort(sortTargetList);
    List<RankingRecord> rankingList = new ArrayList<>();
    int rank = 1;
    for(TestResult testResult: sortTargetList){
      rankingList.add(new RankingRecord(testResult.getName(), testResult.getTotalScore(), rank++));
    }
    return rankingList;
  }

  @Override
  public Optional<RankingRecord> getRecord(String name) {
   Optional<RankingRecord> targetRecord = Optional.empty();
    for(RankingRecord record: getRankingRecordList()){
      if(record.getName() == name){
        targetRecord = Optional.of(record);
      }
    };
    return targetRecord;
  }
}

