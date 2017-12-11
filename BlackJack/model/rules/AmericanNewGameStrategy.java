package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

class AmericanNewGameStrategy extends NewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    
     
      dealCardAndShow(a_deck, a_player, true);
      dealCardAndShow(a_deck, a_dealer, true);
      dealCardAndShow(a_deck, a_player, true);
      dealCardAndShow(a_deck, a_dealer, false);
    
    return true;
  }
}