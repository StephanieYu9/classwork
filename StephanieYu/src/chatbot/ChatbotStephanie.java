package chatbot;

public class ChatbotStephanie implements Topic {
	
	private String[] keywords;
	private String purchaseKeyword;
	private String nopeKeyword;
	private String response;

	public ChatbotStephanie() {
		String[] temp = {"townhouse", "town", "community", "row house"};
		keywords = temp;
		purchaseKeyword = "yes";
		nopeKeyword = "no";
		response = "";
	}

	public void talk(String initial) {
		ChatbotMain.print("I know some really nice townhouses, what would you be interested in?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, nopeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, purchaseKeyword, 0) >= 0)
				ChatbotMain.print("I am so glad that you're interested in this townhouse.");
			else
				ChatbotMain.print("Why doesn't this appeal to you?");
			response = ChatbotMain.getInput();
		}
		ChatbotMain.print("Well, it was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "!");
		ChatbotMain.chatbot.startChatting();
	}

	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0)
				return true;
		return false;
	}

}
