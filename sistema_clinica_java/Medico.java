public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
    private String horariosDisponiveis;

    public Medico(String nome, String cpf, String telefone, String crm, String especialidade, String horariosDisponiveis) {
        super(nome, cpf, telefone);
        this.crm = crm;
        this.especialidade = especialidade;
        this.horariosDisponiveis = horariosDisponiveis;
    }

    public String getCrm() {
        return crm;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public String getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome: " + getNome() + ", CRM: " + crm + ", Especialidade: " + especialidade + ", Horário: " + horariosDisponiveis);
    }
}
