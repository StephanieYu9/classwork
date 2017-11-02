package caveExplorer;

public class Merchant extends NPC {
	
	private CaveRoom[][] floor;
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	
	//these fields are about interaction with NPC
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;

	public Merchant() {
		this.floor = CaveExplorer.caves;
		this.activeDescription = "There is a merchant standing in the room, waiting to talk to you, Press 'e' to talk.";
		this.inactiveDescription = "The merchant don't wanna sell you no goods.";
		//by default, NPC does not have a position,
		//to indicate this, use coordinates -1, -1
		this.currentCol = -1;
		this.currentRow = -1;
		currentRoom = null;
		active = true;
	}

	public boolean isActive() {
		return active;
	}

	public void interact() {
		CaveExplorer.print("Are you interested in buying any goods? Type 'no' if you don't.");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("no")) {
			CaveExplorer.print("What would you like to buy? We have chocolate frogs, wands, and owls. Type 1 for chocolate frogs, 2 for wands, and 3 for owls.");
			s = CaveExplorer.in.nextLine();
			chooseOptions(s);
		}
		CaveExplorer.print("Later, friend!");
		active = false;
	}

	private void chooseOptions(String s) {
		if(s.indexOf("1") != -1 && s.length() == 1 || s.indexOf("2") != -1 && s.length() == 1 ||s.indexOf("3") != -1 && s.length() == 1) {
			CaveExplorer.print("You can only type 1, 2. or 3. Do you even want these goods?");
		}else{
			CaveExplorer.print("Enjoy your purchase! I will be taking 10000 galleons. Don't come back.");
			Inventory.money -= 10000;
		}
		
	}

	public String getDescription() {
		return activeDescription;
	}

	public String getInactiveDescription() {
		return inactiveDescription;
	}
	
	public String getSymbol() {
		return "M";
	}

	public void setPosition(int row, int col) {
		if(row >= 0 && row < floor.length && col >= 0 && col < floor[row].length && floor[row][col] instanceof NPCRoom) {
			if(currentRoom != null) {
				currentRoom.leaveNPC();
			}
			currentRow = row;
			currentCol = col;
			currentRoom = (NPCRoom)floor[row][col];
			currentRoom.enterNPC(this);
		}
	}

	public void autoMove() {
		if(active) {
			int[] move = calculateMove();
			int newRow = move[0];
			int newCol = move[1];
			setPosition(newRow, newCol);
		}
		
	}

	private int[] calculateMove() {
		int[][] possibleMoves = {{-1,0},{0,1},{1,0},{0,-1}};
		int index = (int)(Math.random() * possibleMoves.length);
		int[] newPosition = new int[2];
		newPosition[0] = currentRow + possibleMoves[index][0];
		newPosition[1] = currentCol + possibleMoves[index][1];
		while(currentRoom.getDoor(index) == null || !(CaveExplorer.caves[newPosition[0]][newPosition[1]] instanceof NPCRoom)) {
			index = (int)(Math.random() * possibleMoves.length);
			newPosition[0] = currentRow + possibleMoves[index][0];
			newPosition[1] = currentCol + possibleMoves[index][1];
		}
		return newPosition;
	}
	
}
