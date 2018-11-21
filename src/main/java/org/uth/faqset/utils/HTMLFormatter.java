package org.uth.faqset.utils;

public class HTMLFormatter 
{
  private HTMLFormatter()
  {
  }

  /**
   * Fast HTML stripper.
   * @param input text to strip
   * @return text with < and > replaced by HTML encoded values
   */
  public static String stripHTML( String input )
  {
    String output = input.replaceAll("<", "&lt;");
    
    return output.replaceAll(">", "&gt;");
  }  
}
