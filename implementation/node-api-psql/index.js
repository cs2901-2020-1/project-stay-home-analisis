const express = require('express')
const bodyParser = require('body-parser')
const morgan = require('morgan');
const path = require('path');
const app = express()

//Settings
app.set('port', process.env.PORT || 3000);
app.set('views', path.join(__dirname, 'views'));
app.engine('html', require('ejs').renderFile);
app.set('view engine', 'ejs');

//Middlewares
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended: true,}))
app.use(morgan('dev'));

//Routes
app.use(require('./routes/routes.js'))

//Listening the Server
app.listen(app.get('port'), () => {
  console.log(`App running on port ${app.get('port')}.`)
})
