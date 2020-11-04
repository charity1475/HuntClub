import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css', "../node_modules/bootstrap/dist/css/bootstrap.css"]
})
export class AppComponent implements OnInit{

  public submitted:boolean;
  roomSearch: FormGroup;
  title: null;
  ngOnInit() {
    this.roomSearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });
  }
  onSubmit({value,valid}:{value:Roomsearch,valid:boolean}){
      console.log(value);
  }
}
export interface Roomsearch{
  checkin:string;
  checkout:string;
}
