package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import com.aggregate.Aggregatable;
import com.aggregate.Aggregate;
import com.test.EndTermResult;
import com.test.MidTermResult;
import com.test.TestResult;

public class Sample {
  public static void main(String[] args) {
    System.out.println("======= 定期テスト集計プログラム =======");

    List<TestResult> midTermResults = getRandomMidTermResultList(30);
    System.out.println("中間テストの結果です");
    printTestResults(midTermResults);
    Aggregatable midTermAggregate = new Aggregate(midTermResults);
    printAggregate(midTermAggregate);

    System.out.println();

    System.out.println("期末テストの結果です");
    List<TestResult> endTermResults = getRandomEndTermResultList(30);
    printTestResults(endTermResults);
    Aggregatable endTermAggregate = new Aggregate(endTermResults);
    printAggregate(endTermAggregate);
  }

  private static List<TestResult> getRandomMidTermResultList(int length){
    List<TestResult> resultList = new ArrayList<>();
    Random ran = new Random();
    IntStream.range(1, length).forEach(i -> {
      resultList.add(new MidTermResult("生徒"+i, ran.nextInt(100), ran.nextInt(100), ran.nextInt(100)));
    });
    return resultList;
  }

  private static List<TestResult> getRandomEndTermResultList(int length){
    List<TestResult> resultList = new ArrayList<>();
    Random ran = new Random();
    IntStream.range(1, length).forEach(i -> {
      resultList.add(new EndTermResult("生徒"+i, ran.nextInt(100), ran.nextInt(100), ran.nextInt(100),ran.nextInt(100),ran.nextInt(100)));
    });
    return resultList;
  }

  private static void printTestResults(List<TestResult> testResultList) {
    testResultList.stream().forEach(result -> {
      System.out.println(" "+result.getName() +": "+ result.getTotalScore()+"点");
    });
  }

  private static void printAggregate(Aggregatable aggregate){
    System.out.println("~~~~ 集計結果 ~~~~");
    System.out.println(" 平均: "+ aggregate.getMeans());
    aggregate.getRankingRecordList().stream().forEach(record -> {
      System.out.println(" "+record.getRank() + "位, " + record.getName() + ", " + record.getTotalScore()+"点");
    });
  }
}