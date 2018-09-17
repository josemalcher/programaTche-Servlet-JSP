# ProgramaTche - Servlet JSP

https://www.youtube.com/playlist?list=PLuK0q1zy2dBwA6dK5rYjmJSXw2_4_zvDJ

---

## <a name="indice">Índice</a>

- [00  JSP,  Servlets e JSTL   Preparando o ambiente](#parte1)   
- [01   JSP,   Servlets e JSTL   Listar](#parte2)   
- [02   JSP, Servlets e JSTL   Adicionar](#parte3)   
- [03  JSP, Servlets e JSTL   Excluir](#parte4)   
- [04   JSP, Servlets e JSTL   Alterar](#parte5)   
- [05   JSP, Servlets e JSTL   Filtrando](#parte6)   
- [JSPN pra N    Parte 1](#parte7)   

---

## <a name="parte1">00  JSP,  Servlets e JSTL   Preparando o ambiente</a>

Checklist
- Criar minha unidade de persistência
- Configurar minha classe de conexão
    - O nome da unidade de persistência deve ser o mesmo que foi criado
- Verificar se estou com o driver JDBC do PostgreSQL referenciado no projeto.
- gerar as classes de modelo.



[Voltar ao Índice](#indice)

---

## <a name="parte2">01   JSP,   Servlets e JSTL   Listar</a>

```java
package controle;
import dao.ConsoleDAO;
import java.io.IOException;
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

```

```java
package dao;
import modelo.Console;
/**
 *
 * @author josemalcher
 */
public class ConsoleDAO extends GenericDAO<Console, Integer>{

    public ConsoleDAO() {
        super(Console.class);
    }

}

```

```jsp
      <a href="../console/ConsoleCtl?action=list"><i class="fa fa-fw fa-edit"></i> Consoles</a>
```

```jsp
<div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Marca</th>
                        <th>Valor</th>
                        <th >Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lista}" var="obj">
                        <tr>
                        <td><c:out value="${obj.numSerie}" /></td>
                        <td><c:out value="${obj.nome}" /></td>
                        <td><c:out value="${obj.marca}" /></td>
                        <td><c:out value="${obj.valor}" /></td>
                        <td><a href="upd.jsp?id=" class="btn  btn-primary btn-sm">Alterar</a>
                            <button class="btn  btn-danger btn-sm" data-toggle="modal" data-target="#myModal" onclick="id=">Excluir</button>  
                        </td>
                    </tr>
                    </c:forEach> 
<!--                   
                    <tr>
                        <td>999999</td>
                        <td>XXXXXXXXXXX</td>
                        <td>XXXXXX</td>
                        <td>999,99</td>
                        <td><a href="upd.jsp?id=" class="btn  btn-primary btn-sm">Alterar</a>
                            <button class="btn  btn-danger btn-sm" data-toggle="modal" data-target="#myModal" onclick="id=">Excluir</button>  
                        </td>
                    </tr>
                    -->
                </tbody>
            </table>
           
                <!-- /.table-responsive -->
            </div>

```

[Voltar ao Índice](#indice)

---

## <a name="parte3">02   JSP, Servlets e JSTL   Adicionar</a>


[Voltar ao Índice](#indice)

---

## <a name="parte4">03  JSP, Servlets e JSTL   Excluir</a>


[Voltar ao Índice](#indice)

---

## <a name="parte5">04   JSP, Servlets e JSTL   Alterar</a>


[Voltar ao Índice](#indice)

---

## <a name="parte6">05   JSP, Servlets e JSTL   Filtrando</a>


[Voltar ao Índice](#indice)

---

## <a name="parte7">JSPN pra N    Parte 1</a>


[Voltar ao Índice](#indice)

---
