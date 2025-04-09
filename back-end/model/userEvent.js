
import { pool } from '../database.js';
const userEventModel = {
    async getUserEvent() {
        const [rows] = await pool.query('SELECT * FROM user_event');
        return rows;
    },

    async getUserEventById(id) {
        const [rows] = await pool.query('SELECT * FROM user_event WHERE user_event_id = ?', [id]);
        return rows[0];
    },

};
export default userEventModel;