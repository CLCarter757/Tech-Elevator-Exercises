import Vue from 'vue'
import VueRouter from 'vue-router'

import Products from '../views/Products.vue';
import ProductDetails from '../views/ProductDetails.vue';
import AddReview from '../views/AddReview.vue';

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: Products,
    name: 'products'
  },

  {
    path: '/products/:id',
    component: ProductDetails,
    name: 'product-details'
  },

  {
    path: '/products/:id/add',
    component: AddReview,
    name: 'add-review'
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
