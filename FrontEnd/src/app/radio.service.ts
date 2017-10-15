import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {Adf} from './models/Adf';
import {Nav} from './models/Nav';
import {Radio} from './models/Radio';

@Injectable()
export class RadioService {

  constructor(private http: Http) { }

  public getRadio(): Observable<Radio> {
    return this.getJson('/api/radio');
  }

  public getCom1(): Observable<Nav> {
    return this.getJson('/api/com1');
  }

  public getCom2(): Observable<Nav> {
    return this.getJson('/api/com2');
  }

  public getNav1(): Observable<Nav> {
    return this.getJson('/api/nav1');
  }

  public getNav2(): Observable<Nav> {
    return this.getJson('/api/nav2');
  }

  public getAdf(): Observable<Adf> {
    return this.getJson('/api/adf');
  }

  private getJson(path: string): Observable<any> {
    return this.http.get(path)
      .map((response) => response.json());
  }

}
