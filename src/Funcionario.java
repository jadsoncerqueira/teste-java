import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    BigDecimal salario;
    String funcao;

    public Funcionario(String n, LocalDate dN, BigDecimal sa, String fun) {
        super(n, dN);
        salario = sa;
        funcao = fun;
    }
}
