const express = require('express');
const router = express.Router();

const textualControler = require('../controler/textualcontroler')
const textualValidator = require('../validator/textualvalidator')

const userValidator = require('../validator/usuariovalidator')
const userControler = require('../controler/usuariocontroler')

const videoValidator = require('../validator/videovalidator')
const videoControler = require('../controler/videocontroler')

const substationValidator = require('../validator/subestacaovalidator');
const substationControler = require('../controler/subestacaocontroler');

router.get('/ping', (req,res) => {
    res.json({retorno: true});
})

//Rotas para textual
router.post('/textual/add', textualValidator.manipulateTextual, textualControler.addTextual);
router.get('/textual/listName', textualControler.getTextual);
router.get('/textual/listAll', textualControler.listAllTextual);
router.delete('/textual/delete',textualControler.deleteTextual);
router.put('/textual/edit', textualValidator.manipulateTextual, textualControler.editTextual);

//Rotas para usuario
router.post('/usuario/add', userValidator.manipulateUsuario, userControler.addUsuario);
router.get('/usuario/listName', userControler.getUsuario);
router.get('/usuario/listAll', userControler.listAllUsuario);
router.delete('/usuario/delete',userControler.deleteUsuario);
router.put('/usuario/edit', userValidator.manipulateUsuario, userControler.editUsuario);

//Rotas para video
router.post('/video/add', videoValidator.manipulateVideo, videoControler.addVideo);
router.get('/video/listName', videoControler.getVideo);
router.get('/video/listAll', videoControler.listAllVideo);
router.delete('/video/delete',videoControler.deleteVideo);
router.put('/video/edit', videoValidator.manipulateVideo, videoControler.editVideo);

// Rotas para subestação
router.post('/substation/add', substationValidator.manipulateSubstation, substationControler.addSubstation);
router.get('/substation/listName', substationControler.getSubstation);
router.get('/substation/listAll', substationControler.listAllSubstations);
router.delete('/substation/delete', substationControler.deleteSubstation);
router.put('/substation/edit', substationValidator.manipulateSubstation, substationControler.updateSubstation);

module.exports = router;