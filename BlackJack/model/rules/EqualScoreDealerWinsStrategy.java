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
public class EqualScoreDealerWinsStrategy implements IWinStrategy{

    @Override
    public Boolean wins(int dealerScore, int playerScore,int maxScore) {
        
        if(playerScore>maxScore){
            return true;
        }else if(dealerScore>maxScore){
            return false;
        }
        
        return dealerScore >=playerScore;
    }
    
}
