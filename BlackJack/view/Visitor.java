/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack.view;

import BlackJack.model.Dealer;

/**
 *
 * @author beysimeryalmaz
 */
public interface Visitor {
    public void visit(Dealer dealer);
    
}
