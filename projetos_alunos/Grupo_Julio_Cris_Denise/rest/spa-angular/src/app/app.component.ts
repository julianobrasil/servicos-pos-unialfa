import { Component } from '@angular/core';

import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';

import { UsuarioEntityTo, TarefaEntityTo } from './core/model/to/to';
import { TarefaSelecionada } from './core/model/tarefaSelecionada';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  _usuarios: UsuarioEntityTo[] = [];
  _tarefas: TarefaEntityTo[] = [];

  _tarefaSelecionada : TarefaSelecionada;

  constructor(breakpointObserver: BreakpointObserver) {
    breakpointObserver.observe([
      Breakpoints.HandsetLandscape,
      Breakpoints.HandsetPortrait
    ]).subscribe(result => {
      if (result.matches) {
        this.activateHandsetLayout();
      }
    });
  }

  activateHandsetLayout() {

  }
}
