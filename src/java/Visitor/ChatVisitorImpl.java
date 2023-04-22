/*
class ChatVisitorImpl
27 March 2023 Wasana Ngaogate
 */
package Visitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import model.Chat;
import model.ChatGPT;
import model.ChatSimple;
import model.ChatOther;

public class ChatVisitorImpl implements ChatVisitor {

    @Override
    public Chat visit(ChatSimple chatSimple) {
        chatSimple.setResponse("3,796,742 square miles");
        return chatSimple;
    }

    @Override
    public Chat visit(ChatOther chatOther) {
        chatOther.setResponse("9,833,520 square kilometers");
        return chatOther;
    }

    @Override
    public Chat visit(ChatGPT chatGPT) {

        try {
            // Create the HTTP POST request
            URL obj = new URL(chatGPT.getURL());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + chatGPT.getApiKey());
            con.setRequestProperty("Content-Type", "application/json");

            // Build the request body
            String body = "{\"model\": \"" + chatGPT.getModel() + "\", \"messages\": [{\"role\": \"user\", \"content\": \""
                    + chatGPT.getSentText() + "\"}]}";
            con.setDoOutput(true);
            try ( OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream())) {
                writer.write(body);
                writer.flush();
            }

            // Get the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            chatGPT.setResponse((response.toString().split("\"content\":\"")[1].split("\"")[0]).substring(4));

//            return (response.toString().split("\"content\":\"")[1].split("\"")[0]).substring(4);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return chatGPT;
    }

}
