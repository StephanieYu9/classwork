package chatbot;

public class ChatbotStephanie implements Topic {
	
	private String[] keywords;
	private String purchaseKeyword;
	private String nopeKeyword;
	private String response;
	private String townhouse;
	
	public ChatbotStephanie() {
		String[] temp = {"townhouse", "town", "community", "row house"};
		keywords = temp;
		purchaseKeyword = "yes";
		nopeKeyword = "no";
		response = "";
		townhouse = "2 family townhome with 6 beds and 4 baths.";
	}

	
	
	public void talk(String initial) {
		ChatbotMain.print("I know a really nice townhouse, would you like to hear about it?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, nopeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, purchaseKeyword, 0) >= 0)
				ChatbotMain.print("There is one townhouse for sale right now and it is a " + townhouse + "would you be interested in purchasing this?");
			response = ChatbotMain.getInput();
				if(ChatbotMain.findKeyword(response, purchaseKeyword, 0) >= 0)
				ChatbotMain.print("Thank you for purchasing this townhouse! It was a pleasure doing business with you " + ChatbotMain.chatbot.getUsername() + "!");
				else
					if (ChatbotMain.findKeyword(response, nopeKeyword, 0) == -1)
						ChatbotMain.print("Why don't you find this appealing?");				
			else
				ChatbotMain.print("You are not answering my question.");
			response = ChatbotMain.getInput();
		}
		ChatbotMain.print("Sorry to hear that you're not interested in townhouses, you are really missing out " + ChatbotMain.chatbot.getUsername() + "!");
		ChatbotMain.chatbot.startChatting();
	}

	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0)
				return true;
		return false;
	}