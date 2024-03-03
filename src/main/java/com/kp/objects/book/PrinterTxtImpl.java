package com.kp.objects.book;

public class PrinterTxtImpl implements Printer {

   @Override
   public void print(String text) {
      System.out.println(text);
   }
}
