import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {


  getBoards() {
    return http.get('/boards'); // GET http://localhost:3000/boards
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`); // GET http://localhost:3000/boards/39928
  },

  getCard(boardID, cardID) {
    return http.get(`/boards/${boardID}`).then((response) => {
      const cards = response.data.cards;
      return cards.find(card => card.id == cardID);
    });
  }

}
