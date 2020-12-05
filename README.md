
#Desafio de automação Agibank
Este projeto foi desenvolvido para atender ao desafio de automação proposto pelo Agibank.
O desenvolvimento foi feito em um projeto Maven (Versão 4.0.0) em Java (Versão 8), utilizando o JDK na versão 14.0.2 e a IDE IntelliJ na versão 11.0.9.

#Teste da API
Os scripts de teste estão disponíveis no pacote scr/test/java em br.com.agibank e estão dispostos em:
- healthCheck: valida se a API está ativa e retornando;
- contrato: valida se os schemas permanecem inalterados;
- funcional: valida as ações de POST e PUT;
- exceptions: valida as exceções.






Valida se o código retornado da chamada HTTP é 200;
Valida se o retorno da chamada está em formato JSON;
Valida se o retorno da chamada ocorre em menos de 5000ms;
Valida se o retorno da chamada não apresenta erros;
Valida se os valores da chamada são os mesmos apresentados na descrição do teste;
Valida se o JSON retornado da chamada atende aos requisitos do schema disponível em src/test/resources/schema.json.