public class Exame extends Agendamento {
    public Exame(Paciente paciente, Medico medico) {
        super(paciente, medico);
    }

    @Override
    public void agendar() {
        System.out.println("Exame genérico agendado para " + paciente.getNome());
    }
}

class ExameLaboratorial extends Exame {
    public ExameLaboratorial(Paciente paciente, Medico medico) {
        super(paciente, medico);
    }

    @Override
    public void agendar() {
        System.out.println("Exame LABORATORIAL agendado para " + paciente.getNome());
    }
}

class ExameImagem extends Exame {
    public ExameImagem(Paciente paciente, Medico medico) {
        super(paciente, medico);
    }

    @Override
    public void agendar() {
        System.out.println("Exame DE IMAGEM agendado para " + paciente.getNome());
    }
}
