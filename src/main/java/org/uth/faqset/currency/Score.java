package org.uth.faqset.currency;

import java.util.List;

public class Score
{
  private int _score = 0;
  private String _contributor = null;
  private long _creationDate = 0;

  // Accessors
  public int getScore() { return _score; }
  public String getContributor() { return _contributor; }
  public long getCreationDate() { return _creationDate; }

  public Score( int score, String contributor )
  {
    _score = score;
    _contributor = contributor;
    _creationDate = System.currentTimeMillis();
  }

  /**
   * Static helper method for aggregating all scores.
   * @param scores list of scores to aggregate
   * @return integer aggregation of scores
   */
  public static int aggregate( List<Score> scores )
  {
    int total = 0;

    for( Score score : scores )
    {
      total += score.getScore();
    }

    return (Integer)( total / scores.size());
  }
}