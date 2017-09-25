package duel;

public class CharacterB implements Dueler 
{
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
			int hp = 100;
			return hp;
		}
		public boolean determineIfOpponentIsFair(Dueler d, int hp) {
			if(d == hp)
				return true;
		}
		public int getAction(Object caller) {
			
		}
		public void hit(Object caller) {
			if(isAction == true) {
				hp = hp - 10;
			}	
		}
		public boolean isAction(Object o){
			return o instanceof Duel;
		}
}
