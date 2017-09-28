package duel;


public class CharacterA implements Dueler 
{
	private String name;
	private int hp;
	private boolean loadedGun = false;
	
	public CharacterA() {
		
	}
	
	public void taunt() 
	{
		String taunt = ("Git gud Karluz");
		System.out.println(taunt);
	}
	public String getName()
	{
		this.name = "Chaddd";
		return name;
	}
	public void setStartingHP(int hp)
	{
		this.hp = hp;
	}
	public int getHP()
	{
		return hp;
	}
	public boolean determineIfOpponentIsFair(Dueler d, int hp)
	{
		if (d.getHP() == hp)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int getAction(Object caller)
	{
		if(caller instanceof Duel)
		{
			if (loadedGun == true)
			{
				if (Math.random() > 0.4)
				{
					loadedGun = false;
					return Duel.SHOOTING;
				}
				else
				{
						return Duel.GUARDING;
				}
			}
			else
			{
				if (Math.random() > 0.2)
				{
					return Duel.GUARDING;
				}
				else
				{
					loadedGun = true;
					return Duel.LOADING;
				}
			}
		}
		else
		{
			return Duel.YEAH_RIGHT;
		}
	}
	public void hit(Object caller)
	{
		if (caller instanceof Duel)
		{
			hp = hp - 10;
		}
	}
}
