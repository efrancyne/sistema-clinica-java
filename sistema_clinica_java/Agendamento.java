public class Agendamento {
    public Paciente paciente;
    public Medico medico;

    public Agendamento(Paciente paciente, Medico medico) {
        this.paciente = paciente;
        this.medico = medico;
    }
    public void agendar(){
        System.out.println("Agendamento realizado com sucesso");
    }
    public void exibirInfo(){
        System.out.println("Paciente: " + paciente.getNome());
        if(medico != null){
            System.out.println("Medico: " + medico.getNome());
        }
    }

}
