package sistemaCaptura;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sistemaCaptura.conexao.Conexao;
import sistemaCaptura.user.Usuario;

import java.time.LocalDateTime;
import java.util.List;


public class HistoricoLogin {
    private int id;
    private Usuario usuario;
    private LocalDateTime horarioLogin;
    private boolean sucesso;
    static Conexao conexao = new Conexao();
    public HistoricoLogin() {
    }

    public HistoricoLogin(int idUsuario, LocalDateTime horarioLogin, boolean sucesso) {
        JdbcTemplate con = conexao.getConexaoDoBancoMySQL();
      List usuarios = con.query("SELECT * FROM usuario WHERE idUsuario =?",
                new BeanPropertyRowMapper<>(Usuario.class), idUsuario);
        this.usuario = (Usuario) usuarios.get(0);
        this.horarioLogin = horarioLogin;
        this.sucesso = sucesso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getHorarioLogin() {
        return horarioLogin;
    }

    public void setHorarioLogin(LocalDateTime horarioLogin) {
        this.horarioLogin = horarioLogin;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }



    @Override
    public String toString() {
        return "HistoricoLogin{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", horarioLogin=" + horarioLogin +
                ", sucesso=" + sucesso +
                '}';
    }
}
