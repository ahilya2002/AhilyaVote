import { Component } from '@angular/core';
import { PollComponent } from './poll/poll.component';
import { PollService } from './poll.service';

@Component({
  selector: 'app-root',
  imports: [PollComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  title = 'AhilyaVote';
}
