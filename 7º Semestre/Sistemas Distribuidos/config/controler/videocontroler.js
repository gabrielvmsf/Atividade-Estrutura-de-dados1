const Video = require('../model/video');
const { validationResult, matchedData } = require('express-validator');

module.exports = {
    addVideo: async (req, res) => {
        const erros = validationResult(req);
        if (!erros.isEmpty()) {
            res.json({
                error: erros.mapped()
            });
            return;
        }
        const data = matchedData(req);
        const newVideo = new Video();
        newVideo.title = data.tititletle;
        newVideo.dataCreated = Date.now();
        newVideo.description = data.description;
        newVideo.creatorName = data.creatorName;

        const info = await newVideo.save();
        res.json({ info });
    },

    getVideo: async (req, res) => {
        let title = req.query.title;

        const titleVideo = await Video.findOne({ title: title });

        if (titleVideo == null) {
            res.json({
                res: "Não encontrei!"
            });
            return;
        }

        res.json({ titleVideo });
    },

    listAllVideo: async (req, res) => {
        const todosVideo = await Video.find();

        if (todosVideo == null) {
            res.json({
                res: "Não encontrado!"
            });
            return;
        }
    },

    deleteVideo: async (req, res) => {
        let title = req.query.title;

        const deleteVideo = await Video.findOneAndDelete({ title: title });

        if (!deleteVideo) {
            res.json({
                res: "Não encontrei!"
            });
            return;
        }

        res.json({
            res: "Deletado!"
        });

        res.json({ titleVideo });
    },

    editVideo: async (req, res) => {
        const erros = validadorResult(req);

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

        const info = await Video.findOneAndUpdate({ title: data.title }, { $set: data });
        res.json({ info });
    }
}