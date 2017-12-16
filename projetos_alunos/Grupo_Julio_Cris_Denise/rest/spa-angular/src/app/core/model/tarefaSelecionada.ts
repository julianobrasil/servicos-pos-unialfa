import { TarefaEntityTo } from './to/tarefa-entity-to'; 
import { UsuarioEntityTo } from './to/usuario-entity-to'; 
 
export class TarefaSelecionada{ 
    public tarefa: TarefaEntityTo = null; 
    public usuarios: UsuarioEntityTo[] = []; 
} 