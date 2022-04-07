import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  list() {
    return http.get('/topics');
  },

  get(id) {
    return http.get(`/topics/${id}`);
  },

  addTopic(topic) {
    return http.post('/topics', topic);
  },

  editTopic(topicID, topic) {
    return http.put(`/topics/${topicID}`, topic);
  },

  removeTopic(topicID) {
    return http.delete(`/topics/${topicID}`);
  },

}
