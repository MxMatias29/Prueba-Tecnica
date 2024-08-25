import { NgOptimizedImage } from '@angular/common';
import { Component, inject, input, OnInit, Signal } from '@angular/core';
import { CharacterService } from '@api/character.service';
import { Character } from '@shared/models/character.interface';

@Component({
  selector: 'app-detail',
  standalone: true,
  imports: [NgOptimizedImage],
  templateUrl: './detail.component.html',
})
export default class DetailComponent implements OnInit {
  characterId = input<number>(0, { alias: 'id' });

  character!: Signal<Character | undefined>;

  private readonly characterSvc = inject(CharacterService);

  ngOnInit(): void {
    this.character = this.characterSvc.getCharacterById(this.characterId());
  }
}
