/*
class ChatServlet
27 March 2023 Wasana Ngaogate
 */
package servlet;

import model.ChatOther;
import Visitor.ChatVisitor;
import Visitor.ChatVisitorImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ChatGPT;
import model.ChatSimple;
import model.ResponseText;

/**
 * Created on : Mar 28, 2023 Author : Wasana Ngaogate
 */
public class ChatServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            
            List<ResponseText> responseTexts = new ArrayList<>();
            
            // get sendText from user
            String sendText = request.getParameter("sendText");
            if (sendText == null) {
                sendText = "hi";
            }

            // ChatVisitorImpl
            ChatVisitor chatVisitor = new ChatVisitorImpl();

            // send sendText to ChatSimple
            ChatSimple chatSimple = new ChatSimple();
            chatSimple.setSentText(sendText);
            chatSimple.chat(chatVisitor);
            ResponseText responseTextSimple = new ResponseText();
            responseTextSimple.setLogo(chatSimple.getLogo());
            responseTextSimple.setResponseText(chatSimple.getResponse());
            responseTexts.add(responseTextSimple);

            // send sendText to ChatGPT
            ChatGPT chatGPT = new ChatGPT();
            chatGPT.setSentText(sendText);
            chatGPT.chat(chatVisitor);
            ResponseText responseTextGPT = new ResponseText();
            responseTextGPT.setLogo(chatGPT.getLogo());
            responseTextGPT.setResponseText(chatGPT.getResponse());
            responseTexts.add(responseTextGPT);

            // send sendText to ChatOther
            ChatOther chatOther = new ChatOther();
            chatOther.setSentText(sendText);
            chatOther.chat(chatVisitor);
            ResponseText responseTextOther = new ResponseText();
            responseTextOther.setLogo(chatOther.getLogo());
            responseTextOther.setResponseText(chatOther.getResponse());
            responseTexts.add(responseTextOther);
            
            // forward to show responseText at shat.jsp
            request.setAttribute("sendText", sendText);
            request.setAttribute("responseTexts", responseTexts);
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/chat.jsp");
            rd.forward(request, response);
            
        } finally {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
