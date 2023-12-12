package sistemaCaptura.user;

import sistemaCaptura.HistoricoLogin;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Integer idUsuario;
    private String nome;
    private String email;
    private String senha;

    protected Integer fkInstituicao;
    protected Integer fkTipoUsuario;

    private HistoricoLogin historicoLoginAtual;

    private List<HistoricoLogin> historicoLogin;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nome, String email, String senha, Integer fkInstituicao, Integer fkTipoUsuario) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.fkInstituicao = fkInstituicao;
        this.fkTipoUsuario = fkTipoUsuario;
        this.historicoLogin = new ArrayList<>();
    }

    public void registrarTentativaLogin(boolean sucesso) {
        if (historicoLogin == null) {
            historicoLogin = new ArrayList<>();
        }
        HistoricoLogin historico = new HistoricoLogin(this.idUsuario, LocalDateTime.now(), sucesso);
        historicoLogin.add(historico);
        historicoLoginAtual = historico;
    }


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getFkInstituicao() {
        return fkInstituicao;
    }

    public void setFkInstituicao(Integer fkInstituicao) {
        this.fkInstituicao = fkInstituicao;
    }

    public Integer getFkTipoUsuario() {
        return fkTipoUsuario;
    }

    public void setFkTipoUsuario(Integer fkTipoUsuario) {
        this.fkTipoUsuario = fkTipoUsuario;
    }

    public List<HistoricoLogin> getHistoricoLogin() {
        return historicoLogin;
    }

    public void setHistoricoLogin(List<HistoricoLogin> historicoLogin) {
        this.historicoLogin = historicoLogin;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", fkInstituicao=" + fkInstituicao +
                ", fkTipoUsuario=" + fkTipoUsuario +
                '}';
    }
}
