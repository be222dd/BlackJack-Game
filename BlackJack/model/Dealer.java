package BlackJack.model;

import BlackJack.model.rules.*;
import BlackJack.view.Visitor;


public class Dealer extends Player implements IVisitable{

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinStrategy m_winRule;

  public Dealer(IAbstractRuleFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winRule=a_rulesFactory.GetWinRule();
    
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  
  public boolean NewGame(Player a_player) {
    if (getM_deck() == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return getM_newGameRule().NewGame(getM_deck(), this, a_player);   
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (getM_deck() != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
       
      showAndDealTheCard(a_player, getM_deck());
     return true;
    }
    return false;
  }
  
  
  public boolean Stand(Player a_player){
      
      if(getM_deck()!=null ){
          ShowHand();
          
          for(Card c : GetHand()){
           
              c.Show(true);
            }
          
        while(getM_hitRule().DoHit(this)){
            showAndDealTheCard(this, getM_deck());
         }
         
      }return true;
  }

  public boolean IsDealerWinner(Player a_player) {

    return getM_winRule().wins(CalcScore(), a_player.CalcScore(), g_maxScore);
  }

  public boolean IsGameOver() {
    if (getM_deck() != null && getM_hitRule().DoHit(this) != true) {
        return true;
    }
    return false;
  }
  
  private void showAndDealTheCard(Player player,Deck m_deck){
      
      Card c=m_deck.GetCard();
      c.Show(true);
      player.DealCard(c);
      notifyObserver();
  }

   /* /**
     * @return the m_deck
     */
    public Deck getM_deck() {
        return m_deck;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * @return the m_newGameRule
     */
    public INewGameStrategy getM_newGameRule() {
        return m_newGameRule;
    }

    /**
     * @return the m_hitRule
     */
    public IHitStrategy getM_hitRule() {
        return m_hitRule;
    }

    /**
     * @return the m_winRule
     */
    public IWinStrategy getM_winRule() {
        return m_winRule;
    }

    
}