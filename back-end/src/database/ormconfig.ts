// src/database/ormconfig.ts
import { TypeOrmModuleOptions } from '@nestjs/typeorm';
import * as dotenv from 'dotenv';

dotenv.config();

const config: TypeOrmModuleOptions = {
    type: 'mysql',
    host: process.env.MySQL_HOST || 'localhost',
    port:  3306,
    username: process.env.MySQL_USER, 
    password: process.env.MySQL_PASSWORD, 
    database: process.env.MySQL_DATABASE,
    entities: [__dirname + '/../**/*.entity{.ts,.js}'],
    synchronize: true, // Set to false in production!
  };

export default config;
