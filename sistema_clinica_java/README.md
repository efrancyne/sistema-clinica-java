# Sistema de Clínica Médica

Este é um sistema simples de gerenciamento de clínica médica desenvolvido em Java. Permite cadastrar pacientes e médicos, agendar consultas e exames, e visualizar listas e calendários.

## Funcionalidades

- **Cadastrar Paciente**: Adicione novos pacientes com informações pessoais e de saúde.
- **Cadastrar Médico**: Registre médicos com especialidades e dias de atendimento.
- **Agendar Consulta**: Marque consultas com médicos disponíveis.
- **Agendar Exame**: Agende exames para pacientes.
- **Listar Pacientes**: Visualize a lista de todos os pacientes cadastrados.
- **Listar Médicos**: Veja a lista de médicos registrados.
- **Calendário de Médicos**: Consulte os dias de atendimento dos médicos.
- **Listar Agendamentos**: Veja todos os agendamentos realizados.

## Como Executar

### Pré-requisitos
- Java Development Kit (JDK) instalado (versão 8 ou superior).

### Passos
1. Clone ou baixe o repositório.
2. Navegue até o diretório do projeto: `sistema_clinica_java/`.
3. Compile os arquivos Java:
   ```
   javac *.java
   ```
4. Execute o programa:
   ```
   java Main
   ```

## Estrutura do Projeto

- `Main.java`: Classe principal com o menu e lógica do sistema.
- `Pessoa.java`: Classe base para pessoas (pacientes e médicos).
- `Paciente.java`: Classe para representar pacientes.
- `Medico.java`: Classe para representar médicos.
- `Agendamento.java`: Classe para agendamentos.
- `Consulta.java`: Classe para consultas.
- `Exame.java`: Classe para exames.
- `Exceptions.java`: Tratamento de exceções personalizadas.

## Contribuição

Sinta-se à vontade para contribuir com melhorias ou correções. Abra uma issue ou envie um pull request.

## Licença

Este projeto é de código aberto e está sob a licença MIT.