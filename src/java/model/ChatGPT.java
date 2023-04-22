/*
class ChatGPT extends Chat implements ChatActions
27 March 2023 Wasana Ngaogate
 */
package model;

import Visitor.ChatVisitor;

public class ChatGPT extends Chat implements ChatActions {

    String URL;
    String apiKey;
    String model;

    public ChatGPT() {
        this.setLogo("logoChatGPT.png");
        this.setURL("https://api.openai.com/v1/chat/completions");
        this.setApiKey("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");
        this.setModel("gpt-3.5-turbo");
    }
    
    @Override
    public Chat chat(ChatVisitor chatVisitor) {
        return chatVisitor.visit(this);
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

}
