import eventModel from "../model/event.js";

// Controller function to fetch all events
export async function getEvent(req, res) {
    try {
        const events = await eventModel.getEvent();
        res.status(200).json(events);
    } catch (error) {
        res.status(500).json({ error: "Error fetching events" });
    }
}



// Fetch a single event by its ID.
// Returns 404 if the event is not found, or 500 on server error.

export async function getEventById(req, res) {
    const { id } = req.params;
    try {
        const event = await eventModel.getEventById(id);
        if (!event) {
            return res.status(404).json({ error: "Event not found" });
        }
        res.status(200).json(event);
    } catch (error) {
        res.status(500).json({ error: "Error fetching event" });
    }
}



// Handles the creation of a new event.
// Validates that all required fields (title, description, date, time, location, category) are provided.
export async function createEvent(req, res) {
    // Validate the request body
    const { title, description, date, time, location, category } = req.body;
    if ([title, description, date, time, location, category].some(field => !field?.trim())) {
        return res.status(400).json({ error: "All fields are required" });
    }    
    try {
        const newEvent = await eventModel.createEvent(req.body);
        res.status(201).json(newEvent);
    } catch (error) {
        console.error(error);
        res.status(500).json({ error: "Error creating event" })

    }
}



// Updates an existing event by ID.
// Validates that all required fields (title, description, date, time, location, category) are present in the request body.
export async function updateEvent(req, res) {
    // Validate the request body
    const { id } = req.params;
    const { title, description, date, time, location, category } = req.body;
    if (!title || !description || !date || !time || !location || !category) {
        return res.status(400).json({ error: "All fields are required" });
    }
    try {
        const { title, description, date, time, location, category } = req.body;
        const updatedEvent = await eventModel.updateEvent(id, { title, description, date, time, location, category });

        if (updatedEvent.affectedRows === 0) {
            return res.status(404).json({ error: "Event not found" });
        }
        res.status(200).json(updatedEvent);
    } catch (error) {
        res.status(500).json({ error: "Error updating event" });
    }
}






//  Deletes an existing event by ID.
//  Retrieves the event ID from the request parameters and attempts to delete it using the eventModel.
export async function deleteEvent(req, res) {
    const { id } = req.params;
    try {
        const deletedEvent = await eventModel.deleteEvent(id);
        if (deletedEvent.affectedRows === 0) {
            return res.status(404).json({ error: "Event not found" });
        }
        res.status(200).json({ message: "Event deleted successfully" });
    } catch (error) {
        res.status(500).json({ error: "Error deleting event" });
    }
}







// Retrieve all events matching a given category.
// Returns 404 if no events are found, or 500 on server error.

export async function getEventByCategory(req, res) {
    const { category } = req.params;
    try {
        const events = await eventModel.getEventByCategory(category);
        if (events.length === 0) {
            return res.status(404).json({ error: "No events found for this category" });
        }
        res.status(200).json(events);
    } catch (error) {
        res.status(500).json({ error: "Error fetching events by category" });
    }
}







/**
 * Retrieves events for a specific date.
 * Extracts the date from the request parameters and fetches the events from the eventModel.
 * If no events are found for the specified date, returns a 404 status with an error message.
 * On success, returns a 200 status with the list of events for the given date.
 * Handles any internal errors by returning a 500 status.
 **/

export async function getEventByDate(req, res) {
    const { date } = req.params;
    try {
        const events = await eventModel.getEventByDate(date);
        if (events.length === 0) {
            return res.status(404).json({ error: "No events found for this date" });
        }
        res.status(200).json(events);
    } catch (error) {
        res.status(500).json({ error: "Error fetching events by date" });
    }
}








/**
 * Retrieves events for a specific location.
 * Extracts the location from the request parameters and fetches the events from the eventModel.
 * If no events are found for the specified location, returns a 404 status with an error message.
 * On success, returns a 200 status with the list of events for the given location.
 * Handles any internal errors by returning a 500 status.
 */

export async function getEventByLocation(req, res) {
    const { location } = req.params;
    try {
        const events = await eventModel.getEventByLocation(location);
        if (events.length === 0) {
            return res.status(404).json({ error: "No events found for this location" });
        }
        res.status(200).json(events);
    } catch (error) {
        res.status(500).json({ error: "Error fetching events by location" });
    }
}