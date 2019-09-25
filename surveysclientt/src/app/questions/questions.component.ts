import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Questions } from '../entities/questions';


@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
//   styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  constructor(private http: HttpClient) {
  }

  readonly url = 'http://localhost:8080/surveys';
  questions: Questions[];

  ngOnInit() {
    this.getAllQuestions();
  }

  getAllQuestions() {
    this.http.get(this.url + '/questions').subscribe((data: any) => {
      this.questions = data;
    });
  }




}
