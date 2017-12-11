package BlackJack.model.rules;

public class Soft17AmericanStartEqualDealerWinsFactory implements IAbstractRuleFactory{

  public IHitStrategy GetHitRule() {
     return new Soft17HitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
     return new AmericanNewGameStrategy();
  }
  
  public IWinStrategy GetWinRule(){
      return new EqualScoreDealerWinsStrategy();
  }
  
}