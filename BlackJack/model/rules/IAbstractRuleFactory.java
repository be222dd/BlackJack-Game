/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack.model.rules;

/**
 *
 * @author beysimeryalmaz
 */
public interface IAbstractRuleFactory {
    public IHitStrategy GetHitRule();
    public INewGameStrategy GetNewGameRule();
    public IWinStrategy GetWinRule();
}
