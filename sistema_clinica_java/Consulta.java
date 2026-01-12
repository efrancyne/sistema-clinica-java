public class Consulta extends Agendamento {
    public Consulta(Paciente paciente, Medico medico) {
        super(paciente, medico);
    }

    @Override
    public void agendar() {
        System.out.println("Consulta genérica agendada para " + paciente.getNome());
    }
}

class ConsultaPresencial extends Consulta {
    public ConsultaPresencial(Paciente paciente, Medico medico) {
        super(paciente, medico);
    }

    @Override
    public void agendar() {
        System.out.println("Consulta PRESENCIAL agendada para " + paciente.getNome() +
                " com o Dr(a). " + medico.getNome() + " para " + medico.getHorariosDisponiveis());
    }
}

class ConsultaOnline extends Consulta {
    public ConsultaOnline(Paciente paciente, Medico medico) {
        super(paciente, medico);
    }

    @Override
    public void agendar() {
        System.out.println("Consulta ONLINE agendada para " + paciente.getNome() +
                " com o Dr(a). " + medico.getNome());
    }
}

