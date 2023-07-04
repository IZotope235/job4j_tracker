package ru.job4j.oop;

public class Ball {
   public void thyRun(boolean condition) {
       if (condition) {
           System.out.println("Ball is eaten");
       } else {
           System.out.println("Ball ran away");
       }
   }
}
