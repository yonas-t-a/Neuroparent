

import userEventModel from "../model/userEvent.js";

export async function getUserEvent(req,req){
    try {
        const userEvents = await userEventModel.getUserEvent();
        res.status(200).json(userEvents);
    } catch (error) {
        res.status(500).json({ error: "Error fetching user events" });
    }
}
