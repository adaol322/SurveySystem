import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Surveys } from 'src/app/entities/Surveys';
import { Answers } from 'src/app/entities/answers';

@Component({
  selector: 'app-show-answers',
  templateUrl: './show-answers.component.html',
  styleUrls: ['./show-answers.component.css']
})
export class ShowAnswersComponent implements OnInit {

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  readonly url = 'http://localhost:8080/surveys';
  survey: Surveys;
  answers: Array<Answers>;
  id: number;

  ngOnInit() {
    this.route.paramMap.subscribe(param => {
        this.id = +param.get('id');
    });
    this.getAnswersById();
  }

  getAnswersById() {
    this.http.get(this.url + '/surveys/' + this.id).subscribe((data: any) => {
        this.survey = data;
        this.answers = this.survey.answersDTOS;
    });
  }

}
