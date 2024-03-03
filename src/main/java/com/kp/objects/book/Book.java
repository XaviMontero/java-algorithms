package com.kp.objects.book;

public class Book {

   public String getTitle() {
      return "The Catcher in the Rye";
   }

   public String getAuthor() {
      return "J.D. Salinger";
   }

   public String printBook() {
      return getTitle() + " by " + getAuthor();
   }


}
