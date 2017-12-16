import { Observable } from 'rxjs/Rx';
import { ComentarioEntityTo } from '../../core/model/to/to';
import { DataSource } from "@angular/cdk/collections";
import { CollectionViewer } from '@angular/cdk/collections';


export class ComentarioDataSource implements DataSource<ComentarioEntityTo>{
    connect(collectionViewer: CollectionViewer): Observable<ComentarioEntityTo[]> {
        throw new Error("Method not implemented.");
    }
    disconnect(collectionViewer: CollectionViewer): void {
        throw new Error("Method not implemented.");
    }
    
    
}