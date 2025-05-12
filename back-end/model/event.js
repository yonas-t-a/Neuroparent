// CREATE TABLE IF NOT EXISTS event(
//     event_id INT AUTO_INCREMENT PRIMARY KEY,
//     event_title VARCHAR(255) NOT NULL,
//     event_description TEXT NOT NULL,
//     event_date DATE NOT NULL,
//     event_time TIME NOT NULL,
//     event_location VARCHAR(255) NOT NULL,
//     event_category VARCHAR(100) NOT NULL,
//     creator_id INT,
//     event_status BOOLEAN DEFAULT TRUE,
//     FOREIGN KEY (creator_id) REFERENCES user(user_id)
//         ON DELETE CASCADE
//         ON UPDATE CASCADE
// );
import { pool } from '../database.js';
const eventModel = {
    async getEvent() {
        const [rows] = await pool.query('SELECT * FROM event');
        return rows;
    },

    async getEventById(id) {
        const [rows] = await pool.query('SELECT * FROM event WHERE event_id = ?', [id]);
        return rows[0];
    },

    async createEvent(event) {
        const [result] = await pool.query('INSERT INTO event SET ?', [event]);
        return result;
    },

    async updateEvent(id, event) {
        const [result] = await pool.query('UPDATE event SET ? WHERE event_id = ?', [event, id]);
        return result;
    },
    async deleteEvent(id) {
        const [result] = await pool.query('DELETE FROM event WHERE event_id = ?', [id]);
        return result;
    },
    async getEventByCategory(category) {
        const [rows] = await pool.query('SELECT * FROM event WHERE event_category = ?', [category]);
        return rows;
    },
    async getEventByDate(date) {
        const [rows] = await pool.query('SELECT * FROM event WHERE event_date = ?', [date]);
        return rows;
    },
    async getEventByLocation(location) {
        const [rows] = await pool.query('SELECT * FROM event WHERE event_location = ?', [location]);
        return rows;
    },
    async getEventByCreatorId(creator_id) {
        const [rows] = await pool.query('SELECT * FROM event WHERE creator_id = ?', [creator_id]);
        return rows;
    },
    // search event by name
    async searchEventByName(name) {
        const [rows] = await pool.query('SELECT * FROM event WHERE event_title LIKE ?', [`%${name}%`]);
        return rows;
    },
};
export default eventModel;