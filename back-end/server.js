import express from 'express';
import dotenv from 'dotenv';
import { setUpDatabase } from './database.js';


const app = express();
dotenv.config();
const PORT = process.env.PORT || 5000;

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// database connection
setUpDatabase()
    .then(() => {
        console.log('Database setup completed');
    })
    .catch((error) => {
        console.error('Error setting up database:', error);
    });


// Backend routes


app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
}
);
