import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlocacaoDeTarefasService } from './alocacao-de-tarefas.service';
import { TarefaService } from './tarefa.service';
import { UsuarioService } from './usuario.service';
import { ComentarioService } from './comentario.service';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers: [
    AlocacaoDeTarefasService,
    TarefaService,
    UsuarioService,
    ComentarioService
  ]
})
export class ServicosModule { }
