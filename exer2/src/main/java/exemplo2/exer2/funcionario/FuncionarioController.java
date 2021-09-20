package exemplo2.exer2.funcionario;

import exemplo2.exer2.ponto.Ponto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/func")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> buscarTodos() {
        return funcionarioService.buscarFuncionario();
    }

    @GetMapping("/{id}")
    public Funcionario buscarfuncId(@PathVariable Long id) {
        return funcionarioService.buscarPeloId(id);
    }

    @PostMapping
    public Funcionario addFunco(@RequestBody Funcionario funcionario) {
        return funcionarioService.adicionarFunc(funcionario);
    }

    @PutMapping
    public Funcionario liberar(@RequestBody Funcionario funcionario) {
        return funcionarioService.liberar(funcionario);
    }

}
