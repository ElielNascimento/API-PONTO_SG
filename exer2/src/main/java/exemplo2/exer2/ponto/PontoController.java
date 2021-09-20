package exemplo2.exer2.ponto;

import exemplo2.exer2.funcionario.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/ponto")
public class PontoController {

    @Autowired
    private PontoService pontoService;

    @GetMapping
    public List<Ponto> buscarTodos() {
        return pontoService.busarPontos();
    }

    @GetMapping("/{id}")
    public Ponto ponto(@PathVariable Long id) {
        return pontoService.buscarPeloId(id);
    }

    @PostMapping("/{id}")
    public Ponto postPonto(@PathVariable Long id) throws Exception {
        return pontoService.adicionarPonto(id);
    }

}
