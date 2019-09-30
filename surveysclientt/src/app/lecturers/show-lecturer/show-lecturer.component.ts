import { Component, OnInit } from '@angular/core';
import { LecturersDetailsDTO } from 'src/app/entities/lecturersDetails';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-show-lecturer',
  templateUrl: './show-lecturer.component.html',
  styleUrls: ['./show-lecturer.component.css']
})
export class ShowLecturersComponent implements OnInit {

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  readonly url = 'http://localhost:8080/surveys';
  lecturerDetails: LecturersDetailsDTO;
  id: number;
  successMessage;
  errorMessage;

  ngOnInit() {
    this.route.paramMap.subscribe(param => {
        this.id = +param.get('id');
    });
    this.getLecturerDetailsById();
  }

  getLecturerDetailsById() {
    this.http.get(this.url + '/lecturers/' + this.id + '/details').subscribe((data: any) => {
        this.lecturerDetails = data;
    });
  }

  deleteLecturer(id: number) {
    this.http.delete(this.url + '/lecturers/delete/' + id, {responseType: 'text'}).subscribe((data: any) => {
      this.successMessage = data;
      this.getLecturerDetailsById();
    }, error => {
      this.errorMessage = error.error;
    });
  }

}
