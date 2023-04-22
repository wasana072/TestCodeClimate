/*
class DemoChatGPT
27 March 2023 Wasana Ngaogate
 */
package servlet;

import Visitor.ChatVisitor;
import Visitor.ChatVisitorImpl;
import model.ChatGPT;
import model.ChatSimple;

public class DemoChatGPT {

    public static void main(String[] args) {
        
        ChatVisitor chatVisitor = new ChatVisitorImpl();
        
        // test ChatGPT
        ChatGPT chatGPT = new ChatGPT();
        chatGPT.setURL("https://api.openai.com/v1/chat/completions");
        chatGPT.setApiKey("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");
        chatGPT.setModel("gpt-3.5-turbo");
        chatGPT.setSentText("Hi");
        chatGPT.chat(chatVisitor);
        System.out.println(">>>> " + chatGPT.getResponse());
        
        // test ChatSimple
        ChatSimple chatSimple = new ChatSimple();
        chatSimple.chat(chatVisitor);
        System.out.println(">>>>" + chatSimple.getResponse());
        
        // test ChatOther
        
        
    }
}
