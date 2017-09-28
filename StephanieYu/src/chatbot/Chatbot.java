package chatbot;

public class Chatbot {

	private String username;
	private boolean chatting;
	private Topic stephanie;
	
	public Chatbot() {
		stephanie = new ChatbotStephanie();
		username = "Unknown User";
		chatting = true;
	}

	public void startChatting() {
		//whenever you print or get input, use these methods 
		ChatbotMain.print("Hi! I am an intellegent machine that can respond to your input. Tell me your name.");
		username = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What would you like to talk about?");
			String response = ChatbotMain.getInput();
			if(stephanie.isTriggered(response)) {
				chatting = false; //exit the while loop. IMPORTANT.
				stephanie.talk(response);
			}else {
				ChatbotMain.print("I'm sorry. I don't understand. I never said I was perfect.");
			}
		}
	}

}
