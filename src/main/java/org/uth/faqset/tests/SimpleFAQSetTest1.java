package org.uth.faqset.tests;

import java.util.ArrayList;
import java.util.List;

import org.uth.faqset.currency.Answer;
import org.uth.faqset.currency.Question;

public class SimpleFAQSetTest1
{
  public static void main( String[] args )
  {
    if( args.length != 1 )
    {
      System.out.println( "Usage: java SimpleFAQSetTest1 username");
      System.exit(0);
    }

    new SimpleFAQSetTest1( args[0]);
  }

  public SimpleFAQSetTest1( String user )
  {
    // Create a simple faqset
    List<Question> faq1 = new ArrayList<Question>();

    Question question1 = new Question( "What day comes after Monday?", user);
    Answer question1a1 = new Answer( "Tuesday", user);
    Answer question1a2 = new Answer( "Wednesday", user);

    question1a1.addScore("Uther", 100);
    question1a2.addScore("Uther",0);

    question1.addAnswer(question1a1);
    question1.addAnswer(question1a2);

    faq1.add(question1);

    Question question2 = new Question("What version of OpenShift is currently the newest?", user);
    Answer question2a1 = new Answer( "3.11", user);
    Answer question2a2 = new Answer( "3.10", user);
    Answer question2a3 = new Answer( "3.9", user);

    question2a1.addScore("Lemonhead", 100);
    question2a1.addScore("Uther", 100);
    question2a2.addScore("Lemonhead", 90);
    question2a2.addScore("Uther", 10);
    question2a3.addScore("Lemonhead", 10);
    question2a3.addScore("Uther", 0);

    question2.addAnswer(question2a1);
    question2.addAnswer(question2a2);
    question2.addAnswer(question2a3);

    faq1.add(question2);

    // Output the XML
    try
    {
      for( Question question : faq1 )
      {
        System.out.println( "" );
        System.out.println( question.export("xml", ""));
      }
    }
    catch( Exception exc )
    {
      System.out.println( "Exception occured " + exc.toString());
    }
  }
}