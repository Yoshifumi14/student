package com.aggregate;

import java.util.List;
import java.util.Optional;

public interface Aggregatable {
  public abstract int getMeans();
  public abstract List<RankingRecord> getRankingRecordList();
  public abstract Optional<RankingRecord> getRecord(String name);
}
