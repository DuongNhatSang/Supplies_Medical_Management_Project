import {Component, OnInit} from '@angular/core';
import {SuppliesService} from '../../service/supplies.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Supplies} from '../../model/supplies';
import {ToastrService} from 'ngx-toastr';
import {DataService} from '../../service/data.service';

@Component({
  selector: 'app-detail-supplies',
  templateUrl: './detail-supplies.component.html',
  styleUrls: ['./detail-supplies.component.css']
})
export class DetailSuppliesComponent implements OnInit {
  constructor(
    private suppliesService: SuppliesService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private data: DataService,
    private toastrService: ToastrService,
  ) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.idSupplies = +paramMap.get('id');
    });
  }
  message: string;
  idSupplies: number;
  supplies: Supplies;
  numberOfSupplies = 0;
  idList: string[] = [];

  ngOnInit(): void {
    this.suppliesService.findById(this.idSupplies).subscribe(value => {
      this.supplies = value;
    });
    window.scrollTo(0, 0);
  }
  newMessage() {
    this.idList = Object.keys(localStorage);
    this.numberOfSupplies = this.idList.length;
    this.data.changeMessage('' + this.numberOfSupplies);
  }

  addToCart() {
    this.toastrService.success('Đã thêm thành công ' + this.supplies.name + ' vào giỏ hàng .', 'Tin nhắn từ hệ thống');
    localStorage.setItem(String(this.idSupplies), String(1));
    this.newMessage();
  }

  moveToDetail(id: number) {
    this.router.navigateByUrl('home/detail/' + id );
  }
}
