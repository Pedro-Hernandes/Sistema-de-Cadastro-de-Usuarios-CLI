# Sistema de Cadastro de Usuários (CLI)

Um sistema simples de linha de comando (CLI) para gerenciar usuários, implementando operações CRUD (Cadastrar, Listar, Editar e Excluir) com persistência em arquivo texto. Demonstra conceitos fundamentais de Java: Orientação a Objetos, Collections e leitura/escrita de arquivos.

---

## ✨ Funcionalidades

- **Cadastrar usuário**: Adiciona um novo usuário com ID automático.  
- **Listar usuários**: Exibe todos os usuários cadastrados.  
- **Editar usuário**: Altera nome e/ou e-mail de um usuário existente.  
- **Excluir usuário**: Remove um usuário pelo seu ID.  
- **Persistência**: Armazena e carrega dados em arquivo texto (`users.txt`).  

---

## 🛠 Tecnologias Utilizadas

- Java 8+
- Collections (`ArrayList`, `List`)
- File I/O (`FileReader`, `FileWriter`)
- JUnit 5 *(opcional)*

---

## ▶️ Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/user-management-cli.git
   cd user-management-cli/src

javac com/example/usermanagement/*.java

java com.example.usermanagement.Main

O sistema criará/atualizará o arquivo users.txt no diretório de execução.

=== SISTEMA DE CADASTRO DE USUÁRIOS ===
1. Cadastrar usuário
2. Editar usuário
3. Excluir usuário
4. Listar usuários
5. Sair

Cadastrar: Informe nome e e-mail.
Editar: Informe o ID do usuário e novos dados.
Excluir: Informe o ID do usuário.
Listar: Exibe todos os usuários.
Sair: Salva dados e encerra.

📄 Licença
Este projeto está licenciado sob a MIT License.

Desenvolvido com ❤️ por Pedro.
