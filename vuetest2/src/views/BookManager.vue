<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="图书名"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="publish"
                    label="出版社"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="pages"
                    label="页数（/页）"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="price"
                    label="价格（/元）"
                    width="200">
            </el-table-column>

            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
                    <!--delete是关键字，不能自定义-->
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                @current-change="page">
                <!--点击页数跳转-->
        </el-pagination>
    </div>


</template>

<script>
    export default {
        methods: {
            /*
            * 编辑按钮，跳转页面
            * */
            edit(row) {
                this.$router.push({
                    path: '/BookUpdate',
                    /*带参传值*/
                    query: {
                        id: row.id
                    }
                })
            },

            deleteBook(row){
                const _this = this
                axios.delete('http://localhost:8181/book/delete/' + row.id).then(function(resp){
                    // 消息弹出框---- element官网找个模板直接复制
                    _this.$alert('《' + row.name + '》删除成功！', '提示', {
                        confirmButtonText: '确定',
                        callback: action => {
                            // 动态刷新此页面
                            window.location.reload()
                        }
                    });
                })
            },

            page(currentPage){
                const _this = this
                axios.get('http://localhost:8181/book/findAll/'+(currentPage-1)+'/10').then(function(resp){
                    console.log(resp)
                    _this.tableData = resp.data.content
                    _this.pageSize = resp.data.size
                    _this.total = resp.data.totalElements
                })
            }
        },

        data() {
            return {
                pageSize: '',
                total: '',
                tableData: [
                ]
            }
        },

        created(){
            const _this = this
            axios.get('http://localhost:8181/book/findAll/0/10').then(function(resp){
                console.log(resp)
                _this.tableData = resp.data.content
                _this.pageSize = resp.data.size
                _this.total = resp.data.totalElements
            })
        }
    }
</script>