/*
class ChatSimple extends Chat implements ChatActions
27 March 2023 Wasana Ngaogate
 */
package model;

import Visitor.ChatVisitor;

public class ChatSimple extends Chat implements ChatActions {

    public ChatSimple(){
        this.setLogo("logoChatSimple.png");
    }
    
    @Override
    public Chat chat(ChatVisitor chatVisitor) {
        return chatVisitor.visit(this);
    }
}
