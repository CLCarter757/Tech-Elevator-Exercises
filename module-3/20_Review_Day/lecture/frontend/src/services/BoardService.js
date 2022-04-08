import axios from 'axios';


export default {

  getBoards() {
    return axios.get('/boards');
  },

  addBoard(board) {
    return axios.post('/boards', board);
  },

  deleteBoard(boardID) {
    return axios.delete(`/boards/${boardID}`); // DELETE http://localhost:3000/boards/95410
  },

  getCards(boardID) {
    return axios.get(`/boards/${boardID}`)
  },

  getCard(cardID) {
    return axios.get(`/cards/${cardID}`)
  },

  addCard(card) {
    return axios.post('/cards', card);
  },

  updateCard(card) {
    return axios.put(`/cards/${card.id}`, card);
  },

  deleteCard(cardID) {
    return axios.delete(`/cards/${cardID}`);
  }

}
