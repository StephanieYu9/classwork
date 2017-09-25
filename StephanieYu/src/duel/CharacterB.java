package duel;

public class CharacterB implements Dueler
{
	private int hp = 100; 
	
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
			System.out.println(hp);
		}
		public int getHP() {
			return hp;
		}
		public boolean determineIfOpponentIsFair(Dueler d, int hp) {
			if (d.getHP() == 100) {
				return true;
			}
			return false;
		}
		public int getAction(Object caller) {
			if(caller instanceof Duel) {
				
			}
			
		}
		public void hit(Object caller) {
			if(caller instanceof Duel) {
				hp = hp-10;
			}
		}
}
