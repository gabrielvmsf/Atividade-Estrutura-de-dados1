const mongoose = require('mongoose');
mongoose.Promise = global.Promise;

const substationSchema = new mongoose.Schema({
    id:Number,
    name: String,
    description: String,
    location: String,
    capacity: Number,
    voltage: String,
    substationType: String,
    numberOfTransformers: Number,
    transformerPower: Number,
    yearBuilt: Number,
    owner: String,
    lastCheck: Date,
    nextScheduledMaintenance: Date,
    condition: String
});

const modelName = "Substation";

if(mongoose.connection && mongoose.connection.models[modelName]){
    module.exports = mongoose.connection.models[modelName];
}else{
    module.exports = mongoose.connection.model(modelName, substationSchema);
}