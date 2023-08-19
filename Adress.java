import java.util.ArrayList;
import java.util.List;

public class Adress {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;

    private String localidade;
    private String uf;
    private int ddd;

    List <Adress> adresses;

    public Adress(String logradouro, String complemento, String bairro, String localidade, String uf) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.adresses = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Endereço do CEP " + cep + ": " + logradouro + ", complemento " +
                complemento + ", bairro " + bairro + ", cidade " + localidade + ", UF " + uf + ", DDD " + ddd + ".";
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public int getDdd() {
        return ddd;
    }
}
