const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  //find element that will have book title
  const titleSpan = document.querySelector('#page-title > .name');
  //set title as element's test
  titleSpan.innerText = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  const descriptionField = document.querySelector('.description');
  descriptionField.innerText = description;
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {
  const mainElement = document.getElementById('main');

  reviews.forEach(review => {
    const reviewContainer = document.createElement("div");
    reviewContainer.classList.add('review');

    addReviewer(reviewContainer, review.reviewer);
    addRating(reviewContainer, review.rating);
    addTitle(reviewContainer, review.title);
    addReview(reviewContainer, review.review);
    //mainElement.insertAdjacentElement('beforeend', reviewContainer);
    mainElement.appendChild(reviewContainer);

    
  })

}

/**
 * I will create a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  const nameElement = document.createElement('h4');
  nameElement.innerText = name;

  parent.appendChild(nameElement);
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  const starImageContainer = document.createElement('div');
  starImageContainer.classList.add('rating');

  for(let i = 1; i <= numberOfStars; i++) {
    const starImage = document.createElement('img');
    starImage.src = 'img/star.png';
    starImage.classList.add('ratingStar');

    starImageContainer.appendChild(starImage);
  }

  parent.appendChild(starImageContainer);
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  const titleElement = document.createElement('h3');
  titleElement.innerText = title;
  parent.appendChild(titleElement);
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const reviewElement = document.createElement('p');
  reviewElement.innerText = review;
  parent.appendChild(reviewElement);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
