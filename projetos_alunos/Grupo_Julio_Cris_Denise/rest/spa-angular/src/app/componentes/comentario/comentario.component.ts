import { ComentarioEntityTo } from '../../core/model/to/to';


import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';

import { ComentarioService } from '../../core/servicos/comentario.service';
import { UsuarioEntityTo } from '../../core/model/to/usuario-entity-to';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TarefaEntityTo } from '../../core/model/to/tarefa-entity-to';
import { DataSource } from '@angular/cdk/collections';
import {ComentarioDataSource } from './comentarioDataSource';
import { TarefaService } from '../../core/servicos/tarefa.service';
import { Observable } from 'rxjs/Observable';
import { TarefaSelecionada } from '../../core/model/tarefaSelecionada';
import { MatTableDataSource } from '@angular/material';
import { OnChanges } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
  selector: 'app-comentario',
  templateUrl: './comentario.component.html',
  styleUrls: ['./comentario.component.scss']
})
export class ComentarioComponent implements OnInit ,OnChanges{
  ngOnChanges(changes: SimpleChanges): void {
    if (changes.tarefaSelecionada.currentValue != changes.tarefaSelecionada.previousValue){
      if (this.tarefaSelecionada != null ){
        console.log('tarefa alterado');
        this._carregaDados();
      } 
    }
    
  }
  _outerForm: FormGroup;
  //_usuarioSelecionado : UsuarioEntityTo;
  //_datasource = new ComentarioDataSource();
 _comentarios: ComentarioEntityTo[] = [];
  _tarefa : TarefaEntityTo;
  _usuarios : UsuarioEntityTo[] ;
 
  private _comentario : ComentarioEntityTo;

  @Input() tarefaSelecionada : TarefaSelecionada = new TarefaSelecionada();
  @Output() tarefaSelecionadaChanged = new EventEmitter<TarefaEntityTo>();

  constructor(private comentarioService: ComentarioService, private _fb : FormBuilder) { 
    this._outerForm =  _fb.group({
       usuario: ['', Validators.required],
       corpo: ['',Validators.required],
       data:['',Validators.required]
      });
      
  }

  _carregaDados(){
    this.comentarioService.getAllComentariosPorTarefa(
      this.tarefaSelecionada.tarefa.id).subscribe(
        (data)=> {
          this._comentarios = data;
        }
    );

  }

  _limpa(){
    this._comentario = null;
    this._outerForm.reset();  
  }
  _grava(){
    if (this._comentario == null )
      this._comentario = new ComentarioEntityTo();
    this._comentario.corpo = this._outerForm.value.corpo;
    this._comentario.data = this._outerForm.value.data;
    //this._comentario.id = this._outerForm.value.id;
    this._comentario.tarefa = this.tarefaSelecionada.tarefa;
    this._comentario.usuario = this._outerForm.value.usuario;
    this.comentarioService.saveOrCreate(this._comentario).subscribe( (data) =>{
      if (!data)
        return;
      console.log('Salvo com sucesso');
      this._limpa();
      this._carregaDados();
    });
  }

  private _loadValueToInstanceComentario(comentario: ComentarioEntityTo) {
    this._comentario = comentario ? JSON.parse(JSON.stringify(comentario)) : null;
  }

  private _loadInstanceTarefaToForm() {
    if (!!this._comentario) {
      this._comentario.data = new Date();
      this._outerForm.patchValue(this._comentario);
      this._outerForm.markAsPristine();
      this._outerForm.markAsUntouched();
    } else {
      this._outerForm.reset();
    }
  }


  _voltar(){
    this.tarefaSelecionadaChanged.emit(null);
    
  }

  _editar( comentario : ComentarioEntityTo){
    this._loadValueToInstanceComentario(comentario);
    this._loadInstanceTarefaToForm();
  }


  _remover(idcomentario : number){
    this.comentarioService.remove(idcomentario)
        .subscribe(() => {
          this._carregaDados()
        })
  }
  

  ngOnInit() {
    if (this.tarefaSelecionada == null)
    this.tarefaSelecionada = new TarefaSelecionada();
    //this._usuarios = this.tarefaSelecionada.usuarios;
    //this._tarefa = this.tarefaSelecionada.tarefa;
    
  }

}
