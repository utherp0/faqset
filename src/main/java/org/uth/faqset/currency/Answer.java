package org.uth.faqset.currency;

import java.util.List;
import java.util.ArrayList;

public class Answer
{
  private String _answer = null;
  private String _keywords = null;
  private List<Score> _scores = null;
  private long _creationDate = 0;
  private String _contributor = null;

  // Accessors
  public String getAnswer() { return _answer; }
  public String getKeywords() { return _keywords; }
  public List<Score> getScores() { return _scores; }
  public long getCreationDate() { return _creationDate; }
  public String getContributor() { return _contributor; }

  public Answer( String answer, String contributor )
  {
    this( answer, answer, contributor );
  }

  public Answer( String answer, String keywords, String contributor )
  {
    _answer = answer;
    _keywords = Stopwords.applyStopWords(keywords);
    _scores = new ArrayList<Score>();
    _creationDate = System.currentTimeMillis();
    _contributor = contributor;
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