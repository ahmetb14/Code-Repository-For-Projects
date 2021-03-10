import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title: string = 'northwind';
  user: string = 'Ahmet Yılmaz';
  
}

//app.component.html'in datasını yönettiğimiz yerdir!
//Birbirine kardeş gibilerdir!
//Süslü parantez obje demek her şey olabilir!
//*ngFor="" directivesdir, tekrarlama foreach görevi üstlenir! <li "kısmına yazılır" ></li>
//let C# daki var keyword e benzer!