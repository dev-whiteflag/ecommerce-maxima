import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {environment} from '../../../environments/environment';

export abstract class ApiService {
  public service = 'api';
  public version = 'v1';
  public endpoints = 'clients';
  public readonly URI = environment.uri + '/' + this.service + '/' + this.version + '/' + this.endpoints;
  public headers = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
}
