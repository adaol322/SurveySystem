import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Surveys } from 'src/app/entities/Surveys';
import { Answers } from 'src/app/entities/answers';
import { Subjects } from 'src/app/entities/subjects';
import { LecturersDTO } from 'src/app/entities/lecturers';
import { Questions } from 'src/app/entities/questions';

@Component({
  selector: 'app-survey',
  templateUrl: './create-survey.component.html',
})

export class CreateSurveyComponent implements OnInit {

    constructor(private http: HttpClient) {}

    survey: Surveys = {date : null, lecturer : null, subject : null, answerList : null};
    answer: Answers = {answer : null, question : null};
    readonly url = 'http://localhost:8080/surveys';
    date = '';
    lecturers: LecturersDTO[];
    lecturer: LecturersDTO;
    idLecturers: number;
    subjects: Subjects[];
    subject: Subjects;
    answerString: string;
    questions: Questions[];
    index: number;
    json;

    ngOnInit() {
        this.getAllLecturers();
        this.getAllSubjects();
        this.getAllQuestions();
        this.index = 0;
    }

    createSurvey() {
        this.survey.date = this.date;
        this.survey.lecturer = this.lecturer;
        this.survey.subject = this.subject;
        console.log(this.lecturer);
        console.log(this.subject);
        this.http.post(this.url + 'surveys/add', this.survey).toPromise().then((data: any) => {
            this.clear();
            console.log(data);
            this.json = JSON.stringify(data.json);
        });
    }

    createAnswer() {
        this.answer.answer = this.answerString;
        this.answer.question = new Questions();
        this.answer.question.idQuestions = this.index;
        this.answer.question.question = this.questions[this.index].question;
        this.survey.answerList = new Array<Answers>();
        this.survey.answerList.push(this.answer);
        console.log(this.answer);
        console.log(this.questions);
        if (this.index === 3) {
            this.createSurvey();
        }
        this.answerString = null;
        this.index++;
    }

    getAllLecturers() {
        this.http.get(this.url + '/lecturers').subscribe((data: any) => {
            this.lecturers = data;
        });
    }

    getAllSubjects() {
        this.http.get(this.url + '/subjects').subscribe((data: any) => {
            this.subjects = data;
        });
    }

    getAllQuestions() {
        this.http.get(this.url + '/questions').subscribe((data: any) => {
            this.questions = data;
            console.log(this.questions);
        });
    }

    getLecturerById(){
        this.http.get(this.url + '/lecturers' + this.idLecturers).subscribe((data: any) => {
            this.lecturer = data;
          });
    }

    clear() {
        this.date = '';
        this.lecturers = null;
        this.lecturer = null;
        this.subjects = null;
        this.subject = null;
        this.answerString = null;
        this.questions = null;
    }
}
