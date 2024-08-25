import { Component, inject, OnInit } from '@angular/core';
import { CardComponent } from './card/card.component';
import { CharacterService } from '@api/character.service';

@Component({
  selector: 'app-character',
  standalone: true,
  imports: [CardComponent],
  templateUrl: './character.component.html',
})
export default class CharacterComponent implements OnInit {
  private readonly characterSvc = inject(CharacterService);
  characters = this.characterSvc.characters;

  currentPage = 1;
  totalPages = 42;

  ngOnInit(): void {
    this.loadCharacters(this.currentPage);
  }

  loadCharacters(page: number): void {
    this.currentPage = page;
    this.characterSvc.getCharacters(page);
  }

  nextPage(): void {
    if (this.currentPage < this.totalPages) {
      this.loadCharacters(this.currentPage + 1);
    }
  }

  previousPage(): void {
    if (this.currentPage > 1) {
      this.loadCharacters(this.currentPage - 1);
    }
  }
  downloadExcel(): void {
    this.characterSvc.downloadExcel(this.currentPage).subscribe((blob) => {
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement('a');
      a.href = url;
      a.download = 'characters.xlsx';
      a.click();
      window.URL.revokeObjectURL(url);
    });
  }
}
