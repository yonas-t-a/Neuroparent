
import { pool } from '../database.js';

const articleModel = {
    async getArticle() {
        const [rows] = await pool.query('SELECT * FROM article');
        return rows;
    },

    async getArticleById(id) {
        const [rows] = await pool.query('SELECT * FROM article WHERE article_id = ?', [id]);
        return rows[0];
    },

    async createArticle(article) {
        const mappedArticle = {
            article_title: article.title,
            article_content: article.content,
            article_category: article.category,
            article_image: article.img,
            article_creator_id: article.article_creator_id,
        };
        const [result] = await pool.query('INSERT INTO article SET ?',  [mappedArticle]);
        return result;
    },

    async updateArticle(id, article) {
        const [result] = await pool.query('UPDATE article SET ? WHERE article_id = ?', [article, id]);
        return result;
    },
    async deleteArticle(id) {
        const [result] = await pool.query('DELETE FROM article WHERE article_id = ?', [id]);
        return result;
    },
    async getArticleByCategory(category) {
        const [rows] = await pool.query('SELECT * FROM article WHERE article_category = ?', [category]);
        return rows;
    },
    async getArticleByCreatorId(creator_id) {
        const [rows] = await pool.query('SELECT * FROM article WHERE article_creator_id = ?', [creator_id]);
        return rows;
    },
};
export default articleModel;