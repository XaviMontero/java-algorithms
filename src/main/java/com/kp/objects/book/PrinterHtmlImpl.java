package com.kp.objects.book;

public class PrinterHtmlImpl implements Printer{
   @Override
   public void print(String text) {
      System.out.println("<html><body><h1>" + text + "</h1></body></html>");
   }
}
