/**
 * This function when invoked will look at an array of reviews
 * and add it to the page by cloning the #review-template
 */
function displayReviews(reviews) {
    console.log("Display Reviews...");
  
    // first check to make sure the browser supports content templates
    if('content' in document.createElement('template')) {
      // query the document for .reviews and assign it to a variable called container
      const container = document.querySelector(".reviews");
      // loop over the reviews array
      reviews.forEach((review) => {
        // get the template; find all the elements and add the data from our review to each element
        const tmpl = document.getElementById('review-template').content.cloneNode(true);
        tmpl.querySelector('img').setAttribute("src",review.avatar);
        tmpl.querySelector('.username').innerText = review.username;
        tmpl.querySelector('h2').innerText = review.title;
        tmpl.querySelector('.published-date').innerText = review.publishedOn;
        tmpl.querySelector('.user-review').innerText = review.review;
        container.appendChild(tmpl);
      });
    } else {
      console.error('Your browser does not support templates');
    }
}

function processResponse(response) {
  console.log('processing response');
  return response.json();  // similar to responseEntity.getBody();
}

function loadReviews() {
  const url = 'http://localhost:8080/reviews';

  fetch(url).then(processResponse).then(displayReviews);

  console.log('do other stuff');
  console.log('do more other stuff');
  console.log('do even more other stuff');
}


/* ---- CODE BELOW HERE ------ */
document.addEventListener('DOMContentLoaded', () => {

  const loadReviewsBtn = document.querySelector('button');

  loadReviewsBtn.addEventListener('click', () => {
    loadReviews();
  });

});