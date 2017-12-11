package BlackJack.view;

import BlackJack.model.Dealer;
import java.util.logging.Level;
import java.util.logging.Logger;



public class SimpleView implements IView
{
    char playInput,standInput,hitInput,quitInput;
    
    public SimpleView(){
        playInput='p';
        standInput='s';
        hitInput='h';
        quitInput='q';
        
    }

  public void DisplayWelcomeMessage()
        {
          for(int i = 0; i < 50; i++) {System.out.print("\n");}; 
          System.out.println("Hello Black Jack World");
          System.out.println("Type " +playInput+" to Play, "+hitInput+" to Hit, "+standInput+" to Stand or "+quitInput+" to Quit\n");
        }

        public int GetInput()
        {
          try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
              c = System.in.read();
            }
            return c;
          } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
          }
        }

        public void DisplayCard(BlackJack.model.Card a_card)
        {
           
            System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
        }

        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Player", a_hand, a_score);
        }

        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Dealer", a_hand, a_score);
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            
            
            System.out.println(a_name + " Has: ");
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Score: " + a_score);
            System.out.println("");
        }

        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("GameOver: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Dealer Won!");
            }
            else
            {
                System.out.println("You Won!");
            }
            
        }

    @Override
    public char getPlayInput() {
        return playInput;
    }

    @Override
    public char getStandInput() {
        return standInput;
    }

    @Override
    public char getHitInput() {
        return hitInput;
    }

    @Override
    public char getQuitInput() {
        return quitInput;
    }

    public void visit(Dealer dealer) {
        System.out.println("Hit Rule: "+ dealer.getM_hitRule().toString());
        System.out.println("New Game Rule: "+ dealer.getM_newGameRule().toString());
        System.out.println("Hit Rule: "+ dealer.getM_winRule().toString());
         try {
             Thread.sleep(2000);
         } catch (InterruptedException ex) {
             Logger.getLogger(SwedishView.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    
    }
