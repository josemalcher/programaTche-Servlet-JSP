
<%@include file="../cabecalho.jsp" %>



<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Gerenciamento de Consoles

        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Listagem</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> listagem de registros
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">

        <div class="panel-body">

            <a  href="add.jsp" class="btn  btn-primary btn-sm fa fa-plus-square-o" >Novo</a>
            
        </div>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">
        <form action="#" method="post">
            <div class="form-group input-group">
                <input type="text" class="form-control" name="txtFiltro" placeholder="digite...">
                                <span class="input-group-btn"><button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button></span>
                            </div>
        </form>
        <div class="panel-body">
           
        
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
                   
                    <tr>
                        <td>999999</td>
                        <td>XXXXXXXXXXX</td>
                        <td>XXXXXX</td>
                        <td>999,99</td>
                        <td><a href="upd.jsp?id=" class="btn  btn-primary btn-sm">Alterar</a>
                            <button class="btn  btn-danger btn-sm" data-toggle="modal" data-target="#myModal" onclick="id=">Excluir</button>  
                        </td>
                    </tr>
                    
                </tbody>
            </table>
           
                <!-- /.table-responsive -->
            </div>

        </div>
        <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
        </div>
                
                
    <%@include file="../modalExcluir.jsp" %>
    <%@include file="../rodape.jsp" %>
