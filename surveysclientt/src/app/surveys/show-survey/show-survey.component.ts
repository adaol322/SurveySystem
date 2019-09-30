import { Component, OnInit } from '@angular/core';
import { LecturersDetailsDTO } from 'src/app/entities/lecturersDetails';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Surveys } from 'src/app/entities/Surveys';

@Component({
  selector: 'app-show-survey',
  templateUrl: './show-survey.component.html',
  styleUrls: ['./show-survey.component.css']
})
export class ShowSurveyComponent implements OnInit {

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  readonly url = 'http://localhost:8080/surveys';
  survey: Surveys;
  id: number;

  ngOnInit() {
    this.route.paramMap.subscribe(param => {
        this.id = +param.get('id');
    });
    this.getSurveyById();
  }

  getSurveyById() {
    this.http.get(this.url + '/surveys/' + this.id).subscribe((data: any) => {
        this.survey = data;
    });
  }

}
