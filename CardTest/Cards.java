package CardTest;


class Cards {
	
	//Declare integer type of variable 
	protected int card [];
	protected int get;
	protected int remain;
	protected int count;
	
	//Initialize the constructor by setData function
	public Cards() {
		setData();
	};
	
	//Initialize the variable
	public void setData() {
		card = new int[52];
		get = 0;
		remain = 52;
	}
	
	//Generate a new  card set with 52 cards identified from 1 to 52
	//card[i]%13 equal to the point, card[i]/13 equal to the color
	public void newCards(){
		for (int i = 0; i < 52; i++) {
			card[i] = i;
		}
		remain = 52;
	}	
	
	//Access the [] card
	public int[] accessCards() {
		return card;
	}
	
	/*
	This method is to take one card from card[i],
	set -1 to the taken one element.
	 */
	public int getCard() {
		if (remain == 0)
			newCards();
		for (int i = 0; i < 52; i++) {
			if (card[i] != -1) {
				get = card[i];
				card[i] = -1;
				return get;
			}
		}
		return -1;
	}
	
	//print out the remaining cards with color and number
	@Override public String toString(){
		return null;
	}
	
	
	
}
