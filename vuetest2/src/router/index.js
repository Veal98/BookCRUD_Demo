import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "../views/Index";
import BookManager from "../views/BookManager";
import AddBook from "../views/AddBook";
import BookUpdate from "../views/BookUpdate";


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '图书管理',
    show: true,
    component: Index,
    /* 首页地址直接跳转到/BookManager */
    redirect: "/BookManager",
    children: [
      {
        path: '/BookManager',
        name: '查询图书',
        component: BookManager
      },
      {
        path: '/AddBook',
        name: '添加图书',
        component: AddBook
      },

    ]
  },

  {
    path: '/BookUpdate',
    // name: '修改图书',
    component: BookUpdate,
    show: false
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
