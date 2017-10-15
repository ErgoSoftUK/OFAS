import {Component, OnInit} from '@angular/core';
import {RadioService} from './radio.service';
import {Radio} from './models/Radio';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/timer';
import {DomSanitizer, SafeResourceUrl} from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  radio: Radio = {} as Radio;
  private waiting: boolean = false;
  private skin: string;
  private skinUrl: SafeResourceUrl;

  constructor(private sanitizer: DomSanitizer, private radioService: RadioService) {
    this.loadSkin('b737');
  }

  ngOnInit(): void {
    const timer = Observable.timer(0, 1000);
    timer.subscribe(t => this.refresh());
  }

  private loadSkin(skin: string) {
    this.skin = skin;
    this.skinUrl = this.sanitizer.bypassSecurityTrustResourceUrl('/skins/'+this.skin+'/panel.css');
  }

  private refresh() {
    if (this.waiting)
      return;

    this.waiting = true;
    const vm = this;
    vm.radioService.getRadio()
      .subscribe(
        (result) => {
          vm.update(result);
          vm.waiting = false;
        },
        (error) => {
          console.error(error);
          vm.waiting = false;
        }
      );
  }

  private update(data : Radio) {
    if (data.skin != this.skin)
      this.loadSkin(data.skin);

    this.radio = data;
  }

  private log(value: any) {
    this.radio.adf.freqAsString = ("0" + value + "0").slice(-4);
  }
}
