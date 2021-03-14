import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { BrandResponseModel } from '../models/brandResponseModel';

@Injectable({
  providedIn: 'root',
})
export class BrandService {
  apiUrl = environment.apiUrl + 'brands/getall';
  constructor(private httpClient: HttpClient) {}

  getBrands(): Observable<BrandResponseModel> {
    return this.httpClient.get<BrandResponseModel>(this.apiUrl);
  }
}
