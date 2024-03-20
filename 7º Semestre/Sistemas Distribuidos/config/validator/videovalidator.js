const { checkSchema } = require("express-validator")

module.exports = {
    manipulateVideo: checkSchema({
        title:{
            trim: true,
            isLength:{
                options: {min:5}
            },
            errorMessage: 'title precisa de pelo menos 5 caracteres'
        },
        time: {
            isLength: {
                options: {min: 5}
            },
            errorMessage: 'precisa ter no minimo 5 caracteres (exemplo: "01:01")'
        },
        creatorName: {
            trim: true,
            isLength:{
                options: {min:5}
            },
            errorMessage: 'nome precisa de pelo menos 5 caracteres'
        },
        
    })
};