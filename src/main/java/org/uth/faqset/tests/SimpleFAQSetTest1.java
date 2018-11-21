package org.uth.faqset.tests;

import java.util.List;
import java.util.ArrayList;
import org.uth.faqset.currency.Answer;
import org.uth.faqset.currency.Question;

public class SimpleFAQSetTest1
{
  public static void main( String[] args )
  {
    new SimpleFAQSetTest1();
  }

  public SimpleFAQSetTest1()
  {
    // Create a simple faqset
    List<Question> faq1 = new ArrayList<Question>();

    Question question1 = new Question( "What day comes after Monday?");
    Answer question1a1 = new Answer( "Tuesday");
    Answer question1a2 = new Answer( "Wednesday");

    question1a1.addScore("Uther", 100);
    question1a2.addScore("Uther",0);

    question1.addAnswer(question1a1);
    question1.addAnswer(question1a2);

    faq1.add(question1);
  }
}