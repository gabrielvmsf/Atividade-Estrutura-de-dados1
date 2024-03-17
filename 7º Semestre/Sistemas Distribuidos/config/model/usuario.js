const mongoose = require ('mongoose')
mongoose.Promise = global.Promise;

const modelSchema = new mongoose.Schema({
    name: String,
    phone: String,
    email: String,
    age: Number,
    dateCreated: Date
});

const modelName = 'Usuario';

if(mongoose.connection && mongoose.connection.models[modelName]){
    module.exports = mongoose.connection.models[modelName];
}else{
    module.exports = mongoose.connection.model(modelName, modelSchema);
}