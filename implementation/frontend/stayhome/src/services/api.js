import axios from 'axios';

export default () => {
    return axios.create({
        baseURL: 'https://stayhome-backend.herokuapp.com',
        withCredentials : false
     })
};