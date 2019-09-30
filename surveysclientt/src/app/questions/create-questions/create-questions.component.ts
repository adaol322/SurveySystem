import { Component, OnInit } from '@angular/core';
import { Questions } from 'src/app/entities/questions';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-create-questions',
  templateUrl: './create-questions.component.html',
  styleUrls: ['./create-questions.component.css']
})
export class CreateQuestionsComponent implements OnInit {

  constructor(private http: HttpClient) { }

  readonly url = 'http://localhost:8080/surveys';
  questions: Questions = {idQuestions: null, question: null};
  questionString: string;
  json: any;


  ngOnInit() {
  }


  createQuestion() {
    this.json = '';
    this.questions.question = this.questionString;
    this.http.post(this.url + '/questions/add', this.questions, {responseType: 'text'}).toPromise().then((data: any) => {
      console.log(data);
      this.json = JSON.stringify(data.json);
    });
  }

}
