const Textual = require('../model/textual');
const { validationResult, matchedData } = require('express-validator');

module.exports = {
    addTextual: async (req, res) => {
        const erros = validationResult(req);
        if (!erros.isEmpty()) {
            res.json({
                error: erros.mapped()
            });
            return;
        }
        const data = matchedData(req);
        const newTextual = new Textual();
        newTextual.name = data.name;
        newTextual.dataCreated = Date.now();
        newTextual.title = data.title;
        newTextual.text = data.text;
        newTextual.fontSize = data.fontSize;

        const info = await newTextual.save();
        res.json({ info });
    },

    getTextual: async (req, res) => {
        let name = req.query.name;

        const nameTextual = await Textual.findOne({ name: name });

        if (nameTextual == null) {
            res.json({
                res: "Não encontrei!"
            });
            return;
        }

        res.json({ nameTextual });
    },

    listAllTextual: async (req, res) => {
        const todosTextual = await Textual.find();

        if (todosTextual == null) {
            res.json({
                res: "Não encontrado!"
            });
            return;
        }

        res.json({ todosTextual });
    },

    deleteTextual: async (req, res) => {
        let name = req.query.name;

        const deleteTextual = await Textual.findOneAndDelete({ name: name });

        if (!deleteTextual) {
            res.json({
                res: "Não encontrei!"
            });
            return;
        }

        res.json({
            res: "Deletado!"
        });
    },

    editTextual: async (req, res) => {
        const erros = validationResult(req);

        if (!erros.isEmpty) {
            if (!erros.isEmpty()) {
                error: erros.mapped()
            }
            return;
        }

        const data = matchedData(req);

        if (!data) {
            res.json({
                res: "Não encontrei!"
            });
            return;
        }

        const info = await Textual.findOneAndUpdate({ name: data.name }, { $set: data });
        res.json({ info });
    }
}