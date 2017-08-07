# Terminal

#Instruções para rodar a aplicação

Algumas IDE's precisam ter o plugin do LOMBOK usado no projeto:

	Intellij IDEA :
	Vá para Arquivo> Configurações> Plugins
	Clique em Browse repositories ...
	Procure o Plugin Lombok
	Clique em instalar o plugin
	Reinicie o IntelliJ IDEA
   
    Eclipse:
    Clicar com o botão direito no jar do lombok (lombok-1.16.2.jar).
	Run As -> Java Application.
	Abrindo a janela de instalação, especifique o caminho do Eclipse.
	Clique em Install/Update.
	Reinicie o eclipse na mão( Não por: File -> Restart).
	
#Dependencias

Para importar as dependências do projetos com o comandos do maven no projet  /terminal:
    mvn clean dependency:copy-dependencies (https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

#Acesso ao projeto

   	Post https://terminalapi.herokuapp.com//v1/terminal
   	Get https://terminalapi.herokuapp.com//v1/terminal
   	    https://terminalapi.herokuapp.com//v1/terminal/245135
   	Put https://terminalapi.herokuapp.com//v1/terminal/245135
   	
#Rodar ao projeto

    Em qualquer Ide, basta clicar no Arquivo TerminalApplication.java 
    e selecionar 'Run TerminalApplication'.
    Para rodar direto no terminal:
    Entrar no path /src/main/java/br/com/terminal e digitar
    mvn spring-boot:run
    
#Recursos e parâmetros
O yaml completo está no projeto na pasta 'resources'
pode ser validado no site https://codebeautify.org/yaml-validator
    
    /terminal:
      description: Recurso responsável por consulta de todos os dados persistidos
      type:
        collection-GET:      
          getDescription: Retorna todos os dados persistido de um terminal
          getResponseSchema: string
          getResponseExample: |        
      /{logic}:
        description: Recurso de manutenção e consulta de um terminal
        type:
          member-POST-GET-PUT :
            uriIdParam: logicId
            uriIdDisplayName: logicId
            uriIdDescription: Id do logic
            uriIdType: string
            uriIdExample: "44332211"
            postDescription: Salva os dados de um terminal específico
            postRequestSchema: text
            postRequestExample: |
              44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN
            getDescription: Obtem dados de um terminal específico
            getResponseSchema: terminal
            getResponseExample: |
              {
                "logic": 44332211,
                "serial": "123",
                "model": "PWWIN",
                "sam": 0,
                "ptid": "F04A2E4088B",
                "plat": 4,
                "version": "8.00b3",
                "mxr": 0,
                "mxf": 16777216,
                "VERFM",
                "PWWIN"
              }    
            putDescription: Altera os dados de um terminal específico
            putRequestSchema: terminal
            putRequestExample: |
              {
                "logic": 44332211,
                "serial": "123",
                "model": "PWWIN",
                "sam": 0,
                "ptid": "F04A2E4088B",
                "plat": 4,
                "version": "8.00b3",
                "mxr": 0,
                "mxf": 16777216,
                "VERFM":"PWWIN"
              }
        post:
          headers:
            Content-Type:
              type: string
              required: true
              example: text/plain
              description: Tipo dos dados                    
        put:
          headers:
            Content-Type:
              type: string
              required: true
              example: application/json
              description: Tipo dos dados
        get:
          headers:
            Content-Type:
              type: string
              required: false
              example: application/json
              description: Tipo dos dados
   
   
     
    





   
   	

