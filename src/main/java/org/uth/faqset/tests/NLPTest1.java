package org.uth.faqset.tests;

import java.io.*;

public class NLPTest1
{
  public static void main( String[] args )
  {
    new NLPTest1();
  } 
  
  public NLPTest1()
  {
    try
    {
      InputStream in = this.getClass().getClassLoader().getResourceAsStream("en-parser-chunking.bin");

      System.out.println( in.available() );
    }
    catch( Exception exc )
    {
      System.out.println( "Exception occurred." + exc.toString() );
    }
  }
}