import { HttpClient, HttpHeaders } from '@angular/common/http';
import {
  EnvironmentInjector,
  inject,
  Injectable,
  runInInjectionContext,
  signal,
} from '@angular/core';
import { toSignal } from '@angular/core/rxjs-interop';
import { environment } from '@envs/environment';
import { Character } from '@shared/models/character.interface';
import { Observable, tap } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class CharacterService {
  public characters = signal<Character[]>([]);
  private readonly _http = inject(HttpClient);
  private readonly _endPoint = environment.apiURL;

  private readonly _injector = inject(EnvironmentInjector);

  constructor() {
    this.getCharacters();
  }

  public getCharacters(page: number = 1): void {
    this._http
      .get<Character[]>(`${this._endPoint}character/?page=${page}`)
      .pipe(tap((data: Character[]) => this.characters.set(data)))
      .subscribe();
  }

  public getCharacterById(id: number) {
    return runInInjectionContext(this._injector, () =>
      toSignal<Character>(this._http.get<Character>(`${this._endPoint}character/${id}`))
    );
  }

  public downloadExcel(page: number = 1): Observable<Blob> {
    return this._http.get(`${this._endPoint}character/export/excel?page=${page}`, {
      responseType: 'blob',
      headers: new HttpHeaders({
        Accept:
          'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
      }),
    });
  }
}
