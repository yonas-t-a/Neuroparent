import express from 'express';
import {
    getUser, 
    getUserById,
    getUserByEmail, 
    createUser, 
    updateUser, 
    deleteUser
} from '../../controller/userController.js';

import { authenticate, authorizeRoles } from '../../middleware/authMiddleware.js';

const router = express.Router();

router.get('/', getUser);
router.get('/:id', getUserById);
router.get('/:email', getUserByEmail);
router.post('/', createUser);
router.put('/:id', updateUser);
router.delete('/:id', deleteUser);

export default router;
