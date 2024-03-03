package com.kp.algorithms;

import com.kp.objects.book.Book;
import com.kp.objects.book.Printer;
import com.kp.objects.book.PrinterHtmlImpl;
import com.kp.objects.book.PrinterTxtImpl;

public class SRP {

   public static void main(String[] args) {
      Book book = new Book();

      String text = book.printBook();

      Printer printer = new PrinterTxtImpl();
      Printer printerHtml = new PrinterHtmlImpl();
      printer.print(text);
      printerHtml.print(text);

   }

}
