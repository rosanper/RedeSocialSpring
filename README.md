# RedeSocialSpring

Programa desenvolvido simulando uma rede social para o módulo de Programação Web II do curso Sinqia #dev_makers v.2 ministrada pela Ada

projeto adaptado do repositório https://github.com/rosanper/RedeSocial


## Programa

Desenvolver um programa simulando uma rede social onde o usuário vai fazer um cadastro, postar mensagens e visualizar a Timeline.

### Funcionamento e regra de negócio

- O programa deve ter as opções de cadastrar usuário e entrar;
- Ao selecionar "Cadastrar", o usuário deve iserir um nome, login e senha;
  - Os campos não podem ser vazios;
  - Não pode ser cadastrado um login ou senha já existentes;

- Ao efetuar o login com sucesso, o usuário terá as opções "Postar", "Ver sua timeline" e "Ver Timeline dos usuários da Rede Social";
- Ao selecionar postar você deve adicionar a data, hora e conteúdo do Post;
  - O conteudo deve ser um texto;
  - Ao finalizar a postagem uma mensagem é enviada;
- Ao selecionar ver sua timeline, será exibida todos os posts do usuário;
- Ao selecionar ver timeline dos usuarios da rede social, será exibida todos os posts dos usuários cadastrados no programa;


### Alterações futuras

Adicionar a função entrar:
- Ao selecionar a opção "Entrar", o usuário deve entrar com um login e senha;
  - O usuário deve entrar com um login cadastrado;
  - A senha deve ser a mesma cadastrada para o login escolhido pelo usuário;

Melhorar as Exceptions

Adicionar o Spring Security
