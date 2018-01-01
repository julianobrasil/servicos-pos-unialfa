const gulp = require('gulp');
const shell = require('gulp-shell');

gulp.task('eureka', shell.task([
  'start cmd /k java -jar ./eureka/target/eureka-v0.0.1-alpha.0.jar'
]));

gulp.task('eureka-compile', shell.task([
  'start cmd /k mvn clean package -f ./eureka/pom.xml'
]));

gulp.task('gateway', shell.task([
  'start cmd /k java -jar ./gateway/target/gateway-v0.0.1-alpha.0.jar'
]));

gulp.task('gateway-compile', shell.task([
  'start cmd /k mvn clean package -f ./gateway/pom.xml'
]));

gulp.task('usuarios-1', shell.task([
  'start cmd /k java -jar ./service-usuarios-1/target/service-usuario-1-v0.0.1-alpha.0.jar'
]));

gulp.task('usuarios-1-compile', shell.task([
  'start cmd /k "cd ./service-usuarios-1 & mvnw clean package"'
]));

gulp.task('usuarios-2', shell.task([
  'start cmd /k java -jar ./service-usuarios-1/target/service-usuario-2-v0.0.1-alpha.0.jar'
]));

gulp.task('usuarios-2-compile', shell.task([
  'start cmd /k "cd ./service-usuarios-1 & mvnw clean package"'
]));

gulp.task('tarefas', shell.task([
  'start cmd /k java -jar ./service-tarefas/target/service-tarefas-v0.0.1-alpha.0.jar'
]));

gulp.task('tarefas-compile', shell.task([
  'start cmd /k "cd ./service-tarefas & mvnw clean package"'
]));

gulp.task('mensageria', shell.task([
  'start cmd /k java -jar ./mensageria/target/mensageria-v0.0.1-alpha.0.jar'
]));

gulp.task('mensageria-compile', shell.task([
  'start cmd /k "cd ./mensageria & mvnw clean package"'
]));

gulp.task('default', [
  'eureka',
  'usuarios-1',
  'tarefas',
  'mensageria',
  'gateway'
]);

gulp.task('compile', [
  'eureka-compile',
  'usuarios-1-compile',
  'tarefas-compile',
  'mensageria-compile',
  'gateway-compile'
]);