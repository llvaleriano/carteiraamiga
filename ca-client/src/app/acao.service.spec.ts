import { TestBed, inject } from '@angular/core/testing';

import { AcaoService } from './acao.service';

describe('AcaoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AcaoService]
    });
  });

  it('should be created', inject([AcaoService], (service: AcaoService) => {
    expect(service).toBeTruthy();
  }));
});
