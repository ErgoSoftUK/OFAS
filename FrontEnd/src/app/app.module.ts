import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ToolTipModule} from 'angular2-tooltip';

import { AppComponent } from './app.component';
import {RadioService} from './radio.service';
import {HttpModule} from '@angular/http';
import {KnobModule} from 'ng2-knob';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    ToolTipModule,
    KnobModule
  ],
  declarations: [
    AppComponent
  ],
  providers: [
    RadioService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
