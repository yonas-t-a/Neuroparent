import express from 'express';
import {
  getUserEvent,
  getUserEventById,
  createUserEvent,
  updateUserEvent,
  deleteUserEvent
} from '../../controller/userEventController.js';

const router = express.Router();
router.route('/')
    .get(getUserEvent)
    .post(createUserEvent);



export default router;