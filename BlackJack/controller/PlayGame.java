package BlackJack.controller;

import BlackJack.model.Dealer;
import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.model.IGetCardObserver;
import BlackJack.model.Player;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayGame implements IGetCardObserver{
    
    private Game a_game;
    private IView a_view;
    private Player player;
    private Dealer dealer;
    
    public PlayGame(Game a_game, IView a_view){
        this.a_game=a_game;
        this.a_view=a_view;
        player=a_game.getPlayer();
        dealer=a_game.getDealer();
        player.register(this);
        dealer.register(this);
       
    }

  public boolean Play() {
        
        a_view.DisplayWelcomeMessage();
        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
            
    
    

    if (a_game.IsGameOver())
    {
        a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

    int input = a_view.GetInput();
    
    if (input == a_view.getPlayInput())
    {
        a_game.NewGame();
    }
    else if (input == a_view.getHitInput())
    {
        a_game.Hit();
    }
    else if (input == a_view.getStandInput())
    {
        a_game.Stand();
    }

    return input != a_view.getQuitInput();
  }

    @Override
    public void update() {
        try {
            Thread.sleep(2000);
            a_view.DisplayWelcomeMessage();
            a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
            a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
        } catch (InterruptedException ex) {
            Logger.getLogger(PlayGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    
}