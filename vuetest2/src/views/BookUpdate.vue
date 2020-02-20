<template>
    <div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

            <!--设置Id为无法修改，无须校验-->
            <el-form-item label="图书编号">
                <el-input v-model="ruleForm.id" readOnly></el-input>
            </el-form-item>

            <el-form-item label="图书名称" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>

            <el-form-item label="作者" prop="author">
                <el-input v-model="ruleForm.author"></el-input>
            </el-form-item>

            <el-form-item label="出版社" prop="publish">
                <el-input v-model="ruleForm.publish"></el-input>
            </el-form-item>

            <el-form-item label="页数" prop="publish">
                <el-input v-model="ruleForm.pages"></el-input>
            </el-form-item>

            <el-form-item label="价格" prop="publish">
                <el-input v-model="ruleForm.price"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                // 数据
                ruleForm: {
                    id: '',
                    name: '',
                    author: '',
                    publish: '',
                    pages: '',
                    price: '',
                },
                //校验规则
                rules: {
                    name: [
                        { required: true, message: '图书名称不能为空', trigger: 'blur' }
                    ],
                    author: [
                        { required: true, message: '作者姓名不能为空', trigger: 'blur' }
                    ],
                    publish: [
                        { required: true, message: '出版社不能为空', trigger: 'blur' }
                    ],
                    price: [
                        { required: true, message: '价格不能为空', trigger: 'blur' }
                    ],

                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        /*put和后端的PutMapping对应！！！*/
                        axios.put('http://localhost:8181/book/update', this.ruleForm).then(function(resp){
                            if(resp.data == 'success'){
                                // 消息弹出框---- element官网找个模板直接复制
                                _this.$alert('《' + _this.ruleForm.name + '》修改成功！', '提示', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        // 跳转界面
                                        _this.$router.push('/BookManager')
                                    }
                                });


                            }
                        })
                    } else {
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },

        created() {
            const _this = this
            axios.get('http://localhost:8181/book/findById/' + this.$route.query.id ).then(function(resp){
                _this.ruleForm = resp.data
            })
        }
    }
</script>