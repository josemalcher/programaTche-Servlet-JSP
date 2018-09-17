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
<!--                        <td><c:out value="${obj.numSerie}" /></td>
                        <td><c:out value="${obj.nome}" /></td>
                        <td><c:out value="${obj.marca}" /></td>
                        <td><c:out value="${obj.valor}" /></td>-->
                        <td>${obj.numSerie}</td>
                        <td>${obj.nome}</td>
                        <td>${obj.marca}</td>
                        <td>${obj.valor}</td>
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

```java
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
        RequestDispatcher destino = request.getRequestDispatcher("pagina"); 
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

```

```jsp
 <div class="alert ">
    ${msg}
 </div>
```



[Voltar ao Índice](#indice)

---

## <a name="parte4">03  JSP, Servlets e JSTL   Excluir</a>

```java

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


```

```jsp
<a href="ConsoleCtl?action=del&id=${obj.numSerie}" class="btn  btn-danger btn-sm">Excluir</a>
```


[Voltar ao Índice](#indice)

---

## <a name="parte5">04   JSP, Servlets e JSTL   Alterar</a>

```java
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
        
        String pagina = "index.jsp";
        switch(acao){
            case "list":
                dao = new ConsoleDAO();
                List<Console> lista = dao.listar();
                request.setAttribute("lista", lista);
                dao.fecharEmf();
                pagina = "index.jsp";
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
                pagina = "index.jsp";
                break;
            case "updade":
                dao = new ConsoleDAO();
                String idUpdate= request.getParameter("id");
                
                // busco o reguistro que eu quero exibir
                Console obj = dao.buscarPorChavePrimaria(Integer.parseInt(idUpdate));
                
                request.setAttribute("obj", obj);
                
                pagina = "upd.jsp";
                break;
        }
        RequestDispatcher destino = request.getRequestDispatcher(pagina); 
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
        
        Boolean deuCerto;
        
        if(request.getParameter("txtNumSerie") == null){
            deuCerto = dao.incluir(obj);
            pagina = "add.jsp";
        }else{
            String numSerie = request.getParameter("txtNumSerie");
            obj.setNumSerie(Integer.parseInt(numSerie));
            deuCerto = dao.alterar(obj);
            pagina = "upd.jsp";
        }
        
        
        if(deuCerto){
            msg = "Operação realizada com sucesso";
        }else{
            msg = "Operação FALHOU!";
        }
        
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

```

```jsp

<%@include file="../cabecalho.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Sistema de Comércio Eletrônico
            <small>Admin</small>
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Área Administrativa</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Aqui vai o conteúdo de apresentação
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            Console
        </div>
        <div class="panel-body">

            <div class="alert ">
                ${msg}
            </div>
            <form action="ConsoleCtl" method="post">
                
                <div class="col-lg-6">

                    <div class="form-group">
                        <label>Número de Série</label>
                        <input class="form-control" type="text" name="txtNumSerie" readonly value="${obj.getNumSerie()}"/>
                    </div>
                    
                    <div class="form-group">
                        <label>Nome</label>
                        <input class="form-control" type="text" name="txtNome" required value="${obj.getNome()}" />
                    </div>
                    <div class="form-group">
                        <label>Marca</label>
                        <input class="form-control" type="text" name="txtMarca" required value="${obj.getMarca()}" />
                    </div>
                    <div class="form-group">
                        <label>Valor</label>
                        <input class="form-control" type="number" name="txtValor" required value="${obj.getValor()}" />
                    </div>


                <button class="btn btn-primary btn-sm" type="submit">Salvar</button>
                
            </form>

        </div>


    </div>
</div>
<!-- /.row -->
<%@include file="../rodape.jsp" %>

```

```jsp
<a href="ConsoleCtl?action=updade&id=${obj.numSerie}" class="btn  btn-primary btn-sm">Alterar</a>
```


[Voltar ao Índice](#indice)

---

## <a name="parte6">05   JSP, Servlets e JSTL   Filtrando</a>


[Voltar ao Índice](#indice)

---

## <a name="parte7">JSPN pra N    Parte 1</a>


[Voltar ao Índice](#indice)

---
