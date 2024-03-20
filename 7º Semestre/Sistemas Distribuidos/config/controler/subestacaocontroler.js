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
        const newSubstation = new Substation(data);

        try {
            const savedSubstation = await newSubstation.save();
            res.json(savedSubstation);
        } catch (error) {
            res.status(500).json({ error: error.message });
        }
    },

    getSubstation: async (req, res) => {
        const name = req.params.name;

        try {
            const substation = await Substation.find(name);
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
            const allSubstations = await Substation.find();
            res.json(allSubstations);
        } catch (error) {
            res.status(500).json({ error: error.message });
        }
    },

    deleteSubstation: async (req, res) => {
        let name = req.query.name

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

        let name = req.query.name;

        const data = matchedData(req);

        try {
            const updatedSubstation = await Substation.findOneAndUpdate({ name: data.name }, { $set: data });
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