package CardTest;


class ShuffleCards extends Cards{
	String cardString;
	
	public ShuffleCards() {
		cardString = "";
	}

	//return the remaining cards
	public int getRemain(){
		return remain;
	}
	
	/*Shuffle cards and get one card from card[i] 
	  and set -1 to the taken one element.
	  generate a new card if no card[i] is available.*/
	@Override public int getCard(){
		if (remain == 0)
			newCards();
//		for (int i = 0; i < 52; i++) {
//			int j = (int) (Math.random()*52);
//			int temp = card[j];
//			card[j] = card[i];
//			card[i] = temp;
//		}
		
			int j = (int) (Math.random()*remain);
			get = card[j];
			int temp = card[j];
			card[j] = card[remain-1];
			card[remain-1] = temp;
			remain--;

//		for (int i = 0; i < 52; i++) {
//			if (card[i] != -1) {
//				get = card[i];
//				card[i] = -1;
//				remain --;
//				return get;
//			}
//		}
		return get;
	}
	
	//print out the remaining cards with color and number
	@Override public String toString(){
		String[] color = {"spade","heart","diamond","club"};
		for (int i = 0; i < 52; i++) {
			if (card[i] != -1) {
				cardString += color[card[i]/13] + " #" + Integer.toString(card[i]%13+1) + "\n";
			}
		}
		return cardString;
	}

	

}
