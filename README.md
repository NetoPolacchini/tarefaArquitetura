# Documentação do Sistema de Gerenciamento de Contatos CLI

# Introdução

O Sistema de Gerenciamento de Contatos CLI é uma aplicação simples de linha de comando desenvolvida em Java para permitir a gestão básica de contatos. Ele permite ao usuário listar todos os contatos armazenados, adicionar novos contatos, remover contatos existentes e sair do sistema.

# Componentes
O sistema consiste em três arquivos principais:

Contato.java: Define a estrutura de dados para representar um contato, incluindo seu nome, telefone e email. Fornece métodos para acessar e modificar esses dados.

GerenciadorContatos.java: Implementa a lógica para manipulação dos contatos, incluindo a adição, remoção e listagem dos contatos. Os contatos são armazenados em uma lista interna.

SistemaContatosCLI.java: Contém a classe principal do sistema, que interage com o usuário através da linha de comando. Ele apresenta um menu de opções para que o usuário possa escolher entre listar contatos, adicionar um novo contato, remover um contato existente ou sair do sistema. As interações do usuário são tratadas por meio de um loop de controle.

# Funcionalidades
O Sistema de Gerenciamento de Contatos CLI oferece as seguintes funcionalidades:

Listar todos os contatos: Exibe na tela todos os contatos armazenados no sistema.

Adicionar um novo contato: Solicita ao usuário que insira o nome, telefone e email do novo contato e adiciona-o à lista de contatos.

Remover um contato: Permite ao usuário remover um contato existente fornecendo o nome do contato a ser removido.

Sair do sistema: Encerra a execução do programa.

# Utilização
Para utilizar o sistema, o usuário deve executar a classe principal SistemaContatosCLI. Em seguida, ele será apresentado com um menu de opções numeradas, onde pode escolher a ação desejada digitando o número correspondente ao comando. O sistema responderá de acordo com a escolha do usuário e continuará executando até que o usuário opte por sair.

# Considerações finais
Este sistema é uma implementação simples de um gerenciador de contatos que opera na linha de comando. Escolhi utilizar o padrão de projeto DAO por já ter utilizado ele antes.
