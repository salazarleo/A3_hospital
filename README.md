Aqui está o seu README atualizado com mais testes que você mencionou. Incluí todos os testes adicionais que você pediu, mantendo o formato consistente e organizado:

```markdown
# 🌟 **Sistema de Gerenciamento de Saúde** 🌟

## 📖 **Visão Geral**

Este projeto simula um **sistema de gerenciamento de saúde**, com foco no controle de **pacientes**, **médicos**, **dispositivos médicos**, **consultas** e **monitoramento** de alertas. Ele possui menus interativos no console, permitindo aos usuários gerenciar de maneira eficiente e intuitiva todas as informações relevantes de saúde.

---

## 🚀 **Objetivo**

O objetivo deste sistema é fornecer uma plataforma simples e eficaz para o **gerenciamento de saúde**, possibilitando que **profissionais de saúde** registrem, atualizem e visualizem informações sobre:

- Pacientes 🧑‍⚕️
- Médicos 👩‍⚕️
- Dispositivos Médicos 🩺
- Consultas 📅
- Monitoramento de Saúde 📊

---

## 🧩 **Estrutura do Projeto**

### **1. Menu Principal 🏠**

A **interface principal** do sistema oferece um menu com opções para que o usuário navegue entre as funcionalidades. O menu inclui:

- **Menu Pacientes** 🧑‍⚕️: Registrar, listar, remover e alterar dados dos pacientes.
- **Menu Médicos** 👨‍⚕️: Registrar, listar, remover e alterar dados dos médicos.
- **Menu Dispositivos** 🩺: Registrar, listar, remover dispositivos e vincular aos pacientes.
- **Agendar Consulta** 📅: Criar, listar e remover consultas.
- **Monitoramento e Alertas** 🚨: Monitorar dispositivos, gerar alertas e visualizar dados de monitoramento.

---

### **2. Menu Pacientes 👨‍⚕️🩺**

Dentro do **Menu Pacientes**, o usuário pode realizar as seguintes operações:

- **Registrar Paciente** ✍️: Adicionar novos pacientes ao sistema.
- **Listar Pacientes** 📋: Exibir a lista de pacientes registrados.
- **Remover Pacientes** 🗑️: Excluir pacientes do sistema.
- **Alterar Dados Pacientes** ✏️: Atualizar as informações dos pacientes.

### **3. Menu Médicos 👩‍⚕️🩺**

No **Menu Médicos**, o usuário pode gerenciar os médicos do sistema com as seguintes ações:

- **Registrar Médico** 🩺: Adicionar novos médicos ao sistema.
- **Listar Médicos** 📋: Exibir a lista de médicos registrados.
- **Remover Médico** 🗑️: Excluir médicos do sistema.
- **Alterar Dados Médico** ✏️: Atualizar as informações dos médicos.
- **Ajustar Plano Paciente** 🩻: Atualizar os planos de acompanhamento de saúde dos pacientes.

### **4. Menu Dispositivos 🛠️**

No **Menu Dispositivos**, o usuário pode controlar os dispositivos médicos com as seguintes opções:

- **Cadastrar Dispositivo** 🖥️: Adicionar novos dispositivos médicos ao sistema.
- **Listar Dispositivos** 📋: Exibir todos os dispositivos registrados.
- **Remover Dispositivo** 🗑️: Excluir dispositivos do sistema.
- **Vincular Dispositivo a Paciente** 🔗: Associar um dispositivo a um paciente específico.
- **Listar Dispositivos com Pacientes** 📊: Mostrar os dispositivos e os pacientes associados.

### **5. Agendar Consulta 📅**

No menu **Agendar Consulta**, o usuário pode:

- **Criar Consulta** 📝: Agendar novas consultas entre pacientes e médicos.
- **Remover Consulta** ❌: Cancelar consultas existentes.
- **Listar Consultas** 📋: Exibir as consultas agendadas.

### **6. Monitoramento e Alertas 🚨**

A **funcionalidade de Monitoramento** permite o acompanhamento dos dispositivos médicos e a geração de alertas:

- **Registrar Monitoramento** 📊: Adicionar registros de monitoramento de dispositivos.
- **Listar Monitoramentos** 📋: Exibir os monitoramentos realizados.
- **Gerar Alerta** ⚠️: Criar alertas quando algum problema ou situação crítica for detectada.
- **Remover Alertas** 🗑️: Excluir alertas antigos ou resolvidos.
- **Listar Alertas** 📋: Exibir todos os alertas gerados.

---

## ⚙️ **Como Rodar o Projeto**

Para rodar o sistema, basta seguir os seguintes passos:

1. **Clonar o Repositório**:  
   Clone este repositório para sua máquina local utilizando o comando:
   ```bash
   https://github.com/salazarleo/A3_hospital
   ```

2. **Compilar e Executar**:  
   Compile o código com o comando:
   ```bash
   javac Main.java
   ```
   E execute a classe principal:
   ```bash
   java Main
   ```

3. **Interagir com o Menu**:  
   Ao rodar o programa, você verá o **Menu Principal**, onde poderá escolher entre as opções disponíveis, como **Registrar Paciente**, **Agendar Consulta**, **Gerar Alerta**, etc.

---

## 🛠️ **Tecnologias Utilizadas**

- **Linguagem**: Java ☕
- **Estrutura**: Programação Orientada a Objetos (POO) 🧑‍💻
- **Entrada**: Interface de linha de comando para interação com o usuário 💻

---

## ✨ **Funcionalidades Futuras**

- Adicionar **autenticação de usuário** para proteger dados sensíveis 🔐.
- Implementar **gráficos de monitoramento** para visualizar o status dos dispositivos ao longo do tempo 📈.
- Adicionar uma **base de dados** para persistência de informações 🗄️.

---

## 📚 **Testes Unitários** 🧑‍💻

### **Objetivo**
Os testes unitários garantem que o sistema de gerenciamento de saúde funcione corretamente. Eles validam as funcionalidades principais do sistema, como o cadastro de pacientes, médicos, dispositivos, consultas e alertas.

---

### **Testes Implementados**

#### **PacienteControllerTest** - **Testes do Controlador de Pacientes**

- **Objetivo**: Validar a criação de pacientes e o incremento do ID.
- **Método `setUp()`**: Reinicia o contador de IDs antes de cada teste.
- **Testes**:
  - **`testCriacaoPaciente()`**: Verifica se um paciente é criado corretamente e recebe o ID correto.
  - **`testContadorIdIncrementado()`**: Testa o incremento do contador de IDs para novos pacientes.
  - **`testRemoverPaciente()`**: Verifica se um paciente é removido corretamente do sistema.

#### **MedicoControllerTest** - **Testes do Controlador de Médicos**

- **Objetivo**: Garantir que os médicos sejam registrados corretamente.
- **Método `setUp()`**: Cria uma instância do controlador de médicos.
- **Testes**:
  - **`testRegistrarMedico()`**: Verifica se os dados do médico são registrados corretamente.
  - **`testAlterarDadosMedico()`**: Verifica se os dados do médico são alterados corretamente.
  - **`testRemoverMedico()`**: Testa a remoção de médicos do sistema.

#### **DispositivoControllerTest** - **Testes do Controlador de Dispositivos**

- **Objetivo**: Validar o cadastro e vínculo de dispositivos médicos com pacientes.
- **Testes**:
  - **`testRegistrarDispositivo()`**: Verifica se o dispositivo é registrado corretamente.
  - **`testVincularDispositivoPaciente()`**: Testa o vínculo de dispositivos com pacientes.
  - **`testRemoverDispositivo()`**: Testa a remoção de dispositivos do sistema.
  - **`testListarDispositivosPaciente()`**: Verifica a exibição dos dispositivos vinculados aos pacientes.

#### **ConsultaControllerTest** - **Testes do Controlador de Consultas**

- **Objetivo**: Validar a criação de consultas e o vínculo com médicos e pacientes.
- **Testes**:
  - **`testRegistrarConsulta()`**: Verifica se a consulta é registrada corretamente.
  - **`testRemoverConsulta()`**: Testa a remoção de consultas do sistema.

#### **AlertaControllerTest** - **Testes do Controlador de Alertas**

- **Objetivo**: Garantir que os alertas sejam gerados corretamente quando detectado um problema.
- **Testes**:
  - **`testGerarAlerta()`**: Verifica se um alerta é criado corretamente quando necessário.
  - **`testRemoverAlerta()`**: Testa a remoção de alertas do sistema.
  - **`testListarAlertas()`**: Verifica a exibição dos alertas registrados.

---

**Desenvolvido por**: [Leonardo Salazar](https://github.com/salazarleo)
```

Este README agora inclui os testes adicionais solicitados, organizados por controlador, com detalhes sobre o que cada teste verifica. Se precisar de mais ajustes, estou à disposição!
