import { Component } from '@angular/core';
import { Router } from '@angular/router'
import { CommonModule } from '@angular/common';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AuthserviceService } from '../authservice.service';
import { Role } from '../Role';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
 // username: string = '';
  //password: string = '';
  
  user={
    id:0,
    username: '',
    password:'',
    //role:'' as Role,
  }
  constructor(private router: Router,private authService: AuthserviceService) {}

  onSubmit() {
    // Here, you might want to perform some authentication logic.
    // For now, we'll just navigate to the movie dashboard.
    this.authService.login(this.user).subscribe(
      (response) => {
        // After successful login, store the JWT token in localStorage
        this.authService.storeToken(response.token);
        this.authService.storeRole(response.role);
        console.log(response.role);
        console.log(response.token);
        if(response.role=="ADMIN"){
          this.router.navigate(['deletemoviedashboard']);
        }
        if(response.role=="USER"){
          this.router.navigate(['/moviedashboard']);
        }

        // Handle successful login logic (redirect user, etc.)
      },
      (error) => {
        console.error('Login failed', error);
        alert('Invalid credentials');
      }
    );
    //this.router.navigate(['/moviedashboard']);
  }
}
