package com.laboon;

import java.io.PrintStream;

public class Game
{
  private Player _player = null;
  private House _house = null;
  
  public Game(Player p, House h) {
    _player = p;
    _house = h;
  }
  
  public int run() {
    int toReturn = 0;
    
    java.util.Scanner in = new java.util.Scanner(System.in);
    String move = null;
    
    boolean gameOver = false;
    boolean win = false;
    
    while (!gameOver) {
      System.out.println(_house.getCurrentRoomInfo());
      System.out.println(" INSTRUCTIONS (N,S,L,I,D) > ");
      move = in.nextLine();
      if (move.equals("N")) {
        _house.moveNorth();
      } else if (move.equalsIgnoreCase("S")) {
        _house.moveSouth();
      } else if (move.equalsIgnoreCase("L")) {
        _house.look(_player);
      } else if (move.equalsIgnoreCase("I")) {
        _player.showInventory();
      } else if (move.equalsIgnoreCase("D")) {
        win = _player.drink();
        gameOver = true;
      } else {
        System.out.println("What?");
      }
    }
    
    if (win) {
      System.out.println("You win!");
      toReturn = 0;
    } else {
      System.out.println("You lose!");
      toReturn = 1;
    }
    
    return toReturn;
  }
}
