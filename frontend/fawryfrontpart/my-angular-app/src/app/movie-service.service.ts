import { Injectable,Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import{movie} from './movie';
import { HttpHeaders,HttpParams } from '@angular/common/http';
import { AuthserviceService } from './authservice.service';
import { isPlatformBrowser } from '@angular/common'; 
import { PLATFORM_ID } from '@angular/core';
import { MovieOMDBAPI } from './MovieOMDBAPI';
import { PaginatedResponse } from './PaginatedResponse';
@Injectable({
  providedIn: 'root'
})
export class MovieServiceService {

  private apiUrl = 'http://localhost:8080/movies';
  constructor(private http: HttpClient, private auth:AuthserviceService,@Inject(PLATFORM_ID) private platformId: Object) { }
  
  getMovies(): Observable<movie[]> {
    /*const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem('jwt_token') // Assuming you store the token in localStorage
    })*/
   
   /*let tokenstr='Bearer '+window.localStorage.getItem('jwt_token');
   const headers=new HttpHeaders().set("Authorization",tokenstr);*/
   const token=this.auth.getToken1()
   const headers = new HttpHeaders({
    'Authorization': `Bearer ${token}`,  // Attach the JWT token to the request header
    'Content-Type': 'application/json'
  });
  
    
    return this.http.get<movie[]>(`${this.apiUrl}/getAllMovies`,{headers});
  }
  getmovie(id:number): Observable<movie[]>{
    const token=this.auth.getToken1()
   const headers = new HttpHeaders({
    'Authorization': `Bearer ${token}`,  // Attach the JWT token to the request header
    'Content-Type': 'application/json'
  });
    return this.http.get<movie[]>(`${this.apiUrl}/getMovie/${id}`,{headers});
  }

  getpaginatedmovies(page: number=0, size: number=5):Observable<PaginatedResponse<movie>>{
    const token=this.auth.getToken1()
    const params = new HttpParams()
    .set('page', page.toString())
    .set('size', size.toString());
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,  // Attach the JWT token to the request header
      'Content-Type': 'application/json'
    });
  return this.http.get<PaginatedResponse<movie>>(`${this.apiUrl}/getAllPaginatedMovies`,{params,headers})
  }

  getpaginatedmoviesfromomdb(page: number=0, size: number=2,title:string):Observable<PaginatedResponse<MovieOMDBAPI>>{
    const token=this.auth.getToken1()
    const params = new HttpParams()
    .set('page', page.toString())
    .set('size', size.toString())
    .set('title',title);
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,  // Attach the JWT token to the request header
      'Content-Type': 'application/json'
    });
  return this.http.get<PaginatedResponse<MovieOMDBAPI>>(`${this.apiUrl}/getAllPaginatedMoviesFromOMDB`,{params,headers})
  }
  getmoviesfromomdb(title:string): Observable<MovieOMDBAPI[]>{
    const token=this.auth.getToken1()
    const params = new HttpParams()
      .set('title',title)
   const headers = new HttpHeaders({
    'Authorization': `Bearer ${token}`,  // Attach the JWT token to the request header
    'Content-Type': 'application/json'
  });
    return this.http.get<MovieOMDBAPI[]>(`${this.apiUrl}/getMovies`,{headers,params});
  }
  addMovie(Movie: movie): Observable<string> {
    const token=this.auth.getToken1()
   const headers = new HttpHeaders({
    'Authorization': `Bearer ${token}`,  // Attach the JWT token to the request header
    'Content-Type': 'application/json'
  });
    return this.http.post<string>(`${this.apiUrl}/addMovie`, Movie,{headers});
  }
  deleteMovie(id: number): Observable<string> {
    const token=this.auth.getToken1()
   const headers = new HttpHeaders({
    'Authorization': `Bearer ${token}`,  // Attach the JWT token to the request header
    'Content-Type': 'application/json'
  });
    return this.http.delete<string>(`${this.apiUrl}/deleteMovie/${id}`,{headers});
  }

  /*addMovie(movie: movie): Observable<string> {
    return this.http.post<string>(`${this.apiUrl}/addMovie`, movie);
  }

  deleteMovie(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/deleteMovie/${id}`);
  }*/
}
