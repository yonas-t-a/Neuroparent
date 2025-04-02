import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { EventsModule } from './modules/events/events.module';
import { UsersModule } from './modules/users/users.module';
import { ArticlesModule } from './modules/articles/articles.module';
import { AuthModule } from './modules/auth/auth.module';

@Module({
  imports: [EventsModule, UsersModule, ArticlesModule, AuthModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
