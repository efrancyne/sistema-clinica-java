public class Paciente extends Pessoa {
    private String dataNascimento;
    private String sexo;
    private String planoSaude;
    private String alergia;

    public Paciente(String nome, String cpf, String telefone, String dataNascimento, String sexo,
                    String planoSaude, String alergia) {
        super(nome, cpf, telefone);
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.planoSaude = planoSaude;
        this.alergia = alergia;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Paciente: " + getNome() + ", CPF: " + getCpf() + ", Telefone: " + getTelefone());
        System.out.println("Nascimento: " + dataNascimento + ", Sexo: " + sexo + ", Plano: " + planoSaude + ", Alergia: " + alergia);
    }
}
