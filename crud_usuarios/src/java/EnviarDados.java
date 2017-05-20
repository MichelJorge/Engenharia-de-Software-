
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnviarDados extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try {

            if (request.getParameter("enviar") != null) {

                OperacoesMYSQL om = new OperacoesMYSQL();

                om.realizarOperacaoBancao("InserirNovoUsuario", request, response,
                        new String[]{
                            request.getParameter("nome"),
                            request.getParameter("nascimento"),
                            request.getParameter("email"),
                            request.getParameter("telefone1"),
                            request.getParameter("telefone2"),
                            request.getParameter("cargo")
                        });

            } else if (request.getParameter("listar") != null) {

                OperacoesMYSQL om = new OperacoesMYSQL();

                om.realizarOperacaoBancao("ListarUsuarios", request, response,
                        new String[]{""});
            } else if (request.getParameter("excluir") != null) {

                OperacoesMYSQL om = new OperacoesMYSQL();

                om.realizarOperacaoBancao("ExcluirUsuario", request, response,
                        new String[]{request.getParameter("excluirEste")});
            }

        } catch (Exception excecao) {
            excecao.printStackTrace();

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
