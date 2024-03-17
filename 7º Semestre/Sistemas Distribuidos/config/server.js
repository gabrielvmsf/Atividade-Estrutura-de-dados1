require('dotenv').config({path: 'variables.env' });
const express = require('express');
const mongoose = require ('mongoose');
const cors = require('cors');

const apiRouters = require('./router/routers');

//conexao com bd
mongoose.connect(process.env.DATABASE,{
    useUnifiedTopology:true
});
mongoose.Promise = global.Promise;
mongoose.connection.on('error', (error)=>{
    console.error("Erro e:" + error.message);
});
const server =  express();

server.use(express.json());
server.use(cors());
server.use('/', apiRouters);

server.listen(process.env.PORT, () =>{
    console.log(`servidor rodando na porta: ${process.env.PORT}`);
});