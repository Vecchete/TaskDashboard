# TaskDashboard
TaskDashboard for voxus

Trabalho está incompleto, só consegui impelementar o serviço de criação, edição e deleção de tasks.

Posso ter escolhido as coisas erradas para fazer esse projeto, mas vou deixar aqui meu relatório. Para desenvolver o trabalho eu usei 
as seguintes tecnologias:

- Spring 4.1.7

Primeiramente deixar claro que utilizei o padrão MVC, o Spring MVC é um framework que ajuda no desenvolvimento de aplicações web. Com
ele eu consigo construir aplicações web robustas e flexíveis. Ele já tem todas as funcionalidades  para  atender as requisições HTTP, 
delegar responsabilidades de processamento de dados para outros componentes e preparar a resposta que precisa ser dada. Achei uma 
excelente implementação do padrão MVC.

- Hibernate

É um framework de mapeamento objeto-relacional, usei para facilitar o tratamento dos dados do BD, relacionando eles com um objeto em java.

- MySQL Server 5.6

Usado para criar o BD. Usei um servidor local para testar o BD.

- Maven 3

Utilizei para automatizar o processo de compilação.

- JDK 1.7

Utilizado para desenvolver em Java, embora ja possua uma versão atual.
- Tomcat 8.5

Utilziado para simular o servidor local.

- Eclipse NEON

Utilziado para desenvolver.

Eu comecei a implementação criando um banco de dados local usano MySQL Server, o código em sql do banco está descrito abaixo:
        
        create database voxus;

        use voxus;

        create table Users(
          UserID INT NOT NULL AUTO_INCREMENT,
            Username varchar(45) NOT NULL,
            Email varchar(45) NOT NULL,
            primary key (UserID)
        );

        create table Task(
          TaskID INT NOT NULL auto_increment,
            TaskName varchar(45) NOT NULL,
            Priority int,
            Description varchar(512),
            SubmitUserID INT,
            DoneUserID INT,
            Status INT,
            primary key (TaskID),
            foreign key (SubmitUserID) references Users(UserID),
            foreign key (DoneUserID) references Users(UserID)
        );

        create table Files(
          FileID INT NOT NULL auto_increment,
            TaskID INT NOT NULL,
            TypeFile varchar(45),
            primary key (FileID),
            foreign key (TaskID) references Task(TaskID)
        );

        insert into Users(Username, Email) values ("Outro", "lucasvecchete@unifesp.br");

Criei então os objetos, no qual estão associados ao modelo relacional do bando de dados, os objetos DAO, para serem realizadas as
intruções do BD de fato.

E criei as classes de configuração e controle (controller).

Por fim, criei as paginas .jsp:

  -registration.jsp: Pagina que possui o formulario de criação de task.
  
  -taskslist.jsp: Pagina que possui a lista de tasks.
  
  -registratiosuccess.jsp: Pagina que fala que o registro da task foi feito com sucesso.
  
