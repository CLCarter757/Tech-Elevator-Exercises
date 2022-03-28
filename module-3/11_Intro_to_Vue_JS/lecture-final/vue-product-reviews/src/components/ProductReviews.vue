<template>
  <main class="main">
        <h2>Product Reviews for {{ title }}</h2>
        <p class="description">{{ description }}</p>

        <div class="well-display">
            <div class="well">
                <span class="amount">{{ averageRating }}</span>
                Average Rating
            </div>
            <div class="well">
                <span class="amount">{{ numberOf1StarReviews }}</span>
                1 Star Reviews
            </div>
            <div class="well">
                <span class="amount">{{ numberOf2StarReviews }}</span>
                2 Star Reviews
            </div>
            <div class="well">
                <span class="amount">{{ numberOf3StarReviews }}</span>
                3 Star Reviews
            </div>
            <div class="well">
                <span class="amount">{{ numberOf4StarReviews }}</span>
                4 Star Reviews
            </div>
            <div class="well">
                <span class="amount">{{ numberOf5StarReviews }}</span>
                5 Star Reviews
            </div>
        </div>

        <section class="review" v-for="xyz in reviews" v-bind:key="xyz.id" v-bind:class="{ favorited: xyz.favorited }">
            <h4>{{ xyz.reviewer }}</h4>
            <div class="rating">
                <img src="../assets/star.png" alt="star" v-for="i in xyz.rating" v-bind:key="i">
            </div>
            <h3>{{ xyz.title }}</h3>
            <p>{{ xyz.review }}</p>
            <p>
                Favorited? <input type="checkbox" v-model="xyz.favorited">
            </p>
        </section>
  </main>
</template>

<script>
export default {
    data() {
        return {
            title: 'Cigar Parties for Dummies',
            description: 'Host and plan the perfect cigar party for all of your squirelly friends',
            reviews: [
                {
                    id: 1,
                    reviewer: 'Malcolm Gladwell',
                    title: 'What a book!',
                    rating: 3,
                    review: 'It is a fantastic book, in some language.',
                    favorited: false
                },
                {
                    id: 2,
                    reviewer: "Tim Ferriss",
                    title: "Had a cigar party started in less than 4 hours.",
                    review:
                        "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
                    rating: 4,
                    favorited: false
                },
                {
                    id: 3,
                    reviewer: "Ramit Sethi",
                    title: "What every new entrepreneurs needs. A door stop.",
                    review:
                        "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
                    rating: 1,
                    favorited: false
                },
                {
                    id: 4,
                    reviewer: "Gary Vaynerchuk",
                    title: "And I thought I could write",
                    review:
                        "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
                    rating: 3,
                    favorited: false
                }
            ]
        }
    },

    computed: {
        averageRating() {
            const sum = this.reviews.reduce((sum, review) => {
                return sum + review.rating
            }, 0);

            return sum / this.reviews.length;
        },

        numberOf1StarReviews() {
            return this.reviews.reduce((currentCount, review) => {
                if(review.rating === 1) {
                    return currentCount + 1;
                }  else {
                    return currentCount;
                }
            }, 0);
        },

        numberOf2StarReviews() {
            return this.reviews.reduce((currentCount, review) => {
                if(review.rating === 2) {
                    return currentCount + 1;
                }  else {
                    return currentCount;
                }
            }, 0);
        },

        numberOf3StarReviews() {
            return this.reviews.reduce((currentCount, review) => {
                if(review.rating === 3) {
                    return currentCount + 1;
                }  else {
                    return currentCount;
                }
            }, 0);
        },

        numberOf4StarReviews() {
            return this.reviews.reduce((currentCount, review) => {
                if(review.rating === 4) {
                    return currentCount + 1;
                }  else {
                    return currentCount;
                }
            }, 0);
        },

        numberOf5StarReviews() {
            return this.reviews.reduce((currentCount, review) => {
                if(review.rating === 5) {
                    return currentCount + 1;
                }  else {
                    return currentCount;
                }
            }, 0);
        },
    }
}
</script>

<style scoped>
    .main {
        margin: 1rem 0;
    }

    .main div.well-display {
    display: flex;
    justify-content: space-around;
}

.main div.well-display div.well {
    display: inline-block;
    width: 15%;
    border: 1px black solid;
    border-radius: 6px;
    text-align: center;
    margin: 0.25rem;
}

.main div.well-display div.well span.amount {
    color: darkslategray;
    display: block;
    font-size: 2.5rem;
}

.main section.review {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
}

.main section.review div.rating {
    height: 2rem;
    display: inline-block;
    vertical-align: top;
    margin: 0 0.5rem;
}

.main section.review div.rating img {
    height: 100%;
}

.main section.review p {
    margin: 20px;
}

.main section.review h3 {
    display: inline-block;
}

.main section.review h4 {
    font-size: 1rem;
}

.main .review.favorited {
    background-color: lightyellow;
}

</style>