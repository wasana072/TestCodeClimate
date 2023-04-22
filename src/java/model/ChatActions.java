/*
interface ChatActions
27 March 2023 Wasana Ngaogate
 */
package model;

import Visitor.ChatVisitor;

public interface ChatActions {

    public Chat chat(ChatVisitor chatVisitor);
}
