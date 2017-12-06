
Criando o remote:
heroku git:remote -a servico-tarefas-unialfa
git remote rename heroku heroku-servico-tarefas

verificando o remote:
git remote -v

usando o remote:
eureka: git subtree push --prefix infraestrutura/heroku/eureka heroku-eureka master
zuul: git subtree push --prefix infraestrutura/heroku/eureka heroku-zuul master
service-tarefas: git subtree push --prefix infraestrutura/heroku/service-tarefas heroku-servico-tarefas master
service-usuarios-1: git subtree push --prefix infraestrutura/heroku/service-usuarios-1 heroku-servico-usuarios-1 master
