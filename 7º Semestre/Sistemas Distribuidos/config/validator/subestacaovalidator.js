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
        description: {
            trim: true,
            isLength: {
                options: { min: 2 }
            },
            errorMessage: 'A descrição precisa ter pelo menos 2 caracteres'
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
        },
        networkConnections: {
            isArray: true,
            custom: {
                options: (value) => value.length > 0,
                errorMessage: 'Deve haver pelo menos uma conexão de rede'
            }
        },
        protectionEquipment: {
            isArray: true,
            custom: {
                options: (value) => value.length > 0,
                errorMessage: 'Deve haver pelo menos um equipamento de proteção'
            }
        },
        maintenance: {
            exists: {
                errorMessage: 'Os dados de manutenção são obrigatórios'
            },
            custom: {
                options: (value) => 'lastCheck' in value && 'nextScheduledMaintenance' in value,
                errorMessage: 'Os campos lastCheck e nextScheduledMaintenance são obrigatórios em manutenção'
            },
        },
        coordinates: {
            custom: {
                options: (value, { req, location, path }) => {
                    // Permite que as coordenadas sejam nulas
                    if (value === null) {
                        return true;
                    }
        
                    // Se não for nulo, verifica a existência e validade das coordenadas
                    const hasCoordinates = 'x' in value && 'y' in value && 'direction' in value;
                    if (!hasCoordinates) {
                        throw new Error('As coordenadas x, y e a direção são obrigatórias quando coordinates é fornecido');
                    }
        
                    if (typeof value.x !== 'number' || typeof value.y !== 'number' || typeof value.direction !== 'string') {
                        throw new Error('As coordenadas x e y devem ser números e a direção deve ser uma string');
                    }
        
                    return true;
                },
                errorMessage: 'As coordenadas fornecidas são inválidas',
            },
            optional: { options: { nullable: true } },
        },
    })
};