const Pool = require('pg').Pool

const pool = new Pool({
    host: 'localhost',
    user: 'postgres',
    password : '1234',
    database : 'StayHome',
    port : '5432'
})

const getUsers = (request, response) => {
    pool.query('SELECT * FROM users ORDER BY id ASC', (error, results) => {
    if (error) {
      throw error
    }
    response.status(200).json(results.rows)
  })
}

const getUserById = (request, response) => {
    const id = parseInt(request.params.id)

  pool.query('SELECT * FROM users WHERE id = $1', [id], (error, results) => {
    if (error) {
      throw error
    }
    response.status(200).json(results.rows)
  })
}

const createUser = async(request, response) => {

    const { email, password } = request.body
    const emails = await pool.query('SELECT email FROM users;');
    for(var i = 0; i < emails.rows.length; i++){
      const actual_email = (emails.rows[i].email);
      if (email == actual_email){
          response.status(404).json(emails.rows[i].email)
          break;
      }
    }
    pool.query('INSERT INTO users (email, password) VALUES ($1, $2)', [email, password], (error, results) => {
    if (error) {
      throw error
    }
    response.status(200).send(`User added with ID: ${results.insertId}`)
    //Como no pasamos un user, esta 'indefinido' pero en la base de datos, se enviara un id.
    //request.body.id//
  })
}

const updateUser = (request, response) => {
    const id = parseInt(request.params.id)
    const { email, password } = request.body

    pool.query(
        'UPDATE users SET email = $1, password = $2 WHERE id = $3',
        [email, password, id],
        (error, results) => {
        if (error) {
            throw error
      }
        response.status(200).send(`User modified with ID: ${id}`)
    }
  )
}

const deleteUser = (request, response) => {
    const id = parseInt(request.params.id)

    pool.query('DELETE FROM users WHERE id = $1', [id], (error, results) => {
        if (error){
            throw error
        }
        response.status(200).send(`User deleted with ID: ${id}`)
    })
}

module.exports = {
  getUsers,
  getUserById,
  createUser,
  updateUser,
  deleteUser,
}
