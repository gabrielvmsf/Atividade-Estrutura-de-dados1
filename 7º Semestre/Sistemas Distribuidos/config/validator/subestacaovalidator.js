const { checkSchema } = require("express-validator");

module.exports = {
    manipulateSubstation: checkSchema({
        name: {
            trim: true,
            isLength: {
                options: { min: 2 }
            },
            errorMessage: 'O nome precisa ter pelo menos 2 caracteres'
        },
        location: {
            trim: true,
            isLength: {
                options: { min: 5 }
            },
            errorMessage: 'A localização precisa ter pelo menos 5 caracteres'
        },
        capacity: {
            isInt: {
                options: { min: 1 }
            },
            errorMessage: 'A capacidade deve ser um número inteiro positivo'
        },
        voltage: {
            trim: true,
            isLength: {
                options: { min: 3 }
            },
            errorMessage: 'A tensão precisa ter pelo menos 3 caracteres'
        },
        substationType: {
            trim: true,
            isLength: {
                options: { min: 3 }
            },
            errorMessage: 'O tipo de subestação precisa ter pelo menos 3 caracteres'
        },
        yearBuilt: {
            isInt: true,
            errorMessage: 'O ano de construção deve ser um número inteiro'
        },
        owner: {
            trim: true,
            isLength: {
                options: { min: 2 }
            },
            errorMessage: 'O proprietário precisa ter pelo menos 2 caracteres'
        },
        condition: {
            trim: true,
            isLength: {
                options: { min: 3 }
            },
            errorMessage: 'A condição precisa ter pelo menos 3 caracteres'
        }
    })
};