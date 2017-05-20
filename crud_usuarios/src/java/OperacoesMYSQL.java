
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OperacoesMYSQL extends ConexaoMySQL {

    private final String querys[] = {"select * from usuarios;",
        "insert into usuarios(nome,nascimento,email,telefone1,telefone2,cargo) values(?,?,?,?,?,?);",
        "delete from usuarios where id=?;"};

    public String[] retornarMinhasQuerys() {
        return this.querys;
    }

    public void realizarOperacaoBancao(String descrever, HttpServletRequest htr, HttpServletResponse hts, String... pams) throws Exception {

        assert (pams.length >= 1);

        switch (descrever) {

            case "InserirNovoUsuario": {

                if (pams.length == 6) {

                    Connection minha_conexao = this.getConexaoMySQL();

                    PreparedStatement ps = minha_conexao.prepareStatement(this.retornarMinhasQuerys()[1]);

                    ps.setString(1, pams[0]);
                    ps.setDate(2, new Date(Integer.parseInt(pams[1].split("/")[0]),
                            Integer.parseInt(pams[1].split("/")[1]),
                            Integer.parseInt(pams[1].split("/")[2])));
                    ps.setString(3, pams[2]);
                    ps.setString(4, pams[3]);
                    ps.setString(5, pams[4]);
                    ps.setString(6, pams[5]);

                    if (ps.execute()) {
                        System.out.println(">>Query InserirNovoUsuario");
                    }

                    ps.close();
                    minha_conexao.close();

                    htr.getRequestDispatcher("exibir.jsp").forward(htr, hts);

                }

            }
            break;
            case "ListarUsuarios": {

                Connection minha_conexao = this.getConexaoMySQL();

                Statement st = minha_conexao.createStatement();

                ResultSet meu_resultado = st.executeQuery(this.retornarMinhasQuerys()[0]);

                if (meu_resultado.isBeforeFirst()) {

                    System.out.println(">>Query ListarUsuarios");

                    StringBuffer sb = new StringBuffer();

                    while (meu_resultado.next()) {

                        Usuario usu = new Usuario(
                                meu_resultado.getInt("id"),
                                meu_resultado.getString("nome"),
                                meu_resultado.getDate("nascimento"),
                                meu_resultado.getString("email"),
                                meu_resultado.getString("telefone1"), meu_resultado.getString("telefone2"),
                                meu_resultado.getString("cargo")
                        );

                        sb.append("<form id=\"form_exclusao_para" + usu.getId() + "\" action=\"EnviarDados\" method=\"post\">");
                        sb.append("<br><br><br>");
                        sb.append("<b>" + usu.getId() + "</b>");
                        sb.append("<hr>");
                        sb.append("<b>" + usu.getNome() + "</b>");
                        sb.append("<hr>");
                        sb.append("<b>" + usu.getNascimento() + "</b>");
                        sb.append("<hr>");
                        sb.append("<b>" + usu.getCargo() + "</b>");
                        sb.append("<hr>");
                        sb.append("<b>" + usu.getTelefone1() + "</b><br>");
                        sb.append("<input type=\"hidden\" name=\"excluirEste\" value=\"" + usu.getId() + "\">");
                        sb.append("<input type=\"submit\" name=\"excluir\" value=\"Excluir usuario id (" + usu.getId() + ")\">");
                        sb.append("<br><br><br>");
                        sb.append("</form>");
                    }

                    meu_resultado.close();
                    st.close();
                    minha_conexao.close();

                    htr.setAttribute("usuario", sb.toString());
                    htr.getRequestDispatcher("exibir.jsp").forward(htr, hts);

                }

            }
            break;
            case "ExcluirUsuario": {
                if (pams.length == 1) {

                    Connection minha_conexao = this.getConexaoMySQL();

                    PreparedStatement ps = minha_conexao.prepareStatement(this.retornarMinhasQuerys()[2]);

                    ps.setInt(1, Integer.parseInt(pams[0]));

                    if (ps.execute()) {
                        System.out.println(">>Query ExcluirUsuario");
                    }

                    ps.close();
                    minha_conexao.close();

                    htr.getRequestDispatcher("exibir.jsp").forward(htr, hts);

                }
            }
            break;

        }

    }

}
