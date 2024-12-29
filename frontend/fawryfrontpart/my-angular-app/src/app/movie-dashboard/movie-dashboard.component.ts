import { Component,OnInit } from '@angular/core';
import { MovieServiceService } from '../movie-service.service';
import { FormsModule,ReactiveFormsModule } from '@angular/forms'; 
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { response } from 'express';
import { NgIf,NgFor,NgClass } from '@angular/common';
import { HttpHeaders } from '@angular/common/http';
import { isPlatformBrowser } from '@angular/common'; 
import { PLATFORM_ID } from '@angular/core';
import { Injectable,Inject } from '@angular/core';
import { AuthserviceService } from '../authservice.service';
import { Router } from '@angular/router'
@Component({
  selector: 'app-movie-dashboard',
  standalone: true,
  imports: [FormsModule,HttpClientModule,ReactiveFormsModule,NgIf,NgFor,CommonModule,NgClass],
  templateUrl: './movie-dashboard.component.html',
  styleUrl: './movie-dashboard.component.css'
})
export class MovieDashboardComponent {
  movies: any[] = [];
  
  newMovie = {
    id:7,
    title: '',
    genre: '',
    year: '',
    description:'',
    poster:'',
    director:'',
  };
  page:number = 0;
  size:number = 2;
  totalPages:number = 0;
  totalElements:number = 0;
  constructor(private movieService: MovieServiceService,@Inject(PLATFORM_ID) private platformId: Object,private auth:AuthserviceService,private router:Router) {}
  
  ngOnInit(): void {
    
    this.loadMovies();
  }
  loadMovies():void{
    let headers = new HttpHeaders();
       if (isPlatformBrowser(this.platformId)) {
        const tokenstr = 'Bearer ' + window.localStorage.getItem('jwt_token');
        if (tokenstr) {
          headers = headers.set('Authorization', tokenstr);
        }
      }
    this.movieService.getpaginatedmovies(this.page,this.size).subscribe(

      (res: any) => {
        /*const token=this.auth.getToken1();
        const headers = new HttpHeaders({
          'Authorization': `Bearer ${token}`,  // Attach the JWT token to the request header
          'Content-Type': 'application/json'
        });*/
        this.movies = res.content;
        this.totalPages = res.totalPages; // Total pages
        this.totalElements = res.totalElements;

      },
      (error) => {
        const token1=this.auth.getToken1();
        console.log("jhhh")
        console.log(token1);
        console.error('Error fetching movies:', error);
      }
    );
  }

  /*ngOnInit(): void {
    this.loadMovies();
  }

  loadMovies(): void {
    this.movieService.getMovies().subscribe(
      (movies) => {
        this.movies = movies;
      },
      (error) => {
        console.error('Error fetching movies:', error);
      }
    );
  }

  addMovie(): void {
    if (this.newMovie.title && this.newMovie.genre) {
      this.movieService.addMovie(this.newMovie).subscribe(
        (movie) => {
          this.movies.push(movie);
          this.newMovie = { title: '', genre: '', year: '',description:'',
            poster:'',
            director:'', };  // Reset the form
        },
        (error) => {
          console.error('Error adding movie:', error);
        }
      );
    }
  }

  deleteMovie(id: number): void {
    this.movieService.deleteMovie(id).subscribe(
      () => {
        this.movies = this.movies.filter(movie => movie.id !== id);
      },
      (error) => {
        console.error('Error deleting movie:', error);
      }
    );
  }*/
 moviedetail(id:number):void{
  this.router.navigate(['/moviedetail',id]);
 }
 nextPage() {
  console.log(2)
  if (this.page < this.totalPages - 1) {
    this.page++;
    this.loadMovies();
    
  }
  
}

previousPage() {
  console.log("h");
  if (this.page > 0) {
    this.page--;
    this.loadMovies();
    console.log(this.page)
  }
}
}
