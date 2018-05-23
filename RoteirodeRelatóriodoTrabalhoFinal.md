Roteiro de Relatório do Trabalho Final;

Título: Interação com o usuário por meio de entretenimento;
Subtitulo: Jogo da Memória;
Instituição: UFSC-Florianópolis;
Membros da Equipe: Lucas Espindola, Monique Bertan e Northon Cardoso;
Data:

Uso do Programa

O usuário interage por meio de escolha de nível (Frames) e com o Mouse/MousePad
na escolha do botao(Carta) selecionada.

Análise do Problema 

Os problemas a serem superados são os de implementação de Icons/imageIcons em 
"dois lados" dos botões, e pontuação e tempo "rodando" ao mesmo tempo que o
usuário interage com o programa.

Arquitetura/Projeto

Inicialmente, o usuário escolhe um nível de jogo, cada nível com uma dificuldade
diferente do anterior, com o nível escolhido, abre-se uma nova Frame com o jogo.
Conforme o usuário for acertando as cartas, uma pontuaço é adicionada, o jogo acaba
com toda as cartas viradas ou com o termino do tempo de 300s, no nivel 2 a pontuação
é dobrada e no nivel 3 a pontuação é triplicada e cada erro ao sugerir um par de cartas
identicas é descontado no tempo total restante.
