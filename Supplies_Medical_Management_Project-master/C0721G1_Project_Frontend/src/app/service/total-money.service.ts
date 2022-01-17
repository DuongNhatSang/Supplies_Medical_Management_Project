import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TotalMoneyService {
  private API = 'http://localhost:8080/api/public/total'
  constructor(private httpClient: HttpClient) { }
  getAll(): Observable<number> {
    return this.httpClient.get<number>(this.API);
  }
  save(totalMoney: number): Observable<void> {
    return this.httpClient.get<void>(this.API + '/save/' + totalMoney);
  }
}
