import {Component, OnInit} from '@angular/core';
import {MDBModalRef} from 'angular-bootstrap-md';
import {Router} from '@angular/router';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnInit {
  constructor(public modalRef: MDBModalRef, private router: Router) { }

  ngOnInit(): void {
  }

  hideDialog(): void {
    this.modalRef.hide();
  }

}
