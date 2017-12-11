/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Dealer;
import BlackJack.model.Deck;
import BlackJack.model.Player;

/**
 *
 * @author beysimeryalmaz
 */
abstract class NewGameStrategy {
    
    public void dealCardAndShow(Deck a_deck,Player a_player,boolean toShow){
        Card c;
        c = a_deck.GetCard();
        c.Show(toShow);
        a_player.DealCard(c);
    }
    
}
