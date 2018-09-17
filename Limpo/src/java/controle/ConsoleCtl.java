/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ConsoleDAO;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Console;

/**
 *
 * @author josemalcher
 */
@WebServlet(name = "ConsoleCtl", urlPatterns = {"/console/ConsoleCtl"})
public class ConsoleCtl extends HttpServlet {

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
        String acao = request.getParameter("action");
        ConsoleDAO dao;
        
        
        switch(acao){
            case "list":
                dao = new ConsoleDAO();
                List<Console> lista = dao.listar();
                request.setAttribute("lista", lista);
                dao.fecharEmf();
                break;
            case "del":
                dao = new ConsoleDAO();
                String id= request.getParameter("id");
                Boolean deuCerto = dao.excluir(Integer.parseInt(id));
                String msgE;
                if(deuCerto){
                    msgE = "<script>alert('Registro excluído');</script>";
                }else{
                    msgE = "<script>alert('Objeto Não pode ser Excluído, Verifique Dependências!');</script>";
                }
                List<Console> listaE = dao.listar();
                request.setAttribute("lista", listaE);
                request.setAttribute("msgE", msgE);
                dao.fecharEmf();
                break;
        }
        RequestDispatcher destino = request.getRequestDispatcher("index.jsp"); 
        destino.forward(request, response);
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
        String pagina;
        String msg;
        
        // pegar as informações do form
        String nome = request.getParameter("txtNome");
        String marcar = request.getParameter("txtMarca");
        BigDecimal valor = new BigDecimal(request.getParameter("txtValor"));
        
        // monto o objeto
        Console obj = new Console();
        obj.setNome(nome);
        obj.setMarca(marcar);
        obj.setValor(valor);
        
        //grava no bd
        ConsoleDAO dao = new ConsoleDAO();
        
        Boolean deuCerto = dao.incluir(obj);
        if(deuCerto){
            msg = "Operação realizada com sucesso";
        }else{
            msg = "Operação FALHOU!";
        }
        pagina = "add.jsp";
        request.setAttribute("msg", msg); 
                
        // manda para pagina destino
        RequestDispatcher destino = request.getRequestDispatcher(pagina); 
        destino.forward(request, response);       
        
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
