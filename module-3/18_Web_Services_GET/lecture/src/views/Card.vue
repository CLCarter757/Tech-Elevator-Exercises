<template>
  <card-detail :boardID="$route.params.boardID" :cardID="$route.params.cardID"/>
</template>

<script>
import CardDetail from '@/components/CardDetail';

export default {
  components: {
    CardDetail
  }
};
</script>
