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



@NgModule({
  declarations: [
    AppComponent,
    SurveysComponent,
    LecturersComponent,
    QuestionsComponent,
    CreateSurveyComponent,
    SubjectsComponent,
    CreateLecturersComponent,
    UpdateLecturersComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BsDatepickerModule.forRoot(),
    BrowserAnimationsModule,
    RouterModule.forRoot([
      {
        path: '',
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
        path: 'updateLecturer',
        component: UpdateLecturersComponent
      }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
