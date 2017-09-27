package duel;

import duel.Duel;

public class CharacterA extends Duel implements Dueler 
{
	private String name;
	private int hp;
	private boolean loadedGun = false;
	
	public void taunt() 
	{
		String taunt = ("Git gud Karluz");
		System.out.println(taunt);
	}
	public String getName()
	{
		name = "Chaddd";
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
					return Duel.SHOOTING;
				}
				else
				{
					if (Math.random() < 0.5)
					{
						return Duel.GUARDING;
					}
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
					return Duel.LOADING;
				}
			}
		}
			return YEAH_RIGHT;
		
	}
	public void hit(Object caller)
	{
		if (caller instanceof Duel)
		{
			hp = hp - 10;
		}
	}
}
