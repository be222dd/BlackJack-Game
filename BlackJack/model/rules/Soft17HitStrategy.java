/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Card.Value;
import BlackJack.model.Player;

/**
 *
 * @author beysimeryalmaz
 */
public class Soft17HitStrategy implements IHitStrategy{
    private final int g_hitLimit = 17;

    @Override
    public boolean DoHit(Player a_dealer) {
        
        
        //Check if dealer has 17 
        if(a_dealer.CalcScore()==g_hitLimit){
        // check if dealer has an Ace
        for(Card c : a_dealer.GetHand()){
           //if has Ace hit
            if(c.GetValue()== Value.Ace)
                return true;
            else
                return false;
            
            }
        
        }
            
        return a_dealer.CalcScore() < g_hitLimit;
        
        
    }
    
}
