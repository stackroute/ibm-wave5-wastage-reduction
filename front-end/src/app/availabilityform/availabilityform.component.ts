import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-availabilityform',
  templateUrl: './availabilityform.component.html',
  styleUrls: ['./availabilityform.component.css']
})
export class AvailabilityformComponent implements OnInit {

  public veg="";
  public nonveg="";

  constructor() { }
  
  ngOnInit() {
  }

}
