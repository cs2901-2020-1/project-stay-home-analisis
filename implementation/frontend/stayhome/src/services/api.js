import axios from 'axios';

export default () => {
    return axios.create({
        baseURL: 'http://localhost:9898',
        withCredentials : false
     })
};