import { Component, OnInit } from '@angular/core';
import { LecturersDetailsDTO } from 'src/app/entities/lecturersDetails';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-create-lecturers',
  templateUrl: './create-lecturers.component.html',
  styleUrls: ['./create-lecturers.component.css']
})
export class CreateLecturersComponent implements OnInit {

  constructor(private http: HttpClient) { }

  readonly url = 'http://localhost:8080/surveys';
  lecturers: LecturersDetailsDTO = {idLecturers: null, name: null, surname: null, phone: null, email: null, title: null};
  name: string;
  surname: string;
  phone: string;
  email: string;
  title: string;
  json: any;
  errorMessage;

  ngOnInit() {
  }


  createLecturer() {
    this.errorMessage = '';
    this.json = '';
    this.lecturers.name = this.name;
    this.lecturers.surname = this.surname;
    this.lecturers.phone = this.phone;
    this.lecturers.email = this.email;
    this.lecturers.title = this.title;
    this.http.post(this.url + '/lecturers/add', this.lecturers, {responseType: 'text'}).toPromise().then((data: any) => {
      console.log(data);
      this.json = JSON.stringify(data.json);
    }, error => {
      this.errorMessage = error.error;
    });
  }

}
