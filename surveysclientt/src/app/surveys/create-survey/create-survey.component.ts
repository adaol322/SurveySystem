import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Surveys } from 'src/app/entities/Surveys';
import { Answers } from 'src/app/entities/answers';
import { Subjects } from 'src/app/entities/subjects';
import { LecturersDTO } from 'src/app/entities/lecturers';
import { Questions } from 'src/app/entities/questions';

@Component({
  selector: 'app-create-survey',
  templateUrl: './create-survey.component.html',
  styleUrls: ['./create-survey.component.css']
})

export class CreateSurveyComponent implements OnInit {

    constructor(private http: HttpClient) {}

    survey: Surveys = {date : null, lecturerDTO : null, subjectDTO : null, answersDTOS : null};
    answer: Answers = {answer : null, questionDTO : null};
    readonly url = 'http://localhost:8080/surveys';
    date = '';
    lecturers: LecturersDTO[];
    lecturer: LecturersDTO;
    idLecturers = 0;
    subjects: Subjects[];
    subject: Subjects;
    idSubjects: number;
    answerString = '';
    questions: Questions[];
    index = 0;
    json;

    ngOnInit() {
        this.getAllLecturers();
        this.getAllSubjects();
        this.getAllQuestions();
        this.survey.answersDTOS = new Array<Answers>();
    }

    createSurvey() {
        // this.survey.date = this.date;
        this.getLecturerById();
        this.getSubjectById();
        this.survey.date = '2019-01-01';
    }

    postSurvey() {
        this.printSurvey();
        this.http.post(this.url + '/surveys/add', this.survey).toPromise().then((data: any) => {
            // this.clear();
            console.log(data);
            this.json = JSON.stringify(data.json);
        });
    }

    printSurvey() {
        console.log(this.lecturer);
        console.log(this.subject);
        console.log(this.survey);
    }

    createAnswer() {
        this.survey.answersDTOS.push(new Answers(this.answerString, this.questions[this.index]));
        if (this.index === (this.questions.length - 1)) {
            this.createSurvey();
            this.printSurvey();
            this.postSurvey();
        }
        this.answerString = null;
        this.index++;
        console.log(this.survey);

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

    getLecturerById() {
        this.http.get(this.url + '/lecturers/' + this.idLecturers).subscribe((data: any) => {
            console.log(data);
            this.lecturer = data;
            this.survey.lecturerDTO = this.lecturer;
            console.log(this.lecturer);
          });
    }

    getSubjectById() {
        this.http.get(this.url + '/subjects/' + this.idSubjects).subscribe((data: any) => {
            this.subject = data;
            this.survey.subjectDTO = this.subject;
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
