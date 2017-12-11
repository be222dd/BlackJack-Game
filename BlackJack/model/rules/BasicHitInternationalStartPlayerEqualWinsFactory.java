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
public class BasicHitInternationalStartPlayerEqualWinsFactory implements IAbstractRuleFactory{

    @Override
    public IHitStrategy GetHitRule() {
        return new BasicHitStrategy();
    }

    @Override
    public INewGameStrategy GetNewGameRule() {
        return new InternationalNewGameStrategy();
    }

    @Override
    public IWinStrategy GetWinRule() {
        return new EqualScorePlayerWinsStrategy();
    }
    
}
