import { Component, OnInit } from '@angular/core';
import { RestaurantService } from '../restaurant.service';
import { Restaurant } from '../restaurant';
import { RestaurantProfile } from '../restaurant-profile';

@Component({
  selector: 'app-profile-editable',
  templateUrl: './profile-editable.component.html',
  styleUrls: ['./profile-editable.component.css']
})
export class ProfileEditableComponent implements OnInit {
  public username;
  public restaurant;
  public restaurantProfile;
  public role : string;
  public selectedFile: File
  public editable;
  constructor(private service:RestaurantService) { }

  ngOnInit() {

    this.editable="false";

    this.username = sessionStorage.getItem('username');
    this.role = sessionStorage.getItem('role');


    this.service.getRestaurantProfile(this.username).subscribe(data =>{
      this.restaurant = data;
      console.log(this.restaurant);
      });

  }
  public edit(){
    if(this.editable=='false')
      this.editable="true";
    else
      this.editable="false";

  }

  public update(name, email,mobile,address,location, username, certificateNo, certificateName){

    if(this.restaurant.role == 'restaurant'){
      this.restaurantProfile = new RestaurantProfile(username, email, this.restaurant.role, name,  mobile, address, location, certificateNo, certificateName);
      console.log(this.restaurantProfile);
      this.service.updateRestaurantProfile(this.restaurantProfile).subscribe(data =>{
        console.log(data);
        // sessionStorage.setItem('token',data.token);
        sessionStorage.setItem('username',data.username);
        sessionStorage.setItem('role',data.role);
        this.ngOnInit();
        // this.data.changeMessage(true);
        // this.route.navigateByUrl("/DashboardComponent");
        });
    }
    if(this.editable=='false')
      this.editable="true";
    else
      this.editable="false";
    
    
  }
  // onFileChanged(event){
  //   this.selectedFile=event.target.files[0]
  // }
  // onUpload(){
    //saving file to db 
  // }

}
