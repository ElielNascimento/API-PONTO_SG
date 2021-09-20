package exemplo2.exer2.ponto;

import exemplo2.exer2.funcionario.Funcionario;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Ponto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date date;
    private boolean atraso;

    @JoinColumn(name = "funcionario_id")
    @ManyToOne
    private Funcionario funcionario;

    public Ponto() {
    }

    public Ponto( boolean atraso, Funcionario funcionario) {
        this.atraso = atraso;
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public boolean isAtraso() {
        return atraso;
    }

    public void setAtraso(boolean atraso) {
        this.atraso = atraso;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
