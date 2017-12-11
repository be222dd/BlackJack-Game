/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack.model;

import BlackJack.view.Visitor;

/**
 *
 * @author beysimeryalmaz
 */
public interface IVisitable {
    public void accept(Visitor visitor);
    
}
