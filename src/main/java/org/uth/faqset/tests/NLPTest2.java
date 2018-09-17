package org.uth.faqset.tests;

import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.SimpleTokenizer;

public class NLPTest2
{
  public static void main( String[] args )
  {
    if( args.length != 1 )
    {
      System.out.println( "Usage: java NLPTest2 <test_text>");
      System.exit(0);
    }

    new NLPTest2( args[0] ); 
  }

  public NLPTest2( String testData )
  {
    // Instantiate the sentence detection object
    try
    {
      InputStream model = this.getClass().getClassLoader().getResourceAsStream("en-sent.bin");
      InputStream posTaggerData = this.getClass().getClassLoader().getResourceAsStream("en-pos-maxent.bin");

      long start = System.currentTimeMillis();

      // Create a SentenceModel
      SentenceModel sentenceModel = new SentenceModel( model );

      // Create a SentenceDetector
      SentenceDetectorME detector = new SentenceDetectorME( sentenceModel );

      // Parse the input for sentences
      String[] sentences = detector.sentDetect( testData );

      long end = System.currentTimeMillis();

      System.out.println( "Found " + sentences.length + " sentences in " + ( end - start ) + "ms." );

      int counter = 1;
      for( String sentence : sentences )
      {
        System.out.println( counter++ + ": " + sentence );
      }

      // Apply the tokenizer
      SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;

      System.out.println( "\nTokens:");

      // POS Tagging
      POSModel posModel = new POSModel(posTaggerData);
      POSTaggerME tagger = new POSTaggerME(posModel);

      counter = 1;
      for( String sentence : sentences )
      {
        String[] tokens = tokenizer.tokenize(sentence);

        System.out.print( counter++ + " " );
        for( String token : tokens )
        {
          System.out.print( "[" + token + "] " );
        }

        System.out.println( "" );

        String[] tags = tagger.tag(tokens);

        System.out.print( counter + " " );
        for( String tag : tags )
        {
          System.out.print( "{" + tag + "} " );
        }

        System.out.println( "" );
      }
    }
    catch( Exception exc )
    {
      System.out.println( "Exception occurred during test - " + exc.toString());

      exc.printStackTrace();
    }
  }
}