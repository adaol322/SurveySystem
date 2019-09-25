import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Surveys } from '../entities/Surveys';
// import { LecturersDTO } from '../entities/lecturers';

@Component({
  selector: 'app-survey',
  templateUrl: './surveys.component.html',
  styleUrls: ['./surveys.component.css']
})
export class SurveysComponent implements OnInit {

  constructor(private http: HttpClient) {
  }

  readonly url = 'http://localhost:8080/surveys';
  surveys: Surveys[];
  // lecturer: LecturersDTO;

  ngOnInit() {
    this.getAllSurveys();
  }

  getAllSurveys() {
    this.http.get(this.url + '/surveys').subscribe((data: any) => {
      this.surveys = data;
      //let lect = data['lecturerDTO'];
    });
  }

}
