package com.kp.algorithms;

import com.kp.objects.book.Book;
import com.kp.objects.book.PrinterHtmlImpl;
import com.kp.objects.book.PrinterTxtImpl;

public class SRP {

   public static void main(String[] args) {
      Book book = new Book();

      String text = book.printBook();

      PrinterTxtImpl printer = new PrinterTxtImpl();
      PrinterHtmlImpl printerHtml = new PrinterHtmlImpl();
      printer.print(text);
      printerHtml.print(text);

   }

}
