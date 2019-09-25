import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LecturersDTO } from 'src/app/entities/lecturers';


@Component({
  selector: 'app-lecturers',
  templateUrl: './lecturers.component.html',
  styleUrls: ['./lecturers.component.css']
})
export class LecturersComponent implements OnInit {

  constructor(private http: HttpClient) {
  }

  readonly url = 'http://localhost:8080/surveys';
  lecturers: LecturersDTO[];

  ngOnInit() {
    this.getAllLecturers();
  }

  getAllLecturers() {
    this.http.get(this.url + '/lecturers').subscribe((data: any) => {
      this.lecturers = data;
    });
  }




}
