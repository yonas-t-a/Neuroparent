// test/database.connection.spec.ts
import { Test, TestingModule } from '@nestjs/testing';
import { INestApplication } from '@nestjs/common';
import { AppModule } from '../src/app.module';
import { Connection } from 'typeorm';

describe('Database Connection', () => {
  let app: INestApplication;
  let connection: Connection;

  beforeAll(async () => {
    const moduleFixture: TestingModule = await Test.createTestingModule({
      imports: [AppModule],
    }).compile();

    app = moduleFixture.createNestApplication();
    await app.init();

    // Retrieve the TypeORM connection from the DI container
    connection = app.get(Connection);
  });

  afterAll(async () => {
    await connection.close();
    await app.close();
  });

  it('should connect to the database', () => {
    expect(connection.isConnected).toBeTruthy();
  });
});
