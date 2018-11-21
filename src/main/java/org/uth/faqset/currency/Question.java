package org.uth.faqset.currency;

import java.util.ArrayList;
import java.util.List;

import org.uth.faqset.exceptions.FAQSetFormatException;
import org.uth.faqset.utils.DateFormatter;

public class Question
{
  private String _question = null;
  private String _keywords = null;
  private List<Answer> _answers = null;  
  private long _creationDate = 0;
  private String _contributor = null;

  // Accessors
  public String getQuestion() { return _question; }
  public String getKeywords() { return _keywords; }
  public List<Answer> getAnswers() { return _answers; }
  public long getCreationDate() { return _creationDate; }
  public String getContributor() { return _contributor; }

  public Question( String question, String keywords, String contributor )
  {
    _question = question;
    _creationDate = System.currentTimeMillis();
    _contributor = contributor;

    // Remove all stopwords from the keywords for better searching
    _keywords = Stopwords.applyStopWords(keywords);

    _answers = new ArrayList<Answer>();
  }

  public Question( String question, String contributor )
  {
    this(question,question, contributor);
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

  public String export( String format, String padding )
  {
    // Format defines the output mechanism for the object - currently XML (soon YAML, JSON)
    StringBuilder output = new StringBuilder();

    switch( format )
    {
      case "xml":
      {
        output.append( padding + "<question>\n");
        output.append( padding + "  <text>" + _question + "</text>\n");
        output.append( padding + "  <keywords>" + _keywords + "</keywords>\n");
        output.append( padding + "  <created>" + DateFormatter.longDateFormat( _creationDate ) + "</created>\n");
        output.append( padding + "  <answers>\n");

        for( Answer answer : _answers )
        {
          output.append( padding + "    <answer>\n");
          output.append( padding + "      <text>" + answer.getAnswer() + "</text>\n");
          output.append( padding + "      <contributor>" + answer.getContributor() + "</contributor>\n");
          output.append( padding + "      <created>" + DateFormatter.longDateFormat(answer.getCreationDate()) + "</created>\n");
          output.append( padding + "      <scores>\n");

          for( Score score : answer.getScores())
          {
            output.append( padding + "        <score>\n");
            output.append( padding + "          <value>" + score.getScore() + "</value>\n");
            output.append( padding + "          <contributor>" + score.getContributor() + "</contributor>\n");
            output.append( padding + "          <created>" + DateFormatter.longDateFormat(score.getCreationDate()) + "</created>\n");
            output.append( padding + "        </score>\n");
          }
        
          output.append( padding + "      </scores>\n");
          output.append( padding + "    </answer>\n");
        }

        output.append( padding + " </answers>\n");
        output.append( padding + "</question>");

        break;
      }
      default:
    }

    return output.toString();
  }
}