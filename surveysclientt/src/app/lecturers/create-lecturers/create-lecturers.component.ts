import { Component, OnInit } from '@angular/core';
import { LecturersDTO } from 'src/app/entities/lecturers';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-create-lecturers',
  templateUrl: './create-lecturers.component.html'
})
export class CreateLecturersComponent implements OnInit {

  constructor(private http: HttpClient) { }

  readonly url = 'http://localhost:8080/surveys';
  lecturers: LecturersDTO = {idLecturers: null, name: null, surname: null};
  name: string;
  surname: string;
  json: any;

  ngOnInit() {
  }


  createLecturer() {
    this.lecturers.name = this.name;
    this.lecturers.surname = this.surname;
    this.http.post(this.url + '/lecturers/add', this.lecturers).toPromise().then((data: any) => {
      console.log(data);
      this.json = JSON.stringify(data.json);
      this.name = null;
      this.surname = null;
    });
  }

}
