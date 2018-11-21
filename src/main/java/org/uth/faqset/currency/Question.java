package org.uth.faqset.currency;

import org.uth.faqset.exceptions.*;
import java.util.List;

public class Question
{
  private String _question = null;
  private String _keywords = null;
  private List<Answer> _answers = null;  
  private long _creationDate = 0;

  // Accessors
  public String getQuestion() { return _question; }
  public String getKeywords() { return _keywords; }
  public List<Answer> getAnswers() { return _answers; }
  public long getCreationDate() { return _creationDate; }

  public Question( String question, String keywords )
  {
    _question = question;
    _creationDate = System.currentTimeMillis();

    // Remove all stopwords from the keywords for better searching
    _keywords = Stopwords.applyStopWords(keywords);
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

  public String export( String format ) throws FAQSetFormatException
  {
    // Format defines the output mechanism for the object - currently XML (soon YAML, JSON)
    StringBuilder output = new StringBuilder();

    switch( format )
    {
      case "xml":
      {
        output.append( "<faqset>\n");

        output.append( "</faqset>");

        break;
      }
      default:
    }

    return output.toString();
  }
}