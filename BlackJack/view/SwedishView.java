package BlackJack.view;

import BlackJack.model.Dealer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SwedishView implements IView 
    {
     char playInput,standInput,hitInput,quitInput;
     
     public SwedishView(){
        playInput='p';
        standInput='s';
        hitInput='h';
        quitInput='q';
     
     }
     
        public void DisplayWelcomeMessage()
        {
         
            for(int i = 0; i < 50; i++) {System.out.print("\n");};

            System.out.println("Hej Black Jack Världen");
            System.out.println("----------------------");
            System.out.println("Skriv "+playInput+" för att Spela, "+hitInput+" för nytt kort, "+standInput+" för att stanna "+quitInput+" för att avsluta\n");
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
            if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden)
            {
                System.out.println("Dolt Kort");
            }
            else
            {
                String colors[] = 
                    { "Hjärter", "Spader", "Ruter", "Klöver" };
                String values[] =  
                    { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
                System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
            }
        }
        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Spelare", a_hand, a_score);
        }
        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Croupier", a_hand, a_score);
        }
        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("Slut: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Croupiern Vann!");
            }
            else
            {
                System.out.println("Du vann!");
            }
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Har: " + a_score);
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Poäng: " + a_score);
            System.out.println("");
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
