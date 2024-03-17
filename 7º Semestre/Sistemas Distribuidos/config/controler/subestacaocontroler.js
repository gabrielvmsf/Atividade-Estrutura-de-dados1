const Substation = require('../model/subestacao');
const { validationResult, matchedData } = require('express-validator');

module.exports = {
    addSubstation: async (req, res) => {
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            res.json({
                error: errors.mapped()
            });
            return;
        }

        const data = matchedData(req);
        const newSubstation = new Substation();
        newSubstation.name = data.name;
        newSubstation.description = data.description;
        newSubstation.location = data.location;
        newSubstation.capacity = data.capacity;
        newSubstation.voltage = data.voltage;
        newSubstation.substationType = data.substationType;
        newSubstation.numberOfTransformers = data.numberOfTransformers;
        newSubstation.transformerPower = data.transformerPower;
        newSubstation.yearBuilt = data.yearBuilt;
        newSubstation.owner = data.owner;
        newSubstation.condition = data.condition;
        newSubstation.lastCheck = data.lastCheck;
        newSubstation.nextScheduledMaintenance = data.nextScheduledMaintenance;
        
        try {
            const savedSubstation = await newSubstation.save();
            res.json(savedSubstation);
        } catch (error) {
            res.status(500).json({ error: error.message });
        }
    },

    getSubstation: async (req, res) => {
        const id = req.params.id;

        try {
            const substation = await Substation.find(id);
            if (!substation) {
                res.status(404).json({ error: 'Subestação não encontrada' });
                return;
            }
            res.json(substation);
        } catch (error) {
            res.status(500).json({ error: error.message });
        }
    },

    listAllSubstations: async (req, res) => {
        try {
            const allSubstations = await Substation.find({ name: name });
            res.json(allSubstations);
        } catch (error) {
            res.status(500).json({ error: error.message });
        }
    },

    deleteSubstation: async (req, res) => {
        const id = req.params.id;

        try {
            const deletedSubstation = await Substation.find({ name: name });
            if (!deletedSubstation) {
                res.status(404).json({ error: 'Subestação não encontrada' });
                return;
            }
            res.json({ message: 'Substação deletada' });
        } catch (error) {
            res.status(500).json({ error: error.message });
        }
    },

    updateSubstation: async (req, res) => {
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            res.json({
                error: errors.mapped()
            });
            return;
        }

        const id = req.params.id;
        const data = matchedData(req);

        try {
            const updatedSubstation = await Substation.findAndUpdate({ name: data.name }, { $set: data });
            if (!updatedSubstation) {
                res.status(404).json({ error: 'Subestação não encontrada' });
                return;
            }
            res.json(updatedSubstation);
        } catch (error) {
            res.status(500).json({ error: error.message });
        }
    }
};