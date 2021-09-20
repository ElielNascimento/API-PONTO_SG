package exemplo2.exer2.funcionario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import exemplo2.exer2.ponto.Ponto;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFunc;
    private boolean bloqueio;

    public boolean isBloqueio() {
        return bloqueio;
    }

    public void setBloqueio(boolean bloqueio) {
        this.bloqueio = bloqueio;
    }

    @JsonIgnore
    @JoinColumn(name = "id_func")
    @OneToMany
    private List<Ponto> pontoList;


    public Funcionario() {
    }

    public Funcionario(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public Long getId() {
        return id;
    }

    public List<Ponto> getPontoList() {
        return pontoList;
    }

    public void setPontoList(List<Ponto> pontoList) {
        this.pontoList = pontoList;
    }


}