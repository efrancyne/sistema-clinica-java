import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Agendamento> agendamentos = new ArrayList<>();

        medicos.add(new Medico("Dr. João Silva", "12345678900", "88885555", "001", "cardiologista", "Terça-feira"));
        medicos.add(new Medico("Dra. Maria Oliveira", "98765432100", "99996666", "002", "cardiologista", "Segunda-feira"));
        medicos.add(new Medico("Dr. Pedro Costa", "11223344556", "22223333", "003", "cardiologista", "Quarta-feira"));

        pacientes.add(new Paciente(
                "Ana Silva",
                "123.456.789-00",
                "(11) 99999-8888",
                "10/05/1990",
                "Feminino",
                "Unimed",
                "Nenhuma"
        ));
        pacientes.add(new Paciente(
                "Carlos Souza",
                "987.654.321-00",
                "(21) 98888-7777",
                "22/09/1985",
                "Masculino",
                "Bradesco Saúde",
                "Amendoim"
        ));

        System.out.println("===== SISTEMA DE CLÍNICA MÉDICA =====");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Cadastrar Médico");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Agendar Exame");
            System.out.println("5. Listar Pacientes");
            System.out.println("6. Listar Médicos");
            System.out.println("7. Calendário de Médicos");
            System.out.println("8. Listar Agendamentos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = sc.nextLine();

            try {
                switch (opcao) {
                    case "1":
                        System.out.print("Nome do paciente: ");
                        String nomeP = sc.nextLine();
                        System.out.print("CPF do paciente: ");
                        String cpfP = sc.nextLine();
                        System.out.print("Telefone do paciente: ");
                        String telP = sc.nextLine();
                        System.out.print("Data de nascimento do paciente: ");
                        String dataNascimentoP = sc.nextLine();
                        System.out.print("Sexo do paciente: ");
                        String sexoP = sc.nextLine();
                        System.out.print("Plano de saúde: ");
                        String planoP = sc.nextLine();
                        System.out.print("Alergias: ");
                        String alergiasP = sc.nextLine();


                        Paciente novoPaciente = new Paciente(nomeP, cpfP, telP, dataNascimentoP,sexoP, planoP, alergiasP);
                        pacientes.add(novoPaciente);
                        System.out.println("Paciente cadastrado com sucesso!");
                        break;

                    case "2":
                        System.out.print("Nome do médico: ");
                        String nomeM = sc.nextLine();
                        System.out.print("CPF do médico: ");
                        String cpfM = sc.nextLine();
                        System.out.print("Especialidade do médico: ");
                        String esp = sc.nextLine();
                        System.out.print("CRM: ");
                        String crm = sc.nextLine();
                        System.out.print("Telefone do médico: ");
                        String telM = sc.nextLine();
                        System.out.print("Dias da semana: ");
                        System.out.println("1 - Segunda-feira; 2 - Terça-feira; 3 - Quarta-feira; 4 - Quinta-feira; 5 - Sexta-feira");
                        System.out.print("Escolha o horário disponível do médico: ");

                        int diaSemana = sc.nextInt();
                        sc.nextLine();
                        String horarioD;

                        try {
                            horarioD = obterDiaSemana(diaSemana);
                            Medico novoMedico = new Medico(nomeM, cpfM, telM, crm, esp, horarioD);
                            medicos.add(novoMedico);
                            System.out.println("Médico cadastrado com sucesso! (CRM: " + novoMedico.getCrm() + ")");
                        } catch (DiaInvalidoException e) {
                            throw new DiaInvalidoException(diaSemana);
                        }
                        break;

                    case "3":
                        System.out.print("CPF do paciente: ");
                        String cpfPacienteC = sc.nextLine();
                        Paciente pC = null;
                        for (Paciente p : pacientes) {
                            if (p.getCpf().equals(cpfPacienteC)) {
                                pC = p;
                                break;
                            }
                        }
                        if (pC == null) throw new PacienteNaoEncontradoException(cpfPacienteC);

                        System.out.print("CRM do médico: ");
                        String crmMedicoC = sc.nextLine();
                        Medico mC = null;
                        for (Medico m : medicos) {
                            if (m.getCrm().equals(crmMedicoC)) {
                                mC = m;
                                break;
                            }
                        }
                        if (mC == null) throw new MedicoNaoEncontradoException(crmMedicoC);

                        System.out.println("Tipo de consulta:");
                        System.out.println("1. Presencial");
                        System.out.println("2. Online");
                        String tipoC = sc.nextLine();

                        Agendamento consulta;
                        if (tipoC.equals("1")) {
                            consulta = new ConsultaPresencial(pC, mC);
                        } else if (tipoC.equals("2")) {
                            consulta = new ConsultaOnline(pC, mC);
                        } else {
                            throw new TipoConsultaInvalidoException(tipoC);
                        }

                        consulta.agendar();
                        agendamentos.add(consulta);
                        break;

                    case "4":
                        System.out.print("CPF do paciente: ");
                        String cpfPacienteE = sc.nextLine();

                        Paciente pE = null;
                        for (Paciente p : pacientes) {
                            if (p.getCpf().equals(cpfPacienteE)) {
                                pE = p;
                                break;
                            }
                        }
                        if (pE == null) throw new PacienteNaoEncontradoException(cpfPacienteE);

                        System.out.print("CRM do médico: ");
                        String crmMedicoE = sc.nextLine();

                        Medico mE = null;
                        for (Medico m : medicos) {
                            if (m.getCrm().equals(crmMedicoE)) {
                                mE = m;
                                break;
                            }
                        }
                        if (mE == null) throw new MedicoNaoEncontradoException(crmMedicoE);

                        System.out.println("Tipo de exame:");
                        System.out.println("1. Laboratorial");
                        System.out.println("2. Imagem");
                        String tipoE = sc.nextLine();

                        Agendamento exame;
                        if (tipoE.equals("1")) {
                            exame = new ExameLaboratorial(pE, mE);
                        } else if (tipoE.equals("2")) {
                            exame = new ExameImagem(pE, mE);
                        } else {
                            throw new TipoExameInvalidoException(tipoE);
                        }

                        exame.agendar();
                        agendamentos.add(exame);
                        break;

                    case "5":
                        System.out.println("\n--- Lista de Pacientes ---");
                        if (pacientes.isEmpty()) {
                            System.out.println("Nenhum paciente cadastrado.");
                        } else {
                            int i = 1;
                            for (Paciente p : pacientes) {
                                System.out.println("\nPaciente " + i + ":");
                                p.exibirInfo();
                                i++;
                            }
                        }
                        break;

                    case "6":
                        System.out.println("\n--- Lista de Médicos ---");
                        if (medicos.isEmpty()) {
                            System.out.println("Nenhum médico cadastrado.");
                        } else {
                            int i = 1;
                            for (Medico m : medicos) {
                                System.out.println("\nMédico " + i + ":");
                                m.exibirInfo();
                                i++;
                            }
                        }
                        break;

                    case "7":
                        if (medicos.isEmpty()) {
                            System.out.println("Nenhum médico cadastrado ainda.");
                            return;
                        }

                        Map<String, List<Medico>> agenda = new LinkedHashMap<>();
                        agenda.put("Segunda-feira", new ArrayList<>());
                        agenda.put("Terça-feira", new ArrayList<>());
                        agenda.put("Quarta-feira", new ArrayList<>());
                        agenda.put("Quinta-feira", new ArrayList<>());
                        agenda.put("Sexta-feira", new ArrayList<>());

                        for (Medico m : medicos) {
                            String dia = m.getHorariosDisponiveis();
                            if (agenda.containsKey(dia)) {
                                agenda.get(dia).add(m);
                            } else {
                                agenda.putIfAbsent(dia, new ArrayList<>());
                                agenda.get(dia).add(m);
                            }
                        }

                        System.out.println("\n=== AGENDA DE ATENDIMENTO ===");
                        for (String dia : agenda.keySet()) {
                            System.out.println(dia + ":");
                            List<Medico> listaDia = agenda.get(dia);
                            if (listaDia.isEmpty()) {
                                System.out.println("  (nenhum médico disponível)");
                            } else {
                                for (Medico m : listaDia) {
                                    System.out.println("  - Dr(a). " + m.getNome() + " (" + m.getEspecialidade() + ")");
                                }
                            }
                        }
                        System.out.println();
                        break;

                    case "8":
                        System.out.println("\n=== LISTA DE AGENDAMENTOS ===");
                        if (agendamentos.isEmpty()) {
                            System.out.println("Nenhum agendamento realizado.");
                        } else {
                            int contador = 1;
                            for (Agendamento a : agendamentos) {
                                System.out.println("\nAgendamento " + contador + ":");

                                if (a instanceof ConsultaPresencial) {
                                    System.out.println("Tipo: Consulta Presencial");
                                } else if (a instanceof ConsultaOnline) {
                                    System.out.println("Tipo: Consulta Online");
                                } else if (a instanceof ExameLaboratorial) {
                                    System.out.println("Tipo: Exame Laboratorial");
                                } else if (a instanceof ExameImagem) {
                                    System.out.println("Tipo: Exame de Imagem");
                                } else if (a instanceof Consulta) {
                                    System.out.println("Tipo: Consulta Genérica");
                                } else if (a instanceof Exame) {
                                    System.out.println("Tipo: Exame Genérico");
                                }

                                a.exibirInfo();
                                System.out.println("---");
                                contador++;
                            }
                        }
                        break;

                    case "0":
                        continuar = false;
                        System.out.println("Encerrando o sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        sc.close();
    }

    public static String obterDiaSemana(int dia) throws DiaInvalidoException  {
        switch (dia) {
            case 1: return "Segunda-feira";
            case 2: return "Terça-feira";
            case 3: return "Quarta-feira";
            case 4: return "Quinta-feira";
            case 5: return "Sexta-feira";
            default: throw new DiaInvalidoException(dia);
        }
    }
}


