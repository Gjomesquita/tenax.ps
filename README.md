# tenax.ps
Desafio Tenax

Pré requisitos:
- JDK 11 
DETALHE: É necessário que no sistema, haja a variavel JAVA_HOME com caminho para a pasta do jdk (Explicação abaixo)

Para rodar API sem IDE:

PASSO 1 :
	Baixe servidor tomcat 9 - https://tomcat.apache.org/download-90.cgi
	e extraia o zip
	
PASSO 2 :
	Copie o arquivo tenax.war da pasta /target para a pasta apache-tomcat-9.0.43/webapps
	
PASSO 3 :
	a)
		No terminal, vá para a pasta apache-tomcat-9.0.43/bin e rode o comando "catalina.bat run"
		(caso não reconheça o comando catalina.bat, será necessário rodar desta maneira ".\catalina.bat run"
	b)
		Abra a pasta apache-tomcat-9.0.43/bin e clique para rodar o arquivo startup.bat
		
PASSO 4 :
	Com a api rodando, basta executar as chamadas para http://localhost:8080/tenax (ver Documentação.txt para referência de endpoints)
		
		


Criando variavel de sistema JAVA_HOME (Windows):
	1- Busque e abra: Editar as variáveis de ambiente do sistema 
	2- Em "Avançado", Clique em "Variáveis de Ambiente..."
	3- Em "Variáveis do Sistema"
		caso não exista a variável "JAVA_HOME":
			clique em "Novo..." e crie a variável com nome 'JAVA_HOME' e o diretório será a pasta do jdk 11
		caso exista a variável "JAVA_HOME":
			Certifique que ela aponte para a pasta do jdk, caso não, clique em 'editar' e altere o valor da varíavel para a pasta do jdk