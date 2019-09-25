import { Component, OnInit } from '@angular/core';
import { LecturersDTO } from 'src/app/entities/lecturers';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-update-lecturers',
  templateUrl: './update-lecturers.component.html'
})
export class UpdateLecturersComponent implements OnInit {

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  readonly url = 'http://localhost:8080/surveys';
  lecturers: LecturersDTO = {idLecturers: null, name: null, surname: null};
  name: string;
  surname: string;
  id: number;
  json: any;

  ngOnInit() {
      this.route.paramMap.subscribe(param => {
          this.id = +param.get('id');
      });
      this.getLecturerById();
  }

  getLecturerById() {
      this.http.get(this.url + '/lecturer/' + this.id).subscribe((data: any) => {
          this.lecturers = data;
          this.name = this.lecturers.name;
          this.surname = this.lecturers.surname;
          this.id = this.lecturers.idLecturers;
      });
  }

  updateLecturer() {
      this.lecturers.name = this.name;
      this.lecturers.surname = this.surname;
      this.lecturers.idLecturers = this.id;
      this.http.put(this.url + '/lecturer/modify', this.lecturers).subscribe((data: any) => {
          console.log(data);
          this.json = JSON.stringify(data.json);
      });
  }

}
