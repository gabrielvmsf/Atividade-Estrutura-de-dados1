const mongoose = require('mongoose');
mongoose.Promise = global.Promise;

const substationSchema = new mongoose.Schema({
    //O nome da subestação
    name: String,

    //Breve Descrição
    description: String,

    //As coordenadas geográficas ou o endereço onde a subestação está localizada
    location: String,

    //A capacidade nominal da subestação em termos de potência (em megawatts ou megavolt-amperes).
    capacity: Number,

    //A tensão de operação da subestação
    voltage: String,

    //Se é uma subestação de transformação, de distribuição, de manobra, etc.
    substationType: String,

    //O número de transformadores instalados na subestação
    numberOfTransformers: Number,

    //A capacidade de cada transformador instalado (em MVA: Mega Volt-Amperes)
    transformerPower: Number,

    //Lista dos dispositivos de proteção instalados na subestação (como com disjuntores, relés de proteção, etc.)
    protectionEquipment: [String],

    //O ano em que a subestação foi construída ou instalada
    yearBuilt: Number,

    //O nome da empresa ou entidade que é proprietária da subestação
    owner: String,

    //nformações sobre a última manutenção realizada na subestação e os planos de manutenção futuros
    maintenance: {
        lastCheck: Date,
        nextScheduledMaintenance: Date
    },

    //O estado atual da subestação (como em estado operacional, em manutenção, desativada, etc.)
    condition: String,

    //Informações sobre as linhas de transmissão ou distribuição conectadas à subestação
    networkConnections: [String],

    //Coordenadas para criação de cena automatica
    coordinates: {
        x: Number,
        y: Number,
        direction: String
    },

});

const modelName = "Substation";

if(mongoose.connection && mongoose.connection.models[modelName]){
    module.exports = mongoose.connection.models[modelName];
}else{
    module.exports = mongoose.connection.model(modelName, substationSchema);
}