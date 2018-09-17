package org.uth.faqset.currency;

import java.util.List;

public class Question
{
  private String _question = null;
  private String _keywords = null;
  private List<Answer> _answers = null;  

  // Accessors
  public String getQuestion() { return _question; }
  public String getKeywords() { return _keywords; }
  public List<Answer> getAnswers() { return _answers; }

  public Question( String question, String keywords )
  {
    _question = question;
    _keywords = keywords;
  }

  public Question( String question )
  {
    this(question,question);
  }

  // Mutators
  public void setQuestion( String question ) { _question = question; }

  public void addAnswer( Answer answer )
  {
    _answers.add(answer);
  }

  public boolean deleteAnswer( Answer answerToDelete )
  {
    for( Answer answer : _answers )
    {
      if( answer == answerToDelete )
      {
        _answers.remove(answerToDelete);
        return true;
      }
    }

    return false;
  }
}