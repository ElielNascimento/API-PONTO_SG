package exemplo2.exer2.funcionario;

import exemplo2.exer2.ponto.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PontoRepository pontoRepository;

    public List<Funcionario> buscarFuncionario() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPeloId(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Não encontrado"));
    }

    public Funcionario adicionarFunc(Funcionario dados) {
        return funcionarioRepository.save(dados);
    }

    public Funcionario liberar(Funcionario funcionario) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        funcionario.setBloqueio(false);
        pontoRepository.liberarUsuario(calendar.getTime(), funcionario.getId());
        return funcionarioRepository.save(funcionario);
    }
}
