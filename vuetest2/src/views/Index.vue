<!--<template>-->
<!--    <el-container style="height: 700px; border: 1px solid #eee">-->
<!--        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">-->
<!--            <el-menu router :default-openeds="['0','1']">-->
<!--                &lt;!&ndash;循环遍历routes中的对象，有几个对象就有几个item&ndash;&gt;-->
<!--                &lt;!&ndash;添加index属性标识不同的submenu&ndash;&gt;-->
<!--                &lt;!&ndash;默认的index是字符串类型，而不是整数类型，多以需要转化为字符类型&ndash;&gt;-->
<!--                <el-submenu v-for="(item, index) in $router.options.routes" :index="index+''">-->
<!--                    <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>-->
<!--                    <el-menu-item v-for="(item2, index2) in item.children" :index="item2.path"-->
<!--                    :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>-->
<!--                    &lt;!&ndash;按钮选中变蓝is-active&ndash;&gt;-->
<!--                </el-submenu>-->
<!--            </el-menu>-->

<!--        </el-aside>-->

<!--        <el-main>-->
<!--            <router-view></router-view>-->
<!--        </el-main>-->

<!--    </el-container>-->
<!--</template>-->

<!--<script>-->
<!--    export default {-->
<!--        name: "index"-->
<!--    }-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->

<template>
    <router-view></router-view>
</template>

<script>
    export default {
        name: "Index"
    }
</script>

<style scoped>

</style>