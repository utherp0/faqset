package org.uth.faqset.currency;

import java.util.HashMap;

import org.uth.faqset.utils.DateFormatter;

public class FAQ
{
  private HashMap<String,Question> _faq = null;
  private String _name = null;
  private String _owner = null;
  private long _creationDate = 0;

  public FAQ( String name, String owner )
  {
    _name = name;
    _owner = owner;
    _creationDate = System.currentTimeMillis();

    _faq = new HashMap<String,Question>();
  }

  // Accessors
  public String getName() { return _name; }
  public String getOwner() { return _owner; }
  public long getCreationDate() { return _creationDate; }

  // Mutators
  public boolean addQuestion( Question question )
  {
    if( _faq.containsKey(question.getKeywords()))
    {
      return false;
    }

    _faq.put(question.getKeywords(), question );
    return true;
  }

  public Question removeQuestion( String keywords )
  {
    if( !( _faq.containsKey(keywords)))
    {
      return null;
    }

    Question question = _faq.get(keywords);
    _faq.remove(keywords);

    return question;
  }

  public Question fetchQuestion( String keywords )
  {
    if( !( _faq.containsKey(keywords)))
    {
      return null;
    }

    return _faq.get(keywords);
  }

  public String export( String format )
  {
    StringBuilder output = new StringBuilder();

    switch( format )
    {
      case "xml":

        output.append( "<faq>\n");
        output.append( "  <name>" + _name + "</name>\n");
        output.append( "  <owner>" + _owner + "</owner>\n");
        output.append( "  <created>" + DateFormatter.longDateFormat(_creationDate) + "</created>\n");

        for( Question question : _faq.values())
        {
          output.append( question.export("xml", "  ") + "\n");
        }

        output.append( "</faq>");

      break;
    }

    return output.toString();
  }
}