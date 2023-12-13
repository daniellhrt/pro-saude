# ProSaude - API de Cadastro de Técnicos de Enfermagem 
### PROJETO EM DESENVOLVIMENTO

## Visão Geral

O ProSaude é uma API desenvolvida para facilitar o cadastro e contratação de técnicos de enfermagem, proporcionando serviços em domicílio para atender às necessidades dos pacientes. 
Essa aplicação permite a contratação de uma variedade de serviços simples, incluindo troca de curativos, limpeza e cuidados pessoais.

## Funcionalidades Principais

### 1. Pacientes

- **Cadastro de Paciente:**
  - Endpoint: `/api/pacientes`
  - Método: `POST`
  - Descrição: Cadastra um novo paciente.

- **Atualização de Paciente:**
  - Endpoint: `/api/pacientes/{id}`
  - Método: `PUT`
  - Descrição: Atualiza as informações de um paciente existente.

- **Listagem de Pacientes:**
  - Endpoint: `/api/pacientes`
  - Método: `GET`
  - Descrição: Obtém uma lista de todos os pacientes cadastrados.

### 2. Profissionais de Enfermagem

- **Cadastro de Profissional:**
  - Endpoint: `/api/profissionais`
  - Método: `POST`
  - Descrição: Cadastra um novo técnico de enfermagem.

- **Atualização de Profissional:**
  - Endpoint: `/api/profissionais/{id}`
  - Método: `PUT`
  - Descrição: Atualiza as informações de um técnico de enfermagem existente.

- **Listagem de Profissionais:**
  - Endpoint: `/api/profissionais`
  - Método: `GET`
  - Descrição: Obtém uma lista de todos os técnicos de enfermagem cadastrados.

### 3. Serviços

- **Cadastro de Serviço:**
  - Endpoint: `/api/servicos`
  - Método: `POST`
  - Descrição: Cadastra um novo serviço oferecido pelos profissionais.

- **Listagem de Serviços:**
  - Endpoint: `/api/servicos`
  - Método: `GET`
  - Descrição: Obtém uma lista de todos os serviços disponíveis.
