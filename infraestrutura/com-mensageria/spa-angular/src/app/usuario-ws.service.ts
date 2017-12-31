import { Injectable } from '@angular/core';

// import Stomp from 'stompjs';
// import SockJS from 'sockjs-client';

import { StompService } from 'ng2-stomp-service';

import { map } from 'rxjs/operators';
import { Subject } from 'rxjs/Subject';

import { URL } from './core/model/constantes/constantes';

export interface Message {
  isRemoved: boolean
}

@Injectable()
export class UsuarioWsService {
  private wsConf = {
    host: URL.baseUrlMensageria,
    debug: true,
    queue: { 'init': false }
  }

  public messages: Subject<Message> = new Subject<Message>();

  constructor(private stomp: StompService) {
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection() {
    // const ws = new SockJS(URL.baseUrlMensageria);
    // const stompClient = Stomp.over(ws);

    // stompClient.connect({}, () => {
    //   stompClient.subscribe(URL.usuariosNotificoes_WebSocket,  (message: any) => {
    //     this.messages.next(<Message>message.body););
    // });

    // stompClient.reconnect_delay = 5000;
    // stompClient.debug = (str: string) => { };

    this.stomp.configure(this.wsConf);

    this.stomp.startConnect().then(() => {
      this.stomp.done('init');
      console.log('connected');

      //subscribe
      this.stomp.subscribe(URL.usuariosNotificoes_WebSocket, (message: any) => {
        console.log('aqui', message)
        this.messages.next(<Message>message.body);
      });

      //send data
      // stomp.send('destionation',{"data":"data"});

      //unsubscribe
      // this.subscription.unsubscribe();

      //disconnect
      // stomp.disconnect().then(() => {
      //   console.log( 'Connection closed' )
      // })

    });
  }

}
