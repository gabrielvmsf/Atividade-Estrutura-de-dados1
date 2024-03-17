const {checkSchema} = require ("express-validator")

module.exports = {
    manipulateUsuario: checkSchema({
        name:{
            trim: true,
            isLength:{
                options: {min:2}
            },
            errorMessage: 'Nome precisa de pelo menos 2 caracteres'
        },
        phone: {
            isLength: {
                options: { min: 11 }
            },
            errorMessage: 'O numero precisa ter 11 caracteres'
        },
        email: {
            isEmail: true,
            errorMessage: 'Email inválido'
        },
        age: {
            isInt: {
                options: { min: 18 },
            },
            errorMessage: 'A idade precisa ser um número inteiro maior ou igual a 18'
        }
    })
}