/*
abstract class Chat
27 March 2023 Wasana Ngaogate
 */
package model;

public abstract class Chat implements ChatActions {

    String logo;
    String sentText;
    String response;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSentText() {
        return sentText;
    }

    public void setSentText(String sentText) {
        this.sentText = sentText;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
