<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
         pageEncoding="ISO-8859-1"%>    
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
        <title>DEMDEV Cadastro</title>  
    </head>  
    <body>  
        <h2>DEMDEV Developer</h2>
        <h3>Inserir Usuário</h3>     
        <form action="EnviarDados" method="post">  

            Nome: <input type="text" name="nome" />  
            <br /><br />  
            Nascimento: <input type="text" name="nascimento" />  
            <br /><br />  
            email: <input type="text" name="email" />  
            <br /><br /> 
            Telefone 1: <input type="text" name="telefone1" />  
            <br /><br />  
            Telefone 2: <input type="text" name="telefone2" />  
            <br /><br />  
            Cargo: <input type="text" name="cargo" />  
            <br /><br />  
            <input type="submit" name="enviar" value="Inserir Novo Usuario" />
            <input type="submit" name="listar" value="Listar usuarios." />  


        </form>  
        <br /><br />  
        ${msg }     
    </body>  
</html> 