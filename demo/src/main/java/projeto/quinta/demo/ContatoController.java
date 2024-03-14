import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private static String nome = "Marcelo";
    private static String telefone = "(81) 8964-4323";
    private static String email = "marceloPbn@gmail.com";
    private String nomeCadastrado;
    private String telefoneCadastrado;
    private String emailCadastrado;

    @GetMapping("/dados")
    public String getDadosFixos() {
        return "Nome: " + nomeFixo + ", Telefone: " + telefoneFixo + ", Email: " + emailFixo;
    }

    @PostMapping("/cadastrar")
    public String cadastrarContato(@RequestParam String nome,
                                   @RequestParam String telefone,
                                   @RequestParam String email) {
        this.nomeCadastrado = nome;
        this.telefoneCadastrado = telefone;
        this.emailCadastrado = email;
        return "Contato cadastrado com sucesso";
    }

    @DeleteMapping("/remover")
    public String removerContato(@RequestParam String telefone) {
        if (telefone.equals(this.telefoneCadastrado)) {
            this.nomeCadastrado = null;
            this.telefoneCadastrado = null;
            this.emailCadastrado = null;
            return "Contato removido";
        } else {
            return "dados não encontrado";
        }
    }
}
