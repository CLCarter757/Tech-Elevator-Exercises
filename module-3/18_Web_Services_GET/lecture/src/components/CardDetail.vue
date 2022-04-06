<template>
  <div>
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>

    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <comments-list v-bind:comments="card.comments" v-else />

    <div class="board-actions" v-if="!isLoading">
      <router-link
        v-bind:to="{ name: 'Board', params: { id: boardID } }"
        >Back to Board</router-link
      >
    </div>
  </div>
</template>

<script>
import boardService from '@/services/BoardService.js';
import CommentsList from '@/components/CommentsList.vue';

export default {
  name: "card-detail",

  components: {
    CommentsList
  },

  props: ['boardID', 'cardID'],

  data() {
    return {
      isLoading: true,
      card: {}
    }
  },

  created() {
    boardService.getCard(this.boardID, this.cardID).then(theCard => {
      this.card = theCard;
      this.isLoading = false;
    });
  }
};
</script>
