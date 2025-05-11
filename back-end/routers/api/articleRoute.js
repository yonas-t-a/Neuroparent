import express from 'express';
import {
    getArticle,
    getArticleById,
    createArticle,
    updateArticle,
    deleteArticle,
    getArticleByCategory,
    getArticleByCreatorId
} from '../../controller/articleController.js';

import { authenticate, authorizeRoles } from '../../middleware/authMiddleware.js';
import upload from '../../middleware/uploadMiddleware.js';

const router = express.Router();

// Public routes (accessible by all authenticated users)
router.route('/')
    .get(getArticle);

// Admin-only routes
router.route('/')
    .post(upload.single('img'), createArticle);

router.route('/:id')
    .get(getArticleById)
    .put(updateArticle)
    .delete(deleteArticle);

// Public route: filter articles by category
router.route('/category/:category')
    .get(getArticleByCategory);

// get article by creator id
router.route('/creator/:creator_id')
    .get(getArticleByCreatorId);

export default router;
