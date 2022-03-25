
function saveReview() {
  const url = 'http://localhost:8080/reviews';

  const theData = {
    username: document.getElementById('username').value,
    title: document.getElementById('title').value,
    review: document.getElementById('review').value
  };

  const options = {
    method: 'POST',
    body: JSON.stringify(theData),
    headers: {
      'Content-Type': 'application/json'
    }
  };

  fetch(url, options)
    .then(response => {
      return response.json();
    })
    .then(json => {
      console.log(json);
    })
    .catch(err => {
      console.log(err);
    });
}

document.addEventListener('DOMContentLoaded', () => {

  const form = document.querySelector('form');
  form.addEventListener('submit', (e) => {
    e.preventDefault();
    saveReview();
  });

});