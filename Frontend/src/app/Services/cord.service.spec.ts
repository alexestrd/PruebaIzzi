import { TestBed } from '@angular/core/testing';

import { CordService } from './cord.service';

describe('CordService', () => {
  let service: CordService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CordService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
