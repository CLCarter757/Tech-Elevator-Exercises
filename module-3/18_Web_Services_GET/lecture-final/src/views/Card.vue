<template>
  <card-detail :boardId="$route.params.boardID" :cardId="$route.params.cardID" />
</template>

<script>
import CardDetail from '@/components/CardDetail';

export default {
  components: {
    CardDetail
  }
};
</script>
