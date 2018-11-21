package org.uth.faqset.exceptions;

/**
 * Hub Index Exception. This is an exception thrown if any issues are
 * encountered when using the Lucene Hub Index
 * @author Ian 'Uther' Lawson
 */
public class FAQSetFormatException extends Exception
{
  public FAQSetFormatException()
  {
    
  }
  
  public FAQSetFormatException( String message )
  {
    super( message );
  }
}