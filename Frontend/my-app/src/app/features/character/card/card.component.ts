import { Component, input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Character } from '@shared/models/character.interface';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './card.component.html',
})
export class CardComponent {
  character = input.required<Character>();
}
