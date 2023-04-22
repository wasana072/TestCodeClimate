/*
class ChatOther extends Chat implements ChatActions
29 March 2023 Wasana Ngaogate
 */
package model;

import Visitor.ChatVisitor;

public class ChatOther extends Chat implements ChatActions {

    public ChatOther() {
        this.setLogo("logoChatOther.png");
    }

    @Override
    public Chat chat(ChatVisitor chatVisitor) {
        return chatVisitor.visit(this);
    }
}
