
import { pool } from '../database.js';
const userEventModel = {
    async getUserEvent() {
        const [rows] = await pool.query('SELECT * FROM user_event');
        return rows;
    },
};
export default userEventModel;