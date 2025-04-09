import express from 'express';
import {
  getUserEvent,
  getUserEventById,
  createUserEvent,
  updateUserEvent,
  deleteUserEvent
} from '../../controller/userEventController.js';

const router = express.Router();


export default router;