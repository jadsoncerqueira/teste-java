import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9636.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        funcionarios = funcionarios.stream().filter(f -> !f.name.equals("João")).collect(Collectors.toList());

        System.out.println("---------------------");
        System.out.println("Funcionários:");
        System.out.println("---------------------");
        funcionarios.forEach(f -> System.out.printf("Nome: %s, Data Nascimento: %s, Salário: %,.2f, Função: %s%n",
                f.name, f.dataNascimento.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                f.salario, f.funcao));

        funcionarios.forEach(f -> f.salario = f.salario.multiply(new BigDecimal("1.10")));


        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(f -> f.funcao));

        System.out.println("---------------------");
        System.out.println("Funcionários agrupados:");
        System.out.println("---------------------");
        funcionariosPorFuncao.forEach((chave, valor) -> {
            System.out.println(chave);
            valor.forEach(f -> System.out.printf("Nome: %s, Data Nascimento: %s, Salário: %,.2f, Função: %s%n",
                    f.name, f.dataNascimento.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    f.salario, f.funcao));
        });


        System.out.println("---------------------");
        System.out.println("Funcionários nascidos no mês 10 e 12:");
        System.out.println("---------------------");

        funcionarios.forEach(f -> {
            if(f.dataNascimento.getMonthValue() == 10 || f.dataNascimento.getMonthValue() == 12 ) {
                System.out.printf("Nome: %s, Data Nascimento: %s, Salário: %,.2f, Função: %s%n",
                        f.name, f.dataNascimento.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        f.salario, f.funcao);
            }
        });



    }
}