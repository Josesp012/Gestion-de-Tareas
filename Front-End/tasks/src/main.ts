import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { ListComponent } from './app/components/list/list.component';

bootstrapApplication(ListComponent, appConfig)
  .catch((err) => console.error(err));
