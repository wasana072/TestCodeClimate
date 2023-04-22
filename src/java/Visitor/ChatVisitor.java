/*
interface ChatVisitor
27 March 2023 Wasana Ngaogate
 */
package Visitor;

import model.Chat;
import model.ChatGPT;
import model.ChatSimple;
import model.ChatOther;

public interface ChatVisitor {
    public Chat visit(ChatSimple chatSimple);
    public Chat visit(ChatGPT chatGPT);    
    public Chat visit(ChatOther chatOther);
}
