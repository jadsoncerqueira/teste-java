import java.time.LocalDate;

abstract class Pessoa {
    String  name;
    LocalDate dataNascimento;
    public Pessoa(String n, LocalDate dN) {
        name = n;
        dataNascimento = dN;
    }
}
