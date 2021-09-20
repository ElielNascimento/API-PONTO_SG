package exemplo2.exer2.ponto;

import exemplo2.exer2.funcionario.Funcionario;
import exemplo2.exer2.funcionario.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PontoService {

    @Autowired
    private PontoRepository pontoRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    public List<Ponto> busarPontos() {
        return pontoRepository.findAll();
    }

    public Ponto buscarPeloId(Long id) {
        return pontoRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Usuario nao encontrado"));
    }

    @Transactional
    public Ponto adicionarPonto(Long id) throws Exception {
        Calendar dataAtual = Calendar.getInstance();

        dataAtual.set(Calendar.DAY_OF_WEEK, 1);
        dataAtual.set(Calendar.HOUR_OF_DAY, 00);
        dataAtual.set(Calendar.MINUTE, 00);
        dataAtual.set(Calendar.SECOND, 00);

        Date date = dataAtual.getTime();

        List<Ponto> pontoList = pontoRepository.buscarListaDePontos(date, id);

        Funcionario funcionario1 = funcionarioService.buscarPeloId(id);
        Ponto ponto = new Ponto();
        ponto.setFuncionario(funcionario1);

        Calendar horaComparativa = Calendar.getInstance();
        horaComparativa.set(Calendar.MINUTE, 0);
        horaComparativa.set(Calendar.HOUR_OF_DAY, 9);
        horaComparativa.set(Calendar.SECOND, 0);

        Calendar horaDoPonto = Calendar.getInstance();


        Calendar calendaGet = Calendar.getInstance();
        calendaGet.set(Calendar.HOUR_OF_DAY, 0);
        calendaGet.set(Calendar.MINUTE, 0);
        calendaGet.set(Calendar.SECOND, 0);

        Date date1 = calendaGet.getTime();

        List<Ponto> pontosDoDia = pontoRepository.buscarPrimeiroPonto(date1, id);

        if (funcionario1.isBloqueio()) {
            throw new Exception("voce esta bloqueado");
        } else {

            if (pontosDoDia.size() == 0 && pontoList.size() < 3) {

                if (horaDoPonto.after(horaComparativa)) {
                    ponto.setAtraso(true);
                } else {
                    ponto.setAtraso(false);
                }
                return pontoRepository.save(ponto);
            }
            if (pontosDoDia.size() < 4 /*&& pontoList.size() < 3*/) {
                return pontoRepository.save(ponto);
            } else {
                throw new Exception("Total de pontos limites excedido");
            }
        }


    }


}