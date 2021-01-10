import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
@Injectable({
  providedIn: 'root'
})
export class ToasterService {

  constructor(private toastr: ToastrService) {}
  showWarning(message: any) {
    this.toastr.error(message)
  }

  showSuccess( msg: any) {
      this.toastr.success(msg);
  
    }
}
