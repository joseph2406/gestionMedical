import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RDV } from 'src/app/model/rdv';
import { ParentToChildService } from 'src/app/service/parent-to-child.service';
import { Comment, comments } from './comments-data';

@Component({
  selector: 'app-recent-comments',
  templateUrl: './recent-comments.component.html',
  styleUrls: ['./recent-comments.component.css']
})
export class RecentCommentsComponent implements OnInit {

  userComments: Comment[];
  passList: ParentToChildService = new ParentToChildService;
  @Input()listRdv: RDV[] = [];
  constructor(passList:ParentToChildService,private activatedroute: ActivatedRoute) {
    this.userComments = comments;
    /* this.activatedroute.queryParams.subscribe(data =>this.listRdv=data) */
   
  }

  ngOnInit(): void {
  }
 /*  ngAfterViewInit() {
    
  } */
}
