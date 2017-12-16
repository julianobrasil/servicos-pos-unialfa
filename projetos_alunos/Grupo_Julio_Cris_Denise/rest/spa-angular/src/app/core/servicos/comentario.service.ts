import { Injectable } from '@angular/core';
import { ComentarioEntityTo } from '../model/to/comentario-entity-to';
import { Observable } from 'rxjs/Observable';
import { TarefaEntityTo } from '../model/to/tarefa-entity-to';

import { HttpClient, HttpParams } from '@angular/common/http';
import { URL } from '../model/constantes/constantes';
import { PaginaDeRespostaDoSpring } from '../model/to/pagina-de-resposta-do-spring';
import { UsuarioEntityTo } from '../model/to/usuario-entity-to';




@Injectable()
export class ComentarioService {

  constructor(private http: HttpClient) { }

  saveOrCreate( _comentario: ComentarioEntityTo):
    Observable<ComentarioEntityTo>{
    const requestUrl = `${URL.baseUrl}${URL.comentariosSaveOrCreate_Post}`;
    return this.http.post<ComentarioEntityTo>(requestUrl, _comentario);
  };

  remove( _idComentario: number ) : Observable<void>{
    const requestUrl = `${URL.baseUrl}${URL.comentariosRemove_Delete}`
    .replace(URL.comentariosRemove_Delete_Par1, '' + _idComentario);

    return this.http.delete<void>(requestUrl);
  }

  getAllUsuariosPorTarefa( _idtarefa: number): Observable<UsuarioEntityTo[]>{
    const requestUrl = `${URL.baseUrl}${URL.usuarioTarefaByTarefaId_Get}`
    .replace(URL.usuarioTarefaByTarefaId_Get_Par1, '' + _idtarefa);

    return this.http.get<UsuarioEntityTo[]>(requestUrl);
  }

  getAllComentariosPorTarefa( _idTarefa: number):Observable<ComentarioEntityTo[]>{
    const requestUrl = `${URL.baseUrl}${URL.comentariosByTarefaId_Get}`
    .replace(URL.comentariosByTarefaId_Get_Par1, '' + _idTarefa);

    return this.http.get<ComentarioEntityTo[]>(requestUrl);
  }
}
