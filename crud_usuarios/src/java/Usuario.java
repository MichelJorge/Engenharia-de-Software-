
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Michel Jorge
 */
public class Usuario {

    private int id;

    private String nome;

    private Date nascimento;

    private String email;

    private String telefone1, telefone2;

    private String cargo;

    public Usuario(int id, String nome, Date nascimento, String email, String telefone1, String telefone2, String cargo) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
