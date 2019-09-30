import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subjects } from '../entities/subjects';


@Component({
  selector: 'app-subjects',
  templateUrl: './subjects.component.html',
  styleUrls: ['./subjects.component.css']
})
export class SubjectsComponent implements OnInit {

  constructor(private http: HttpClient) {
  }

  readonly url = 'http://localhost:8080/surveys';
  subjects: Subjects[];

  ngOnInit() {
    this.getAllSubjects();
  }

  getAllSubjects() {
    this.http.get(this.url + '/subjects').subscribe((data: any) => {
      this.subjects = data;
    });
  }




}
