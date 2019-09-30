import { Component, OnInit } from '@angular/core';
import { LecturersDetailsDTO } from 'src/app/entities/lecturersDetails';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-update-lecturers',
  templateUrl: './update-lecturers.component.html',
  styleUrls: ['./update-lecturers.component.css']
})
export class UpdateLecturersComponent implements OnInit {

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  readonly url = 'http://localhost:8080/surveys';
  lecturers: LecturersDetailsDTO = {idLecturers: null, name: null, surname: null, phone: null, email: null, title: null};
  name: string;
  surname: string;
  id: number;
  phone: string;
  email: string;
  title: string;
  json: any;
  errorMessage;

  ngOnInit() {
      this.route.paramMap.subscribe(param => {
          this.id = +param.get('id');
      });
      this.getLecturerById();
  }

  getLecturerById() {
      this.http.get(this.url + '/lecturers/' + this.id + '/details').subscribe((data: any) => {
          this.lecturers = data;
          this.name = this.lecturers.name;
          this.surname = this.lecturers.surname;
          this.id = this.lecturers.idLecturers;
          this.phone = this.lecturers.phone;
          this.email = this.lecturers.email;
          this.title = this.lecturers.title;
      });
  }

  updateLecturer() {
      this.errorMessage = '';
      this.json = '';
      this.lecturers.name = this.name;
      this.lecturers.surname = this.surname;
      this.lecturers.idLecturers = this.id;
      this.lecturers.phone = this.phone;
      this.lecturers.email = this.email;
      this.lecturers.title = this.title;
      this.http.put(this.url + '/lecturers/modify', this.lecturers, {responseType: 'text'}).subscribe((data: any) => {
          console.log(data);
          this.json = data;
      }, error => {
          console.log(error);
          this.errorMessage = error.error;
      });
  }

}
