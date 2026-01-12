public class Exceptions extends RuntimeException {
    public Exceptions(String message) {
        super(message);
    }
}

class PacienteNaoEncontradoException extends Exception {
    public PacienteNaoEncontradoException(String cpf) {
        super("Paciente com CPF " + cpf + " não encontrado no sistema.");
    }
}

class MedicoNaoEncontradoException extends Exception {
    public MedicoNaoEncontradoException(String identificador) {
        super("Médico com identificador " + identificador + " não encontrado no sistema.");
    }
}

class DiaInvalidoException extends Exception {
    public DiaInvalidoException(int dia) {
        super("Dia inválido: " + dia + ". Escolha um número entre 1 e 5.");
    }
}

class TipoConsultaInvalidoException extends Exception {
    public TipoConsultaInvalidoException(String tipo) {
        super("Tipo de consulta inválido: " + tipo + ". Escolha 1 (Presencial) ou 2 (Online).");
    }
}

class TipoExameInvalidoException extends Exception {
    public TipoExameInvalidoException(String tipo) {
        super("Tipo de exame inválido: " + tipo + ". Escolha 1 (Laboratorial) ou 2 (Imagem).");
    }
}

class CpfInvalidoException extends Exception {
    public CpfInvalidoException(String cpf) {
        super("CPF inválido: " + cpf + ". Verifique o formato e tente novamente.");
    }
}

class CrmInvalidoException extends Exception {
    public CrmInvalidoException(String crm) {
        super("CRM inválido: " + crm + ". Verifique o formato e tente novamente.");
    }
}