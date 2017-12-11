/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack.model;

/**
 *
 * @author beysimeryalmaz
 */
public interface IGetCardPublisher {
    
    public void register(IGetCardObserver o);

    public void unregister(IGetCardObserver o);

    public void notifyObserver();

    
    
}
