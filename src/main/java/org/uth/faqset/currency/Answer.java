package org.uth.faqset.currency;

import java.util.List;
import java.util.ArrayList;

public class Answer
{
  private String _answer = null;
  private String _keywords = null;
  private List<Score> _scores = null;

  // Accessors
  public String getAnswer() { return _answer; }
  public String getKeywords() { return _keywords; }
  public List<Score> getScores() { return _scores; }

  public Answer( String answer )
  {
    this( answer, answer );
  }

  public Answer( String answer, String keywords )
  {
    _answer = answer;
    _keywords = keywords;
    _scores = new ArrayList<Score>();
  }

  // Mutators
  public void setAnswer( String answer ) { _answer = answer; }
  public void setKeywords( String keywords ) { _keywords = keywords; }

  public boolean deleteScore( String contributor )
  {
    for( Score score : _scores )
    {
      if( score.getContributor().equals( contributor ))
      {
        _scores.remove(score);
        return true;
      }
    }

    return false;
  }

  public void addScore( String contributor, int scoreValue )
  {
    Score score = new Score( scoreValue, contributor );

    this.deleteScore(contributor);
    _scores.add(score);
  }
}