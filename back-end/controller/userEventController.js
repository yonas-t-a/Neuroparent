

import userEventModel from "../model/userEvent.js";

export async function getUserEvent(req,req){
    try {
        const userEvents = await userEventModel.getUserEvent();
        res.status(200).json(userEvents);
    } catch (error) {
        res.status(500).json({ error: "Error fetching user events" });
    }
}
export async function getUserEventById(req,res){
    const { id } = req.params;
    try {
        const userEvent = await userEventModel.getUserEventById(id);
        if (!userEvent) {
            return res.status(404).json({ message: "User event not found" });
        }
        res.status(200).json(userEvent);
    } catch (error) {
        res.status(500).json({ error: "Error fetching user event" });
    }
}
