export const baseUrl = 'http://localhost:9000';

// api de usuários
export const usuariosAll_Get = '/usuarios/all';
export const usuariosSaveOrCreate_Post = '/usuarios/save-or-create';
export const usuariosRemove_Delete = '/usuarios/remove/{id}';
export const usuariosRemove_Delete_Par1 = '{id}';

// api de tarefas
export const tarefasAll_Get = '/tarefas/all';
export const tarefasSaveOrCreate_Post = '/tarefas/save-or-create';
export const tarefasRemove_Delete = '/tarefas/remove/{id}';
export const tarefasRemove_Delete_Par1 = '{id}';

// api de alocação de tarefas
export const usuarioTarefaByTarefaId_Get = '/usuarios-tarefas/find-by-tarefa-id/{idTarefa}';
export const usuarioTarefaByTarefaId_Get_Par1 = '{idTarefa}';
export const usuarioTarefaSaveOrCreate_Post = '/usuarios-tarefas/save-or-create';
export const usuarioTarefaRemove_Delete = '/usuarios-tarefas/remove/{id}';
export const usuarioTarefaRemove_Delete_Par1 = '{id}';

// api de comentarios de tarefas
export const comentariosByTarefaId_Get = '/comentarios/comentario-por-tarefa/{idTarefa}';
export const comentariosByTarefaId_Get_Par1 = '{idTarefa}';
export const comentariosSaveOrCreate_Post = '/comentarios/save-or-update';
export const comentariosRemove_Delete = '/comentarios/remove/{id}';
export const comentariosRemove_Delete_Par1 = '{id}';

export const usuariosByTarefaId_Get = '/usuarios-tarefas/usuarios-por-tarefaId/{idTarefa}'
export const usuariosByTarefaId_Get_Par1 = '{idTarefa}';
