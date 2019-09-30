import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { SurveysComponent } from './surveys/surveys.component';
import { LecturersComponent } from './lecturers/lecturers.component';
import { QuestionsComponent } from './questions/questions.component';
import { CreateSurveyComponent } from './surveys/create-survey/create-survey.component';
import { SubjectsComponent } from './subjects/subjects.component';
import { CreateLecturersComponent } from './lecturers/create-lecturers/create-lecturers.component';
import { UpdateLecturersComponent } from './lecturers/update-lecturers/update-lecturers.component';
import { ShowLecturersComponent } from './lecturers/show-lecturer/show-lecturer.component';
import { ShowSurveyComponent } from './surveys/show-survey/show-survey.component';
import { ShowAnswersComponent } from './surveys/show-answers/show-answers.component';
import { CreateQuestionsComponent } from './questions/create-questions/create-questions.component';




@NgModule({
  declarations: [
    AppComponent,
    SurveysComponent,
    LecturersComponent,
    QuestionsComponent,
    CreateSurveyComponent,
    SubjectsComponent,
    CreateLecturersComponent,
    UpdateLecturersComponent,
    ShowLecturersComponent,
    ShowSurveyComponent,
    ShowAnswersComponent,
    CreateQuestionsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BsDatepickerModule.forRoot(),
    BrowserAnimationsModule,
    RouterModule.forRoot([
      {
        path: 'surveys',
        component: SurveysComponent
      },
      {
        path: 'lecturers',
        component: LecturersComponent
      },
      {
        path: 'questions',
        component: QuestionsComponent
      },
      {
        path: 'createSurvey',
        component: CreateSurveyComponent
      },
      {
        path: 'subjects',
        component: SubjectsComponent
      },
      {
        path: 'createLecturer',
        component: CreateLecturersComponent
      },
      {
        path: 'updateLecturer/:id',
        component: UpdateLecturersComponent
      },
      {
        path: 'showLecturer/:id',
        component: ShowLecturersComponent
      },
      {
        path: 'showSurvey/:id',
        component: ShowSurveyComponent
      },
      {
        path: 'showSurvey/:id/showAnswers',
        component: ShowAnswersComponent
      },
      {
        path: 'createQuestions',
        component: CreateQuestionsComponent
      }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
