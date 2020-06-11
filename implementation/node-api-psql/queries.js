const Pool = require('pg').Pool
const pool = new Pool({
    user: 'l4mb0',
    host: 'localhost',
    database: 'stayhome',
    password: 'password',
    port: 5432,
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

const createUser = (request, response) => {
    const { email, password } = request.body

    pool.query('INSERT INTO users (email, password) VALUES ($1, $2)', [email, password], (error, results) => {
    if (error) {
      throw error
    }
    response.status(201).send(`User added with ID: ${result.insertId}`)
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

