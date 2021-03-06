package duel;

public class CharacterB implements Dueler
{
	private int hp; 
	private boolean isLoaded = false; 
	private int lastMove = 0;
	
	public CharacterB() {
	}
		public void taunt() {
			String taunt = ("yo mama so fat");
			System.out.println(taunt);
		}
		public String getName() {
			String name = ("Carlos");
			return name;
		}
		public void setStartingHP(int hp) {
			this.hp = hp;
		}
		public int getHP() {
			return hp;
		}
		public boolean determineIfOpponentIsFair(Dueler d, int hp) {
			if (d.getHP() == hp) {
				return true;
			}
			return false;
		}
		public int getAction(Object caller) {
			if(caller instanceof Duel) {
				if(isLoaded == false) {
					return Duel.LOADING;
				}
				isLoaded = true;
				lastMove = 0;
				}
			else {
				if(isLoaded == true && lastMove == 0) {
						return Duel.GUARDING;
					}
					lastMove = 2;
				if (isLoaded == true && lastMove == 2) {
					return Duel.SHOOTING;
				}
				isLoaded = false;
				lastMove = 1;
			}
			return Duel.YEAH_RIGHT;
			
		}
		public void hit(Object caller) {
			if(caller instanceof Duel) {
				hp = hp-10;
			}
		}
}
