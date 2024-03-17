const Usuario = require ('../model/usuario');
const {validationResult, matchedData} = require ('express-validator');

module.exports = {
    addUsuario: async(req, res) =>{
        const erros = validationResult(req);
        if(!erros.isEmpty()){
            res.json({
                error: erros.mapped()
            });
            return;
        }
        const data = matchedData(req);
        const newUsuario = new Usuario();
        newUsuario.nome = data.nome;
        newUsuario.dataCreated = Date.now();
        newUsuario.age = data.age;
        newUsuario.nome = data.nome;
        newUsuario.phone = data.phone;

        const info = await newUsuario.save();
        res.json({info});

    },

    getUsuario: async (req, res) => {
        let nome = req.query.nome;

        const nomeUsuario = await Usuario.findOne({ nome : nome });

        if (nomeUsuario == null) {
            res.json({
                res: "Não encontrei!"
            });
            return;
        }

        res.json({ nomeUsuario });
    },

    listAllUsuario: async (req, res) => {
        const todosUsuario = await Usuario.find();

        if (todosUsuario == null) {
            res.json({
                res: "Não encontrado!"
            });
            return;
        }

        res.json({ todosUsuario });
    },

    deleteUsuario: async (req, res) => {
        let nome = req.query.nome;

        const deleteUsuario = await Usuario.findOneAndDelete({ nome: nome });

        if (!deleteUsuario) {
            res.json({
                res: "Não encontrei!"
            });
            return;
        }

        res.json({
            res: "Deletado!"
        });
    },

    editUsuario: async (req, res) => {
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

        const info = await Usuario.findOneAndUpdate({ nome: data.nome }, { $set: data });
        res.json({ info });
    }
}