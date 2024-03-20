const mongoose = require('mongoose');
mongoose.Promise = global.Promise;

const modelSchema = new mongoose.Schema({
    title:String,
    dateCreated:Date,
    description:String,
    time:String,
    creatorName:String,
    status:{type:Boolean, default:true}
});

const modelName = "Video";

if(mongoose.connection && mongoose.connection.models[modelName]){
    module.exports = mongoose.connection.models[modelName];
}else{
    module.exports = mongoose.connection.model(modelName, modelSchema);
}