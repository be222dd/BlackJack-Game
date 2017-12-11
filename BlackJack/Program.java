package BlackJack;

import BlackJack.model.Game;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program
{

  public static void main(String[] a_args)
  {
    
    Game g = new Game();
    IView v = new SimpleView(); //new SwedishView();
    g.getDealer().accept(v);
    PlayGame ctrl = new PlayGame(g,v);
    
    while (ctrl.Play());
  }
}