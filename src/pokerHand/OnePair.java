package pokerHand;

import java.util.ArrayList;
import java.util.Arrays;

import deck.Card;
import player.Player;

/**
 * Classe Flush: Responsável de retornar ao jogador caso sua combinação de cartas
 * entre na regra do OnePair.
 * @author Felie Glicério Gomes Marcelino
 *
 */
public class OnePair implements GetPokerHand {

	private static OnePair onePair = new OnePair();
	private int totalSameRank;
	private boolean[] cardSameRank = new boolean[7];

	/**
	 * Private construtor.
	 */
	private OnePair() {
	}

	/**
	 * Retorna {@link #onePair}
	 * @return Retorna instância da classe.
	 */
	public static OnePair getInstance() {
		return onePair;
	}

	/**
	 * 
	 * @param bestFive 5 melhores cartas
	 * @param hand Mao do jogador combinado com as cartas da mesa.
	 */
	private void getBestFivePair(ArrayList<Card> bestFive, ArrayList<Card> hand) {
		for (int i = 0; i < hand.size(); i++) {
			if (this.cardSameRank[i] == true) {
				bestFive.add(hand.get(i));
				if (bestFive.size() == 2)
					break;
			}
		}

		for (int i = 0; i < hand.size(); i++) {
			if (this.cardSameRank[i] == false) {
				bestFive.add(hand.get(i));
				if (bestFive.size() == 5)
					break;
			}
		}
	}

	@Override
	public boolean testHand(ArrayList<Card> hand, Player player) {

		for (int i = 0; i < Card.ranks.length; i++) {
			this.totalSameRank = 0;
			Arrays.fill(cardSameRank, Boolean.FALSE);
			for (int k = 0; k < hand.size(); k++) {
				if (Card.ranks[i] == hand.get(k).getRank()) {
					this.totalSameRank++;
					this.cardSameRank[k] = true;
				}
			}

			if (this.totalSameRank == 2) {
				getBestFivePair(player.setBestFive(), hand);
				return true;
			}

		}

		return false;
	}

}
