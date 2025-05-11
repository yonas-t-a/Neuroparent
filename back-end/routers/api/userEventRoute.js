import express from 'express';
import {
  getUserEvent,
  getUserEventById,
  createUserEvent,
  updateUserEvent,
  deleteUserEvent
} from '../../controller/userEventController.js';

import { authenticate } from '../../middleware/authMiddleware.js';

const router = express.Router();

// All routes are protected — only logged-in users can use them
router.route('/')
    .get(getUserEvent) 
    .post(createUserEvent);

router.route('/:id')
    .get(getUserEventById) 
    .put(updateUserEvent) 
    .delete(deleteUserEvent);
// get user event by user id
router.route('/user/:user_id')
    .get(getUserEventByUserId);

export default router;
